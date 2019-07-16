package com.training.rettiwt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Account extends BaseEntity {

    @Id
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_gen")
    @SequenceGenerator(name = "account_gen", sequenceName = "account_id_seq")
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 30)
    private String phone;

    @Column
    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
    private Profile profile;
}
