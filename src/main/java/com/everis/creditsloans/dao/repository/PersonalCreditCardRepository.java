package com.everis.creditsloans.dao.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.creditsloans.dao.entity.PersonalCreditCard;


@Repository
public interface PersonalCreditCardRepository extends ReactiveMongoRepository<PersonalCreditCard, UUID>{

}
