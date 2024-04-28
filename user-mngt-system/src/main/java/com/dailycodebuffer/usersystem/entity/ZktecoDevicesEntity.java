package com.dailycodebuffer.usersystem.entity;

import com.dailycodebuffer.usersystem.model.Connection;
import jakarta.persistence.*;

@Entity
@Table(name ="ZktecoDevice")
public class ZktecoDevicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String device_name;
    public String getDeviceName() {
        return this.device_name;
    }

    public void setDeviceName(String device_name) {
        this.device_name = device_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZktecoDevicesEntity(int id, String device_name, String password, String ip_address, int port, Connection connection_State) {
        this.id = id;
        this.device_name = device_name;
        this.password = password;
        this.ip_address = ip_address;
        this.port = port;
        this.Connection_State = connection_State;
    }


    private String password;
    private String ip_address;
    private int port;

    @Enumerated(EnumType.STRING)
    private Connection Connection_State;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Connection getConnection_State() {
        return Connection_State;
    }

    public void setConnection_State(Connection connection_State) {
        this.Connection_State = connection_State;
    }


    public ZktecoDevicesEntity(){
    };

}
