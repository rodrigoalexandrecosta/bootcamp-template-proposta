package br.com.zup.bootcamp.proposal.api.features.creditcard;

import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardTask {

    private final ProposalService proposalService;

    @Scheduled(fixedDelay = 10000)
    public void updateProposalWithCreditCardNumber() {
        this.proposalService.updateProposalWithCreditCardNumber();
    }
}

