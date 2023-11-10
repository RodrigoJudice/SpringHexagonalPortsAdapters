package com.git.judice.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.git.judice.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.git.judice.hexagonal.adapters.out.InsertCustomerAdapter;
import com.git.judice.hexagonal.adapters.out.SendDocumentForValidationAdapter;
import com.git.judice.hexagonal.application.core.usecase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

  @Bean
  public InsertCustomerUseCase insertCustomerUseCase(
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      InsertCustomerAdapter insertCustomerAdapter,
      SendDocumentForValidationAdapter sendDocumentForValidationAdapter) {

    return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter,
        sendDocumentForValidationAdapter);

  }
}
