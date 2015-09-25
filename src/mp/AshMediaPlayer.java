 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */

/*
	This is Main Java File
*/
package AshMediaPlayer;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import static AshMediaPlayer.LoadMp3.folder;

/**
 *
 * @author Ashish
 */
public class AshMediaPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int i=0,j=0;
    float color=(float) 1.0;
    
       Processing ps = new Processing();
       while(i<=2000)
       {
           if(i==1)
           {
               
           }
           ps.pb.setValue(i);
        //   ps.lb.setFont(null);
           if(i%10==0){j++;}
           ps.lb.setFont(new Font("",2 , j));
           ps.lb.setForeground(Color.getHSBColor(color+=5,color+=3, color++));
         //  ps.pb.setString("Loading... "+j++);
           //ps.pb.setStringPainted(true);
           i+=10;
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                
            }
           
       }
        ps.setVisible(false);     
        
               
       new MyFrame();
    }
}
