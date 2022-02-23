package onlinebanking;

import onlinebanking.Account;
import onlinebanking.CreditCard;
import onlinebanking.User;
import java.util.ArrayList;
import java.util.Scanner;


public class MainPanel {
   
    
    

public static void main(String[] args) {
    
    ArrayList<User> u = new ArrayList<User>();
    
    int kaba_secim = -1;
    int alt_secim = -1;
    int alt_alt_secim = -1;
    
    while (kaba_secim != 0){
        
        Scanner inputt=new Scanner (System.in);
        System.out.println("KULLANICI İŞLEMLERİ İÇİN 1 , HESAP İŞLEMLERİ İÇİN 2 , KREDİ KARTI İŞEMLERİ İÇİN 3 , ÇIKIŞ İÇİN 0 ");
        kaba_secim = inputt.nextInt();
        
//******************************************************************************************************************************       
    if (kaba_secim == 1){
        
        System.out.println("KULLANICI EKLEMEK İÇİN 1 , KULLANCI SİLMEK İÇİN 2 , KULLANICI BİLGİERİ İÇİN 3");
        Scanner input5 = new Scanner (System.in);
        alt_secim = input5.nextInt();

        if (alt_secim==1){

            Scanner input= new Scanner (System.in);
            System.out.println("İSİM: ");
            String isim = input.next();
            System.out.println("SOYİSİM: ");
            String soyisim = input.next();
            System.out.println("EPOSTA: ");
            String eposta = input.next();
            System.out.println("PAROLA: ");
            int parola = input.nextInt();
            System.out.println("TELEFON NUMARSI: ");
            long telefonnumarasi = input.nextLong();
            int müsterinumarasi = (int)(Math.random() * 100);
            System.out.println("MÜŞTERİ NUMARANIZ: "+müsterinumarasi);

            User yeniKullanici = new User(isim, soyisim, müsterinumarasi, eposta, parola, telefonnumarasi);
            u.add(yeniKullanici);

            System.out.println("SAYIN "+isim+" KAYDINIZ TAMAMLANDI");
        }

        if(alt_secim==2){

            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();

            int found_user_index = -1;

            for (int i = 0; i < u.size(); i++) {
                User listedenAlinanUser = u.get(i);

                if(listedenAlinanUser.getMusteriNumarası() == müsterinumarasi){

                    found_user_index = i;
                    u.remove(i);
                }
            }

                if(u.isEmpty() || found_user_index == -1){

                    System.out.println("BÖYLE BİR KAYIT YOKTUR.HATALI GİRİŞ!");
                }    
        }

        if(alt_secim==3){

            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            
            for(int i=0 ; i<u.size() ; i++ ){
                User gosterilecekKisi = u.get(i);

                if(gosterilecekKisi.getMusteriNumarası() == müsterinumarasi){

                    System.out.println("İSİM: "+gosterilecekKisi.getIsim());
                    System.out.println("SOYİSİM: "+gosterilecekKisi.getSoyisim());
                    System.out.println("MÜŞTERİNUMARASI: "+gosterilecekKisi.getMusteriNumarası());
                    System.out.println("EPOSTA: "+gosterilecekKisi.getEposta());
                    System.out.println("PAROLA: "+gosterilecekKisi.getParola());
                    System.out.println("TELEFON NUMARASI: "+gosterilecekKisi.getTelefonNumarasi());
                    break;
                }
            }
        }
    }

//******************************************************************************************************************************            
    if(kaba_secim == 2){
        
        Scanner input6 = new Scanner (System.in);
        System.out.println("HESAP EKLEMEK/SİLMEK/GÖRMEK İÇİN 1 , EFT İÇİN 2 , PARA YATIR/ÇEK İÇİN 3 ");
        alt_secim= input6.nextInt();
        
        if(alt_secim==1){
            
            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            
            for (int i = 0; i < u.size(); i++) {
                User hesapEklenecekKisi = u.get(i);
                
                if(hesapEklenecekKisi.getMusteriNumarası()==müsterinumarasi && hesapEklenecekKisi.getParola() == parola){
            
                    System.out.println("HESAP EKLEMEK İÇİN 1 , SİLMEK İÇİN 2 , GÖRÜNTÜLEMEK İÇİN 3 ");
                    alt_alt_secim = input.nextInt();
                    
                    if(alt_alt_secim==1){
                        
                        if(hesapEklenecekKisi.hesapBilgileri.size()<5){

                        int hesapnumarasi = (int)(Math.random() * 100);
                        int ibannumarası = (int) (Math.random()* 1000);
                        System.out.println("HESAPBINIZIN HESAP NUMARASI: "+hesapnumarasi);
                        System.out.println("HESABINIZIN IBAN NUMARASI: "+ibannumarası);

                        Account yeniGelenHesap = new Account (hesapEklenecekKisi, 0, 0, hesapnumarasi, ibannumarası);
                        hesapEklenecekKisi.setHesapBilgileri(yeniGelenHesap);
                        }
                        
                        else{
                            
                            System.out.println("MAX 5 HESAP AÇABİLİRSİNİZ!. HESAP AÇMA HAKKINIZ KALMAMIŞTIR!");
                        }
                    }

                    else if(alt_alt_secim==2){
                        
                        Scanner input1 = new Scanner (System.in);
                        System.out.println("SİLMEK İSTEDİĞİNİZ HESABIN NUMARASINI GİRİNİZ: ");
                        int silinecekhesap = input1.nextInt();
                        
                        int hesapNumarasi = silinecekhesap;
                        
                        boolean sonuc = hesapEklenecekKisi.silHesapBilgileri(hesapNumarasi);
                        
                        if (sonuc==true){
                            
                            System.out.println("HESABINIZ SİLİNMİSTİR");
                        }
                        
                        else if (sonuc==false){
                            
                        System.out.println("HESABINIZ SİLİNMEMİŞTİR!HATALI");
                        }  

                    }
                    else if (alt_alt_secim==3){
                        Scanner input1 = new Scanner (System.in);
                        System.out.println("GÖRMEK İSTEDİĞİNİZ HESABIN NUMARASINI GİRİNİZ: ");
                        int görülecekHesap = input1.nextInt();
                        
                        int hesapNumarasi = görülecekHesap;
                     
                        hesapEklenecekKisi.gösterHesapBilgileri(hesapNumarasi);
                    }
                }
            }
        }
        
        if(alt_secim==2){

            int gonderen_user_index = -1;
            int alici_user_index = -1;
            int gonderen_hesap_index = -1;
            int alici_hesap_index = -1;

            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            for (int i = 0; i < u.size(); i++) {
                User eftYapacakKisi = u.get(i);

                if(eftYapacakKisi.getMusteriNumarası()==müsterinumarasi && eftYapacakKisi.getParola() == parola){
                    
                    gonderen_user_index = i;
                    Scanner input2 = new Scanner (System.in);
                    System.out.println("EFT MİKTARINI GİRİNİZ: ");
                    int eftYapilanMiktar = input2.nextInt();

                    
                    System.out.println("EFT YAPMAK İSTEDİĞİNİZ HESABINIZIN NUMARASINI GİRİNİZ: ");
                    int hesapNumarasi = input2.nextInt();

                    gonderen_hesap_index = eftYapacakKisi.getHesap(hesapNumarasi);

                    
                    Scanner input1 = new Scanner (System.in);
                    System.out.println("ALICININ HESAP NUMARASINI GİRİNİZ: ");
                    int aliciHesapNumarasi = input1.nextInt();

                    for(int a = 0 ; a<u.size() ; a++){
                        User eftAlacakKisi = u.get(a);

                        int alici_hesap_index_temp = eftAlacakKisi.getHesap(aliciHesapNumarasi);
                        if(alici_hesap_index_temp != -1){
                            alici_user_index = a;
                            alici_hesap_index = alici_hesap_index_temp;
                        }

                    }

                    Account gonderen_kopya= u.get(gonderen_user_index).hesapBilgileri.get(gonderen_hesap_index);
                    Account alici_kopya= u.get(alici_user_index).hesapBilgileri.get(alici_hesap_index);

                    // eft yap
                    Account a = new Account();
                    boolean eft_durum = a.eftYap(alici_kopya,gonderen_kopya, eftYapilanMiktar);

                    if (eft_durum == true){

                        gonderen_kopya.setBakiye(gonderen_kopya.getBakiye() - eftYapilanMiktar);
                        alici_kopya.setBakiye(alici_kopya.getBakiye() + eftYapilanMiktar);

                        System.out.println(gonderen_kopya.getHesapNumarasi()+"NUMARALI HESABINIZDAN"+alici_kopya.getHesapNumarasi()+
                        "NUMARALI HESABA"+eftYapilanMiktar+"MİKTAR TUTARINDA EFT İŞELEMİZ BAŞARIYLA GERÇEKLEŞMİŞTİR");

                        u.get(gonderen_user_index).changeHesapBilgileri(gonderen_kopya, gonderen_hesap_index);
                        u.get(alici_user_index).changeHesapBilgileri(alici_kopya, alici_hesap_index);                    
                        break;
                    }
                    
                    else{
                        
                        System.out.println("HESABINIZDA YETERLİ BAKİYE BULUNMADIĞINDAN EFT İŞLEMİ GERÇEKLEŞEMEMİŞTİR!");
                        break;
                    }
                }                   
            }
        }
        if(alt_secim==3){
            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            for (int i = 0; i < u.size(); i++) {
                User paraÇekecekKisi = u.get(i);

                if(paraÇekecekKisi.getMusteriNumarası()==müsterinumarasi && paraÇekecekKisi.getParola() == parola){
                    
                    Scanner inpput= new Scanner (System.in);
                    System.out.println("İŞLEM YAPMAK İSTEDĞİNİZ HESABIN NUMARASINI GİRİNİZ: ");
                    int işlemYapılacakHesap = inpput.nextInt();
                    
                    for(int a =0 ; a<paraÇekecekKisi.hesapBilgileri.size() ; a++){
                        if(paraÇekecekKisi.hesapBilgileri.get(a).getHesapNumarasi()==işlemYapılacakHesap){
                                
                            Scanner inputA = new Scanner (System.in);
                            System.out.println("PARA ÇEKMEK İÇİN 1 , YATIRMAK İÇİN 2");
                            alt_alt_secim = inputA.nextInt();

                                if(alt_alt_secim==1){
                                    
                                
                                    System.out.println("MEVCUT BAKİYENİZ: "+paraÇekecekKisi.hesapBilgileri.get(a).getBakiye());
                                    Scanner innput= new Scanner(System.in);
                                    System.out.println("ÇEKMEK İSTEDİĞİNİZ MİKTARI GİRİNİZ:");
                                    int çekilenPara = innput.nextInt();

                                    if(çekilenPara<=paraÇekecekKisi.hesapBilgileri.get(a).getBakiye()){
                                        
                                        paraÇekecekKisi.hesapBilgileri.get(a).setBakiye(paraÇekecekKisi.hesapBilgileri.get(a).
                                                getBakiye()-çekilenPara);
                                        
                                        System.out.println("İŞLEMİNİZ BAŞARIYLA GERÇEKLEŞMİŞTİR.KALAN BAKİYENİZ: "+
                                                paraÇekecekKisi.hesapBilgileri.get(a).getBakiye());

                                    }
                                    else{
                                        System.out.println("BAKİYENİZ YETERLİ DEĞİLDİR!");
                                    }
                                    
                                }
                                
                                if(alt_alt_secim==2){
                                    
                                    System.out.println("MEVCUT BAKİYENİZ: "+paraÇekecekKisi.hesapBilgileri.get(a).getBakiye());
                                    Scanner innput= new Scanner(System.in);
                                    System.out.println("YATIRMAK İSTEDİĞİNİZ MİKTARI GİRİNİZ:");
                                    int yatırılanPara = innput.nextInt();

                                    paraÇekecekKisi.hesapBilgileri.get(a).setBakiye(paraÇekecekKisi.hesapBilgileri.get(a).
                                                getBakiye()+yatırılanPara);
                                        
                                        System.out.println("İŞLEMİNİZ BAŞARIYLA GERÇEKLEŞMİŞTİR .MEVCUT BAKİYENİZ: "+
                                                paraÇekecekKisi.hesapBilgileri.get(a).getBakiye());
                                  
                                }
                        }

                            
                    }
                }
                      
            }
        }
        
    }

//*******************************************************************************************************************************
    if(kaba_secim == 3){
       
        Scanner aa = new Scanner(System.in);
        System.out.println("KREDİ KARTI EKLEMEK/SİLMEK İÇİN 1 , HARCAMA YAPMAK İÇİN 2 , BORÇ ÖDEME İÇİN 3 ");
        alt_secim = aa.nextInt();
        
        if(alt_secim==1){
            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            for (int i = 0; i < u.size(); i++) {
                User krediKartiKisi = u.get(i);

                if(krediKartiKisi.getMusteriNumarası()==müsterinumarasi && krediKartiKisi.getParola() == parola){
                    
                    Scanner inputy = new Scanner (System.in);
                    System.out.println("KREDİ KARTI EKELEMEK İÇİN 1 , SİLMEK İÇİN 2");
                    alt_alt_secim = inputy.nextInt();
                    
                    if(alt_alt_secim==1){
                        
                        if(krediKartiKisi.krediKart.size()<2){

                        int krediKartNumarasi = (int)(Math.random() * 100);
                        System.out.println("KREDİ KARTI NUMARASI: "+krediKartNumarasi);
                        
                         CreditCard yeniKrediKartı = new CreditCard (krediKartiKisi, 10000, krediKartNumarasi, 0, 0);
                         krediKartiKisi.setKrediKart(yeniKrediKartı);

                        }
                        
                        else{
                            
                            System.out.println("MAX 2 KREDİ KARTI EKLEYEBİLİRSİNİZ!.KREDİ KARTI EKLEME HAKKINIZ KALMAMIŞTIR");
                        }
                    }
                    if(alt_alt_secim==2){
    
                        Scanner input1 = new Scanner (System.in);
                        System.out.println("SİLMEK İSTEDİĞİNİZ KREDİ KARTININ NUMARASINI GİRİNİZ: ");
                        int silinecekKrediKartı = input1.nextInt();
                        
                        int krediKartıNumarası = silinecekKrediKartı;
                        
                        boolean sonuc = krediKartiKisi.silKrediKart(krediKartıNumarası);
                        
                        if (sonuc==true){
                            
                            System.out.println("KREDİ KARTINIZ SİLİNMİSTİR");
                        }
                        
                        else if (sonuc==false){
                            
                        System.out.println("KREDİ KARTINIZ SİLİNMEMİŞTİR!HATALI");
                        }  
  
                    }
  
                    }
  
                }
 
        }
        if(alt_secim==2){
            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            for (int i = 0; i < u.size(); i++) {
                User krediKartiKisi = u.get(i);

                if(krediKartiKisi.getMusteriNumarası()==müsterinumarasi && krediKartiKisi.getParola() == parola){
                    
                
                    Scanner inpput= new Scanner (System.in);
                    System.out.println("İŞLEM YAPMAK İSTEDĞİNİZ KREDİ KARTI NUMARASINI GİRİNİZ: ");
                    int işlemYapılacakKrediKartı = inpput.nextInt();
                    
                    for(int a =0 ; a<krediKartiKisi.krediKart.size() ; a++){
                        if(krediKartiKisi.krediKart.get(a).getKrediKartNumarasi()==işlemYapılacakKrediKartı){

                            System.out.println("MEVCUT LİMİTİNİZ: "+krediKartiKisi.krediKart.get(a).getLimit());
                            Scanner innput= new Scanner(System.in);
                            System.out.println("HARCAMA YAPMAK İSTEDİĞİNİZ MİKTARI GİRİNİZ:");
                            int harcananPara = innput.nextInt();

                            if(harcananPara<=krediKartiKisi.krediKart.get(a).getLimit()){

                                krediKartiKisi.krediKart.get(a).setLimit(krediKartiKisi.krediKart.get(a).getLimit()-harcananPara);
                                krediKartiKisi.krediKart.get(a).setToplamBorc(krediKartiKisi.krediKart.get(a).getToplamBorc()+harcananPara);
                                krediKartiKisi.krediKart.get(a).setAsgariBorc((krediKartiKisi.krediKart.get(a).getToplamBorc()+((harcananPara)/100)));

                                System.out.println("İŞLEMİNİZ BAŞARIYLA GERÇEKLEŞMİŞTİR.KALAN LİMİTİNİZ: "+
                                        krediKartiKisi.krediKart.get(a).getLimit());

                            }
                            else{
                                System.out.println("LİMİT YETERLİ DEĞİLDİR!");
                            }
                                    
                        }
                    
                    }
                }
            }
        }
        if(alt_secim==3){
            Scanner input = new Scanner (System.in);
            System.out.println("MÜŞTERİ NUMARANIZI GİRİNİZ: ");
            System.out.println("PAROLANIZI GİRİNİZ: ");
            int müsterinumarasi = input.nextInt();
            int parola = input.nextInt();
            for (int i = 0; i < u.size(); i++) {
                User krediKartiKisi = u.get(i);

                if(krediKartiKisi.getMusteriNumarası()==müsterinumarasi && krediKartiKisi.getParola() == parola){
                    
                    Scanner inputtt = new Scanner (System.in);
                    System.out.println("BORCUNUZU ÖDEMEK İSTEDİĞİNİZ HESABIN NUMARASINI GİRİNİZ: ");
                    int borcOdenecekHesapNumarası = inputtt.nextInt();
                    
                    Scanner innputt = new Scanner (System.in);
                    System.out.println("HANGİ HESAPLI KREDİ KARTINIZIN BORCUNU ÖDEMEK İSTERSİNİZ: ");
                    int borcuOdencekKrediKartı = innputt.nextInt();
                    
                    for (int p =0 ; p<krediKartiKisi.hesapBilgileri.size() ; p++ ){
            
                        if(krediKartiKisi.hesapBilgileri.get(p).getHesapNumarasi()==borcOdenecekHesapNumarası){
                            
                            for(int t=0; t<krediKartiKisi.krediKart.size(); t++){
                                
                                if(krediKartiKisi.krediKart.get(t).getKrediKartNumarasi() == borcuOdencekKrediKartı){
                            
                                   CreditCard a = new CreditCard();
                                    a.borcOde(krediKartiKisi.krediKart.get(t).getToplamBorc(), 
                                              krediKartiKisi.krediKart.get(t).getAsgariBorc(),
                                              krediKartiKisi.hesapBilgileri.get(p));

                                }
                                
                                
                                
                          
                            }
                            

                        }
                    
                    }
                }
           }
        
        
        }
    }
//*******************************************************************************************************************************  
    if(kaba_secim == 0){
        
        System.out.println("BAY BAY");
        System.exit(0);
    }

    }//while son parantezi
}
}




 

