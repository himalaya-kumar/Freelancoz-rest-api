package com.freelancoz.serviceInterface;

import com.freelancoz.model.Address;

public interface AddressService {
    Address getAddress(long id);
    void saveAddress(Address address);
}
