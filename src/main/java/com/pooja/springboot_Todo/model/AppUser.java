package com.pooja.springboot_Todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "user_table")
    public class AppUser {
        @Id
        @GeneratedValue
        private int id;
        private String username;
        private String password;

        @JsonIgnore
        @OneToMany(mappedBy = "appUser")
        private List<Todo> todoList;
}
