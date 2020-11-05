package br.com.zup.bootcamp.proposal.api.features.creditcard;

import br.com.zup.bootcamp.proposal.api.features.proposal.Proposal;
import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditCardTask {

    private final CreditCardService creditCardService;
    private final ProposalService proposalService;

    @Scheduled(fixedDelay = 10000)
    public void updateProposalWithCreditCard() {
        List<Proposal> eligibleProposalsWithoutCard = this.proposalService.findAllEligibleWithoutCreditCard();
        this.creditCardService.createBatch(eligibleProposalsWithoutCard);
    }
}

