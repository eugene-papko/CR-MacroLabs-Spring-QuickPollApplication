package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;

@Entity
@Table(name = "button")
public class Button {
    @Id
    @Column(name = "mac")
    private Long mac;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Button(Long mac, User user) {
        this.mac = mac;
        this.user = user;
    }

    public Button() {
    }

    //    @Column(name = "ACTIVITY_ID")
//    private Activity activity;

    public Long getMac() {
        return mac;
    }

    public void setMac(Long mac) {
        this.mac = mac;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Activity getActivity() {
//        return activity;
//    }
//
//    public void setActivity(Activity activity) {
//        this.activity = activity;
//    }
}
