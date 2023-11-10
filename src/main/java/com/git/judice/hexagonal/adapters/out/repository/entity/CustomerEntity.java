package com.git.judice.hexagonal.adapters.out.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class CustomerEntity {

  @Id
  private String id;
  private String name;
  private AddressEntity address;
  private String documentId;
  private boolean isValidDocument;
}
