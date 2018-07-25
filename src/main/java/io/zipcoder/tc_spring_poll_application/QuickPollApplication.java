package io.zipcoder.tc_spring_poll_application;

import io.zipcoder.tc_spring_poll_application.controller.UserController;
import io.zipcoder.tc_spring_poll_application.domain.Button;
import io.zipcoder.tc_spring_poll_application.domain.User;
import io.zipcoder.tc_spring_poll_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class QuickPollApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuickPollApplication.class, args);


    }
}