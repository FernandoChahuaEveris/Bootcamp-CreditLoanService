package com.everis.creditsloans.dao.repository;

import com.everis.creditsloans.dao.entity.PersonalCredit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PersonalCreditRepository extends ReactiveMongoRepository<PersonalCredit, UUID> {
    Mono<PersonalCredit> findFirstByPersonalClientIdPersonalClient(UUID idPersonalClient);
}
