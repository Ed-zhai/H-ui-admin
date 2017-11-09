package com.lanou.service.impl;

import com.lanou.bean.SysUser;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/8.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteById(Integer id) {

        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {

        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {

        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectById(Integer id) {

        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(SysUser record) {

        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(SysUser record) {

        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public SysUser selectByName(String username) {

        return sysUserMapper.selectByName(username);
    }
}
