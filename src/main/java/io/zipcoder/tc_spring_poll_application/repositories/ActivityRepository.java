package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Iterable<Activity> findDurationByButtonMac(Long buttonMac);
}
