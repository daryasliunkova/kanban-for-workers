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
    @JoinColumn(name = "caseId")
    private Case issueCase;
    @Column(name = "status")
    private Status status;
    @Column(name = "changeDate")
    private Date changeDate;

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
