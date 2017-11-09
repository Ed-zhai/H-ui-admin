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

}
