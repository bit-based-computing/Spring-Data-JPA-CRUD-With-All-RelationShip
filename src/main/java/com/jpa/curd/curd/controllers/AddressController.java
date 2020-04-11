package com.jpa.curd.curd.controllers;

import com.jpa.curd.curd.domains.Address;
import com.jpa.curd.curd.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/{userId}")
    public Address getAddress(@PathVariable long userId){
        return addressService.getAddress(userId);
    }

    @PutMapping("/{userId}")
    public Address updateAddress(@PathVariable long userId, @Valid @RequestBody Address address){
        return addressService.updateAddress(userId, address);
    }
}
