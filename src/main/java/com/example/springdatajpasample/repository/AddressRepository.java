package com.example.springdatajpasample.repository;

import com.example.springdatajpasample.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long > {
}
