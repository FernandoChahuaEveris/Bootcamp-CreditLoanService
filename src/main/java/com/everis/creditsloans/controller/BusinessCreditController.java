package com.everis.creditsloans.controller;

import com.everis.creditsloans.dto.BusinessCreditDTO;
import com.everis.creditsloans.dto.PersonalCreditDTO;
import com.everis.creditsloans.service.BusinessCreditService;
import com.everis.creditsloans.service.PersonalCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/credits-loans/business-credit")
public class BusinessCreditController {
    @Autowired
    private BusinessCreditService businessCreditService;

    @GetMapping
    public Flux<BusinessCreditDTO> findAll() { return businessCreditService.findAll(); }

    @PostMapping
    public Mono<BusinessCreditDTO> create(@RequestBody BusinessCreditDTO entity){
        return businessCreditService.create(entity);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BusinessCreditDTO>> findById(@PathVariable("id") UUID id){
        return businessCreditService.findById(id)
                .map(e -> ResponseEntity.ok().body(e));
    }

    @DeleteMapping("/{id}")
    public Mono<BusinessCreditDTO> deleteById(@PathVariable("id") UUID id){
        return businessCreditService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Mono<BusinessCreditDTO> update(@PathVariable("id")UUID id, @RequestBody BusinessCreditDTO entity){
        return businessCreditService.update(id,entity);
    }
}
