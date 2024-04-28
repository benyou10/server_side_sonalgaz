package com.dailycodebuffer.usersystem.entity;

import com.dailycodebuffer.usersystem.model.Roles;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToOne
    private DepartmentEntity department;

    private int matricule;
    private String firstName;
    private String lastName;

    private Date birthday;
    private Roles role_id;
    public EmployeeEntity(int id, DepartmentEntity department, int matricule, String firstName, String lastName, Date birthday, Roles role_id) {
        this.id = id;
        this.department = department;
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role_id = role_id;
    }

    public EmployeeEntity() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentEntity getDepartment_id() {
        return department;
    }

    public void setDepartment_id(DepartmentEntity departmentEntity) {
        this.department = departmentEntity;
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
