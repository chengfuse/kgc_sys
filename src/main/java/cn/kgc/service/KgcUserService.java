package cn.kgc.service;

import cn.kgc.dto.Page;
import cn.kgc.pojo.KgcUser;

import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:37
 * @Description:
 **/
public interface KgcUserService {
    KgcUser queryUserByName(String userName);

    List<KgcUser> queryUserList(String name, Integer state, Page page);

    int queryUserCountByParam(String name,Integer state);

    int updateMenu(String menuIds,String userId);

    int  addUser(KgcUser user);
}
