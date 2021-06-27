package com.example.springdatajpasample.repository;

import com.example.springdatajpasample.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
