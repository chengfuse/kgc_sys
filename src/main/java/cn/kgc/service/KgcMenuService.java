package cn.kgc.service;

import cn.kgc.pojo.KgcMenu;

import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 15:21
 * @Description:
 **/
public interface KgcMenuService {
    /**
     * 根据用户登录id查询对于的菜单
     * @param userId
     * @return
     */
    List<KgcMenu> queryMenuList(int userId);


}
