package com.example.springdatajpasample.resource;

import com.example.springdatajpasample.entity.Phone;
import com.example.springdatajpasample.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("phone")
@RestController
public class PhoneResource {

    @Autowired
    private PhoneRepository phoneRepository;

    @PostMapping
    public ResponseEntity<Phone> save(@RequestBody Phone phone){
        Phone save = phoneRepository.save(phone);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
}
