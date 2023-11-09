package com.git.judice.hexagonal.application.ports.out;

import java.util.Optional;

import com.git.judice.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);
}