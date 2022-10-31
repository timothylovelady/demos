package com.brainstutter.brainstutter.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserDTO {

    private Integer id;

    private String userName;

    private Date created;

    private  String email;

    private String avatarUrl;

    private String token;

}
