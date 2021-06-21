package com.everis.creditsloans.util;

import com.everis.creditsloans.dao.entity.PersonalClient;
import com.everis.creditsloans.dao.entity.PersonalCredit;
import com.everis.creditsloans.dto.PersonalCreditDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MapperPersonalCredit {
    public static PersonalCreditDTO entityToDTO(PersonalCredit personalCredit){
        return PersonalCreditDTO.builder()
                .amountPaid(personalCredit.getAmountPaid())
                .creditBalance(personalCredit.getCreditBalance())
                .creditName(personalCredit.getCreditName())
                .creditType(personalCredit.getCreditType())
                .idPersonalCredit(personalCredit.getIdPersonalCredit())
                .dni(personalCredit.getPersonalClient().getDni())
                .idPersonalClient(personalCredit.getPersonalClient().getIdPersonalClient())
                .currencyType(personalCredit.getCurrencyType())
                .build();
    }

    public static PersonalCredit dtoToEntity(PersonalCreditDTO personalCreditDTO){
        return PersonalCredit.builder()
                .idPersonalCredit(personalCreditDTO.getIdPersonalCredit())
                .amountPaid(personalCreditDTO.getAmountPaid())
                .creditBalance(personalCreditDTO.getCreditBalance())
                .creditName(personalCreditDTO.getCreditName())
                .creditType(personalCreditDTO.getCreditType())
                .currencyType(personalCreditDTO.getCurrencyType())
                .personalClient( new PersonalClient(personalCreditDTO.getIdPersonalClient(),personalCreditDTO.getDni()))
                .build();
    }

}
