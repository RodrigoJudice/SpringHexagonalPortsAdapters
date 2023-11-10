package com.git.judice.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.git.judice.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.git.judice.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.git.judice.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdConfig {

  @Bean
  public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
    return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
  }

}
