package com.freelancoz.serviceImpl;

import com.freelancoz.model.Address;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.serviceInterface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddress(long id) {
        Optional<Address> address = addressRepository.findById(id);
                return address.get();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}