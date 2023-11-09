package com.git.judice.hexagonal.application.ports.out;

import com.git.judice.hexagonal.application.core.domain.Customer;

public interface DeleteCustomerByIdOutputPort {
  void delete(String id);
}
