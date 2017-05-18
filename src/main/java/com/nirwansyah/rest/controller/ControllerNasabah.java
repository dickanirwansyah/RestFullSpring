/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.controller;

import com.nirwansyah.rest.dao.NasabahDAO;
import com.nirwansyah.rest.entities.AutoNumber;
import com.nirwansyah.rest.entities.Nasabah;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dickajava
 */
@Controller
@RequestMapping("/nasabah")
public class ControllerNasabah {
    
    @Autowired
    private NasabahDAO nasabahDAO;
    
    private int kodeAuto(){
        int id=0;
        try {
            for(Nasabah n : nasabahDAO.findAll()){
                id=n.getIdnasabah();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void index(Model model){
        model.addAttribute("title", "List Nasabah");
        model.addAttribute("listnasabah", nasabahDAO.findAll());
    }
    
    
    @RequestMapping(value = "/proses_update", method = RequestMethod.POST)
    public String update( HttpServletRequest request)
            throws ServletException, IOException{
            
        Nasabah nasabah=new Nasabah();
        String nama=request.getParameter("nama");
        String alamat=request.getParameter("alamat");
        String notelp=request.getParameter("notelp");
        int idnasabah=Integer.parseInt(request.getParameter("idnasabah"));
        nasabah.setNama(nama);
        nasabah.setAlamat(alamat);
        nasabah.setNotelp(notelp);
        nasabah.setIdnasabah(idnasabah);
        nasabahDAO.save(nasabah);
        return "redirect:/nasabah/list";
    }
    
    @RequestMapping(value = "/ambil/{idnasabah}", method = RequestMethod.GET)
    public String ambil(@PathVariable("idnasabah") int idnasabah, 
        HttpServletRequest request, Model model){
        
        
        Nasabah nasabah=nasabahDAO.findOne(idnasabah);
        model.addAttribute("get", nasabah);
        model.addAttribute("title", "Update Nasabah");
        return "/nasabah/update";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update(Model model){
        
        model.addAttribute("title", "Update Nasabah");
    }
    
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insert(Model model){
        model.addAttribute("title", "Form Insert Nasabah");
    }
}
