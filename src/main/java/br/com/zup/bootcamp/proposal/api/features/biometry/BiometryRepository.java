package br.com.zup.bootcamp.proposal.api.features.biometry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BiometryRepository extends CrudRepository<Biometry, UUID> {

}
