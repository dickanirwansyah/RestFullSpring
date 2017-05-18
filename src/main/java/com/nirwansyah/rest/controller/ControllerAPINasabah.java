/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.controller;

import com.google.gson.Gson;
import com.nirwansyah.rest.dao.NasabahDAO;
import com.nirwansyah.rest.entities.Nasabah;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dickajava
 */
@RestController
@RequestMapping("/api")
public class ControllerAPINasabah extends HttpServlet{
    
    @Autowired
    private NasabahDAO nasabahDAO;
    
    @RequestMapping(value = "/nasabah", method = RequestMethod.GET)
    @ResponseBody
    public String nasabah(HttpServletRequest request){
        
        Gson gson=new Gson();
        Iterable<Nasabah> list=nasabahDAO.findAll();
        return gson.toJson(list);
        
    }
    
    @RequestMapping(value = "/ambil/{idnasabah}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String ambil(@PathVariable("idnasabah") int idnasabah, HttpServletRequest request){
        
        Gson gson=new Gson();
        Nasabah nasabah=nasabahDAO.findOne(idnasabah);
        return gson.toJson(nasabah);
    }
    
    @RequestMapping(value = "/delete/{idnasabah}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String delete(@PathVariable("idnasabah") int idnasabah, HttpServletRequest request){
        
        Gson gson=new Gson();
        if(nasabahDAO.findOne(idnasabah)==null){
            return null;
        }else{
            nasabahDAO.delete(idnasabah);
            return gson.toJson(idnasabah);
        }
    }
    
    
   
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String update( HttpServletRequest request, @RequestBody String json){
            
//        Gson gson=new Gson();
//        Nasabah nasabah=gson.fromJson(json, Nasabah.class);
//        String nama=request.getParameter("nama");
//        String alamat=request.getParameter("alamat");
//        String notelp=request.getParameter("notelp");
//        int idnasabah=Integer.parseInt(request.getParameter("idnasabah"));
//        nasabah.setNama(nama);
//        nasabah.setAlamat(alamat);
//        nasabah.setNotelp(notelp);
//        nasabah.setIdnasabah(idnasabah);
//        return gson.toJson(nasabahDAO.save(nasabah));

          Gson gson=new Gson();
          Nasabah nasabah=gson.fromJson(json, Nasabah.class);
          return gson.toJson(nasabahDAO.save(nasabah));
    }
    
    @RequestMapping(value = "/simpan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String insert(HttpServletRequest request, @RequestBody String json){
        
        Gson gson=new Gson();
        Nasabah nasabah=gson.fromJson(json, Nasabah.class);
        return gson.toJson(nasabahDAO.save(nasabah));
    }
}
