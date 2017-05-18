/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author dickajava
 */

@Configuration
public class ConfigurationWeb extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new ConfigurationThymeleaf());
    }
    
    
}
