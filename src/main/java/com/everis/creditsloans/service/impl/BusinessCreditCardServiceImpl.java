package com.everis.creditsloans.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.creditsloans.dao.entity.BusinessCreditCard;
import com.everis.creditsloans.dao.repository.BusinessCreditCardRepository;
import com.everis.creditsloans.dto.BusinessCreditDTO;
import com.everis.creditsloans.service.BusinessCreditCardService;
import com.everis.creditsloans.util.MapperBusinessCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessCreditCardServiceImpl implements BusinessCreditCardService{

	@Autowired
	private BusinessCreditCardRepository businessCreditCardRepository;
	
	@Override
    public Mono<BusinessCreditCard> findById(UUID uuid) {
        return businessCreditCardRepository.findById(uuid)
                .switchIfEmpty(Mono.error(new Exception("No se encontro el producto")));
    }

    @Override
    public Flux<BusinessCreditCard> findAll() {
        return businessCreditCardRepository.findAll()
                .switchIfEmpty(Mono.error(new Exception("La lista de créditos esta vacía")));
    }

    @Override
    public Mono<BusinessCreditCard> update(UUID uuid, BusinessCreditCard entity) {
        return businessCreditCardRepository.findById(uuid)
                .filter(e -> e.getIdBusinessCreditCard().equals(entity.getIdBusinessCreditCard()))
                .switchIfEmpty(Mono.error(new Exception("No coincide")))
                .flatMap(e -> businessCreditCardRepository.save(e));
    }

    @Override
    public Mono<BusinessCreditCard> create(BusinessCreditCard entity) {
        entity.setIdBusinessCreditCard(UUID.randomUUID());

        return Mono.just(entity)
                .flatMap(businessCreditCardRepository::save);
    }

    @Override
    public Mono<BusinessCreditCard> deleteById(UUID uuid) {
        return businessCreditCardRepository
                .findById(uuid)
                .flatMap(p -> businessCreditCardRepository.deleteById(p.getIdBusinessCreditCard()).thenReturn(p));
    }

	@Override
	public Flux<BusinessCreditCard> findAllByRuc(String ruc) {
		return businessCreditCardRepository.findAllByBusinessClientRuc(ruc);
	}

}
