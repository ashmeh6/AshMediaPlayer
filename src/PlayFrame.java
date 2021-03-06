 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthPanelUI;

/**
 *
 * @author Ashish
 */
public class PlayFrame extends JFrame
{
    PlayingList list;
    static int height,width;
    public PlayFrame(String s[])
    {
        this.setSize(400,500);
        width = this.getWidth();
        height = this.getHeight();
        this.setLayout(null);
       this.setResizable(false);
        
        this.setVisible(true);
        list = new PlayingList(s);
        //list.setUI(new SynthPanelUI());
        list.setBounds(0, 0, this.getWidth(), this.getHeight());
       // list.setBackground(Color.red);
        this.add(list);
        
    }
}
