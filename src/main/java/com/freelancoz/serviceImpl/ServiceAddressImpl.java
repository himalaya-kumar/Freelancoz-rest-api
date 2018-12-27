package com.freelancoz.serviceImpl;

import com.freelancoz.model.Address;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.serviceInterface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAddressImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddress(long id) {
        Address address = addressRepository.findByaddressId(id);
        return address;
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

}