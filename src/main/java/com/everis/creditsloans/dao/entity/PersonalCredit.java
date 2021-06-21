package com.everis.creditsloans.dao.entity;


import lombok.AllArgsConstructor;
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
public class PersonalCredit {
    @Id
    private UUID idPersonalCredit;

    private PersonalClient personalClient;
    private String creditName;
    private String creditType;
    private BigDecimal creditBalance;
    private String currencyType;
    private BigDecimal amountPaid;
    private boolean state;
}
