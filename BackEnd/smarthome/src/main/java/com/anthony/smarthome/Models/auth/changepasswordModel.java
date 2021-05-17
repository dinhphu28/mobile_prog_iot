package com.anthony.smarthome.Models.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class changepasswordModel {
    private String username;

    private String oldPassword;

    private String newPassword;

    private boolean accountType;
}
