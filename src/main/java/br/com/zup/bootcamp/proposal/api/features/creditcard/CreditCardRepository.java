package br.com.zup.bootcamp.proposal.api.features.creditcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, UUID> {

}
