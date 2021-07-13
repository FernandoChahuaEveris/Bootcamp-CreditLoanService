package com.everis.creditsloans.service.impl;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.everis.creditsloans.dao.entity.BusinessCreditCard;
import com.everis.creditsloans.dao.entity.PersonalCreditCard;
import com.everis.creditsloans.dao.repository.BusinessCreditCardRepository;
import com.everis.creditsloans.dao.repository.PersonalCreditCardRepository;
import com.everis.creditsloans.service.PersonalCreditCardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PersonalCreditCardServiceImpl implements PersonalCreditCardService {

    @Autowired
    private PersonalCreditCardRepository personalCreditCardRepository;

    @Override
    public Mono<PersonalCreditCard> findById(UUID uuid) {
        return personalCreditCardRepository.findById(uuid)
                .switchIfEmpty(Mono.error(new Exception("No se encontro el producto")));
    }

    @Override
    public Flux<PersonalCreditCard> findAll() {
        return personalCreditCardRepository.findAll()
                .switchIfEmpty(Mono.error(new Exception("La lista de créditos esta vacía")));
    }

    @Override
    public Mono<PersonalCreditCard> update(UUID uuid, PersonalCreditCard entity) {
        return personalCreditCardRepository.findById(uuid)
                .filter(e -> e.getIdPersonalCreditCard().equals(entity.getIdPersonalCreditCard()))
                .switchIfEmpty(Mono.error(new Exception("No coincide")))
                .flatMap(e -> personalCreditCardRepository.save(e));
    }

    @Override
    public Mono<PersonalCreditCard> create(PersonalCreditCard entity) {
        entity.setIdPersonalCreditCard(UUID.randomUUID());

        return Mono.just(entity)
                .flatMap(personalCreditCardRepository::save);
    }

    @Override
    public Mono<PersonalCreditCard> deleteById(UUID uuid) {
        return personalCreditCardRepository
                .findById(uuid)
                .flatMap(p -> personalCreditCardRepository.deleteById(p.getIdPersonalCreditCard()).thenReturn(p));
    }

    @Override
    public Flux<PersonalCreditCard> findAllByDni(String dni) {
        return personalCreditCardRepository.findAllByPersonalClientDni(dni);
    }


}
