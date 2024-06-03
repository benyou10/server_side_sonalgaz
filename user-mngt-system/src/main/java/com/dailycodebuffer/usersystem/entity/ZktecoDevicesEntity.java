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

    private int password;
    private String ip_address;
    private int port;

    @Enumerated(EnumType.STRING)
    private Connection connection;

    public ZktecoDevicesEntity(int id, String device_name, int password, String ip_address, int port, Connection connection_State) {
        this.id = id;
        this.device_name = device_name;
        this.password = password;
        this.ip_address = ip_address;
        this.port = port;
        this.connection = connection_State;
    }


    public String getDeviceName() {
        return this.device_name;
    }

    public void setDeviceName(String device_name) {
        this.device_name = device_name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
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
        return connection;
    }

    public void setConnection_State(Connection connection_State) {
        this.connection = connection_State;
    }


    public ZktecoDevicesEntity(){
    };

}
