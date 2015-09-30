 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Ashish
 */
public class Jb extends JButton
{
    Image i;
    public Jb(String name)
    {
       try{
                i = ImageIO.read(new URL(this.getClass().getResource(name),name));
                //j = ImageIO.read(new URL(this.getClass().getResource("aaa.JPG"),"aaa.JPG"));

        }catch(IOException e){} 
    }
           protected void paintComponent(Graphics g)
            {
                //g.drawImage(j,400,200,200,200,this);
                g.drawImage(i,0,0,this.getWidth(),this.getHeight(),this);
            }
}
