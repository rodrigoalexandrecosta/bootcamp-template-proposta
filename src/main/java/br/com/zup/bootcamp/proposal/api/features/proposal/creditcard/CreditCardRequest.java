package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreditCardRequest {

    private String documento;

    private String nome;

    private String idProposta;


    @Deprecated
    public CreditCardRequest() {
    }
}
