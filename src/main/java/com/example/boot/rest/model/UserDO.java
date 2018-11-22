package com.example.boot.rest.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 4382629624053154693L;
    private Long id;

    private String name;

    private String password;

    private String gender;

    private String phoneNumber;

    private String email;

    private String career;

    private String idNumber;

    private String birthday;

    private String address;

    private Long createdAt;

    private Long updatedAt;


}