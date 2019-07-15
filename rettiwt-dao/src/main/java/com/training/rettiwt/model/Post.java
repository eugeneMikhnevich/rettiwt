package com.training.rettiwt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Post extends BaseEntity {

    @Column(length = 350, nullable = false)
    private String message;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Integer dislikes;

    //todo
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @OneToOne
    private Post post;

}
