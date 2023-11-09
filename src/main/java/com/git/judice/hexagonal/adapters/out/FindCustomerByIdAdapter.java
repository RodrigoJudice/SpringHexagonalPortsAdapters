package com.git.judice.hexagonal.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.out.repository.CustomerRepository;
import com.git.judice.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }

}
