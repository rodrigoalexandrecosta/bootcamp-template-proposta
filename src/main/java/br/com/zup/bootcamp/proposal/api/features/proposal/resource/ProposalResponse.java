package br.com.zup.bootcamp.proposal.api.features.proposal.resource;

import br.com.zup.bootcamp.proposal.api.features.proposal.Proposal;
import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProposalResponse {

    private UUID id;
    private String socialIdentity;
    private String name;
    private ProposalStatus status;


    @Deprecated
    public ProposalResponse() {
    }

    public ProposalResponse(Proposal proposal) {
        this.id = proposal.getId();
        this.socialIdentity = proposal.getSocialIdentity();
        this.name = proposal.getName();
        this.status = proposal.getStatus();
    }
}
