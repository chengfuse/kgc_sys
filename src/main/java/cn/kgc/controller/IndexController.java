package cn.kgc.controller;

import cn.kgc.dao.KgcUserMenuMapper;
import cn.kgc.pojo.KgcMenu;
import cn.kgc.pojo.KgcUser;
import cn.kgc.service.KgcMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:46
 * @Description:
 **/
@Controller
public class IndexController {
    @Autowired
    private KgcMenuService kgcMenuService;

    @GetMapping("/toMain")
    public String toMain(HttpServletRequest request, Model model){
        Object loginUser = request.getSession().getAttribute("loginUser");
        int userId = null != loginUser?((KgcUser)loginUser).getId():0;
        List<KgcMenu> list = kgcMenuService.queryMenuList(userId);
        model.addAttribute("menuList",list);
       return "main";
    }

}
