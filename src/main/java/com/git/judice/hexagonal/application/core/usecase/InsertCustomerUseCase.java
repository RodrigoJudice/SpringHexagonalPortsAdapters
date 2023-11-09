package com.git.judice.hexagonal.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.git.judice.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.git.judice.hexagonal.application.ports.out.InsertCustomerOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }

}
