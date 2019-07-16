package com.training.rettiwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Profile {

    @Id
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 200)
    private String description;

    @Column(length = 100)
    private String location;

    /**
     * A working OneToOne relationship, but if you try to get account then profile will be also fetched.
     * Even if fetch type lazy will be specified profile will be fetched
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    @JsonIgnore
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_2_subscriber",
            joinColumns = {@JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscriber_id")})
    private List<Profile> subscriptions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_2_subscriber",
            joinColumns = {@JoinColumn(name = "subscriber_id")},
            inverseJoinColumns = {@JoinColumn(name = "profile_id")})
    private List<Profile> subscribers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private List<Post> posts;
}
