package com.everis.creditsloans.service;

import java.util.UUID;

import com.everis.creditsloans.dao.entity.PersonalCreditCard;

import reactor.core.publisher.Flux;

public interface PersonalCreditCardService extends CRUDService<PersonalCreditCard,UUID>{
	Flux<PersonalCreditCard> findAllByDni(String dni);
}
