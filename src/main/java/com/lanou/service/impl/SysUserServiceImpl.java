package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysUser;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageInfo<SysUser> findAllSysUsersWithPageInfo(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;

        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        List<SysUser> sysUserList = sysUserMapper.findAll();

        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUserList);

        return pageInfo;
    }

    @Override
    public PageInfo<SysUser> findAllSysUsersBySearch(Integer pageNo, Integer pageSize, String datemin, String datemax, String username) {

        pageNo = pageNo == null ? 1 : pageNo;

        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        List<SysUser> sysUserList = sysUserMapper.findBySearch(datemin,datemax,username);

        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUserList);

        return pageInfo;

    }
}
