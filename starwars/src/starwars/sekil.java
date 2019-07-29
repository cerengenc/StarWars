package starwars;
import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.image.ImageObserver;
//import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.exit;
//import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class sekil extends JPanel implements KeyListener{
     
    ArrayList <MasterYoda> oyuncu1=new ArrayList();
    ArrayList <LukeSkywalker> oyuncu2=new ArrayList();
    ArrayList <Karakter> kotuK=new ArrayList();
    ArrayList path[];
    ArrayList <Integer> yolx = new ArrayList();
              ArrayList <Integer> yoly = new ArrayList();
    String name;
    int x,y,m1,m2;
    boolean win;
    boolean lose;
    int[][] matris=matrisOku();
    Image image;
                          ImageIcon img=new ImageIcon("image/yoda.png");
                          ImageIcon img1=new ImageIcon("image/skywalker.png");
                          ImageIcon img2=new ImageIcon("image/stormtrooper.png");
                          ImageIcon img3=new ImageIcon("image/darthvader.png");
                          ImageIcon img4=new ImageIcon("image/kyloren.png");
                          ImageIcon can2=new ImageIcon("image/kalp2.png");
                          ImageIcon can=new ImageIcon("image/kalp.png");
                          ImageIcon son=new ImageIcon("image/win.png");
                          ImageIcon over=new ImageIcon("image/gameOver.png");
                          ImageIcon kupa=new ImageIcon("image/kupa.png");
                          
    sekil(String name) throws IOException{
                 this.name=name;
                 if(!name.equalsIgnoreCase("master yoda") && !name.equalsIgnoreCase("luke skywalker")){
                     System.out.println("yanlis girdi yapildi ");
                     exit(1);
                 }
              if(name.equalsIgnoreCase("Master Yoda")){
                   MasterYoda o1=new MasterYoda("Master Yoda","iyi",50+50*6,50+50*5);
                   oyuncu1.add(o1);
              } else if(name.equalsIgnoreCase("Luke Skywalker")){
                  LukeSkywalker o2=new LukeSkywalker("Luke Skywalker","iyi",50+50*6,50+50*5);
                  oyuncu2.add(o2);
              }
           kotuK=karakterOku(); 
           path=new ArrayList[kotuK.size()];
           if(name.equalsIgnoreCase("Master Yoda")){
                for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              System.out.println(""+kotuK.get(i).getAd());
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }  
           }else{
                  for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }
           }
           
           if(name.equalsIgnoreCase("Master Yoda")){
           x=50+50*6;
           y=50+50*5;
           } else {
             x=50+50*6;
             y=50+50*5;  
           }
           m1=(x/50)-1;
           m2=(y/50)-1;
           win=false;
           lose=false;
          
    }
  
    void setX(int lokasyon){
        x=x+lokasyon;
        m1=(x/50)-1;
        win=end(m1,m2);
        if(name.equalsIgnoreCase("Master Yoda")){
        oyuncu1.get(0).setLokasyonx(x);
        System.out.println(oyuncu1.get(0).getLokasyonx()+":"+oyuncu1.get(0).getLokasyony());
        
               for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              System.out.println(""+kotuK.get(i).getAd());
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }
                kotuSet();
        for(int i=0;i<kotuK.size();i++){
            if(kotuK.get(i).getLokasyonx()== (oyuncu1.get(0).getLokasyonx()+1)*50 && kotuK.get(i).getLokasyony()== (oyuncu1.get(0).getLokasyony()+1)*50){
               lose=true;
               oyuncu1.get(0).setCan(1);
            }}
        
          
        } else{
         oyuncu2.get(0).setLokasyonx(x);   
            System.out.println(oyuncu2.get(0).getLokasyonx()+":"+oyuncu2.get(0).getLokasyony());
           for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              System.out.println(""+kotuK.get(i).getAd());
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }
                kotuSet();
                
             for(int i=0;i<kotuK.size();i++){
            if(kotuK.get(i).getLokasyonx()== (oyuncu2.get(0).getLokasyonx()+1)*50 && kotuK.get(i).getLokasyony()== (oyuncu2.get(0).getLokasyony()+1)*50){
               lose=true;
               oyuncu2.get(0).setCan(1);
            }       
        }
         
           
        }
        
        
      
    }
    
    void setY(int lokasyon){
        y=y+lokasyon;
        m2=(y/50)-1;
        win=end(m1,m2);
        
        if(name.equalsIgnoreCase("Master Yoda")){
        oyuncu1.get(0).setLokasyony(y);
        System.out.println(oyuncu1.get(0).getLokasyonx()+":"+oyuncu1.get(0).getLokasyony());
        
        for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              System.out.println(""+kotuK.get(i).getAd());
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu1.get(0).getLokasyonx(),oyuncu1.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }
                kotuSet();
                
        for(int i=0;i<kotuK.size();i++){
            if(kotuK.get(i).getLokasyonx()== (oyuncu1.get(0).getLokasyonx()+1)*50 && kotuK.get(i).getLokasyony()== (oyuncu1.get(0).getLokasyony()+1)*50){
               lose=true;
               oyuncu1.get(0).setCan(1);
            }   
        }
 
        } else{
         oyuncu2.get(0).setLokasyony(y);  
         System.out.println(oyuncu2.get(0).getLokasyonx()+":"+oyuncu2.get(0).getLokasyony());
          for(int i=0;i<kotuK.size();i++){
              node temp=new node();
              System.out.println(""+kotuK.get(i).getAd());
              if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
              path[i]=temp.enKisaYolVader(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);   
              }else{
              path[i]=temp.enKisaYol(oyuncu2.get(0).getLokasyonx(),oyuncu2.get(0).getLokasyony(),(kotuK.get(i).getLokasyonx()/50)-1,(kotuK.get(i).getLokasyony()/50)-1, matris);
              }
          }
                kotuSet();
           for(int i=0;i<kotuK.size();i++){
            if(kotuK.get(i).getLokasyonx()== (oyuncu2.get(0).getLokasyonx()+1)*50 && kotuK.get(i).getLokasyony()== (oyuncu2.get(0).getLokasyony()+1)*50){
               lose=true;
               oyuncu2.get(0).setCan(1);
            }     
        }
           
        }
       
    }
    
    boolean end(int lx,int ly){
        boolean bitti = false;
            if(lx==13 && ly==9)
                bitti=true;
        
        return bitti;
        
    }
    
    
     @Override
          public void paintComponent(Graphics g){
     
              
                               super.paintComponent(g);
                               this.setBackground(Color.darkGray);
                               int j=1;
                              
                              
                            g.setColor(Color.LIGHT_GRAY);
                            for (int i = 0; i < 14; i++) {
                                for (int k = 0; k < 11; k++) {
                                    if(matris[i][k]== 1){
                                        g.fillRect(50+i*50,50+k*50,50,50);
                                    }
                                    
                                    
                                }
         }
                            
                            g.setColor(Color.white);
                                for(int i=50;i<=600;i=i+50){
                                g.drawLine(50,i,750,i);   
                                    
                                }
                                for(int i=50;i<=750;i=i+50){
                                g.drawLine(i,50,i,600);
                                
                                }
                            j=0;
                            g.setColor(Color.white);
                                for(int i=75;i<600;i=i+50){
                                g.drawString(""+j,20, i);
                                j++;
                                }
                                j=0;
                                for(int i=60;i<750;i=i+50){
                               g.drawString(""+j,i+5,40);
                                j++;
                                }
                                
                                   
                            for (int k = 0; k < 14; k++) {
                                for (int l = 0; l < 11; l++) {
                                    if(matris[k][l]== 0){
                                     g.setColor(Color.WHITE);
                                     g.drawString(""+matris[k][l],75+k*50,75+l*50);
                                    } else{
                                    g.setColor(Color.BLACK);
                                    g.drawString(""+matris[k][l],75+k*50,75+l*50);
                                }    
                                }
                             }
                            
                            
                         g.setColor(Color.blue);
                         g.fillRect(50+50*4,50,50,50);
                         g.fillRect(50+50*12,50,50,50);
                         g.fillRect(50+50*13,50+50*5,50,50);
                         g.fillRect(50+50*4,50+50*10,50,50);
                         g.fillRect(50,50+50*5,50,50);
                         g.setColor(Color.ORANGE);
                         g.fillRect(50+50*6,50+50*5,50,50);
                         
                         g.setColor(Color.CYAN);
                         g.drawString("A",70,50+55*5);
                         g.drawString("B",50+55*4,75);
                         g.drawString("C",49+52*12,75);
                         g.drawString("D",47+52*13,50+55*5);
                         g.drawString("E",50+55*4,53+52*10);
                         
                         image=kupa.getImage();
                         g.drawImage(image,14*50+60,10*50,60,60,null);
                         
                         for (int i = 0; i <kotuK.size(); i++) {
                             
                        if(kotuK.get(i).getAd().equalsIgnoreCase("stormtrooper")){
                            image=img2.getImage();
                            
 g.drawImage(image,kotuK.get(i).getLokasyonx(),kotuK.get(i).getLokasyony(),45,45,null);
                      
                        }
                        
                        else if(kotuK.get(i).getAd().equalsIgnoreCase("Kylo Ren")){
                            image=img4.getImage();
 g.drawImage(image,kotuK.get(i).getLokasyonx(),kotuK.get(i).getLokasyony(),45,45,null);                           
                        }
                        
                          else if(kotuK.get(i).getAd().equalsIgnoreCase("DarthVader")){
                            image=img3.getImage();
 g.drawImage(image,kotuK.get(i).getLokasyonx(),kotuK.get(i).getLokasyony(),45,45,null);                           
                        }
         }
                         
                         if(name.equalsIgnoreCase("Master Yoda")){
                             image=img.getImage();
 g.drawImage(image,x,y,45,45,null);                              
                         }   else if(name.equalsIgnoreCase("Luke Skywalker")){
                             image=img1.getImage();
 g.drawImage(image,x,y,45,45,null);                              
                         }
                         
                         image=can.getImage();
                         j=50;
                         if(name.equalsIgnoreCase("Master Yoda")){
                             if(oyuncu1.get(0).getCan()%2==0){
                             for (int i = 0; i <oyuncu1.get(0).getCan();i=i+2) {
                             g.drawImage(image,770,j,30,30,null);
                             j=j+30;
                             }
                         } else{
                              for (int i = 0; i <oyuncu1.get(0).getCan()-1; i=i+2) {
                             g.drawImage(image,770,j,30,30,null);
                             j=j+30;
                             }
                                  image=can2.getImage();
                                  g.drawImage(image,770,j,30,30,null);
                              
                             }
                         } else{
                             for (int i = 0; i <oyuncu2.get(0).getCan(); i++) {
                             g.drawImage(image,770,j,30,30,null);
                             j=j+30;
                             }  
                         }
                         
                         
                         
                        g.setColor(Color.red);
                        for (int i = 0; i < kotuK.size(); i++) {
                            if(path[i]!=null){
                                if(i==1){
                                    g.setColor(Color.BLUE);
                                }
                                if(i==2){
                                    g.setColor(Color.PINK);
                                }
                                if(i==3){
                                    g.setColor(Color.YELLOW);
                                }
                                if(i==4){
                                    g.setColor(Color.GREEN);
                                }
                                for (int k = 1; k <path[i].size(); k++) {
                                    int x1,y1;
                                     x1=0;
                                     y1=0;
                                    if((int)path[i].get(k)==84){
                                          x1 = (int )path[i].get(k)%14+13;
                                     y1 = (int)path[i].get(k)/14-1;
                                    }else{
                                     x1 = (int )path[i].get(k)%14-1;
                                     y1= (int)path[i].get(k)/14;
                                    }
                                  
                                  
                               g.drawRoundRect(50+(x1)*50, 50+y1*50,50, 50, 30, 30);
                                    //g.drawRect();
                                }
                            }
                           if(win==true){
                               image=son.getImage();
                           g.drawImage(image,0,0,850,700,null);
                            } 
                         
                        if(lose==true){
                            if(name.equalsIgnoreCase("Master Yoda")){    
                                try {
                                    kotuK=karakterOku();
                                } catch (IOException ex) {
                                    Logger.getLogger(sekil.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            oyuncu1.get(0).setLokasyonx(50+50*6);
                            oyuncu1.get(0).setLokasyony(50+50*5);
                            x=50+50*6;
                            y=50+50*5;
                            m1=(x/50)-1;
                            m2=(y/50)-1;
                            } else{ try {
                                    kotuK=karakterOku();
                                } catch (IOException ex) {
                                    Logger.getLogger(sekil.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            oyuncu2.get(0).setLokasyonx(50+50*6);
                            oyuncu2.get(0).setLokasyony(50+50*5);
                            x=50+50*6;
                            y=50+50*5;
                            m1=(x/50)-1;
                            m2=(y/50)-1;
                                
                            }
                            lose=false;
                           repaint();
                         }
                        if(name.equalsIgnoreCase("master yoda")){
                         if(oyuncu1.get(0).getCan()==0){
                                 image=over.getImage();
                                 g.drawImage(image,0,0,850,700,null);
                            }} else{
                              if(oyuncu2.get(0).getCan()==0){
                                 image=over.getImage();
                                 g.drawImage(image,0,0,850,700,null);
                            }
                         } 
                        if(name.equalsIgnoreCase("master yoda")){
                         if(oyuncu1.get(0).getCan()==0){
                                 image=over.getImage();
                                 g.drawImage(image,0,0,850,700,null);
                            }} else{
                              if(oyuncu2.get(0).getCan()==0){
                                 image=over.getImage();
                                 g.drawImage(image,0,0,850,700,null);
                            }
                         }    
                            
                            
         }              
                    
                                 }
          
          
          public int[][] matrisOku() throws IOException{
              int matris[][]= new int [14][11];
              
              
              for(int k =0;k<14;k++){
                  for(int l=0;l<11;l++){
                      matris[k][l]=0;     
                  } 
              }
              
             File file=new File("Harita.txt");
            BufferedReader bf=null;
            bf=new BufferedReader(new FileReader(file));
            String satir=bf.readLine();
            
            String line[]=null;
            int sayac=0;
            while(satir != null){
              
            line=satir.split("\t"); 
            
            if(line[0].equals("1") || line[0].equals("0") && sayac<11){
                  
                for (int i = 0; i < line.length; i++) {
                    matris[i][sayac]=Integer.valueOf(line[i]);
                }
             
               sayac++;
            }
            
            satir=bf.readLine();
            }
              bf.close();
              music();
              return matris;
          }
          
          public static void music() throws IOException{
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;
        try
        {
            InputStream test = new FileInputStream("sounds/muzik.au");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
           // MD = BGM.getData();
           //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
         MGP.start(loop);


}
          
          
     public ArrayList karakterOku() throws IOException{
         
         ArrayList <Karakter> kotu=new ArrayList();
         
        String line[]=null;
        String line2[]=null;
        String line3[]=null;
        int x=0,y=0;
         

            File file=new File("Harita.txt");
            BufferedReader bf=null;
            bf=new BufferedReader(new FileReader(file));
            String satir=bf.readLine();
            
            while(satir != null){
                 
                      line=satir.split(",");
                      
                      if(line.length>1){
                          line2=line[0].split(":");
                          line3=line[1].split(":");
                          
                          if(line3[1].equals("A")){
                              x=50;
                              y=50+50*5;
                          } else if(line3[1].equals("B")){
                              x=50+50*4;
                              y=50;
                          } else if(line3[1].equals("C")){
                              x=50+50*12;
                              y=50;
                          } else if(line3[1].equals("D")){
                              x=50+50*13;
                              y=50+50*5;
                          } else if(line3[1].equals("E")){
                              x=50+50*4;
                              y=50+50*10;
                          }
                          
                          if(line2[1].equalsIgnoreCase("DarthVader")){
                              DarthVader k=new DarthVader(line2[1],"kotu",x,y);
                              kotu.add(k);
                          } else if(line2[1].equalsIgnoreCase("Kylo Ren")){
                              KyloRen k1=new KyloRen(line2[1],"kotu",x,y);
                              kotu.add(k1);
                          } else if(line2[1].equalsIgnoreCase("stormtrooper")){
                           Stormtrooper k2=new Stormtrooper(line2[1],"kotu",x,y);
                           kotu.add(k2);
                          }
                          
                          
                          
                      }
                      satir=bf.readLine();
                  
     }
            bf.close();
            
  return kotu;
     }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if(m1+1<14){
                if(matris[m1+1][m2] != 0 ){
                    this.setX(50);
                } 
                }
                  
                
                
                break;
            case KeyEvent.VK_LEFT:
                if( m1-1>-1){
                if(matris[m1-1][m2] != 0)
                this.setX(-50);
                 } 
                break;
                
            case KeyEvent.VK_DOWN:
                if(m2+1<11){
                if(matris[m1][m2+1] != 0) 
                this.setY(50);
               } 
                
                break;
            case KeyEvent.VK_UP:
                if( m2-1>-1){
                if(matris[m1][m2-1] != 0)
                this.setY(-50);
                } 
                break;
            default:
                break;
        }
        
       repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    public void kotuSet(){
        int x = 0,y=0,many=0;
        
        for (int i = 0; i < kotuK.size(); i++) {
            if(kotuK.get(i).getAd().equalsIgnoreCase("stormtrooper")){
                if(path[i].size()>1){
                x=(int)path[i].get(1)%14;
                y=(int)path[i].get(1)/14+1;
                kotuK.get(i).setLokasyonx(x*50);
                kotuK.get(i).setLokasyony(y*50);
                many=(int)path[i].size()-1;
                System.out.println("En kisa yol:"+many);
            } else{
                    lose=true;
                }
            }
            else if(kotuK.get(i).getAd().equalsIgnoreCase("darthvader")){
                if(path[i].size()>1){
                    if((int)path[i].get(1)==84){
                         x = (int )path[i].get(1)%14+13;
                                     y = (int)path[i].get(1)/14-1;
                    }
                    else{
                x=(int)path[i].get(1)%14;
                y=(int)path[i].get(1)/14+1;
                    }
                kotuK.get(i).setLokasyonx(x*50);
                kotuK.get(i).setLokasyony(y*50);
                many=(int)path[i].size()-1;
                System.out.println("En kisa yol:"+many);
            } else{
                    lose=true;
                }
            }
            
            else  if(kotuK.get(i).getAd().equalsIgnoreCase("kylo ren")){
                if(path[i].size()>2){
                x=(int)path[i].get(2)%14;
                y=(int)path[i].get(2)/14+1;
                kotuK.get(i).setLokasyonx(x*50);
                kotuK.get(i).setLokasyony(y*50);
                many=(int)path[i].size()-1;
                System.out.println("En kisa yol:"+many);
            } else{
                    if(path[i].size()>1){
                 x=(int)path[i].get(1)%14;
                y=(int)path[i].get(1)/14+1;
                kotuK.get(i).setLokasyonx(x*50);
                kotuK.get(i).setLokasyony(y*50); 
               many=(int)path[i].size()-1;
                System.out.println("En kisa yol:"+many);
                } else{
                        lose=true;
                    }
                }
            }
        }
        repaint();
    }
}