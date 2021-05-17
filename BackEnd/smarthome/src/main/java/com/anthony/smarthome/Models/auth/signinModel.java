package com.anthony.smarthome.Models.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class signinModel {
    private String username;

    private String password;

    private boolean accountType;
}
