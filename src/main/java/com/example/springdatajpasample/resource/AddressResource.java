package com.example.springdatajpasample.resource;

import com.example.springdatajpasample.entity.Address;
import com.example.springdatajpasample.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressResource {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address){
        Address save = addressRepository.save(address);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
}
