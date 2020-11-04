package br.com.zup.bootcamp.proposal.api.features.creditcard.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AvisoResponse {

    private LocalDate validoAte;
    private String destino;
}
