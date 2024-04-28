package com.dailycodebuffer.usersystem.service;

import com.dailycodebuffer.usersystem.entity.EmployeeEntity;
import com.dailycodebuffer.usersystem.model.Employee;
import com.dailycodebuffer.usersystem.repository.UserRepsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class UserServiceImpl implements  UserService{
        private UserRepsitory userRepsitory;

        public UserServiceImpl(UserRepsitory userRepsitory) {
            this.userRepsitory = userRepsitory;
        }

        @Override
        public Employee saveUser(Employee user) {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            BeanUtils.copyProperties(user, employeeEntity);
            userRepsitory.save(employeeEntity);
            return user;
        }

    @Override
    public List<Employee> getAllUsers() {
            List<EmployeeEntity> userEntities= userRepsitory.findAll();


            List<Employee> users= userEntities.stream().map(employeeEntity -> new Employee(
                    employeeEntity.getId(),
                            employeeEntity.getDepartment_id(),
                            employeeEntity.getMatricule(),
                    employeeEntity.getFirstName(),
                    employeeEntity.getLastName(),

                            employeeEntity.getBirthday(),
                    employeeEntity.getRole_id()


            ))
                    .collect(Collectors.toList());

        return users;
    }



    @Override
    public Employee getUserById(int id) {
        EmployeeEntity employeeEntity = userRepsitory.findById((long) id).get();
        Employee user = new Employee();
        BeanUtils.copyProperties(employeeEntity,user);
            return user;
    }

    @Override
    public boolean deleteUser(int id) {
            EmployeeEntity user = userRepsitory.findById((long) id).get();
            userRepsitory.delete(user);
        return true;
    }

    @Override
    public Employee upddateUser(int id, Employee user) {
            EmployeeEntity employeeEntity = userRepsitory.findById((long)id).get();
            employeeEntity.setFirstName(user.getFirstName());
            employeeEntity.setRole_id(user.getRole_id());
            employeeEntity.setMatricule(user.getMatricule());
            employeeEntity.setDepartment_id(user.getDepartment_id());

            //employeeEntity.setFirstName(user.getFirstName());
            //employeeEntity.setLastName(user.getLastName());
        userRepsitory.save(employeeEntity);


        return user;
    }

}
