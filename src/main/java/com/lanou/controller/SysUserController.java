package com.lanou.controller;

import com.lanou.bean.SysUser;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 17/11/8.
 */
@Controller
public class SysUserController {

    //用户登录页面
    @RequestMapping(value = "/login")
    public String login() {

        if (SecurityUtils.getSubject().isAuthenticated()) {

            return "index";
        }

        return "login";
    }

    //用户登出
    @RequestMapping(value = "/logout")
    public String logout() {

        if (SecurityUtils.getSubject().isAuthenticated()) {

            SecurityUtils.getSubject().logout();
        }

        return "login";
    }

    //用户登录表单验证
    @ResponseBody
    @RequestMapping(value = "/loginSubmit")
    public AjaxResult loginSubmit(SysUser sysUser, @RequestParam("verifyCode") String verifyCode, HttpServletRequest request){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());

        try {

            subject.login(token);

            //获取生成验证码图片时保存的验证字符串对象
            String srcVerifyCode = (String) request.getSession().getAttribute("verifyCode");

            //提交的验证码与session保存的进行比较,如果不一致,加入错误信息.
            if (!verifyCode.equalsIgnoreCase(srcVerifyCode)) {

                return new AjaxResult(2);
            }

        } catch (AuthenticationException e) {


            return new AjaxResult(1);
        }

        return new AjaxResult(3);
    }

    //验证码的刷新与判定
    @ResponseBody
    @RequestMapping(value = "/verifyCode")
    public AjaxResult verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //用于处理真正的返回结果
        VerifyCode verifyCode = new VerifyCode();//创建工具类对象
        BufferedImage image = verifyCode.getImage();//验证码工具生成图片对象
        //保存生成的验证码的字符串对象
        //将验证码保存到session中
        request.getSession().setAttribute("verifyCode", verifyCode.getText());
        //获得response对象的输出流用于图像的写入
        ServletOutputStream os = response.getOutputStream();
        VerifyCode.output(image, os);//将图片映射到输出流中
        return new AjaxResult();
    }
}
