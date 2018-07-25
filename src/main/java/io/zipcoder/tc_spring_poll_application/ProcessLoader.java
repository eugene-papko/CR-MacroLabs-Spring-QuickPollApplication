package io.zipcoder.tc_spring_poll_application;

import io.zipcoder.tc_spring_poll_application.domain.Activity;
import io.zipcoder.tc_spring_poll_application.domain.Button;
import io.zipcoder.tc_spring_poll_application.domain.User;
import io.zipcoder.tc_spring_poll_application.repositories.ActivityRepository;
import io.zipcoder.tc_spring_poll_application.repositories.ButtonRepository;
import io.zipcoder.tc_spring_poll_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class ProcessLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ButtonRepository buttonRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public void run(ApplicationArguments args) {


        User user1 = new User("Maria", "sdffd");
        Button but1 = new Button(1234235445L, user1);
        Button but2 = new Button(23456645345L, user1);
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date1 = new Date(stamp.getTime());
        Activity act1 = new Activity(date1, 23, but1);

//        user1.setButtons(new HashSet<Button>() {{
//            add(but1);
//            add(but2);
//        }});


        userRepository.save(user1);
        buttonRepository.save(but1);
        buttonRepository.save(but2);
        User user2 = new User("Eugene", "werfdfgr");
        userRepository.save(user2);
        buttonRepository.save(new Button(92512323445L, user2));
        activityRepository.save(act1);
    }
}
