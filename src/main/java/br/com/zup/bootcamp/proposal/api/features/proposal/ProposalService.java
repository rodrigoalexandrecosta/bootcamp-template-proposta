package br.com.zup.bootcamp.proposal.api.features.proposal;

import br.com.zup.bootcamp.proposal.api.features.proposal.analysis.ProposalAnalysisClient;
import br.com.zup.bootcamp.proposal.api.features.proposal.analysis.ProposalAnalysisResponse;
import br.com.zup.bootcamp.proposal.api.features.proposal.resource.ProposalResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalAnalysisClient proposalAnalysisClient;

    @Transactional
    public ProposalResponse create(final Proposal proposal) {
        if (this.proposalRepository.findBySocialIdentity(proposal.getSocialIdentity()).isPresent()) {
            throw new IllegalArgumentException("message.proposal.social-identity.unique");
        }
        var persistedProposal = this.proposalRepository.save(proposal);
        persistedProposal = this.evaluateProposal(persistedProposal);
        return new ProposalResponse(this.proposalRepository.save(persistedProposal));
    }

    Proposal evaluateProposal(final Proposal proposal) {
        var analysisResponse = ProposalAnalysisResponse.builder().build();

        try {
            analysisResponse = this.proposalAnalysisClient.evaluateProposal(proposal.toAnalysisRequest());
            proposal.setStatus(analysisResponse.getResultadoSolicitacao().toProposalStatus());
        } catch (FeignException e) {
            proposal.setStatus(ProposalStatus.NOT_ELIGIBLE);
        }

        return proposal;
    }
}
