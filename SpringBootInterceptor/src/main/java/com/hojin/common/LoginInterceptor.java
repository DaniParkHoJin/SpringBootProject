package com.hojin.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Log
public class LoginInterceptor implements HandlerInterceptor {
    private static final String USER_INFO = "userInfo";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");

        String requestURI = request.getRequestURI();

        log.info("requestURI: " + requestURI);
        HandlerMethod mothod = (HandlerMethod) handler;
        Method methodObj = mothod.getMethod();

        log.info("Bean: " + mothod.getBean());
        log.info("Method: " + methodObj);

        HttpSession session = request.getSession();
        if (session.getAttribute(USER_INFO) != null) {
            session.removeAttribute(USER_INFO);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

        String requestURL = request.getRequestURI();

        log.info("requestURL : " + requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean: " + method.getBean());
        log.info("Method: " + methodObj);

        HttpSession session = request.getSession();

        ModelMap modelMap = modelAndView.getModelMap();

        Object member = modelMap.get("user");

        if (member != null) {
            log.info("member != null");
            session.setAttribute(USER_INFO, member);
            response.sendRedirect("/");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");

        String requestURL = request.getRequestURI();

        log.info("requestURL : " + requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean: " + method.getBean());
        log.info("Method: " + methodObj);
    }
}
