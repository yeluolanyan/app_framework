package com.wu.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.wu.common.response.BaseResponse;
import com.wu.common.response.ResponseEnum;
import com.wu.service.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过token去获取userId,判断是否登录
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserTokenService dubboUserTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String token = request.getParameter("token");

        // token is not needed when debug
        //TODO remember to comment this when deploy on server !!
        /*if(token == null) {
            return true;
        };*/

        String userId = request.getParameter("userId");
        String uToken = dubboUserTokenService.queryTokenByUserId(Integer.parseInt(userId));
        if(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(uToken) && token.equals(uToken) ){
            return true;
        }
        BaseResponse res = new BaseResponse(ResponseEnum.TOKEN_ERROR.getCode(),ResponseEnum.TOKEN_ERROR.getMsg());
        response.getWriter().print(JSON.toJSON(res).toString());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
