package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("${clients.url.creditcard_service}")
public interface CreditCardClient {

    CreditCardResponse generateCreditCard(@RequestBody CreditCardRequest request);
}
