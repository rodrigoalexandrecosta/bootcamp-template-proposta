package br.com.zup.bootcamp.proposal.api.features.creditcard;

import br.com.zup.bootcamp.proposal.api.features.proposal.Proposal;
import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalService;
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
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final ProposalService proposalService;
    private final CreditCardClient creditCardClient;

    @Transactional
    public void createBatch(List<Proposal> eligibleProposals) {

        eligibleProposals.forEach(proposal -> {
            try {
                Optional.ofNullable(this.creditCardClient.getCreditCardByProposalId(proposal.getId().toString()))
                        .ifPresent(cardResponse -> this.create(new CreditCard(cardResponse.getId(), proposal)));
            } catch (FeignException e) {
                log.error("API communication error: {}", e.getMessage());
            }
        });
    }

    public void create(CreditCard creditCard) {
        this.creditCardRepository.save(creditCard);
    }

    public Optional<CreditCard> findById(final UUID creditCardId) {
        return this.creditCardRepository.findById(creditCardId);
    }
}
