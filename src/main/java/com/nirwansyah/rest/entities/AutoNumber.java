/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.rest.entities;

/**
 *
 * @author dickajava
 */
public class AutoNumber {
    
    public String AutoNums(String kode, String awalan, int panjangField){
        String max="";
        String kodeAuto="";
        int nomor=0;
        int panjangKode = panjangField - awalan.length();
        int panjangNomor = 0;
        if(kode.equals("")){
            nomor=0;
        }else{
            String kodeId = kode.substring(awalan.length(), panjangField);
            nomor = Integer.valueOf(kodeId);
        }
        
        panjangNomor = String.valueOf(nomor+1).length();
        for(int i=0; i<panjangKode-panjangNomor; i++){
            kodeAuto=kodeAuto+"0";
        }
        
        max=awalan+kodeAuto+String.valueOf(nomor+1);
        return max;
    }
}
