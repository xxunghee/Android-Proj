package com.example.mylifecycle;

import java.io.Serializable;

public class Info implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
