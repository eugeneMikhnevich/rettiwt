package com.training.rettiwt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Profile extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 200)
    private String description;

    @Column(length = 100)
    private String location;

    @OneToOne
    @MapsId
    private Account account;

    @ManyToMany
    @JoinTable(name = "profile_2_subscriber",
            joinColumns = {@JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscriber_id")})
    private List<Profile> subscriptions;

    @ManyToMany
    @JoinTable(name = "profile_2_subscriber",
            joinColumns = {@JoinColumn(name = "subscriber_id")},
            inverseJoinColumns = {@JoinColumn(name = "profile_id")})
    private List<Profile> subscribers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private List<Post> posts;

}
