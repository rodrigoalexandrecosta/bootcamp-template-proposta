package br.com.zup.bootcamp.proposal.api.features.proposal;

import br.com.zup.bootcamp.proposal.api.features.proposal.analysis.ProposalAnalysisClient;
import br.com.zup.bootcamp.proposal.api.features.proposal.analysis.ProposalAnalysisResponse;
import br.com.zup.bootcamp.proposal.api.features.proposal.analysis.ProposalAnalysisStatus;
import br.com.zup.bootcamp.proposal.api.features.proposal.creditcard.CreditCardClient;
import br.com.zup.bootcamp.proposal.api.features.proposal.creditcard.CreditCardResponse;
import br.com.zup.bootcamp.proposal.api.features.proposal.resource.ProposalResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalAnalysisClient proposalAnalysisClient;
    private final CreditCardClient creditCardClient;

    @Transactional
    public ProposalResponse create(Proposal proposal) {
        if (this.proposalRepository.findBySocialIdentity(proposal.getSocialIdentity()).isPresent()) {
            throw new IllegalArgumentException("message.proposal.social-identity.unique");
        }
        this.proposalRepository.save(proposal);
        this.evaluateProposal(proposal);
        return new ProposalResponse(proposal);
    }

    @Transactional
    public void updateProposalWithCreditCardNumber() {
        List<Proposal> proposals = this.findAllEligibleWithoutCreditCardNumber();

        proposals.forEach(proposal -> {
            try {
                CreditCardResponse response = this.creditCardClient.getCreditCardByProposalId(proposal.getId().toString());
                if (response != null) {
                    proposal.setCreditCardNumber(UUID.fromString(response.getId()));
                }
            } catch (FeignException e) {
                log.error("API communication error: {}", e.getMessage());
            }
        });
    }

    private List<Proposal> findAllEligibleWithoutCreditCardNumber() {
        return this.proposalRepository.findAllByStatusAndCreditCardNumberIsNull(ProposalStatus.ELIGIBLE);
    }

    private void evaluateProposal(final Proposal proposal) {
        var analysisResponse = ProposalAnalysisResponse.builder()
                .resultadoSolicitacao(ProposalAnalysisStatus.COM_RESTRICAO)
                .build();

        try {
            analysisResponse = this.proposalAnalysisClient.evaluateProposal(proposal.toAnalysisRequest());
        } catch (FeignException e) {
            log.error("API communication error: {}", e.getMessage());
        }

        proposal.setStatus(analysisResponse.getResultadoSolicitacao().toProposalStatus());
    }
}
