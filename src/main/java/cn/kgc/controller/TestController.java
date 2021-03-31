package cn.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletRequest;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/18 13:19
 * @Description:
 **/
@Controller
public class TestController {
    @GetMapping("/test")
    public String tet(){
        return "/test1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "/test2";
    }
}
