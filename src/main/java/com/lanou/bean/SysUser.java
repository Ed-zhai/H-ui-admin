package com.lanou.bean;

import java.util.List;

public class SysUser {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private Integer roleId;

    private Integer usertype;

    private Integer state;

    private String thirdId;

    private String endTime;

    private String email;

    private String tel;

    private String address;

    private String titleUrl;

    private String remark;

    private String theme;

    private Integer backSiteId;

    private Integer createSiteId;

    private String createTime;

    private Integer createId;

    private String updateTime;

    private Integer updateId;

    private List<SysRole> sysRoleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId == null ? null : thirdId.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl == null ? null : titleUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Integer getBackSiteId() {
        return backSiteId;
    }

    public void setBackSiteId(Integer backSiteId) {
        this.backSiteId = backSiteId;
    }

    public Integer getCreateSiteId() {
        return createSiteId;
    }

    public void setCreateSiteId(Integer createSiteId) {
        this.createSiteId = createSiteId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", roleId=" + roleId +
                ", usertype=" + usertype +
                ", state=" + state +
                ", thirdId='" + thirdId + '\'' +
                ", endTime='" + endTime + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", titleUrl='" + titleUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", theme='" + theme + '\'' +
                ", backSiteId=" + backSiteId +
                ", createSiteId=" + createSiteId +
                ", createTime='" + createTime + '\'' +
                ", createId=" + createId +
                ", updateTime='" + updateTime + '\'' +
                ", updateId=" + updateId +
                ", sysRoleList=" + sysRoleList +
                '}';
    }
}