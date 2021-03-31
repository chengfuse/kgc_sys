package cn.kgc.dao;

import cn.kgc.pojo.KgcMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:47
 * @Description:
 **/
public interface KgcMenuMapper {
    public List<KgcMenu> queryMenuList(@Param("userId") int uid);
}
