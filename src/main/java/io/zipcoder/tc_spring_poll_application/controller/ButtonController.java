package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Button;
import io.zipcoder.tc_spring_poll_application.repositories.ButtonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.data.domain.Pageable;

@RestController
public class ButtonController {
    private ButtonRepository buttonRepository;

    @Autowired
    public ButtonController(ButtonRepository buttonRepository) {
        this.buttonRepository = buttonRepository;
    }

    @RequestMapping(value = "/users/{userId}/buttons", method = RequestMethod.POST)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> createButton(@PathVariable Long userId, @RequestBody Button button) {
        button = buttonRepository.save(button);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{mac}").buildAndExpand(button.getMac()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/buttons", method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public Iterable<Button> getAllButtons() {
        return buttonRepository.findAll();
    }

    @RequestMapping(value = "/users/{userId}/buttons", method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
//    public Iterable<Button> getButton(@PathVariable Long userId) {
//        return buttonRepository.findButtonByUserId(userId);
//    }
    public Iterable<Button> getAllCommentsByPostId(@PathVariable (value = "userId") Long postId) {
        return buttonRepository.findButtonByUserId(postId);
    }
}
