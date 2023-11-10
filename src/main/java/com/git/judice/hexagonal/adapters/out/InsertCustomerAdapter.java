package com.git.judice.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.out.repository.CustomerRepository;
import com.git.judice.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.out.InsertCustomerOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  private final CustomerRepository customerRepository;

  @Autowired
  private final CustomerEntityMapper customerEntityMapper;

  @Override
  public void insert(Customer customer) {
    customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
  }

}
