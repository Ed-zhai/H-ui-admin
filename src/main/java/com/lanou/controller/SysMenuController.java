package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysMenu;
import com.lanou.service.SysMenuService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/14.
 */
@Controller
public class SysMenuController {
    @Resource
    private SysMenuService menuService;

    //到菜单页面
    @RequestMapping(value = "/menu-list")
    public String menuList(){
        return "menu-list";
    }

    //查询全部菜单列表
    @ResponseBody
    @RequestMapping(value = "/findAllMenu",method = RequestMethod.POST)
    public AjaxResult findAllMenu(@RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("pageNo")Integer pageNo){

        PageInfo<SysMenu> allMenu = menuService.findAllMenu(pageNo, pageSize);
        System.out.println(allMenu);

        return new AjaxResult(allMenu);
    }

}
