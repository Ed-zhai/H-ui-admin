package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.mapper.SysMenuMapper;
import com.lanou.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
@Service("SysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    //查询所有
    public PageInfo<SysMenu> findAllMenu(Integer pageNo, Integer pageSize) {
        return queryServiceByPage(pageNo, pageSize);
    }

    //查询--分页
    public PageInfo<SysMenu> queryServiceByPage(
            Integer pageNo, Integer pageSize) {

        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<SysMenu> allMenu = sysMenuMapper.findAllMenu();

        //使用pageInfo对结果进行包装
        PageInfo<SysMenu> pageInfo = new PageInfo<>(allMenu);

        return pageInfo;
    }
}
