 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import java.awt.Component;
import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish
 */
public class LoadMp3 
{
    static ArrayList<File> folder = new ArrayList<File>();
    static ArrayList<File> mp3Files = new ArrayList<File>();
   static FileDialog fileDialog;
   
   
    public void Load(String path)
    {
        try
        {
            int k=0,temp;
                File dir = new File(path);
		File[] children= dir.listFiles();
                
		for(int i=0;i<children.length;i++)
		{
			//File filename = new File(children[i]);
                      
			if(children[i].isDirectory())
			{
				folder.add(children[i]); 
			}
			else
			{
                           if(children[i].getName().endsWith(".mp3"))
                            {
                                mp3Files.add(children[i]);
                                k++;
                                //System.out.println(mp3Files.get(k++));
                            }	
			}
		}
                    
        }catch(Exception e){}
    }
}
