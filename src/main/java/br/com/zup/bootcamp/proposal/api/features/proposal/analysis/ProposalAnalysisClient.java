package br.com.zup.bootcamp.proposal.api.features.proposal.analysis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("${clients.url.analysis_service}")
public interface ProposalAnalysisClient {

    @PostMapping("/api/solicitacao")
    ProposalAnalysisResponse evaluateProposal(@RequestBody ProposalAnalysisRequest request);
}
