package com.freelancoz.serviceInterface;

import com.freelancoz.model.Address;

public interface AddressService {
    Address getAddress(long id);
    Address saveAddress(Address address);
}
