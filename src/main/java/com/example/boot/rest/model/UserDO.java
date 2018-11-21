package com.example.boot.rest.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserDO {
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