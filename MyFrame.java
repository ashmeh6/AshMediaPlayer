 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;


import com.sun.java.swing.plaf.motif.MotifSliderUI;
import com.sun.java.swing.plaf.windows.WindowsButtonUI;
import com.sun.java.swing.plaf.windows.WindowsCheckBoxMenuItemUI;
import com.sun.java.swing.plaf.windows.WindowsMenuBarUI;
import com.sun.java.swing.plaf.windows.WindowsMenuUI;
import com.sun.java.swing.plaf.windows.WindowsSliderUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.swing.plaf.synth.SynthSliderUI;

import static AshMediaPlayer.LoadMp3.folder;
import static AshMediaPlayer.PlayingList.list;

/**
 *
 * @author Ashish
 */

public class MyFrame extends JFrame implements Runnable  
{
    JPanel panel;
    JLabel volimg,test;
    Jb cross,min;
    Image i,j,k;
    JSlider vol,seekbar;
    static Player player;
    File file;
    JMenuBar menu;
    JMenu filemenu,loadmenu,about;
    JMenuItem exit,selectMedia,allmp3,aboutme,playlist;
    FileDialog fileDialog=new FileDialog(this, "Select Media File", FileDialog.LOAD);
    Thread t=null;
    Component vcp;
    String currentDirectory;
    JButton selectButton;
    String b1,b2,b3;
    RoundButton stopButton,nextButton,previousButton,forwardButton,backwardButton;//playButton
    boolean status=false;
    boolean play = false,firstTime = true,stop = false,repeatplay = false;
   static int songNum;
    int count;
    JMenu playmenu;
   // JMenuItem jumpto;
    JCheckBoxMenuItem repeat;
    JLabel time,video;
   JFileChooser chooser;
   String choosertitle,pausenormal,pauseentered,pauseclicked,playnormal,playentered,playclicked;
   PlayFrame pf;
   // CustomLabel cl;
    
    public  void play(int no)
     {
         //player.close();
                        try 
                    {
                       
                       // System.out.println(file.getName());
                        if(LoadMp3.mp3Files.get(no).getName().endsWith(".mp3"))
                        {
                            
                            player= Manager.createPlayer(LoadMp3.mp3Files.get(no).toURL());
                            player.start();
//                            try{
//                float vv=(float)vol.getValue()/100;
//           //     System.out.println(vv);
//                player.getGainControl().setLevel(vv);}catch(Exception volu){}
                            play = true;
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(pausenormal),pausenormal)));
                            panel.repaint();
                        }
                        else if(LoadMp3.mp3Files.get(no).getName().endsWith(".mpg"))
                        {
                            player=Manager.createRealizedPlayer(LoadMp3.mp3Files.get(no).toURL());
                            player.start();
                            vcp=player.getVisualComponent();
                            vcp.setBounds(0,0,400,300);
                          //  video.repaint();
                            video.add(vcp);
                            video.revalidate();
                           // panel.repaint();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(MyFrame.this, "wrong type");
                            return;
                        }
                   
                   Thread.sleep(1000);
                    System.out.println((player.getDuration().getSeconds()));
                        seekbar.setMaximum((int)player.getDuration().getSeconds());
                        vol.setMaximum(100);
                       // seekbar.setValue((int)player.getMediaTime().getSeconds());
                        System.out.println(player.getMediaNanoseconds());
