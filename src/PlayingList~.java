 /*
 * GNU GENERAL PUBLIC LICENSE
 * Version 2, June 1991
 */
package AshMediaPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.synth.SynthListUI;

public class PlayingList extends JPanel {

//  String label[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six",
//      "Seven", "Eight", "Nine", "Ten", "Eleven" };

  static JList list;
  static boolean clicked;
  static int songclicked;
  public PlayingList(String label[]) {
    //setLayout(new BorderLayout());
      
      this.setLayout(null);
     // this.setBounds(0, 0, 250  ,400);
    list = new JList(label);
    JScrollPane pane = new JScrollPane(list);

    DefaultListSelectionModel m = new DefaultListSelectionModel();
    m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    m.setLeadAnchorNotificationEnabled(false);
    list.setSelectionModel(m);

   /* list.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        System.out.println(e);
      }
    });*/
    //list.setSelectedIndex(MyFrame.songNum);
    list.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
         System.out.println(MyFrame.songNum = list.getSelectedIndex());
         
        //new MyFrame().play(list.getSelectedIndex());
        }

        @Override
        public void mousePressed(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    
    pane.setBounds(0, 0, PlayFrame.width-14,PlayFrame.height-36);
    this.add(pane);
    //add(pane, BorderLayout.NORTH);
//    add(button, BorderLayout.SOUTH);
  }

//  public static void main(String s[]) {
//    JFrame frame = new JFrame("List Example");
//   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  //  frame.setContentPane(new SimpleList2());
//   // frame.add(new SimpleList2());
//   // frame.pack();
//    frame.setVisible(true);
//  }

// An inner class to respond to clicks on the Print button
//  class PrintListener implements ActionListener {
//    public void actionPerformed(ActionEvent e) {
//      int selected[] = list.getSelectedIndices();
//      System.out.println("Selected Elements:  ");
//
//      for (int i = 0; i < selected.length; i++) {
//        String element = (String) list.getModel().getElementAt(
//            selected[i]);
//        System.out.println("-->" + element);
//      }
//    }
//  }
}
    
