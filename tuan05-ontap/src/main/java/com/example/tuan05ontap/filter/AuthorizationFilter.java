package com.example.tuan05ontap.filter;

import com.example.tuan05ontap.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthorizationFilter implements Filter {
    private JwtService jwtService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        this.jwtService = (JwtService) WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean("jwtService");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String header = req.getHeader("Authorization").trim();
        if (header != null && !header.equals("") &&  jwtService.validateToken(header)) {
            System.out.println("Thanh cong");
            filterChain.doFilter(req, res);
        } else res.sendError(403);

    }

}
