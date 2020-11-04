package br.com.zup.bootcamp.proposal.api.features.creditcard.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VencimentoResponse {

    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;
}
