package com.dsliunkova.kanbanforworkers.entities;

import com.dsliunkova.kanbanforworkers.entities.enums.Status;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "repair_case")
public class Case {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "case_id", nullable = true)
    private Case problem;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "case_status")
    private Status status;


    public Case(String name, String description, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Case() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Case getProblem() {
        return problem;
    }

    public void setProblem(Case problem) {
        this.problem = problem;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
