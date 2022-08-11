package com.andryanstgkr.desmartweb.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User extends BaseEntity{

    private String userName;

    private String email;

    private String password;

}