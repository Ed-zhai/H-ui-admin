package com.lanou.service;

import com.lanou.bean.SysUser;

/**
 * Created by dllo on 17/11/8.
 */
public interface SysUserService {

    int deleteById(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectById(Integer id);

    int updateByIdSelective(SysUser record);

    int updateById(SysUser record);

    SysUser selectByName(String username);
}
