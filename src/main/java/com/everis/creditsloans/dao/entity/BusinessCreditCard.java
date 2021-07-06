package com.everis.creditsloans.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class BusinessCreditCard {
    @Id
    private UUID idBusinessCreditCard;

    private PCreditCard pCreditCard;

    private BusinessClient businessClient;
    private BigDecimal creditBalance;
    private String currencyType;
    private boolean state;

}
