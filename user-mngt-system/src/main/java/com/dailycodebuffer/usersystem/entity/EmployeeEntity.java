package com.dailycodebuffer.usersystem.entity;

import com.dailycodebuffer.usersystem.model.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToOne
   @JoinColumn(name = "department_id")

    private DepartmentEntity department;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<ArchiveEntity> archives;
    private int matricule;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private TimeOffEntity timeOff;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private String firstName;
    private String lastName;

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
    @Column(columnDefinition = "integer default 0")
    private int RC;
    @Column(columnDefinition = "integer default 10")
    private int CP;
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private Roles role_id;

    public EmployeeEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public List<ArchiveEntity> getArchives() {
        return archives;
    }

    public void setArchives(List<ArchiveEntity> archives) {
        this.archives = archives;
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

    public EmployeeEntity(int id, List<ArchiveEntity> archives, DepartmentEntity department, int matricule, String password, String firstName, String lastName, Date birthday, Roles role_id, int RC, int CP, String email, int phoneNumber) {
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
        this.phoneNumber=phoneNumber;
    }


}
