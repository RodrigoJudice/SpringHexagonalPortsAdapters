package com.git.judice.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.out.repository.CustomerRepository;
import com.git.judice.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.git.judice.hexagonal.application.core.domain.Customer;
import com.git.judice.hexagonal.application.ports.out.UpdateCustomerOutpuPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutpuPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
