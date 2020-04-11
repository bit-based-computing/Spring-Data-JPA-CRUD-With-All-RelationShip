package com.jpa.curd.curd.services;

import com.jpa.curd.curd.domains.Address;
import com.jpa.curd.curd.domains.User;
import com.jpa.curd.curd.exceptions.ApplicationRunTimeException;
import com.jpa.curd.curd.repositories.AddressRepository;
import com.jpa.curd.curd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public Address getAddress(long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ApplicationRunTimeException("User Id " + userId + " Not Found");
        }
        if (addressRepository.findByUserId(userId) != null) {
            return addressRepository.findByUserId(userId);
        } else {
            throw new ApplicationRunTimeException("Address not found");
        }
    }

    public Address updateAddress(long userId, Address updateAddress) {
        return userRepository.findById(userId).map(user -> {
            Address address;
            if (user.getAddress() != null) {
                address = user.getAddress();
            } else {
                address = new Address();
            }
            address.setCountry(updateAddress.getCountry());
            address.setState(updateAddress.getState());
            address.setStreet(updateAddress.getStreet());
            address.setZipCode(updateAddress.getZipCode());
            address.setUser(user);
            return addressRepository.save(address);
        }).orElseThrow(() -> new ApplicationRunTimeException("User Id " + userId + " Not Found"));
    }
}
