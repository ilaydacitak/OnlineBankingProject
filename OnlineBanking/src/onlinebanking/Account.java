/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;

import onlinebanking.User;

/**
 *
 * @author hp
 */
public class Account {
    
    private User kullanıcı ; 
    private int bakiye ; 
    private int minBakiyeLimiti ; 
    private int hesapNumarasi ;
    private int ibanNumarasi ;
    
    public Account(){
        
    }
    
    public Account (User kullanıcı ,int bakiye , int minBakiyeLimiti , int hesapNumarasi , int ibanNumrası){
        this.kullanıcı=kullanıcı;
        this.bakiye = bakiye;
        this.minBakiyeLimiti = minBakiyeLimiti ;
        this.hesapNumarasi = hesapNumarasi ;
        this.ibanNumarasi = ibanNumrası ;
    }
    
    public void setKullanıcı(User kullanıcı){
        this.kullanıcı=kullanıcı;
    }
    
    public User getKullanıcı(){
        return kullanıcı;
    }
    
    public void setBakiye (int bakiye){
        this.bakiye= bakiye ;
    }
    
    public int getBakiye (){
        return bakiye;
    }
    
    public void setMinBakiyeLimiti(int minBakiyeLimiti){
        this.minBakiyeLimiti=minBakiyeLimiti;
    }
    
    public int getMinBakiyeLimiti(){
        return minBakiyeLimiti;
    }
    
    public void setHesapNumarasi(int hesapNumarasi){
        this.hesapNumarasi=hesapNumarasi ;
    }
    
    public int getHesapNumarasi(){
        return hesapNumarasi;
    }
    
    public void setIbanNumarasi(int ibanNumarasi){
        this.ibanNumarasi=ibanNumarasi;
    }
    
    public int getIbanNumarasi(){
        return ibanNumarasi;
    }

    
    public boolean eftYap (Account aliciHesap , Account vericiHesap , int eftYapilanMiktar){
        if (vericiHesap.getBakiye()>eftYapilanMiktar){
        
             return true;
        }
        else{
            return false;
        }

    }

    
}
