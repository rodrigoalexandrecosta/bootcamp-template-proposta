package br.com.zup.bootcamp.proposal.api.features.proposal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, UUID> {
    Optional<Proposal> findBySocialIdentity(String socialIdentity);

    List<Proposal> findAllByStatusAndCreditCardIsNull(ProposalStatus status);
}
