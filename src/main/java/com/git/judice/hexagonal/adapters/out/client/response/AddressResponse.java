package com.git.judice.hexagonal.adapters.out.client.response;

import lombok.*;

@Getter
@Setter
public class AddressResponse {
    private String street;
    private String city;
    private String state;
}
