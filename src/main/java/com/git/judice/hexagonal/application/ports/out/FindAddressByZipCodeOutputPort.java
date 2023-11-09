package com.git.judice.hexagonal.application.ports.out;

import com.git.judice.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
