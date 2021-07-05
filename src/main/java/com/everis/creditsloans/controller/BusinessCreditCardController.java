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

import com.everis.creditsloans.dao.entity.BusinessCreditCard;
import com.everis.creditsloans.service.BusinessCreditCardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/credits-loans/business-credit-card")
public class BusinessCreditCardController {
    @Autowired
    private BusinessCreditCardService businessCreditCardService;

    @GetMapping
    public Flux<BusinessCreditCard> findAll() { return businessCreditCardService.findAll(); }

    @PostMapping
    public Mono<BusinessCreditCard> create(@RequestBody BusinessCreditCard entity){
        return businessCreditCardService.create(entity);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BusinessCreditCard>> findById(@PathVariable("id") UUID id){
        return businessCreditCardService.findById(id)
                .map(e -> ResponseEntity.ok().body(e));
    }

    @DeleteMapping("/{id}")
    public Mono<BusinessCreditCard> deleteById(@PathVariable("id") UUID id){
        return businessCreditCardService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<BusinessCreditCard> update(@PathVariable("id")UUID id, @RequestBody BusinessCreditCard entity){
        return businessCreditCardService.update(id,entity);
    }
    
    @GetMapping("/ruc/{ruc}")
    public Flux<BusinessCreditCard> findAllByRuc(@PathVariable("ruc")String ruc){
    	return businessCreditCardService.findAllByRuc(ruc);
    }
}

