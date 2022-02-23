/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;

import onlinebanking.Account;
import onlinebanking.User;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class CreditCard {
    
    private User kullanıcı ;
    private int limit ;
    private int krediKartNumarasi; 
    private int toplamBorc ; 
    private int asgariBorc; 
    
    
    public CreditCard (){
        
    }
    
    public CreditCard (User kullanıcı ,int limit , int krediKartNumarasi , int toplamBorc , int asgariBorc){
        this.kullanıcı=kullanıcı;
        this.limit=limit;
        this.krediKartNumarasi=krediKartNumarasi;
        this.toplamBorc=toplamBorc;
        this.asgariBorc=asgariBorc;
    }
    
        public void setKullanıcı(User kullanıcı){
        this.kullanıcı=kullanıcı;
    }
    
    public User getKullanıcı(){
        return kullanıcı;
    }
    
    public void setLimit(int limit){
        this.limit=limit;
    }
    
    public int getLimit (){
        return limit;
    }
    
    public void setKrediKartNumarasi(int krediKartNumarasi){
        this.krediKartNumarasi= krediKartNumarasi;
    }
    
    public int getKrediKartNumarasi(){
        return krediKartNumarasi;
    }
    
    public void setToplamBorc(int toplamBorc){
        this.toplamBorc=toplamBorc;
    }
    
    public int getToplamBorc(){
        return toplamBorc;
    }
    
    public void setAsgariBorc (int asgariBorc){
        this.asgariBorc=asgariBorc;
    }
    
    public int getAsgariBorc(){
        return asgariBorc;
    }
    public void borcOde (int borc ,int asgari , Account odemeYapacakHesap){
        
        if(odemeYapacakHesap.getBakiye() >= borc ){
            odemeYapacakHesap.setBakiye(odemeYapacakHesap.getBakiye() - borc);
            System.out.println("BORCUNUZ ÖDENMİSTİR. KALAN BAKIYENİZ: "+odemeYapacakHesap.getBakiye());
        }
        else {
            System.out.println("BORCUNUZU ÖDEMEK İÇİN YETERLİ BAKİYE MEVCUT DEĞİLDİR!");
            Scanner input = new Scanner (System.in);
            System.out.println("ASGARİ TUTARI ÖDEMEK İSTERSENİZ 1 , ÇIKIŞ 0");
            int secimm = input.nextInt();
            
            if(secimm == 1){
                if(odemeYapacakHesap.getBakiye() >= asgari ){
                    odemeYapacakHesap.setBakiye(odemeYapacakHesap.getBakiye() - asgari);
                    System.out.println("ASGARİ BORCUNUZ ÖDENMİSTİR. KALAN BAKIYENİZ: "+odemeYapacakHesap.getBakiye());
                }
            
            
                else{
                    System.out.println("ASGARİ BORCUNUZU ÖDEMEK İÇİN YETERLİ BAKİYENİZ YOKTUR!");
                }
            }
            else{
               
            }
        
        }
    }
}

