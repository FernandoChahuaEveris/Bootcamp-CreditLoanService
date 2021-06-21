package com.everis.creditsloans.dto;

import com.everis.creditsloans.dao.entity.PCreditCard;
import com.everis.creditsloans.dao.entity.PersonalClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalCreditDTO {

    private UUID idPersonalCredit;

    private UUID idPersonalClient;
    private String dni;

    private String creditName;
    private String creditType;
    private BigDecimal creditBalance;
    private String currencyType;
    private BigDecimal amountPaid;
}