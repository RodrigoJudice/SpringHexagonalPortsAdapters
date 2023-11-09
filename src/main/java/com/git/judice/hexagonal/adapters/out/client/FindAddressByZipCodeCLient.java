package com.git.judice.hexagonal.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.git.judice.hexagonal.adapters.out.client.response.AddressResponse;

@FeignClient(name = "findAddressByZipCode", url = "${hexagonal.client.address.url}")
public interface FindAddressByZipCodeCLient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);

}
