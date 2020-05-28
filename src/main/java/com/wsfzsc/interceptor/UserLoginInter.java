package com.wsfzsc.interceptor;

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
        if(user == null){
            // 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
            // 如果是ajax请求响应头会有，X-Requested-With
            if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")){
                response.setHeader("SESSIONSTATUS", "TIMEOUT");
                response.setHeader("CONTEXTPATH", "../user/ToLogin");
                // FORBIDDEN，forbidden。也就是禁止、403
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }else{
                //直接跳转
                request.getRequestDispatcher("../user/ToLogin").forward(request,response);
            }
            /*request.getRequestDispatcher("/WEB-INF/jsp/frontground/UserLogin.jsp").forward(request,response);*/
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
