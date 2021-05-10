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
@Table(name = "retokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class retokens {
    @Id
    @Column(name = "uname")
    private String username;    // max length 20

    @Column(name = "rtoken")
    private String rtoken;  // max length 300
}
