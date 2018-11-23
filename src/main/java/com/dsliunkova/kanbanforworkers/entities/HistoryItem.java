package com.dsliunkova.kanbanforworkers.entities;

import com.dsliunkova.kanbanforworkers.entities.enums.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryItem {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "case_id")
    private Case issueCase;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "status")
    private Status status;
    @Column(name = "change_date")
    private Date changeDate;
    @Column(name = "description")
    private String description;
    @Column(name = "old_value")
    private String oldValue;
    @Column(name = "new_value")
    private String newValue;

    public HistoryItem(Case issueCase, Status status, Date changeDate) {

        this.status = status;
        this.changeDate = changeDate;
    }

    public HistoryItem() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}
