package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Activity;
import io.zipcoder.tc_spring_poll_application.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ActivityController {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @RequestMapping(value = "/users/{userId}/buttons/{buttonMac}/activities", method = RequestMethod.POST)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public ResponseEntity<?> createActivity(@PathVariable Long buttonMac, @RequestBody Activity activity) {
        activity = activityRepository.save(activity);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{timestamp}").buildAndExpand(activity.getTimestamp()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/buttons/activities", method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public Iterable<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @RequestMapping(value = "/users/{userId}/buttons/{buttonMac}/activities", method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
    public Iterable<Activity> getAllActivitiesByButtonMac(@PathVariable (value = "buttonMac") Long postId) {
        return activityRepository.findDurationByButtonMac(postId);
    }
}
