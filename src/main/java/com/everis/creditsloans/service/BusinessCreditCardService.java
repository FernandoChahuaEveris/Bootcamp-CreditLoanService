package com.everis.creditsloans.service;

import java.util.UUID;

import com.everis.creditsloans.dao.entity.BusinessCreditCard;
import com.everis.creditsloans.dao.entity.PersonalCreditCard;

import reactor.core.publisher.Flux;

public interface BusinessCreditCardService extends CRUDService<BusinessCreditCard, UUID>{
	Flux<BusinessCreditCard> findAllByRuc(String ruc);
}
