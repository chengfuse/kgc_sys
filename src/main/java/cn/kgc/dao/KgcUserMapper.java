package cn.kgc.dao;

import cn.kgc.pojo.KgcUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:32
 * @Description:
 **/
public interface KgcUserMapper {
    KgcUser queryUserByName(@Param("userName") String queryUserByName);

    List<KgcUser> queryUserList(Map<String,Object> map);

    int queryUserCountByParam(@Param("name") String name,@Param("state") Integer state);

    @Insert("insert into kgc_user(name,pwd,state,createUser,createDate,modifyUser,modifyDate) " +
            "value (#{name},#{pwd},#{state},#{createUser},#{modifyUser},#{modifyDate}) ")
    int  addUser(KgcUser user);
}
