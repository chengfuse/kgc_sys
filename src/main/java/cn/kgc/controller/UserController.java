package cn.kgc.controller;

import cn.kgc.dto.Page;
import cn.kgc.dto.ResultDto;
import cn.kgc.pojo.KgcClass;
import cn.kgc.pojo.KgcUser;
import cn.kgc.service.KgcUserService;
import cn.kgc.utls.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/18 6:09
 * @Description:
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private KgcUserService kgcUserService;
    /**
     * 跳转到用户页面
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "/user/index";
    }
    @GetMapping("/toAdd")
    public String toAdd(){
        return "/user/add";
    }
    /**
     * 查询用户列表信息
     * @param name
     * @param state
     * @param pg
     * @return
     */
    @GetMapping("/queryAll")
    @ResponseBody
    public ResultDto queryAll(@RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer state, Page pg){
        //查询列表数据
        List<KgcUser> list = kgcUserService.queryUserList(name,state,pg);
        //查询总条数
        int count = kgcUserService.queryUserCountByParam(name,state);
        return ResultUtil.returnSuccess(list,count);
    }
    /**
     * 给用户分配菜单
     */
    @PostMapping("/updateMenu")
    @ResponseBody
    public int updateMenu(@RequestParam String menuIds,String userId){
        return kgcUserService.updateMenu(menuIds,userId);
    }
    @PostMapping("addUser")
    @ResponseBody
    public  String addUser(HttpServletRequest request)throws Exception{
        request.setCharacterEncoding("utf-8");
        KgcUser user =new KgcUser();
        HttpSession session =request.getSession();
        KgcUser sessionUser= (KgcUser) session.getAttribute("loginUser");
        user.setName(request.getParameter("name"));
        return "";
    }
}
