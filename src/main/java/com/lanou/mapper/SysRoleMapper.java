package com.lanou.mapper;

import com.lanou.bean.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteRoleMenuByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertRoleMenu(@Param("roleid") Integer roleid,@Param("menuid") Integer menuid);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> selectAllRole();

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKeyWithBLOBs(SysRole record);

    int updateByPrimaryKey(SysRole record);


}