package com.anthony.smarthome.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class accounts {
    @Id
    @Column(name = "uname")
    private String username;    // max length: 20

    @Column(name = "passwd")
    private String password;    // max length: 50

    @Column(name = "accounttype")
    private boolean accountType;    // 0: device | 1: admin
}
