/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;

import onlinebanking.Account;
import onlinebanking.CreditCard;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class User {
 
    private String isim ; 
    private String soyisim ; 
    private int musteriNumarasi ; 
    private String eposta ;
    private int parola ; 
    private long telefonNumarasi ; 
    ArrayList<Account> hesapBilgileri = new ArrayList<Account>();
    ArrayList<CreditCard> krediKart = new ArrayList<CreditCard>();
    
    public User (){
        
    }
     
    public User (String isim , String soyisim , int musteriNumarasi , String eposta , int parola , long telefonNumarasi ){
        this.isim = isim ;
        this.soyisim = soyisim ;
        this.musteriNumarasi = musteriNumarasi ;
        this.eposta = eposta ;
        this.parola = parola;
        this.telefonNumarasi = telefonNumarasi ;
    }
    
    public void setIsim (String isim){
        this.isim = isim ;
    }
    
    public String getIsim (){
        return isim ;
    }
    
    public void setSoyisim(String soyisim){
        this.soyisim = soyisim ;
    }
    
    public String getSoyisim (){
        return soyisim ;
    }
    
    public void setMusteriNumarasi (int musteriNumarasi){
        this.musteriNumarasi=musteriNumarasi;
    }
    
    public int getMusteriNumarası (){
        return musteriNumarasi ;
    }
    
    public void setEposta(String eposta){
        this.eposta=eposta ;
    }
    
    public String getEposta(){
        return eposta;
    }
    
    public void setParola (int parola){
        this.parola = parola ;
    }
    
    public int getParola(){
       return parola ;
    }
    
    public void setTelefonNumarasi (long telefonNumarasi){
        this.telefonNumarasi=telefonNumarasi;
    }
    
    public long getTelefonNumarasi(){
        return telefonNumarasi ;
    }
    
    public void setHesapBilgileri (Account yeniGelenHesap){
        hesapBilgileri.add(yeniGelenHesap);
    }
    
    public void changeHesapBilgileri (Account yeniGelenHesap, int i){
        hesapBilgileri.set(i,yeniGelenHesap);
    }
    
    public boolean silHesapBilgileri(int hesapNumarasi){
        int sonuc = 0;
        for(int i=0 ; i<hesapBilgileri.size() ; i++){
            Account temp = hesapBilgileri.get(i);
            
            if(temp.getHesapNumarasi()==hesapNumarasi){
                
                hesapBilgileri.remove(i);
                sonuc = 1 ;
                break;
            }
            
        }
        if (sonuc==1){
        return true;
        }
        else{
        return false;
        }
    }
    
    public void gösterHesapBilgileri (int hesapNumarasi){
        for(int i = 0 ; i<hesapBilgileri.size() ; i ++){
            Account temp = hesapBilgileri.get(i);
            
            if(temp.getHesapNumarasi()==hesapNumarasi){
                

                System.out.println("BAKİYE"+temp.getBakiye());
                System.out.println("MİN BAKİYE LİMİTİ"+temp.getMinBakiyeLimiti());
                System.out.println("HESAPNUMARASI"+temp.getHesapNumarasi());
                System.out.println("IBAN"+temp.getIbanNumarasi());
                

            }
        }
    }
    public int getHesap (int hesapNumarasi){
        int hesap_index = -1;
                
        for (int i =0 ; i<hesapBilgileri.size() ; i++ ){
            
           if(hesapBilgileri.get(i).getHesapNumarasi()==hesapNumarasi){
               
             hesap_index = i;
           }
        }
     return hesap_index;
    }
    
    
    public void setKrediKart (CreditCard yeniKrediKartı){
        krediKart.add(yeniKrediKartı);
    }
    
    public boolean silKrediKart(int krediKartıNumarası){
        int sonuc = 0;
        for(int i=0 ; i<krediKart.size() ; i++){
            CreditCard temp = krediKart.get(i);
            
            if(temp.getKrediKartNumarasi()==krediKartıNumarası){
                
                krediKart.remove(i);
                sonuc = 1 ;
                break;
            }
            
        }
        if (sonuc==1){
        return true;
        }
        else{
        return false;
        }
    }
    
}
    
    

  

    
    
    
    

