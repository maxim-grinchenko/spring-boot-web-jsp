package com.resolution.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author maxima - 17.08.2018
 */

@WebFilter(urlPatterns = "/")
@Slf4j
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        LOGGER.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOGGER.info("request.getAuthType() : {} ", request.getAuthType());
        LOGGER.info("request.getPathInfo() : {} ", request.getPathInfo());
        LOGGER.info("getRequestURI  : {}", request.getRequestURI());
        LOGGER.info("getServletPath  : {}", request.getServletPath());
        LOGGER.info("getContextPath  : {}", request.getContextPath());
        LOGGER.info("getRequestedSessionId  : {}", request.getRequestedSessionId());
        LOGGER.info("servletRequest.getAttribute(\"id\");  : {}", servletRequest.getAttribute("id"));
        LOGGER.info("servletRequest.getParameter(\"id\");  : {}", servletRequest.getParameter("id"));
        LOGGER.info("getRequestURL  : {}", request.getRequestURL());
        LOGGER.info("getContentType  : {}", request.getContentType());
        LOGGER.info("getAttribute: {}", request.getAttribute("id"));
//        LOGGER.info("  : {}", );

        LOGGER.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        chain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig config) throws ServletException {

        LOGGER.info("!!!!!!!    init SecurityFilter      !!!!!!!!!!!");

    }

    public void destroy() {
    }

}
