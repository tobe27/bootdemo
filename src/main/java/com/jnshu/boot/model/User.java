package com.jnshu.boot.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * 对应数据库里面是db_user
 * 字段有id，name,password
 */
@Data

public class User implements Serializable {
    private static final long serialVersionUID = -6713143892683483902L;

    private String id;
    private String name;
    private String password;
    private String role;

}
