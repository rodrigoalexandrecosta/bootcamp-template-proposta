package br.com.zup.bootcamp.proposal.api.features.creditcard;

import br.com.zup.bootcamp.proposal.api.features.creditcard.response.CreditCardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("${clients.creditcard_service.url}")
public interface CreditCardClient {

    @GetMapping("/api/cartoes")
    CreditCardResponse getCreditCardByProposalId(@RequestParam("idProposta") String idProposta);

}
