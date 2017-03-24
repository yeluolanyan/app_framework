package com.wu.common.handler;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    Logger logger = Logger.getLogger(this.getClass());
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.error("请求路径："+httpServletRequest.getRequestURL());
        logger.error("请求参数："+httpServletRequest.getQueryString());
        logger.error(o.toString(),e);
        return new ModelAndView("error");
    }
}
