package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    //@Column(name = "USER_ID")
    private Long id;

    //@Column(name = "NAME")
    private String name;

    //@Column(name = "PASS")
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    //@JoinColumn(name = "button_USER_ID")
//    //@OrderBy
//    private Set<Button> buttons;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

//    public User(String name, String password, Set<Button> buttons) {
//        this.name = name;
//        this.password = password;
//        this.buttons = buttons;
//    }

    public User() {
    }

    //    public User(String name, String password) {
//        this.name = name;
//        this.password = password;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Button> getButtons() {
//        return buttons;
//    }
//
//    public void setButtons(Set<Button> buttons) {
//        this.buttons = buttons;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}