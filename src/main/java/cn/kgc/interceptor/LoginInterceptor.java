package cn.kgc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/17 10:14
 * @Description:
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("==========拦截器来时执行=====");
        //判断用户是否登录
        Object userName = request.getSession().getAttribute("userName");
        if(null == userName){
            //跳转到登录页面
            response.sendRedirect("/index.jsp");
            return false;
        }
        return true;
    }
}
