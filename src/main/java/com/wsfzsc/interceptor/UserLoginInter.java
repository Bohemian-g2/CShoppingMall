package com.wsfzsc.interceptor;

import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.SuperAdmin;
import com.wsfzsc.pojo.UserInf;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInter implements HandlerInterceptor {
    @Override
    //controller方法执行前进行拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInf user = (UserInf) request.getSession().getAttribute("user");
            if(user==null){
                request.getRequestDispatcher("user/ToLogin").forward(request,response);
                return false;

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
