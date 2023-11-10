package com.git.judice.hexagonal.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.git.judice.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.git.judice.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

  CustomerEntity toCustomerEntity(Customer customer);

  Customer toCustomer(CustomerEntity customerEntity);

}
