package com.everis.creditsloans.util;

import com.everis.creditsloans.dao.entity.BusinessClient;
import com.everis.creditsloans.dao.entity.BusinessCredit;
import com.everis.creditsloans.dao.entity.PersonalClient;
import com.everis.creditsloans.dao.entity.PersonalCredit;
import com.everis.creditsloans.dto.BusinessCreditDTO;
import com.everis.creditsloans.dto.PersonalCreditDTO;

public class MapperBusinessCredit  {
  public static BusinessCreditDTO entityToDTO(BusinessCredit businessCredit) {
    return BusinessCreditDTO.builder().amountPaid(businessCredit.getAmountPaid())
        .creditBalance(businessCredit.getCreditBalance()).creditName(businessCredit
            .getCreditName())
        .creditType(businessCredit.getCreditType()).idBusinessCredit(businessCredit
            .getIdBusinessCredit())
        .ruc(businessCredit.getBusinessClient().getRuc())
        .idBusinessClient(businessCredit.getBusinessClient().getIdBusinessClient()).build();
  }

  public static BusinessCredit dtoToEntity(BusinessCreditDTO personalCreditDTO) {
    return BusinessCredit.builder().amountPaid(personalCreditDTO.getAmountPaid())
        .creditBalance(personalCreditDTO.getCreditBalance())
        .creditName(personalCreditDTO.getCreditName())
        .creditType(personalCreditDTO.getCreditType())
        .idBusinessCredit(personalCreditDTO.getIdBusinessCredit())
        .businessClient(new BusinessClient(personalCreditDTO
            .getIdBusinessClient(), personalCreditDTO.getRuc()))
        .build();
  }
}
