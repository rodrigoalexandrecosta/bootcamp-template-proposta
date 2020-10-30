package br.com.zup.bootcamp.proposal.api.features.proposal.resource;

import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/proposals")
@RequiredArgsConstructor
public class ProposalRestController {

    private final ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponse> create(@RequestBody @Valid ProposalRequest request) {
        final var proposal = this.proposalService.create(request.toProposal());
        return ResponseEntity.created(URI.create("/api/v1/proposals/" + proposal.getId())).body(proposal);
    }
}
