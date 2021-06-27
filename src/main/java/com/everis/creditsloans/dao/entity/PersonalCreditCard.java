package com.everis.creditsloans.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalCreditCard {
  @Id
  private UUID idPersonalCreditCard;

  @DBRef
  private PCreditCard pCreditCard;
  @DBRef
  private PersonalClient personalClient;
  private BigDecimal creditBalance;
  private String currencyType;
  private boolean state;
}
