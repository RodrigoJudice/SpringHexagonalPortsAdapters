package com.git.judice.hexagonal.application.ports.in;

import com.git.judice.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findById(String id);

}
