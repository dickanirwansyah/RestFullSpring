/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author dickajava
 */
public class ConfigurationThymeleaf extends HandlerInterceptorAdapter{
    
    private static final String DEFAULT_LAYOUT = "index";
    private static final String DEFAULT_LOCATION_FOLDER="place";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
     
    if(modelAndView == null || !modelAndView.hasView()){
        return;
    }
    String originalViewName=modelAndView.getViewName();
    if(originalViewName.startsWith("redirect:")){
        return;
    }
    modelAndView.addObject("title");
    modelAndView.setViewName(DEFAULT_LAYOUT);
    modelAndView.addObject(DEFAULT_LOCATION_FOLDER, originalViewName);
 }
}