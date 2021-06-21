package com.everis.creditsloans.dao.repository;

import com.everis.creditsloans.dao.entity.BusinessCredit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusinessCreditRepository extends ReactiveMongoRepository<BusinessCredit, UUID> {
}
