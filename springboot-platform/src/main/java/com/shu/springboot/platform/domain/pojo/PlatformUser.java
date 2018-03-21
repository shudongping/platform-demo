package com.shu.springboot.platform.domain.pojo;

import java.util.Date;

public class PlatformUser {
    private String id;

    private String username;

    private Integer age;

    private Byte userType;

    private String mobile;

    private Date createTime;

    private Date updateTime;

    public PlatformUser(String id, String username, Integer age, Byte userType, String mobile, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.userType = userType;
        this.mobile = mobile;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PlatformUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}