package in.lingtan.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;



 
/**
 * This Java filter demonstrates how to intercept the request
 * and transform the response to implement authentication feature.
 * for the website's back-end.
 *
 */
@WebFilter("/*")
public class AuthFilter implements Filter {
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	System.out.println("AuthCheck");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        //To check whether there is some data in session.
        boolean isLoggedIn = (session != null && session.getAttribute("ADMIN_ID") != null);
        
      
        
        String loginURI = httpRequest.getContextPath() + "/AdminLogin";
        
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
  
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("adminLogin.jsp");
        System.out.println("Is LogIn Page---"+isLoginPage);
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the admin is already logged in and he's trying to login again
            // then forwards to the admin's homepage
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminLogin.jsp");
            dispatcher.forward(request, response);
 
        } else if (isLoggedIn || isLoginRequest) {
            // continues the filter chain
            // allows the request to reach the destination
            chain.doFilter(request, response);
 
        } else {
            // the admin is not logged in, so authentication is required
            // forwards to the Login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminLogin.jsp");
            dispatcher.forward(request, response);
 
        }
 
    }
 
    public AuthFilter() {
    }
    @Override
    public void destroy() {
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
 
}