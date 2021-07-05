package com.everis.creditsloans.dao.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.creditsloans.dao.entity.BusinessCreditCard;
import com.everis.creditsloans.dao.entity.PersonalCreditCard;

import reactor.core.publisher.Flux;

@Repository
public interface BusinessCreditCardRepository extends ReactiveMongoRepository<BusinessCreditCard, UUID>{
	Flux<BusinessCreditCard> findAllByBusinessClientRuc(String ruc);
}
