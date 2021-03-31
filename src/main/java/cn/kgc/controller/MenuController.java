package cn.kgc.controller;

import cn.kgc.pojo.KgcMenu;
import cn.kgc.service.KgcMenuService;
import cn.kgc.service.KgcUserMenuService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/18 9:41
 * @Description:
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private KgcMenuService kgcMenuService;
    @Autowired
    private KgcUserMenuService kgcUserMenuService;
    @GetMapping("/toMenu")
    public String toMenu(@RequestParam int uId, Model model){
        //查询所有的菜单
        List<KgcMenu> list = kgcMenuService.queryMenuList(0);
        model.addAttribute("uId",uId);
        model.addAttribute("list", JSON.toJSONString(list));
        //查询用户已经有的菜单ID
        String ownIds = kgcUserMenuService.queryMenuIdByUserId(uId);
        model.addAttribute("userOwnMenIds",ownIds);
        return "/user/menu";
    }

}
