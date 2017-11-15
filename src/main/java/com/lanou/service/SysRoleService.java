package com.lanou.service;

import com.lanou.bean.SysRole;

/**
 * Created by dllo on 17/11/10.
 */
public interface SysRoleService {
    int deleteById(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKeyWithBLOBs(SysRole record);

    int updateByPrimaryKey(SysRole record);
}
