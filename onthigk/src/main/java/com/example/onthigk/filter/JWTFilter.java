package com.example.onthigk.filter;

import com.example.onthigk.service.JWTService;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter implements Filter {

    private JWTService jwtService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        jwtService= new JWTService();
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse res= (HttpServletResponse) servletResponse;

        String header= req.getHeader("Authorization");
        if(header !=null && jwtService.vertifyToken(header)){
            filterChain.doFilter(req,res);
        }else {
            res.sendError(401);
        }
    }
}
