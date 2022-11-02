package com.springbootNurhadi.springsg.configuration;

import com.springbootNurhadi.springsg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse Response
    ,Object handler) throws Exception {
        try {
            String current_url = request.getRequestURL().toString();
            System.out.println("Current URL: " +current_url+ "with the Method: " +request.getMethod());
            if(request.getMethod().equals("OPTIONS")){
                return true;
            }

            if(current_url.endsWith("userLogin") || current_url.contains("readImage")) {
                System.out.println("Excluding the URL: " +current_url);
                return true;
            }

            String token = request.getHeader("token");
            String userId = request.getHeader("userId");
            System.out.println(token + "" +userId);
            if(token == null || token.equals("")) {
                System.out.println("Token is Empty or Not Defined");
                throw new CustomException ("Send some Tokens please");
            }

            if (userId == null || userId.equals("")) {
                System.out.println("Your UserID is either Empty or Undefined");
                throw new CustomException ("Please provide valid UserID");
            }

            Integer integer_userId = Integer.parseInt(userId); // Converting the String to Int
            userService.checkJWTToken(token);

            if (userService.validateToken(token, integer_userId)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response,
                            Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response,
                                 Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("This was afterCompletion");
    }
}
