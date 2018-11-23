package com.dsliunkova.kanbanforworkers.entities;

import com.dsliunkova.kanbanforworkers.entities.enums.Role;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "link_google")
    private String linkGoogle;

    public User(String surname, String name, Role role) {
        this.surname = surname;
        this.name = name;
        this.role = role;
    }

    public User() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
