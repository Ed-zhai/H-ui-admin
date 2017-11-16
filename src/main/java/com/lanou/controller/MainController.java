package com.lanou.controller;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/adminrole")
    public String adminrole() {

        return "admin-role";
    }

    //    去咨询管理页面
    @RequestMapping(value = "/articleList")
    public String articleList(){
        return "article-list";
    }


}
