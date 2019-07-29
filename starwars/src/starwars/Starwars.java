package starwars;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Starwars {

    public static void main(String[] args) throws IOException  {
        
       Scanner keyboard=new Scanner(System.in);
              System.out.println("Oynamak istediginiz karakterin adini giriniz.");
              String name=keyboard.nextLine();
     
         sekil s = new sekil(name);
                                s.setBackground(Color.BLACK);
                               JFrame jf = new JFrame("Izgara Ekrani");
                               jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                               jf.setSize(850,700);
                               jf.add(s);  
                               jf.setVisible(true);
                               jf.addKeyListener(s);
    }

}

