package cn.kgc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/18 6:18
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int page;
    private int limit;

    /**
     * 根据当前页数计算sql语句的偏移量
     * @return
     */
    public  int getStartIndex(){
        if(this.page==0) this.page=1;
        if(this.limit==0) this.limit=10;
        return (page-1)*limit;
    }
}
