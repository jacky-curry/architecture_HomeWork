package com.example.lab3.controller;


import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Integer id;

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
