package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:03
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgcUser extends DefaultBean {
    //用户主键
    private int id;
    //用户名
    private String name;
    //密码
    private String pwd;
    //状态(0:正常 1:禁用）
    private int state;
    private  int createUser;
    private  Date  createDate;
    private  int  modifyUser;
    private  Date modifyDate;
}
