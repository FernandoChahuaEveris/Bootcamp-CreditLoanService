package com.everis.creditsloans.controller;


import com.everis.creditsloans.dto.PersonalCreditDTO;
import com.everis.creditsloans.service.PersonalCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/credits-loans/personal-credit")
public class PersonalCreditController {
    @Autowired
    private PersonalCreditService personalCreditService;

    @GetMapping
    public Flux<PersonalCreditDTO> findAll() { return personalCreditService.findAll(); }

    @PostMapping
    public Mono<PersonalCreditDTO> create(@RequestBody PersonalCreditDTO entity){
        return personalCreditService.create(entity);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PersonalCreditDTO>> findById(@PathVariable("id") UUID id){
        return personalCreditService.findById(id)
                .map(e -> ResponseEntity.ok().body(e));
    }

    @DeleteMapping("/{id}")
    public Mono<PersonalCreditDTO> deleteById(@PathVariable("id") UUID id){
        return personalCreditService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<PersonalCreditDTO> update(@PathVariable("id")UUID id, @RequestBody PersonalCreditDTO entity){
        return personalCreditService.update(id,entity);
    }
}
