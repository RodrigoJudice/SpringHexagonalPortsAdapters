package com.git.judice.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

  private String id;

  private String name;

  private String zipCode;

  private String documentId;

  private Boolean isValidDocument;

}
