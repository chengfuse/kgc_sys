package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:06
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class kgcUserMenu{
    private int id;
    private int userId;
    private int menuId;
}
