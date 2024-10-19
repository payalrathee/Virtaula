package com.virtaula.entities;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class Schedule {
    private Date startDate;
    private Date endDate;

    public Schedule() {
    }

    public Schedule(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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
}
