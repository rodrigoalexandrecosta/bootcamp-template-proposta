package br.com.zup.bootcamp.proposal.api.features.proposal.resource;

import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/proposals")
@RequiredArgsConstructor
public class ProposalRestController {

    private final ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponse> create(@RequestBody @Valid ProposalRequest request) {
        final var proposalResponse = this.proposalService.create(request.toProposal());
        return ResponseEntity.created(URI.create("/api/v1/proposals/" + proposalResponse.getId())).body(proposalResponse);
    }

    @GetMapping("/{proposalId}")
    public ResponseEntity<ProposalResponse> find(@PathVariable UUID proposalId) {
        return this.proposalService.findById(proposalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
