package com.everis.creditsloans.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class BusinessCredit {
    @Id
    private UUID idBusinessCredit;

    private BusinessClient businessClient;
    private String creditName;
    private String creditType;
    private BigDecimal creditBalance;
    private String currencyType;
    private BigDecimal amountPaid;
    private boolean state;
}
