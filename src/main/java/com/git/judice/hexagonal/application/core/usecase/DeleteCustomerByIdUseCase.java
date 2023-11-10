package com.git.judice.hexagonal.application.core.usecase;

import com.git.judice.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;

  private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

  @Override
  public void delete(final String id) {
    findCustomerByIdInputPort.findById(id);
    deleteCustomerByIdOutputPort.delete(id);
  }

}
