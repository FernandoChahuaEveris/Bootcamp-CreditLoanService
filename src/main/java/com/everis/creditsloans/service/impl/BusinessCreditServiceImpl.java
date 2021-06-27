package com.everis.creditsloans.service.impl;

import com.everis.creditsloans.dao.repository.BusinessCreditRepository;
import com.everis.creditsloans.dto.BusinessCreditDTO;
import com.everis.creditsloans.service.BusinessCreditService;
import com.everis.creditsloans.util.MapperBusinessCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class BusinessCreditServiceImpl implements BusinessCreditService {
  @Autowired
  private BusinessCreditRepository businessCreditRepository;

  @Override
  public Mono<BusinessCreditDTO> findById(UUID uuid) {
    return businessCreditRepository.findById(uuid).map(MapperBusinessCredit::entityToDTO)
        .switchIfEmpty(Mono.error(new Exception("No se encontro el producto")));
  }

  @Override
  public Flux<BusinessCreditDTO> findAll() {
    return businessCreditRepository.findAll().map(MapperBusinessCredit::entityToDTO)
        .switchIfEmpty(Mono.error(new Exception("La lista de créditos esta vacía")));
  }

  @Override
  public Mono<BusinessCreditDTO> update(UUID uuid, BusinessCreditDTO entity) {
    return businessCreditRepository.findById(uuid)
        .filter(e -> e.getIdBusinessCredit().equals(entity.getIdBusinessCredit()))
        .switchIfEmpty(Mono.error(new Exception("No coincide")))
        .map(e -> MapperBusinessCredit.dtoToEntity(entity))
        .flatMap(e -> businessCreditRepository.save(e)).map(MapperBusinessCredit::entityToDTO);
  }

  @Override
  public Mono<BusinessCreditDTO> create(BusinessCreditDTO entity) {
    entity.setIdBusinessCredit(UUID.randomUUID());

    return Mono.just(entity).map(MapperBusinessCredit::dtoToEntity)
        .flatMap(businessCreditRepository::save)
        .map(MapperBusinessCredit::entityToDTO);
  }

  @Override
  public Mono<BusinessCreditDTO> deleteById(UUID uuid) {
    return businessCreditRepository.findById(uuid)
        .flatMap(p -> businessCreditRepository.deleteById(p.getIdBusinessCredit()).thenReturn(p))
        .map(MapperBusinessCredit::entityToDTO);
  }
}
