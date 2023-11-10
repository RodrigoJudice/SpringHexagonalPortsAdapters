package com.git.judice.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.git.judice.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.git.judice.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.git.judice.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.git.judice.hexagonal.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      UpdateCustomerAdapter updateCustomerAdapter) {
    return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
  }

}
