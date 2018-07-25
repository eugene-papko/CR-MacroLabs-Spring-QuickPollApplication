package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "button_mac")
    private Button button;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Activity(Date timestamp, Integer duration, Button button) {
        this.timestamp = timestamp;
        this.duration = duration;
        this.button = button;
    }

    public Activity() {}
}
