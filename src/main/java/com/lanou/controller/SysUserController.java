package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysUser;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dllo on 17/11/8.
 */
@Controller
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    //用户登录页面
    @RequestMapping(value = "/login")
    public String login() {

        if (SecurityUtils.getSubject().isAuthenticated()) {

            return "index";
        }

        return "login";
    }

    //退出当前用户
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {

        if (SecurityUtils.getSubject().isAuthenticated()) {

            SecurityUtils.getSubject().logout();

            request.getSession().removeAttribute("adminUser");
        }

        return "login";
    }

    //用来显示当前用户
    @ResponseBody
    @RequestMapping(value = "/showName")
    public AjaxResult showName(HttpServletRequest request) {

        SysUser sysUser = (SysUser) request.getSession().getAttribute("adminUser");

        return new AjaxResult(sysUser);
    }


    //用户登录表单验证
    @ResponseBody
    @RequestMapping(value = "/loginSubmit")
    public AjaxResult loginSubmit(SysUser sysUser, @RequestParam("verifyCode") String verifyCode, HttpServletRequest request) {

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

    @ResponseBody
    @RequestMapping(value = "/pageInfo", method = RequestMethod.POST)
    public PageInfo<SysUser> sysUserPageInfo(@RequestParam("pageNo") Integer pageNo,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam(value = "datemin", required = false) String datemin,
                                             @RequestParam(value = "datemax", required = false) String datemax,
                                             @RequestParam(value = "username", required = false) String username,
                                             Integer flag) {

        if (flag == 0) {

            return sysUserService.findAllSysUsersWithPageInfo(pageNo, pageSize);

        } else {

            return sysUserService.findAllSysUsersBySearch(pageNo, pageSize, datemin, datemax, username);

        }
    }

    //跳转到添加页面
    @RequestMapping(value = "/admin-add")
    public String adminAdd() {

        return "admin-add";
    }


    @ResponseBody
    @RequestMapping(value = "/adminAdd", method = RequestMethod.POST)
    public AjaxResult adminAdd(@RequestParam("id") Integer id, HttpServletRequest request) {

        SysUser sysUser1 = sysUserService.selectById(id);

        request.getSession().setAttribute("sysUser", sysUser1);

        return new AjaxResult();
    }


    @ResponseBody
    @RequestMapping(value = "/admin-add1", method = RequestMethod.POST)
    public AjaxResult adminAdd1(HttpServletRequest request) {

        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");

        request.getSession().removeAttribute("sysUser");

        return new AjaxResult(sysUser);
    }

    @ResponseBody
    @RequestMapping(value = "/updateOrAddAdmin", method = RequestMethod.POST)
    public AjaxResult updateOrAddAdmin(SysUser sysUser, @RequestParam("flag") Integer flag) {

        if (flag == 0) {

            sysUser.setState(1);

            sysUser.setCreateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));

            sysUserService.insertSelective(sysUser);

            return new AjaxResult();

        } else {

            sysUserService.updateByIdSelective(sysUser);

            return new AjaxResult();

        }
    }


    //删除一个用户
    @ResponseBody
    @RequestMapping(value = "/admin_del")
    public AjaxResult delAdmin(@RequestParam("id") Integer id) {

        sysUserService.deleteById(id);

        PageInfo<SysUser> pageInfo = sysUserService.findAllSysUsersWithPageInfo(1, 5);

        return new AjaxResult(pageInfo);
    }

    //批量删除用户
    @ResponseBody
    @RequestMapping(value = "/dataDelete")
    public AjaxResult dataDel(@RequestParam("ids") Integer[] ids) {

        for (Integer id : ids) {

            sysUserService.deleteById(id);
        }

        PageInfo<SysUser> pageInfo = sysUserService.findAllSysUsersWithPageInfo(1, 5);

        return new AjaxResult(pageInfo);
    }

    //管理员-启用
    @ResponseBody
    @RequestMapping(value = "/admin-start")
    public AjaxResult adminStart(@RequestParam("id") Integer id) {

        SysUser sysUser = sysUserService.selectById(id);

        sysUser.setState(1);

        sysUserService.updateByIdSelective(sysUser);

        return new AjaxResult();
    }

    //管理员-暂停
    @ResponseBody
    @RequestMapping(value = "/admin-stop")
    public AjaxResult adminStop(@RequestParam("id") Integer id) {

        SysUser sysUser = sysUserService.selectById(id);

        sysUser.setState(0);

        sysUserService.updateByIdSelective(sysUser);

        return new AjaxResult();
    }
}
