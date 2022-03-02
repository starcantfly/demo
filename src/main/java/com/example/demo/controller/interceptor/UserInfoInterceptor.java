package com.example.demo.controller.interceptor;

import com.example.demo.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String headerToken = request.getHeader("userToken");
        String userId = request.getHeader("userId");
        //下面两个判断可以从数据库或者redis缓存中查询进行判断
        if (StringUtils.isEmpty(headerToken) || StringUtils.isEmpty(userId)) {
            log.error("客户信息为空，请重新输入！");
            GraceException.display("客户信息为空，请重新输入！");
            return false;
        }
        if (!headerToken.equals("abdxyz") || !userId.equals("1001")) {
            log.error("客户信息不正确！");
            GraceException.display("客户信息不正确！");
            return false;
        }
        return true;
    }

    /**
     * 请求访问到controller之后，渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求访问到controller之后，渲染视图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
