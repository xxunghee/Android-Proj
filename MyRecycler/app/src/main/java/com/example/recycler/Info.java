package com.example.recycler;

public class Info {
    private String name;
    private int age;

    public Info(String s, int i) {
        this.name = s;
        this.age = i;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return Integer.toString(age);
    }
}
