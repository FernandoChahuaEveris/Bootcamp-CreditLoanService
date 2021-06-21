package com.everis.creditsloans.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
 * Entidad Cuenta Corriente
 * */
public class PCreditCard {
    @Id
    private UUID idPCreditCard;

    private String productName;

    private String creditCardType;

    private BigDecimal creditBalance;

    private String currencyType;

    private boolean state;
}
