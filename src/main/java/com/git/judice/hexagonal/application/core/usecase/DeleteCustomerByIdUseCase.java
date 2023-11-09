package com.git.judice.hexagonal.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import com.git.judice.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
  private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

  @Override
  public void deleteById(String id) {
    findCustomerByIdOutputPort.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    deleteCustomerByIdOutputPort.delete(id);
  }

}
