package com.lanou.mapper;

import com.lanou.bean.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(String username);

    List<SysUser> findAll();

    List<SysUser> findBySearch(@Param("datemin") String datemin,@Param("datemax") String datemax,@Param("username") String username);
}