package com.dailycodebuffer.usersystem.entity;

import com.dailycodebuffer.usersystem.model.Attendence_State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "archive")
public class ArchiveEntity {
    public int getId() {
        return id;
    }



    public ArchiveEntity(int id, Date attendence_day, Time morning_attendence,Time morning_leaving ,Time mid_day_leaving , Time mid_day_attendence, Attendence_State attendence_State, EmployeeEntity employee) {
        this.id = id;
        this.attendence_day = attendence_day;
        this.morning_attendence = morning_attendence;
        this.morning_leaving=morning_leaving;
        this.mid_day_leaving=mid_day_leaving;
        this.mid_day_attendence = mid_day_attendence;
        this.attendence_State = attendence_State;
        this.employee = employee;

    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAttendence_day() {
        return attendence_day;
    }

    public void setAttendence_day(Date attendence_day) {
        this.attendence_day = attendence_day;
    }

    public Time getMorning_attendence() {
        return morning_attendence;
    }

    public void setMorning_attendence(Time morning_attendence) {
        this.morning_attendence = morning_attendence;
    }

    public Time getMid_day_attendence() {
        return mid_day_attendence;
    }

    public void setMid_day_attendence(Time mid_day_attendence) {
        this.mid_day_attendence = mid_day_attendence;
    }

    public Attendence_State getAttendence_State() {
        return attendence_State;
    }

    public void setAttendence_State(Attendence_State attendence_State) {
        this.attendence_State = attendence_State;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date attendence_day ;

    public Time getMorning_leaving() {
        return morning_leaving;
    }

    public void setMorning_leaving(Time morning_leaving) {
        this.morning_leaving = morning_leaving;
    }

    public Time getMid_day_leaving() {
        return mid_day_leaving;
    }

    public void setMid_day_leaving(Time mid_day_leaving) {
        this.mid_day_leaving = mid_day_leaving;
    }

    private Time morning_attendence ;
    private Time morning_leaving ;
    private Time mid_day_attendence ;
    private Time mid_day_leaving ;
    @Enumerated(EnumType.STRING)
    private Attendence_State attendence_State;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private EmployeeEntity employee;


    public ArchiveEntity() {

    }
// Constructors, getters, and setters
}