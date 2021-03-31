package cn.kgc.dao;

import cn.kgc.pojo.KgcUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:32
 * @Description:
 **/
public interface KgcUserMenuMapper {
      String queryMenuIdsByUserId(@Param("userId") int userId);

      int deleteMenuIdByUserId(@Param("uId") String uId);

      int insertUserMenu(@Param("uId") String uId, @Param("menuIds") String[] menuIds);

}
