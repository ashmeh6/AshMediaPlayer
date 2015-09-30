 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Ashish
 */
public class CustomLabel extends JLabel
{
    String var;
    public CustomLabel(String value)
    {
        var = value;
    }
     protected void paintComponent(Graphics g)
            {
                g.setColor(Color.WHITE);
                g.drawString(var, this.getX(), this.getY());
            }
}
