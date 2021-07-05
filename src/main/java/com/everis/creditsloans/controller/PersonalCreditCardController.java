package com.everis.creditsloans.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.creditsloans.dao.entity.PersonalCreditCard;
import com.everis.creditsloans.service.PersonalCreditCardService;
import com.everis.creditsloans.service.PersonalCreditCardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/credits-loans/personal-credit-card")
public class PersonalCreditCardController {
    @Autowired
    private PersonalCreditCardService personalCreditCardService;

    @GetMapping
    public Flux<PersonalCreditCard> findAll() { return personalCreditCardService.findAll(); }

    @PostMapping
    public Mono<PersonalCreditCard> create(@RequestBody PersonalCreditCard entity){
        return personalCreditCardService.create(entity);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PersonalCreditCard>> findById(@PathVariable("id") UUID id){
        return personalCreditCardService.findById(id)
                .map(e -> ResponseEntity.ok().body(e));
    }

    @DeleteMapping("/{id}")
    public Mono<PersonalCreditCard> deleteById(@PathVariable("id") UUID id){
        return personalCreditCardService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<PersonalCreditCard> update(@PathVariable("id")UUID id, @RequestBody PersonalCreditCard entity){
        return personalCreditCardService.update(id,entity);
    }
    @GetMapping("/dni/{dni}")
    public Flux<PersonalCreditCard>findAllByDni(@PathVariable("dni")String dni){
    	return personalCreditCardService.findAllByDni(dni);
    }
}


