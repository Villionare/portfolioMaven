package com.abhay.diddy.Entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "Student")
public class Student {

    @Id //it tell this is id or primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //its the kind of id
    private Long id;

    private String name;
    private int age;
    private String course;

    public Student(){};

    public Student(Long id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
