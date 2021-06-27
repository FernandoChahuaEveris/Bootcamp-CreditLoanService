package com.everis.creditsloans.service.impl;

import com.everis.creditsloans.dao.entity.PersonalCredit;
import com.everis.creditsloans.dao.repository.PersonalCreditRepository;
import com.everis.creditsloans.dto.PersonalCreditDTO;
import com.everis.creditsloans.service.PersonalCreditService;
import com.everis.creditsloans.util.MapperPersonalCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PersonalCreditServiceImpl implements PersonalCreditService {
  @Autowired
  private PersonalCreditRepository personalCreditRepository;

  @Override
  public Mono<PersonalCreditDTO> findById(UUID uuid) {
    return personalCreditRepository.findById(uuid).map(MapperPersonalCredit::entityToDTO)
        .switchIfEmpty(Mono.error(new Exception("No se encontro el producto")));
  }

  @Override
  public Flux<PersonalCreditDTO> findAll() {
    return personalCreditRepository.findAll().map(MapperPersonalCredit::entityToDTO)
        .switchIfEmpty(Mono.error(new Exception("La lista de créditos esta vacía")));
  }

  @Override
  public Mono<PersonalCreditDTO> update(UUID uuid, PersonalCreditDTO entity) {
    return personalCreditRepository.findById(uuid)
        .filter(e -> e.getIdPersonalCredit().equals(entity.getIdPersonalCredit()))
        .switchIfEmpty(Mono.error(new Exception("No coincide")))
        .map(e -> MapperPersonalCredit.dtoToEntity(entity))
        .flatMap(e -> personalCreditRepository.save(e)).map(MapperPersonalCredit::entityToDTO);
  }

  @Override
  public Mono<PersonalCreditDTO> create(PersonalCreditDTO entity) {
    entity.setIdPersonalCredit(UUID.randomUUID());
    return personalCreditRepository.findFirstByPersonalClientIdPersonalClient(entity
        .getIdPersonalClient())
        .flatMap(__ -> Mono.error(new Exception("El cliente ya tiene un crédito")))
        .switchIfEmpty(Mono.defer(() -> personalCreditRepository
            .save(MapperPersonalCredit.dtoToEntity(entity))))
        .cast(PersonalCredit.class).map(MapperPersonalCredit::entityToDTO);
  }

  @Override
  public Mono<PersonalCreditDTO> deleteById(UUID uuid) {
    return personalCreditRepository.findById(uuid)
        .flatMap(p -> personalCreditRepository.deleteById(p.getIdPersonalCredit()).thenReturn(p))
        .map(MapperPersonalCredit::entityToDTO);
  }

}
