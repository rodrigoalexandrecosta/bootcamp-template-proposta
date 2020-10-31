package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CreditCardTask {

//    @Scheduled(fixedDelay = 1000)
    private void execute() {
        System.out.println("Executing!!!!!!!!!");
    }
}

