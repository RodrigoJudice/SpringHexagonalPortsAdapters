package com.git.judice.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.git.judice.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.git.judice.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

  @Bean
  public FindCustomerByIdUseCase findCustomerByIdUseCase(
      FindCustomerByIdAdapter findCustomerByIdAdapter) {
    return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
  }

}
