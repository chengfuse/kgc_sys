package cn.kgc.config;

import cn.kgc.pojo.KgcMenu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/19 10:00
 * @Description:
 **/
@Configuration
public class SysConfig {
    @Bean
    public KgcMenu kgcMenu(){
        return new KgcMenu();
    }
}
