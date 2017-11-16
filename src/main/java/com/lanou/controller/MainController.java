package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by dllo on 17/11/8.
 */
@Controller
public class MainController {


    @RequestMapping(value = "/index")
    public String frontPage() {

        return "index";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {

        return "welcome";
    }

    @RequestMapping(value = "/admin-role")
    public String adminrole() {

        return "admin-role";
    }

    @RequestMapping(value = "/admin-permission")
    public String adminPermission() {

        return "admin-permission";
    }
    //    去咨询管理页面
    @RequestMapping(value = "/articleList")
    public String articleList() {
        return "article-list";
    }

    @RequestMapping(value = "/admin-list")
    public String adminList() {

        return "admin-list";
    }

    @RequestMapping(value = "/404")
    public String errorPage() {

        return "404";
    }


}