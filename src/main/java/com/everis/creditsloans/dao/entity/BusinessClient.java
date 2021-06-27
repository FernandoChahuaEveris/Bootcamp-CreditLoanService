package com.everis.creditsloans.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class BusinessClient {
  @Id
  private UUID idBusinessClient;
  private String ruc;
}
