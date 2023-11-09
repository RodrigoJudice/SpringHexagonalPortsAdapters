package com.git.judice.hexagonal.application.ports.in;

import com.git.judice.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPorta {

  void update(Customer customer, String zipCode);
}
