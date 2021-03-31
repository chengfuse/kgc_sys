package cn.kgc.controller;

import cn.kgc.pojo.KgcUser;
import cn.kgc.service.KgcUserService;
import cn.kgc.utls.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:13
 * @Description:
 **/
@Controller
public class LoginController {

    @Autowired
    private KgcUserService kgcUserService;

    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String userName, @RequestParam String pwd,
                        HttpServletRequest request){
        KgcUser user = kgcUserService.queryUserByName(userName);
//        if(user == null || !MD5.getMd5(pwd,32).equals(user.getPwd())){
//
//            return "false";
//        }
        request.getSession().setAttribute("loginUser",user);
        return "success";
    }
}
