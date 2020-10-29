package br.com.zup.bootcamp.proposal.api.features.proposal;

import br.com.zup.bootcamp.proposal.api.features.proposal.resource.ProposalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;

    @Transactional
    public ProposalResponse create(final Proposal proposal) {
        final var persistedProposal = this.proposalRepository.save(proposal);
        return new ProposalResponse(persistedProposal.getId());
    }
}
