package br.com.zup.bootcamp.proposal.api.features.creditcard.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarteiraResponse {

    private UUID id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;
}
