package com.dailycodebuffer.usersystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "department")
public class DepartmentEntity {
    public DepartmentEntity(int id, String department_name, List<EmployeeEntity> employees) {
        this.id = id;
        this.department_name = department_name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public DepartmentEntity(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department_name;
    @OneToMany (mappedBy = "department")
    private List<EmployeeEntity> employees;
}
