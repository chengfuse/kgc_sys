package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:07
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgcMenu extends DefaultBean {
    //主键
    private Integer id;
    //菜单名称
    private String menuName;
    //菜单地址
    private String menuUrl;
    //父及菜单ID
    private Integer parent;
    //状态(0:启用 1:禁用)
    private Integer status;
    //描述
    private String describes;
    //排序
    private Integer menuOrder;

    //二级菜单
    private List<KgcMenu> childMenu;

}