//                        if((int)player.getDuration().getSeconds()==(int)player.getMediaTime().getSeconds())
//                        {
//                            play(++songNum);
//                        }
                        t=new Thread(MyFrame.this);
                        t.start();
                     
                    } catch (Exception ex) {}
    }

    
    public MyFrame()
    {
        pf = null;
        PlayingList.clicked = false;
        PlayingList.songclicked = 0;
                video = new JLabel();
        try {
            video.setIcon(new ImageIcon(new URL(this.getClass().getResource("bglabel.jpg"),"bglabel.jpg")));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                count = 0;
                songNum = 0;
                seekbar=new JSlider();
                seekbar.setValue(0);
                seekbar.setBounds(10, 300, 375, 9);
                seekbar.setOpaque(false);
                playnormal = "001g.png";
                playclicked = "001d.png";
                playentered = "001.png";
                pausenormal = "001gnew.png";
                pauseentered = "001new.png";
                pauseclicked = "001dnew.png";
                try{seekbar.setUI(new BasicSliderUI(seekbar));}catch(Exception eee){}
//                cl = new CustomLabel("test");
                    this.setSize(400,400);
        this.setLayout(null);
        //this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        video.setBounds(0, 25, 400, 275);
                                
        panel = new JPanel() ;
//        {
//            public void paintComponent(Graphics g)
//            {
//              try
//              {  
//                 Image i=ImageIO.read(new URL(this.getClass().getResource("bg001.jpg"),"bg001.jpg"));
//                 g.drawImage(i,0,0,this.getWidth(),this.getHeight(),this);
//              }catch(Exception e){}
//            }
//        };
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, this.getWidth(),this.getHeight());
        this.add(panel);
        panel.setLayout(null);
             
      //  playButton=new RoundButton(new ImageIcon(getClass().getResource(b1)), b2,b3);
      //  playButton.setBounds(160, 317, 46, 46);
        test = new JLabel();
        try {
            test.setIcon(new ImageIcon(new URL(this.getClass().getResource("001g.png"),"001g.png")));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        pauseButton=new JButton("PAUSE");
//        pauseButton.setBounds(30, 275, 80, 20);
        test.setBounds(160, 317, 46, 46);
        selectButton=new JButton("SELECT");
        selectButton.setBounds(200, 50, 80, 20);
        
       

        stopButton=new RoundButton(new ImageIcon(getClass().getResource("005g.png")), "005d.png", "005.png");
        stopButton.setBounds(17,327,24,24);
        
        nextButton=new RoundButton(new ImageIcon(getClass().getResource("004.png")), "004d.png", "004g.png");
        nextButton.setBounds(248,326,24,24);
        
        previousButton=new RoundButton(new ImageIcon(getClass().getResource("0051.png")), "0051d.png", "0051g.png");
        previousButton.setBounds(94,326,24,24);
        forwardButton=new RoundButton(new ImageIcon(getClass().getResource("002.png")), "002d.png", "002g.png");
        forwardButton.setBounds(212, 323, 32, 32);
        backwardButton=new RoundButton(new ImageIcon(getClass().getResource("003.png")), "003d.png", "003g.png");
        backwardButton.setBounds(123, 323, 32, 32);
        
        panel.add(video);
        
        menu = new JMenuBar();
        menu.setBounds(0, 0, this.getWidth(), 25);
        menu.setBackground(Color.red);
        menu.setUI(new WindowsMenuBarUI());
        panel.add(menu);
        filemenu = new JMenu("File");
        filemenu.setUI(new WindowsMenuUI());
        menu.add(filemenu);
        loadmenu = new JMenu("Open Folder");
        loadmenu.setUI(new WindowsMenuUI());
        menu.add(loadmenu);
        playmenu = new JMenu("Utility");
        playmenu.setUI(new WindowsMenuUI());
        menu.add(playmenu);
        about = new JMenu("About");
        about.setUI(new WindowsMenuUI());
        menu.add(about);
        exit = new JMenuItem("Exit");
        allmp3 = new JMenuItem("AllMp3Folder");
        aboutme = new JMenuItem("About Developer");
        about.add(aboutme);
        loadmenu.add(allmp3);
        selectMedia = new JMenuItem("Select File");
     
        playlist = new JMenuItem("PlayList");
        playmenu.add(playlist);
        repeat = new JCheckBoxMenuItem("Repeat");
        repeat.setUI(new WindowsCheckBoxMenuItemUI());
        filemenu.add(selectMedia);
        playmenu.add(repeat);
        filemenu.add(exit);
        time = new JLabel();
        time.setBounds(55, 295, 40, 90);
        time.setForeground(Color.WHITE);
        time.setText("00:00");
        time.setFont(new Font("", 3, 13));
        panel.add(time);
//       volimg=new JLabel(new ImageIcon(k));
//       volimg.setBounds(225, 300, 50, 30);
       
        vol=new JSlider();
        vol.setBounds(285, 335, 80, 9);
        vol.setUI(new BasicSliderUI(vol));
        panel.add(vol);
        vol.setToolTipText("Vol");
        vol.setOpaque(false);
      //  vol.setUI(new BasicSliderUI(vol));
        vol.setValue(100);
             
   
     //     panel.add(playButton);
        panel.add(test);
//        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(forwardButton);
        panel.add(backwardButton);
        panel.add(nextButton);
        panel.add(previousButton);
      //  panel.add(selectButton);
     
        
//        panel.add(cl);
  //          cl.setBounds(300, 200, 200, 50);
            panel.repaint();

//        panel.add(volimg);
        panel.add(seekbar);
        
      this.setVisible(true); 
      exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        System.exit(0);
                    }
                });
      playlist.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(LoadMp3.mp3Files.size()!=0){
                        if(pf==null)
                    {
                         String ss[] = new String[LoadMp3.mp3Files.size()];
                        for(int i=0;i<LoadMp3.mp3Files.size();i++)
                        {
                            ss[i]= LoadMp3.mp3Files.get(i).getName();
                        }
                        pf = new PlayFrame(ss);
                    }
                        pf.setVisible(true);
                    }else
                    {
                          JOptionPane.showMessageDialog(MyFrame.this,"No Song Selected");
                    }
                    }    
                });
     
      allmp3.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        chooser = new JFileChooser(); 
                        chooser.setCurrentDirectory(new java.io.File("."));
                        chooser.setDialogTitle(choosertitle);
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
                        chooser.setAcceptAllFileFilterUsed(false);
    //    
                        if (chooser.showOpenDialog(MyFrame.this) == JFileChooser.APPROVE_OPTION) { 
                      //  System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
                        System.out.println("getSelectedFile() : "+  chooser.getSelectedFile());
                          LoadMp3 obj = new LoadMp3();
                        obj.Load((chooser.getSelectedFile()).toString());
                        
                        for(int i =0;i<folder.size();i++)
                        {                       
                            String pathNew = (folder.get(i)).toString();
                            obj.Load(pathNew);
                        }
                        JOptionPane.showMessageDialog(MyFrame.this, "Successfully Loaded: "+LoadMp3.mp3Files.size()+" Mp3 Files");
                       
                      
                        }
                        else 
                        {
                            System.out.println("No Selection ");
                            JOptionPane.showMessageDialog(MyFrame.this, "Not Any File Selected");
                        }
                      }
   
                });
      repeat.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        count++;
                        if(count%2!=0)
                        {
                            repeatplay=true;
                        }
                        else
                        {
                            repeatplay = false;
                         }   }
                });
      aboutme.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        JOptionPane.showMessageDialog(MyFrame.this, "   This Media Player is Alpha Version.\n     So This can be Freely Distributed\nAnd this Player is Designed By Ashish Lal\n\n         ThankYou For Choosing This");
                    }
                });
        backwardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                player.setMediaTime(new Time(player.getMediaTime().getSeconds()-10));
            }
        });
        
        forwardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
               // System.out.println( player.getStopTime().getSeconds()/60);
                player.setMediaTime(new Time(player.getMediaTime().getSeconds()+10));
                seekbar.setValue((int)player.getMediaTime().getSeconds());
               //System.out.println((player.getMediaTime().getSeconds())/60);
            }
        });
       
        nextButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                       // panel.revalidate();
                        
                        stop = false;
                        firstTime = false;
                        songNum++;
                        try{
                            if(player!=null)
                {
                    player.close();
                }
                        play(songNum);
                        System.out.println ("song selected");}catch(Exception exe){}
