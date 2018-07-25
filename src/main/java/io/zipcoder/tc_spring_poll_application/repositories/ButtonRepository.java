package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.domain.Button;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Pageable;

@RepositoryRestResource
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public interface ButtonRepository extends JpaRepository<Button, Long> {
//    @Query(value = "SELECT b.* " +
//            "FROM Option o, Button b " +
//            "WHERE o.POLL_ID = ?1 " +
//            "AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
//    public Iterable<Button> findButtonsByUser(Long pollId);
        Iterable<Button> findButtonByUserId(Long userId);
}

