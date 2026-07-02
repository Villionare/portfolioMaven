package com.abhay.diddy.Entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;
    private Double salary;
    private boolean married;

    public Teachers(Long ID, String name, Double salary, boolean married) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.married = married;
    }

    public Teachers() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        married = married;
    }
}
