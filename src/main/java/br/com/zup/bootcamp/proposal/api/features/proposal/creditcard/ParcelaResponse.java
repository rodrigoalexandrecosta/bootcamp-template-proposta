package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParcelaResponse {

    private String id;
    private Integer quantidade;
    private BigDecimal valor;
}
