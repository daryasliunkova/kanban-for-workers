package com.dsliunkova.kanbanforworkers.entities;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "make")
    private String make;
    @Column(name = "carNumber")
    private String carNumber;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "year")
    private int year;
    @Column(name = "vin")
    private String vin;

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
