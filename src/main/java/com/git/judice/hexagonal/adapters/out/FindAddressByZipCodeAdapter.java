package com.git.judice.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.out.client.FindAddressByZipCodeCLient;
import com.git.judice.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.git.judice.hexagonal.application.core.domain.Address;
import com.git.judice.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeCLient findAddressByZipCodeCLient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeCLient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}