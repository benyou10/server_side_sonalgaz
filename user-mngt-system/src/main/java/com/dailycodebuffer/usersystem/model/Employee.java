package com.dailycodebuffer.usersystem.model;

import com.dailycodebuffer.usersystem.entity.ArchiveEntity;
import com.dailycodebuffer.usersystem.entity.DepartmentEntity;

import java.sql.Date;
import java.util.List;

public class Employee {

    private int id;
    private DepartmentEntity department;

private String password;

    public int getRC() {
        return RC;
    }

    public void setRC(int RC) {
        this.RC = RC;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    private int RC;
    private int CP;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int matricule;
    private String firstName;
    private String lastName;

    private Date birthday;
    private List<ArchiveEntity> archives;

    public List<ArchiveEntity> getArchives() {
        return archives;
    }

    public void setArchives(List<ArchiveEntity> archives) {
        this.archives = archives;
    }

    private Roles role_id;
    private int phoneNumber;
    private  String email;

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(int id, List<ArchiveEntity> archives, DepartmentEntity department, int matricule, String password, String firstName, String lastName, Date birthday, Roles role_id, int RC, int CP,String email,int phoneNumber) {
        this.id = id;
        this.archives=archives;
        this.department = department;
        this.matricule = matricule;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role_id = role_id;
        this.RC=RC;
        this.CP=CP;
        this.email=email;
        this.phoneNumber =phoneNumber;
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
        return department;
    }

    public void setDepartment_id(DepartmentEntity department_id) {
        this.department = department_id;
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
