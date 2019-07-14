package com.training.rettiwt.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
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
    private Account account;

    @ManyToMany
    private List<Profile> subscriptions;

    @ManyToMany
    private List<Profile> subscribers;

}
