package com.git.judice.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

  private String name;

  private AddressResponse address;

  private String documentId;

  private Boolean validDocument;

}
