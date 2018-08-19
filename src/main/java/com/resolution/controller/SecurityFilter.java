package com.resolution.controller;

import com.resolution.domain.entity.User;
import com.resolution.infra.exception.UserNotFoundException;
import com.resolution.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.acls.model.NotFoundException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author maxima - 17.08.2018
 */

@WebFilter(urlPatterns = {"/edit/*"})
@Slf4j
public class SecurityFilter implements Filter {

    private final static String REGEX = "/edit/(\\d)";
    private final static String PARAMETR_URL = "test_id";

    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        processFilterRequest(servletRequest, servletResponse);
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        LOGGER.info("...init SecurityFilter");
    }

    private void processFilterRequest(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(request.getRequestURI());

        LOGGER.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOGGER.debug("request.getRequestURI() {}", request.getRequestURI());

        LOGGER.info("response.sendRedirect(request.getContextPath()) {}", request.getContextPath());
        if (!matcher.find()) throw new NoSuchElementException("Incorrect request URI: " + request.getRequestURI());

        Long userID = Long.valueOf(matcher.group(1));
        Optional<User> user = userService.findOneByLogin(userID);
//        userService.findOneByLogin(userID).filter(user -> user.getEmail().equals("dfsdf") && user.getId(userID));

        if (!user.isPresent()) throw new UserNotFoundException("User not found");

    }

}
