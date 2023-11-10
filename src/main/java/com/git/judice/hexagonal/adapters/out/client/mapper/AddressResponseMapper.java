package com.git.judice.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.git.judice.hexagonal.adapters.out.client.response.AddressResponse;
import com.git.judice.hexagonal.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
  Address toAddress(AddressResponse addressResponse);
}
