package com.pooja.springboot_Todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo_table")
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String todo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uid",referencedColumnName = "id")
    private AppUser appUser;
}