package br.com.zup.bootcamp.proposal.api.features.proposal;

import br.com.zup.bootcamp.proposal.api.features.analysis.ProposalAnalysisClient;
import br.com.zup.bootcamp.proposal.api.features.analysis.ProposalAnalysisResponse;
import br.com.zup.bootcamp.proposal.api.features.analysis.ProposalAnalysisStatus;
import br.com.zup.bootcamp.proposal.api.features.proposal.resource.ProposalResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalAnalysisClient proposalAnalysisClient;

    @Transactional
    public ProposalResponse create(Proposal proposal) {
        if (this.proposalRepository.findBySocialIdentity(proposal.getSocialIdentity()).isPresent()) {
            throw new IllegalArgumentException("message.proposal.social-identity.unique");
        }
        this.proposalRepository.save(proposal);
        proposal = this.evaluateProposal(proposal);
        return new ProposalResponse(this.proposalRepository.save(proposal));
    }

    public Optional<ProposalResponse> findById(final UUID id) {
        return this.proposalRepository.findById(id)
                .map(ProposalResponse::new);
    }

    public List<Proposal> findAllEligibleWithoutCreditCard() {
        return this.proposalRepository.findAllByStatusAndCreditCardIsNull(ProposalStatus.ELIGIBLE);
    }

    private Proposal evaluateProposal(final Proposal proposal) {
        var analysisResponse = ProposalAnalysisResponse.builder()
                .resultadoSolicitacao(ProposalAnalysisStatus.COM_RESTRICAO)
                .build();

        try {
            analysisResponse = this.proposalAnalysisClient.evaluateProposal(proposal.toAnalysisRequest());
        } catch (FeignException e) {
            log.error("API communication error: {}", e.getMessage());
        }

        proposal.setStatus(analysisResponse.getResultadoSolicitacao().toProposalStatus());
        return proposal;
    }

}
