package com.dailycodebuffer.usersystem.model;

import com.dailycodebuffer.usersystem.entity.DepartmentEntity;

import java.sql.Date;

public class Employee {

    private int id;
    private DepartmentEntity departmentEntity;



    private int matricule;
    private String firstName;
    private String lastName;

    private Date birthday;
    private Roles role_id;
    public Employee(int id, DepartmentEntity departmentEntity, int matricule, String firstName, String lastName, Date birthday, Roles role_id) {
        this.id = id;
        this.departmentEntity = departmentEntity;
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role_id = role_id;
    }
    public Employee(){

    }



    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentEntity getDepartment_id() {
        return departmentEntity;
    }

    public void setDepartment_id(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Roles getRole_id() {
        return role_id;
    }

    public void setRole_id(Roles role_id) {
        this.role_id = role_id;
    }
}
