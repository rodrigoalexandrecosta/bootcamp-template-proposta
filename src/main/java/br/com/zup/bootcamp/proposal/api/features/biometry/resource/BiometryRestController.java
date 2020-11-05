package br.com.zup.bootcamp.proposal.api.features.biometry.resource;

import br.com.zup.bootcamp.proposal.api.features.biometry.BiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestControllerAdvice
@RequestMapping("/api/v1/credit-cards/{creditCardId}/biometries")
@RequiredArgsConstructor
public class BiometryRestController {

    private final BiometryService biometryService;

    @PostMapping
    public ResponseEntity<UUID> create(@PathVariable UUID creditCardId, @RequestBody @Valid BiometryRequest request) {
        final UUID id = this.biometryService.create(creditCardId, request);
        return ResponseEntity.created(URI.create("/biometries/" + id)).build();
    }
}
