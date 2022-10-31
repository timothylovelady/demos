package com.brainstutter.brainstutter.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(unique = true)
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    private String token;

    private Boolean online;
}
