package starwars;

public class Stormtrooper extends Karakter{
    
    public Stormtrooper(String ad, String tur, int lokasyonx, int lokasyony) {
        super(ad, tur, lokasyonx, lokasyony);
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
        return this.x;
    }
    
    @Override
    int getLokasyony(){
        return this.y;
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
    
}
