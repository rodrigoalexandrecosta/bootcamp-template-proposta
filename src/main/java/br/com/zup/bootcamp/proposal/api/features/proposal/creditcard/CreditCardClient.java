package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("${clients.url.creditcard_service}")
public interface CreditCardClient {

    @GetMapping("/api/cartoes")
    CreditCardResponse getCreditCardByProposalId(@RequestParam("idProposta") String idProposta);

}
