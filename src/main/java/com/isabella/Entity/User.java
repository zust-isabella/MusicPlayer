package com.isabella.Entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private Date birthday;
    private String sign;

}
