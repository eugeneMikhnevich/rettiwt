package com.training.rettiwt.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Account extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 30)
    private String phone;

    @Column(nullable = false)
    private Boolean deleted;

}