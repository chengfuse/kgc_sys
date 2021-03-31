package cn.kgc.service;

import cn.kgc.dao.KgcUserMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/18 10:34
 * @Description:
 **/
@Service
public class KgcUserMenuSerImpl implements KgcUserMenuService {
    @Autowired
    private KgcUserMenuMapper kgcUserMenuMapper;

    /**
     * 根据用户ID查询已有菜单ID
     * @param uId
     * @return
     */
    @Override
    public String queryMenuIdByUserId(int uId) {
        return kgcUserMenuMapper.queryMenuIdsByUserId(uId);
    }
}
