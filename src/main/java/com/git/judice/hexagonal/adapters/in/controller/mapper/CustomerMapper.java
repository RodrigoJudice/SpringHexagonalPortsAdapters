package com.git.judice.hexagonal.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.git.judice.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.git.judice.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.git.judice.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "validDocument", ignore = true)
  Customer toCustomer(CustomerRequest customerRequest);

  CustomerResponse toCustomerResponse(Customer customer);

}
