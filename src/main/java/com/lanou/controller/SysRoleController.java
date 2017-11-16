package com.lanou.controller;

import com.lanou.bean.SysRole;
import com.lanou.service.SysRoleSerivce;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller
public class SysRoleController {

    @Resource
    private SysRoleSerivce sysRoleSerivce;

//    去添加页面
    @RequestMapping(value = "/roleAdd")
    public String addRole(){
        return "admin-role-add";
    }

    //    去404页面
    @RequestMapping(value = "/404")
    public String fZF(){
        return "404";
    }



    //找到所有Role
    @ResponseBody
    @RequestMapping(value = "/selectAllRoles")
    public AjaxResult selectAllRoles() {
        List<SysRole> sysRoles = sysRoleSerivce.selectAllRole();
        return new AjaxResult(sysRoles);
    }

    @ResponseBody
    @RequestMapping(value = "/datadel")
    public AjaxResult datadel(@RequestParam("idList") Integer[] idList) {

        for (Integer id : idList) {
            int i1 = sysRoleSerivce.deleteRoleMenuByPrimaryKey(id);
            int i = sysRoleSerivce.deleteByPrimaryKey(id);
        }

        return new AjaxResult(1);
    }

    @ResponseBody
    @RequestMapping(value = "/roledel")
    public AjaxResult roledelete(SysRole sysRole) {
        int i1 = sysRoleSerivce.deleteRoleMenuByPrimaryKey(sysRole.getId());
        int i = sysRoleSerivce.deleteByPrimaryKey(sysRole.getId());


        return new AjaxResult(1);
    }

    @ResponseBody
    @RequestMapping(value = "/rollBack")
    public AjaxResult rollBack(HttpServletRequest request,SysRole sysRole) {

        SysRole sysRole1 = sysRoleSerivce.selectByPrimaryKey(sysRole);

request.getSession().setAttribute("sysRole",sysRole1 );
        return new AjaxResult(1);
    }

    @ResponseBody
    @RequestMapping(value = "/getRollBack")
    public AjaxResult getRollBack(HttpServletRequest request) {


        SysRole sysRole = (SysRole) request.getSession().getAttribute("sysRole");
        request.getSession().removeAttribute("sysRole");
        return new AjaxResult(sysRole);
    }



//添加点击事件
    @ResponseBody
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public AjaxResult addRole(@RequestParam("menuIdList") Integer[] menuIdList, SysRole sysRole) {

//存入role表
        sysRole.setStatus(1);
        sysRole.setCreateTime(new Date());
        sysRoleSerivce.insertSelective(sysRole);
        System.out.println(11);
        for (Integer menuId : menuIdList) {
            System.out.println(menuId);
            System.out.println(sysRole.getId());
            int i = sysRoleSerivce.insertRoleMenu(sysRole.getId(), menuId);

        }
        System.out.println(22);
        return new AjaxResult(1);
    }
}
