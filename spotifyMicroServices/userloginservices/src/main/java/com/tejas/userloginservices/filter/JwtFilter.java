package com.tejas.userloginservices.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        final String authHeader=httpServletRequest.getHeader("authorization");
        if(httpServletRequest.getMethod().equals("OPTIONS"))
        {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
        else if(authHeader==null || !authHeader.startsWith("Bearer "))
        {
            throw new ServletException("Missing or Invalid Authorization header");
        }

        final String token=authHeader.substring(7);
        final Claims claims= Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
        httpServletRequest.setAttribute("claims",claims);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
