package com.dailycodebuffer.usersystem.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.sql.Date;


@Entity
@Table(name = "archive")
public class ArchiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date attendence_time ;
    private Date attendence_record ;
    private String State;
    private String employee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAttendence_time() {
        return attendence_time;
    }

    public void setAttendence_time(Date attendence_time) {
        this.attendence_time = attendence_time;
    }

    public Date getAttendence_record() {
        return attendence_record;
    }

    public void setAttendence_record(Date attendence_record) {
        this.attendence_record = attendence_record;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public ArchiveEntity() {

    }
// Constructors, getters, and setters
}