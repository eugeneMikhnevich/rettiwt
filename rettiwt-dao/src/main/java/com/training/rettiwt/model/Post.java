package com.training.rettiwt.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
public class Post extends BaseEntity {

    @Column(length = 350, nullable = false)
    private String message;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Integer dislikes;

    //todo
    @ManyToOne
    private Profile profile;

    @OneToOne
    private Post post;

}