//                  Exception ex) {}
                    }
                    
                });
        
        previousButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        firstTime =false;
                        stop = false;
                        songNum--;
                        if(songNum<=0){songNum=0;}
                        try{
                            if(player!=null){player.close();}
                        play(songNum);}catch(Exception exp){}
                    }
                });
        stopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                songNum = 0;    
                firstTime = true;           
                player.close();
               time.setText("00:00");
               test.setIcon(new ImageIcon(new URL(this.getClass().getResource(playnormal),playnormal)));
               panel.repaint();
               play = false;
                stop = true;  
                }
                catch(Exception ex){JOptionPane.showMessageDialog(MyFrame.this,"Already Stopped");}
            }
        });
        
//        pauseButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               player.stop();
//            }
//        });
        
//        playButton.addActionListener(new ActionListener() {

         //   @Override
        //    public void actionPerformed(ActionEvent e) 
//            {
//                if(LoadMp3.mp3Files.size()!=0&&firstTime)
//                {
//                    firstTime = false;
//                    stop = false;
//                    play(songNum);
//                    
//                }
//                try{if(play)  
//                {
//                    play = false;
//                    player.stop();
//                               
//                  
//                }
//              else
//                {
//                    play = true;
//                     player.start();
//                }}catch(Exception exp){JOptionPane.showMessageDialog(MyFrame.this,"File Not Selected...");}
//              
//            }
//        });
        test.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e)
                    
                    {
                        panel.repaint();
                        if(!play){
                        try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(pauseclicked),pauseclicked)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }}
                        else
                        {
                             try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(playclicked),playclicked)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                            
                         if(LoadMp3.mp3Files.size()!=0&&firstTime)
                        {
                             firstTime = false;
                             stop = false;
                             play(songNum);
                             
                        }
                        try{if(play)  
                        {
                             play = false;
                             player.stop();
                               
                  
                        }
                         else
                        {
                              play = true;
                               player.start();
                        }}catch(Exception exp){JOptionPane.showMessageDialog(MyFrame.this,"File Not Selected...");}
                        
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) 
                    {
                        if(!play)
                        {try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(playentered),playentered)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }}
                        else
                        {
                            try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(pauseentered),pauseentered)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) 
                    {
                         if(!play)
                        {try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(playnormal),playnormal)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }}
                        else
                        {
                            try {
                            test.setIcon(new ImageIcon(new URL(this.getClass().getResource(pausenormal),pausenormal)));
                            panel.repaint();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                        }
                    }
                });
        
        selectMedia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fileDialog.setDirectory (currentDirectory);
                fileDialog.show ();
                currentDirectory = fileDialog.getDirectory();
                file=new File(currentDirectory+fileDialog.getFile());
                 if (player != null)
                 {
                  player.close ();
                 }
                try {
//                    System.out.println(file.getName());
//                    if(file.getName().endsWith(".mp3"))
//                    {
//                      player= Manager.createPlayer(file.toURL());
//                      player.start();
//                     
//                    }
                    if(file.getName().endsWith(".mpg"))
                    {
                        player=Manager.createRealizedPlayer(file.toURL());
                        player.start();
                        try{test.setIcon(new ImageIcon(new URL(this.getClass().getResource(pausenormal),pausenormal)));
                            panel.repaint();
                             play = true;}catch(Exception eee){}
                        vcp=player.getVisualComponent();
                        vcp.setBounds(0,0,400,300);
                        video.repaint();
                        video.add(vcp);
                    }
                    else{
                        panel.repaint();
                        JOptionPane.showMessageDialog(MyFrame.this, "wrong type");
                        return;
                    }
                   
                   //Thread.sleep(1000);
                  
                   System.out.println((player.getDuration().getSeconds()));
                   seekbar.setMaximum((int)player.getDuration().getSeconds());
                   vol.setMaximum(100);
                   seekbar.setValue((int)player.getMediaTime().getSeconds());
                   if(player.getMediaTime().getSeconds()==player.getDuration().getSeconds())
                   {
                        try {
            video.setIcon(new ImageIcon(new URL(this.getClass().getResource("bglabel.jpg"),"bglabel.jpg")));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
                    {player.close();
                      panel.repaint();
                    time.setText("00:00");}
                   }
                  t=new Thread(MyFrame.this);
                  
                  t.start();
                     System.out.println ("song selected");
                     
                } catch (Exception ex) {
                    
                }
             }
        });
        

       seekbar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                status=true;
