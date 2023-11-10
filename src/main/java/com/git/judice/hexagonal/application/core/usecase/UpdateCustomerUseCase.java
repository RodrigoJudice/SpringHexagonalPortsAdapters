package com.git.judice.hexagonal.application.core.usecase;

import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.in.UpdateCustomerInputPorta;
import com.git.judice.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.git.judice.hexagonal.application.ports.out.UpdateCustomerOutpuPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomerInputPorta {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final UpdateCustomerOutpuPort updateCustomerOutpuPort;

  @Override
  public void update(Customer customer, String zipCode) {
    var customerSaved = findCustomerByIdInputPort.findById(customer.getId());
    var address = findAddressByZipCodeOutputPort.find(zipCode);

    customerSaved.setName(customer.getName());
    customerSaved.setDocumentId(customer.getDocumentId());
    customerSaved.setAddress(address);

    updateCustomerOutpuPort.update(customerSaved);

  }

}
