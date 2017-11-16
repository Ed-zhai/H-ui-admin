package com.lanou.service.impl;

import com.lanou.bean.SysRole;
import com.lanou.mapper.SysRoleMapper;
import com.lanou.service.SysRoleSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Service
public class SysRoleSerivceImpl implements SysRoleSerivce {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectAllRole() {

        List<SysRole> sysRoles = sysRoleMapper.selectAllRole();
        return sysRoles;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = sysRoleMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int deleteRoleMenuByPrimaryKey(Integer id) {
        int i = sysRoleMapper.deleteRoleMenuByPrimaryKey(id);
        return i;
    }

    @Override
    public SysRole selectByPrimaryKey(SysRole sysRole) {
        SysRole sysRole1 = sysRoleMapper.selectByPrimaryKey(sysRole.getId());
        return sysRole1;
    }

    @Override
    public int insertSelective(SysRole sysRole) {
        int i = sysRoleMapper.insertSelective(sysRole);
        return i;
    }

    @Override
    public int insertRoleMenu(Integer roleid, Integer menuid) {
        int i = sysRoleMapper.insertRoleMenu(roleid, menuid);
        return i;
    }
}
