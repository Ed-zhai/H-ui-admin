package com.lanou.service;

import com.lanou.bean.SysRole;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface SysRoleSerivce {
    List<SysRole>selectAllRole();

    int deleteByPrimaryKey(Integer id);
    int deleteRoleMenuByPrimaryKey(Integer id);

    SysRole selectByPrimaryKey(SysRole sysRole);

    int insertSelective(SysRole sysRole);
    int insertRoleMenu(Integer roleid,Integer menuid);
}
