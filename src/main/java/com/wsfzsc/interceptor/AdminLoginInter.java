package com.wsfzsc.interceptor;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*后台登录的拦截器*/
public class AdminLoginInter implements HandlerInterceptor {

    @Override
    //controller方法执行前进行拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SuperAdmin superAdmin=(SuperAdmin)request.getSession().getAttribute("superAdmin");
        Admin ordinaryAdmin=(Admin)request.getSession().getAttribute("admin");
        if(superAdmin==null){
            if(ordinaryAdmin==null){
                request.getRequestDispatcher("admin/Login").forward(request,response);
                return false;
            }
        }
        return true;
    }

    @Override
    //controller方法执行后，jsp视图执行前拦截
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }

    @Override
    //JSP页面执行后拦截
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }
}
