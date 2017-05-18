/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dickajava
 */


@Controller
public class ControllerHallo {
    
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView ShowPageLanded(Model model){
        ModelAndView modelAndView=null;
        try {
            modelAndView=new ModelAndView("index");
            model.addAttribute("title", "RestFullApi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    
}
