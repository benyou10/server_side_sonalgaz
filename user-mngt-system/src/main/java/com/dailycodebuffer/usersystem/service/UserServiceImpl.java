package com.dailycodebuffer.usersystem.service;

import com.dailycodebuffer.usersystem.entity.ArchiveEntity;
import com.dailycodebuffer.usersystem.entity.EmployeeEntity;
import com.dailycodebuffer.usersystem.entity.TimeOffEntity;
import com.dailycodebuffer.usersystem.entity.ZktecoDevicesEntity;
import com.dailycodebuffer.usersystem.model.*;
import com.dailycodebuffer.usersystem.repository.ArchiveRepository;
import com.dailycodebuffer.usersystem.repository.TimeOffRepository;
import com.dailycodebuffer.usersystem.repository.UserRepsitory;
import com.dailycodebuffer.usersystem.repository.ZktecoDevicesReposity;
import com.zkteco.commands.AttendanceRecord;
import com.zkteco.commands.UserInfo;
import com.zkteco.terminal.ZKTerminal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepsitory userRepsitory;
    private final ArchiveRepository archiveRepository;
    private final TimeOffRepository timeOffRepository;
    private final ZktecoDevicesReposity zktecoDevicesReposity;

    // Constructor injection for all dependencies
    public UserServiceImpl(UserRepsitory userRepsitory,
                           ArchiveRepository archiveRepository,
                           TimeOffRepository timeOffRepository,
                           ZktecoDevicesReposity zktecoDevicesReposity) {
        this.userRepsitory = userRepsitory;
        this.archiveRepository = archiveRepository;
        this.timeOffRepository = timeOffRepository;
        this.zktecoDevicesReposity = zktecoDevicesReposity;
    }

    @Override
    public Employee saveUser(Employee user) {
        System.out.println(user.getRole_id());
        System.out.println("user.getDepartment_id()");
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setDepartment(user.getDepartment_id());
        BeanUtils.copyProperties(user, employeeEntity);
        userRepsitory.save(employeeEntity);
        return user;
    }

    @Override
    public List<Employee> getAllUsers() {
        List<EmployeeEntity> userEntities = userRepsitory.findAll();
        return userEntities.stream()
                .map(employeeEntity -> new Employee(
                        employeeEntity.getId(),
                        employeeEntity.getArchives(),
                        employeeEntity.getDepartment(),
                        employeeEntity.getMatricule(),
                        employeeEntity.getPassword(),
                        employeeEntity.getFirstName(),
                        employeeEntity.getLastName(),
                        employeeEntity.getBirthday(),
                        employeeEntity.getRole_id(),
                        employeeEntity.getRC(),
                        employeeEntity.getCP(),
                        employeeEntity.getEmail(),
                        employeeEntity.getPhoneNumber()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllUsersInDepartment(int i) {
        System.out.println("ffffffffffff");
        EmployeeEntity userEn=userRepsitory.findById((long) i).get();

        List<EmployeeEntity> userEntities = userRepsitory.findByDepartment(userEn.getDepartment());
        return userEntities.stream()
                .map(employeeEntity -> new Employee(
                        employeeEntity.getId(),
                        employeeEntity.getArchives(),
                        employeeEntity.getDepartment(),
                        employeeEntity.getMatricule(),
                        employeeEntity.getPassword(),
                        employeeEntity.getFirstName(),
                        employeeEntity.getLastName(),
                        employeeEntity.getBirthday(),
                        employeeEntity.getRole_id(),
                        employeeEntity.getRC(),
                        employeeEntity.getCP(),
                        employeeEntity.getEmail(),
                        employeeEntity.getPhoneNumber()

                ))
                .collect(Collectors.toList());
    }


    @Override
    public Employee getUserById(int id) {
        EmployeeEntity employeeEntity = userRepsitory.findById((long) id).get();
        Employee user = new Employee();
        BeanUtils.copyProperties(employeeEntity, user);
        return user;
    }

    @Override
    public List<Archive> getAllNewArchivesInDepartment(int id) {
        EmployeeEntity userEn=userRepsitory.findById((long) id).get();

        List<EmployeeEntity> userEntities = userRepsitory.findByDepartment(userEn.getDepartment());
        return null;
    }

    @Override
    public UserInfo saveUserinDevice(UserInfo user) throws IOException {
List<ZktecoDevicesEntity> zktecoDevicesList =zktecoDevicesReposity.findAllByConnection(Connection.CONNECTING);
        System.out.println(user.getName());
        System.out.println(user.getRole());
        System.out.println(user.getUserid());
       for(ZktecoDevicesEntity zktecoDevices :zktecoDevicesList){
           ZKTerminal terminal = new ZKTerminal(zktecoDevices.getIp_address(), zktecoDevices.getPort());
           terminal.setCommKey(zktecoDevices.getPassword());

      terminal.modifyUserInfo(user);
       };


        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        EmployeeEntity user = userRepsitory.findById((long) id).orElseThrow(() -> new RuntimeException("User not found"));
        List<ArchiveEntity> archive = user.getArchives();

        userRepsitory.delete(user);
        return true;
    }

    @Override
    public List<TimeOff> searchForTimeOff() {
        List<TimeOffEntity> timeOffs = timeOffRepository.findAll();
        return timeOffs.stream()
                .map(timeOff -> new TimeOff(
                        timeOff.getId(),
                        timeOff.getStartDate(),
                        timeOff.getExperationDate(),
                        timeOff.getName(),
                        timeOff.getEmployee()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Employee upddateUser(int id, Employee user) {
        EmployeeEntity employeeEntity = userRepsitory.findById((long) id).orElseThrow(() -> new RuntimeException("User not found"));
        employeeEntity.setFirstName(user.getFirstName());
        employeeEntity.setRole_id(user.getRole_id());
        employeeEntity.setMatricule(user.getMatricule());
        employeeEntity.setDepartment(user.getDepartment_id());
        userRepsitory.save(employeeEntity);
        return user;
    }

    @Override
    public Boolean upddatePassword(int id, PasswordChange user) {
        System.out.println(user.getOldPassword());
        EmployeeEntity employeeEntity = userRepsitory.findById((long) id).get();
        System.out.println(employeeEntity.getPassword());
        String l=user.getOldPassword();
        String LL=employeeEntity.getPassword();
if(Objects.equals(l, LL)){

    employeeEntity.setPassword(user.getNewPassword());
    userRepsitory.save(employeeEntity);
    return true;
}
        return false;
    }

    public int updateRcByID(int id) {
        EmployeeEntity employeeEntity = userRepsitory.findById((long) id).orElseThrow(() -> new RuntimeException("User not found"));
        employeeEntity.setRC(employeeEntity.getRC() + 1);
        userRepsitory.save(employeeEntity);
        return 1;
    }

    public TimeOff searchForTimeOffById(int id) {
        TimeOffEntity timeOffEntity = timeOffRepository.findByEmployee_Id((long) id);
        if (timeOffEntity == null) {
            return null;  // Return null if no TimeOffEntity is found
        }
        TimeOff timeOff = new TimeOff();
        BeanUtils.copyProperties(timeOffEntity, timeOff);
        return timeOff;
    }

}
