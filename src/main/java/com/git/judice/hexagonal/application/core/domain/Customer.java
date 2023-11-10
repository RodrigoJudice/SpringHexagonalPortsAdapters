package com.git.judice.hexagonal.application.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private String id;
  private String name;
  private Address address;
  private String documentId;
  private boolean validDocument = false;
}
