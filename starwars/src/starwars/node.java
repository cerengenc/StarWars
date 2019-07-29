package starwars;

import java.util.ArrayList;

public class node {
    
    ArrayList <Integer> path=new ArrayList();
    int x,y,lokasyon;
    
    
    ArrayList enKisaYol(int ox,int oy,int kx,int ky,int matris[][]){
         
    ArrayList <node> dugum=new ArrayList();
         
         boolean var=false;
         int hedef=(14*oy)+ox+1;
         int basla=(14*ky)+kx;
         int count=0;
         
         node root=new node();
         root.x=kx;
         root.y=ky;
         
         if(root.y==0){
             
              root.path.add((root.y*14)+kx+1);
         }else
        root.path.add((root.y*14)+kx+1);
        
         dugum.add(root);
        
            while((dugum.get(0).y*14)+dugum.get(0).x+1 != hedef){
                count++;
                 if(dugum.get(0).x-1<=14 && dugum.get(0).y<11 && dugum.get(0).y>=0 && dugum.get(0).x-1>=0){
                     if(matris[dugum.get(0).x-1][dugum.get(0).y] != 0){
                    
                  node left=new node();
                       
                  left.x=dugum.get(0).x-1;
                  left.y=dugum.get(0).y;
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (left.y*14)+left.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  left.path=(ArrayList)dugum.get(0).path.clone();
                   left.path.add((left.y*14)+left.x+1);
                  
                  dugum.add(left);
                   }
                  
                  var=false;
                }
                 }
                if( dugum.get(0).x+1<14 && dugum.get(0).y<11 && dugum.get(0).y>=0 && dugum.get(0).x+1>=0){
                  if(matris[dugum.get(0).x+1][dugum.get(0).y] != 0 ){
                    node right=new node();
                  right.x=dugum.get(0).x+1;
                  right.y=dugum.get(0).y;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (right.y*14)+right.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  right.path=(ArrayList)dugum.get(0).path.clone();
                  right.path.add((right.y*14)+right.x+1);
                  dugum.add(right);
                   }
                  
                  var=false;
                }
                }
                
                if( dugum.get(0).x<=14 && dugum.get(0).y+1<11 && dugum.get(0).y>=0 && dugum.get(0).x>=0){
                   if(matris[dugum.get(0).x][dugum.get(0).y+1] != 0){
                    node down=new node();
                  down.x=dugum.get(0).x;
                  down.y=dugum.get(0).y+1;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (down.y*14)+down.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  down.path=(ArrayList)dugum.get(0).path.clone();
                  down.path.add((down.y*14)+down.x+1);
                  dugum.add(down);
                   }
                  
                  var=false;
                }
                }
                if( dugum.get(0).x<=14 && dugum.get(0).y-1<=11 && dugum.get(0).y-1>=0 && dugum.get(0).x>0){
                  if(matris[dugum.get(0).x][dugum.get(0).y-1] != 0 ){
                  node up=new node();
                  up.x=dugum.get(0).x;
                  up.y=dugum.get(0).y-1;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (up.y*14)+up.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  up.path=(ArrayList)dugum.get(0).path.clone();
                  up.path.add((up.y*14)+up.x+1);
                  dugum.add(up);
                   }
                  
                  var=false;
                }
                 }
                 
                dugum.remove(0);
                
            }
         System.out.println("Kac adimda bulundu:"+count);
         return dugum.get(0).path;
     }
    
     ArrayList enKisaYolVader(int ox,int oy,int kx,int ky,int matris[][]){
         
    ArrayList <node> dugum=new ArrayList();
         
         boolean var=false;
         int hedef=(14*oy)+ox+1;
         int basla=(14*ky)+kx;
         int count=0;
         
         node root=new node();
         root.x=kx;
         root.y=ky;
         
         if(root.y==0){
             
              root.path.add((root.y*14)+kx+1);
         }else
        root.path.add((root.y*14)+kx+1);
        
         dugum.add(root);
        
            while((dugum.get(0).y*14)+dugum.get(0).x+1 != hedef){
                
        count++;
                 if(dugum.get(0).x-1<=14 && dugum.get(0).y<11 && dugum.get(0).y>=0 && dugum.get(0).x-1>=0){
                    
                  node left=new node();
                       
                  left.x=dugum.get(0).x-1;
                  left.y=dugum.get(0).y;
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (left.y*14)+left.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  left.path=(ArrayList)dugum.get(0).path.clone();
                   left.path.add((left.y*14)+left.x+1);
                  
                  dugum.add(left);
                   }
                  
                  var=false;
                
                 }
                if( dugum.get(0).x+1<14 && dugum.get(0).y<11 && dugum.get(0).y>=0 && dugum.get(0).x+1>=0){
                
                    node right=new node();
                  right.x=dugum.get(0).x+1;
                  right.y=dugum.get(0).y;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (right.y*14)+right.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  right.path=(ArrayList)dugum.get(0).path.clone();
                  right.path.add((right.y*14)+right.x+1);
                  dugum.add(right);
                   }
                  
                  var=false;
                
                }
                
                if( dugum.get(0).x<=14 && dugum.get(0).y+1<11 && dugum.get(0).y>=0 && dugum.get(0).x>=0){
                  
                    node down=new node();
                  down.x=dugum.get(0).x;
                  down.y=dugum.get(0).y+1;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (down.y*14)+down.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  down.path=(ArrayList)dugum.get(0).path.clone();
                  down.path.add((down.y*14)+down.x+1);
                  dugum.add(down);
                   }
                  
                  var=false;
                
                }
                if( dugum.get(0).x<=14 && dugum.get(0).y-1<=11 && dugum.get(0).y-1>=0 && dugum.get(0).x>0){
                 
                  node up=new node();
                  up.x=dugum.get(0).x;
                  up.y=dugum.get(0).y-1;
                  
                   for(int i=0;i<dugum.get(0).path.size();i++){
                         if(dugum.get(0).path.get(i) == (up.y*14)+up.x+1)
                           var=true;
                     }
                   
                  if(var != true){
                  up.path=(ArrayList)dugum.get(0).path.clone();
                  up.path.add((up.y*14)+up.x+1);
                  dugum.add(up);
                   }
                  
                  var=false;
                
                 }
                 
                dugum.remove(0);
                
            }
         System.out.println("Kac adimda bulunduVader:"+count);
         return dugum.get(0).path;
     }
}