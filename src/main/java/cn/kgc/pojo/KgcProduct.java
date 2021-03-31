package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:09
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KgcProduct extends DefaultBean {
    private int id;
    private String productName;
}
