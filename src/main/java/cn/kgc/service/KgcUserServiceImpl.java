package cn.kgc.service;

import cn.kgc.dao.KgcUserMapper;
import cn.kgc.dao.KgcUserMenuMapper;
import cn.kgc.dto.Page;
import cn.kgc.pojo.KgcUser;
import cn.kgc.utls.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:35
 * @Description:
 **/
@Service
public class KgcUserServiceImpl implements KgcUserService {
    @Autowired
    private KgcUserMapper kgcUserMapper;

    @Autowired
    private KgcUserMenuMapper kgcUserMenuMapper;

    @Override
    public KgcUser queryUserByName(String userName) {
        return kgcUserMapper.queryUserByName(userName);
    }

    /**
     * 根据条件查询用户列表
     * @param name
     * @param state
     * @return
     */
    @Override
    public List<KgcUser> queryUserList(String name, Integer state, Page page) {
        Map<String,Object> map= new HashMap<>();
        map.put("name",name);
        map.put("state",state);
        map.put("start",page.getStartIndex());
        map.put("pageSize",page.getLimit());
        return kgcUserMapper.queryUserList(map);
    }

    @Override
    public int queryUserCountByParam(String name,Integer state){
        return kgcUserMapper.queryUserCountByParam(name,state);
    }

    /**
     * 根据用户id修改对应的菜单ID：******必须要加事务处理************
     * @param menuIds
     * @param userId
     * @return
     */
    @Override
    public int updateMenu(String menuIds,String userId) {
        if(EmptyUtils.isEmpty(menuIds))
            return 0;
        String[] ids = menuIds.split(",");
        //删除原有的菜单ID
        int count = kgcUserMenuMapper.deleteMenuIdByUserId(userId);
        //新增菜单ID
        if(count>0){
           count =kgcUserMenuMapper.insertUserMenu(userId, ids);
        }
        return count;
    }

    @Override
    public int addUser(KgcUser user) {
        return kgcUserMapper.addUser(user);
    }
}
