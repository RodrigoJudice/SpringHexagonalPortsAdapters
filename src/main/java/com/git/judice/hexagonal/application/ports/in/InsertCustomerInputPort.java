package com.git.judice.hexagonal.application.ports.in;

import com.git.judice.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}