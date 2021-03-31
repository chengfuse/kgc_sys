package cn.kgc.service;

import cn.kgc.dao.KgcMenuMapper;
import cn.kgc.pojo.KgcMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 15:21
 * @Description:
 **/
@Service
public class KgcMenuServiceImpl implements KgcMenuService {
    @Autowired
    private KgcMenuMapper kgcMenuMapper;

    /**
     * 根据登录用户的id查询对应的菜单
     * @param userId
     * @return
     */
    @Override
    public List<KgcMenu> queryMenuList(int userId) {
        return kgcMenuMapper.queryMenuList(userId);
    }
}
