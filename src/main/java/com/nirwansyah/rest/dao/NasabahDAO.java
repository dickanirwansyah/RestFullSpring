/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.dao;

import com.nirwansyah.rest.entities.Nasabah;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dickajava
 */
public interface NasabahDAO extends CrudRepository<Nasabah, Integer>{
    
    
}
