package br.com.zup.bootcamp.proposal.api.features.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProposalAnalysisRequest {

    private String documento;

    private String nome;

    private String idProposta;

    @Deprecated
    public ProposalAnalysisRequest() {
    }
}
