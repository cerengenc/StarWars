package starwars;

public class LukeSkywalker extends Karakter{
    
    int can;
    public LukeSkywalker(String ad, String tur, int lokasyonx, int lokasyony) {
        super(ad, tur, lokasyonx, lokasyony);
        can=3;
    }
    
    @Override
     String getAd(){
        return this.Ad;
    }
    
    @Override
    String getTur(){
        return this.Tur;
    }
    
    @Override
    int getLokasyonx(){
        return (this.x/50)-1;
    }
    
    @Override
    int getLokasyony(){
        return (this.y/50)-1;
    }
    
    int getCan(){
        return this.can;
    }
    
    @Override
    void setAd(String name){
        this.Ad=name;
    }
    
    @Override
    void setTur(String kind){
        this.Tur=kind;
    }
    
    @Override
    void setLokasyonx(int x){
        this.x=x;
    }
    
    @Override
    void setLokasyony(int y){
        this.y=y;
    }
    
    void setCan(int can){
        this.can-=1;
    }
    
}

 