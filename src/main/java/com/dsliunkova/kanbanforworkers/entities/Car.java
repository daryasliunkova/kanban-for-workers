package com.dsliunkova.kanbanforworkers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private int id;
    @Column(name = "carNumber")
    private String carNumber;
    @Column(name = "model")
    private String model;

    public Car(String carNumber, String model) {
        this.carNumber = carNumber;
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
