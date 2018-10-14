package com.hdtech.dianligongdan.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dianli_managers")
public class Account extends BaseEntity implements Serializable {
    @Column(name = "last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private String appversion;
    @Column(name = "IMEI")
    private String iMEI;
    private String phonenum;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private AccountEnabled enabled;
    private String password;
    private String post;
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    @Column(name = "organization_id")
    private int organizationId;
    @Column(name = "manager_role_id")
    private int managerRoleId;
    private String name;
    @Id
    private int id;
    @Column(name = "last_os")
    private String lastOs;
    @Column(name = "last_cid")
    private String lastCid;
    private String username;

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getiMEI() {
        return iMEI;
    }

    public void setiMEI(String iMEI) {
        this.iMEI = iMEI;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountEnabled getEnabled() {
        return enabled;
    }

    public void setEnabled(AccountEnabled enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getManagerRoleId() {
        return managerRoleId;
    }

    public void setManagerRoleId(int managerRoleId) {
        this.managerRoleId = managerRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastOs() {
        return lastOs;
    }

    public void setLastOs(String lastOs) {
        this.lastOs = lastOs;
    }

    public String getLastCid() {
        return lastCid;
    }

    public void setLastCid(String lastCid) {
        this.lastCid = lastCid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account() {
    }
}

enum AccountType {
    front, back, leader, charge
}

enum AccountEnabled {
    y, n
}