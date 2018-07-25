package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.User;
import io.zipcoder.tc_spring_poll_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value="/users", method=RequestMethod.POST)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> createUser(@RequestBody User user) {
        user = userRepository.save(user);
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(newPollUri);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        User user = userRepository.findOne(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method=RequestMethod.PUT)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId) {
        User usr = userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method=RequestMethod.DELETE)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
