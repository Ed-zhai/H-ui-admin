package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;

/**
 * Created by dllo on 17/11/14.
 */
public interface SysMenuService {
    PageInfo<SysMenu> findAllMenu(Integer pageNo, Integer pageSize);

}
