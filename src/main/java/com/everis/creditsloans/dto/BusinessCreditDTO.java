package com.everis.creditsloans.dto;

import com.everis.creditsloans.dao.entity.BusinessClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessCreditDTO {
    private UUID idBusinessCredit;

    private UUID idBusinessClient;
    private String ruc;

    private String creditName;
    private String creditType;
    private BigDecimal creditBalance;
    private String currencyType;
    private BigDecimal amountPaid;
    private boolean state;
}
