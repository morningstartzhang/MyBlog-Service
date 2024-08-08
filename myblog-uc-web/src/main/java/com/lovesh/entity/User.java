package com.lovesh.entity;

import java.util.Date;

public class User {
    private Long id;

    private String code;

    private String type;

    private String mobile;

    private String email;

    private String encryptMobile;

    private String encryptEmail;

    private String password;

    private Date passwordUseTime;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Byte errorRetryCnt;

    private String locked;

    private Date lockedExpireTime;

    private String isHalt;

    private String createUser;

    private Date createDatetime;

    private String modifyUser;

    private Date modifyDatetime;

    private Date expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptMobile() {
        return encryptMobile;
    }

    public void setEncryptMobile(String encryptMobile) {
        this.encryptMobile = encryptMobile;
    }

    public String getEncryptEmail() {
        return encryptEmail;
    }

    public void setEncryptEmail(String encryptEmail) {
        this.encryptEmail = encryptEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPasswordUseTime() {
        return passwordUseTime;
    }

    public void setPasswordUseTime(Date passwordUseTime) {
        this.passwordUseTime = passwordUseTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getErrorRetryCnt() {
        return errorRetryCnt;
    }

    public void setErrorRetryCnt(Byte errorRetryCnt) {
        this.errorRetryCnt = errorRetryCnt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Date getLockedExpireTime() {
        return lockedExpireTime;
    }

    public void setLockedExpireTime(Date lockedExpireTime) {
        this.lockedExpireTime = lockedExpireTime;
    }

    public String getIsHalt() {
        return isHalt;
    }

    public void setIsHalt(String isHalt) {
        this.isHalt = isHalt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}