//                System.out.println(status);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
               status=true;
//                System.out.println(status);
//       
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
             //   status=true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
       status=false;
            }
        });
       
        seekbar.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if(status)
                {
                try{ player.setMediaTime(new Time((double)seekbar.getValue()));
             //   System.out.println(status);
                }catch(Exception seekk){}
       
                }
             //   System.out.println(seekbar.getValue());  // player.setMediaTime(new Time((double)seekbar.getValue()));
            }
        });
        vol.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
               
                try{
                float vv=(float)vol.getValue()/100;
           //     System.out.println(vv);
                player.getGainControl().setLevel(vv);}catch(Exception volu){}
            }
        });
       
    }
    
   

     //   this.setVisible(true);
       
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet.");
        int min=-1;
         while(true)
        {
            panel.repaint();
            try{
            if(PlayingList.clicked==true)
            {
                player.close();
                songNum = PlayingList.songclicked;
                play(songNum);
                PlayingList.clicked = false;
            }
            }catch(Exception playexp){}
            if(((int)player.getMediaTime().getSeconds())==0){min=-1;}
            if(((int)player.getMediaTime().getSeconds())%60==0){min++;}
//            JButton time=null;
            if(stop)
            {
                seekbar.setValue(0);
                seekbar.setToolTipText("00:00");
            }
            else{
            seekbar.setValue((int)player.getMediaTime().getSeconds());
            PlayingList.list.setSelectedIndex(songNum);
            
            seekbar.setToolTipText(String.valueOf(((int)player.getMediaTime().getSeconds())/60)+":"+String.valueOf(((int)player.getMediaTime().getSeconds())%60));
            time.setText(String.valueOf(((int)player.getMediaTime().getSeconds())/60)+":"+String.valueOf(((int)player.getMediaTime().getSeconds())%60));
            
            
            
            panel.repaint();}
//            time = new JButton(String.valueOf(min)+":"+String.valueOf(((int)player.getMediaTime().getSeconds())%60));
//            time.setBounds(42,287, 80, 30);
            try {
                Thread.sleep(1000);              
                if(player.getMediaTime().getSeconds()==player.getDuration().getSeconds())
                {
                   // if(player!=null)
                    //player.stop();
                    try {
            video.setIcon(new ImageIcon(new URL(this.getClass().getResource("bglabel.jpg"),"bglabel.jpg")));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
                    {player.close();
                      panel.repaint();
                    time.setText("00:00");}
                    songNum++;
                    if(repeatplay)
                    {
                        songNum--;
                        play(songNum);
                      
                    }
                    else
                    {play(songNum);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Media.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    }

   

    
