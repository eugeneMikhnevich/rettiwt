package com.training.rettiwt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Profile extends BaseEntity {

    @Id
    private Long id;

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
     * Even if fetch type lazy is specified profile will be fetched
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    private Account account;
}
