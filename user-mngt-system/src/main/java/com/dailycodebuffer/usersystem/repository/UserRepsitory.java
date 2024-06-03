package com.dailycodebuffer.usersystem.repository;

import com.dailycodebuffer.usersystem.entity.DepartmentEntity;
import com.dailycodebuffer.usersystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepsitory extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByDepartment(DepartmentEntity department);
}
