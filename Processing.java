 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import com.sun.java.swing.plaf.motif.MotifProgressBarUI;
import com.sun.java.swing.plaf.windows.WindowsProgressBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.metal.MetalProgressBarUI;
import javax.swing.plaf.synth.SynthProgressBarUI;

/**
 *
 * @author Ashish
 */
public class Processing extends JWindow 
{
    MyPanel p;
    JProgressBar pb;
    JLabel lb;
    public Processing()
    {
        p = new MyPanel();
        lb = new JLabel("WELCOME");
       // lb.setFont(new Font("", , 15));
        lb.setBounds(15, 10, 400, 400);
        //lb.setForeground(Color.getHSBColor(1.0(float)i, 1.0, 1.0));
        pb = new JProgressBar(0,2000);
        pb.setValue(0);
        pb.setBounds(30,300,390,18);
        pb.setUI(new WindowsProgressBarUI());
        pb.setVisible(true);
// pb.setForeground(Color.GREEN);
//        lb.setSize(150, 300);
//        lb.setBounds(100, 100,100,100);
//        lb.setForeground(Color.red);
//        p.add(lb);
        this.setSize(450,350);
        this.setLayout(new GridLayout());
        
        p.add(pb);
        p.add(lb);
        p.setLayout(null);
        //this.setBounds(490,250,this.getWidth(),this.getHeight());
        Dimension dimension  = Toolkit.getDefaultToolkit().getScreenSize(); //
        int x = (int)((dimension.getWidth()-this.getWidth())/2);            //  Set ScreeCentre
        int y = (int)((dimension.getHeight()-this.getHeight())/2);          //
        this.setLocation(x,y);
        this.add(p);
        this.setVisible(true);
    }
   
}
