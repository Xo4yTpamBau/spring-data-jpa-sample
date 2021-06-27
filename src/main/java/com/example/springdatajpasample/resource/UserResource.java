package com.example.springdatajpasample.resource;

import com.example.springdatajpasample.entity.User;
import com.example.springdatajpasample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        final User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody User user){
        User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PostMapping("findById")
    public ResponseEntity<User> findById(long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> all = userRepository.findAll();
        if (all.size() != 0) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("deleteById")
    public ResponseEntity<?> deleteById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("findByUsername")
    public ResponseEntity<User> findByUsername(String username){
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()){
            User user = byUsername.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("findAllByName")
    public ResponseEntity<List<User>> findAllByName(String name) {
        List<User> all = userRepository.findAllByName(name);
        if (all.size() != 0) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
