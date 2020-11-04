package br.com.zup.bootcamp.proposal.api.features.proposal.analysis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProposalAnalysisResponse {

    private String documento;
    private String nome;
    private ProposalAnalysisStatus resultadoSolicitacao;
    private String idProposta;

    @Deprecated
    public ProposalAnalysisResponse() {
    }
}
