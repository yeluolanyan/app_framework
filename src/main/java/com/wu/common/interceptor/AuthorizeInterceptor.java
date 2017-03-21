package com.wu.common.interceptor;

import com.alibaba.dubbo.common.json.JSON;
import com.wu.common.response.BaseResponse;
import com.wu.common.utils.UserHolder;
import com.wu.service.UserTokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lwh on 2016/7/12.
 */
public class AuthorizeInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(AuthorizeInterceptor.class);
    @Autowired
    UserTokenService dubboUserTokenService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserHolder.removeUserId();
        //验证签名
//        if(!HttpUtils.verifySign(httpServletRequest.getParameterMap(), "sign", "21b35fa480505dbae4a50668182e6008")){
//            writeFail(httpServletResponse, "0", "签名无效");
//            return false;
//        }
        String pathInfo = httpServletRequest.getPathInfo();
        if(pathInfo == null) pathInfo = "/";
        /*过滤不需要认证就可访问的接口*/
        if(isInterceptor(pathInfo)){
            return true;
        }
        String token = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                //TODO 获取cookie
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if(token == null){
            writeFail(httpServletResponse, 1, "未登录");
            return false;
        }
        Integer uid = dubboUserTokenService.queryUserIdByToken(token);
        if(uid == null){
            writeFail(httpServletResponse, 1, "未登录");
            return false;
        }
        UserHolder.setUserId(uid);
        return true;
    }
    private boolean isInterceptor(String pathInfo){
        if(pathInfo.startsWith("/auth") || pathInfo.startsWith("/index")){
            return true;
        }
        return false;
    }
    private void writeFail(HttpServletResponse httpServletResponse, int code, String message) throws Exception{
        httpServletResponse.setHeader("Content-Type", "text/html; charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.json(new BaseResponse(code,message)));
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
