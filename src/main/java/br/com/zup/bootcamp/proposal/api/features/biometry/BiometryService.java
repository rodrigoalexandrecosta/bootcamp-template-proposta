package br.com.zup.bootcamp.proposal.api.features.biometry;

import br.com.zup.bootcamp.proposal.api.features.biometry.resource.BiometryRequest;
import br.com.zup.bootcamp.proposal.api.features.creditcard.CreditCard;
import br.com.zup.bootcamp.proposal.api.features.creditcard.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BiometryService {

    private final BiometryRepository biometryRepository;
    private final CreditCardService creditCardService;

    @Transactional
    public UUID create(final UUID creditCardId, final BiometryRequest request) {
        final CreditCard creditCard = this.creditCardService.findById(creditCardId)
                .orElseThrow(() -> new EntityNotFoundException("message.proposal.credit-card.not-found"));

        final Biometry biometry = this.biometryRepository.save(request.toBiometry(creditCard));
        return biometry.getId();
    }
}
