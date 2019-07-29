package starwars;

public class Lokasyon {
    
    int kordinatx;
    int kordinaty;
    
    Lokasyon(int x ,int y) {
    this.kordinatx=x;
    this.kordinaty=y;
    
}
    void setkordinatx(int x) {
        this.kordinatx = x;
    }

    void sety(int y) {
        this.kordinaty = y;
    }

    int getx() {
        return this.kordinatx;
    }

    int gety() {
        return this.kordinaty;
    }
            
}
