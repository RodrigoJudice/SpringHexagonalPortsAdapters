package com.git.judice.hexagonal.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

  @Override
  public Customer findById(String id) {

    return findCustomerByIdOutputPort.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

  }

}
