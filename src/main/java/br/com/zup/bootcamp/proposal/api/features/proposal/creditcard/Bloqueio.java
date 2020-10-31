package br.com.zup.bootcamp.proposal.api.features.proposal.creditcard;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Bloqueio {

    private UUID id;
    private OffsetDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private boolean ativo;
}
