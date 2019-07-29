package starwars;

public class Karakter {
    
    String Ad;
    String Tur;
    int x;
    int y;
       
    Karakter(String ad,String tur,int lokasyonx,int lokasyony){
      this.Ad=ad;
      this.Tur=tur;  
      this.x=lokasyonx;
      this.y=lokasyony;
      
    }
       String getAd(){
        return this.Ad;
    }
    
    String getTur(){
        return this.Tur;
    }
    
    int getLokasyonx(){
        return this.x;
    }
    
    int getLokasyony(){
        return this.y;
    }
    
    void setAd(String name){
        this.Ad=name;
    }
    
    void setTur(String kind){
        this.Tur=kind;
    }
    
    void setLokasyonx(int x){
        this.x=x;
    }
    
    void setLokasyony(int y){
        this.y=y;
    }
    
    
}