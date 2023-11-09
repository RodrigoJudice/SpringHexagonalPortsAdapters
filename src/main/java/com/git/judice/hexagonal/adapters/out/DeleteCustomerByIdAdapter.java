package com.git.judice.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.out.repository.CustomerRepository;
import com.git.judice.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

  private final CustomerRepository customerRepository;

  @Override
  public void delete(String id) {
    customerRepository.deleteById(id);
  }

}
