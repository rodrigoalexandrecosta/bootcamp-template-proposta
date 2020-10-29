package br.com.zup.bootcamp.proposal.api.features.proposal.resource;

import java.util.UUID;

public class ProposalResponse {

    private UUID id;

    public ProposalResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
