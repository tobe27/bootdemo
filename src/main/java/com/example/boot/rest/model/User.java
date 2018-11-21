package com.example.boot.rest.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * 对应数据库里面是user
 * @author Created by L.C.Y on 2018-11-20
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 9028234143724515096L;

    private String id;
    private String name;
    private String password;
    private String role;

}
