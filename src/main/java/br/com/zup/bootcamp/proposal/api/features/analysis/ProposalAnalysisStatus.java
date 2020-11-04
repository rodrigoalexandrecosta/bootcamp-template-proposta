package br.com.zup.bootcamp.proposal.api.features.analysis;

import br.com.zup.bootcamp.proposal.api.features.proposal.ProposalStatus;

public enum ProposalAnalysisStatus {

    COM_RESTRICAO {
        @Override
        public ProposalStatus toProposalStatus() {
            return ProposalStatus.NOT_ELIGIBLE;
        }
    },
    SEM_RESTRICAO {
        @Override
        public ProposalStatus toProposalStatus() {
            return ProposalStatus.ELIGIBLE;
        }
    };

    public abstract ProposalStatus toProposalStatus();
}
