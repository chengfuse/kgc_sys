package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:10
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgcClass extends DefaultBean {
    private int id;
    //班级名称
    private String className;
    //班级人数
    private int studentNumber;
    //老师姓名
    private String teacherName;
    //班级状态(0:未开班1:正常 2:已结课)
    private int classStatus;
    //开班时间
    private Date startDate;
    //产品ID
    private int productId;
    //备注
    private  String remark;
}
