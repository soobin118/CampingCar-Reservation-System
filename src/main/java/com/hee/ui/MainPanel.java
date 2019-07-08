package com.hee.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel{
   private JPanel admin, user;
   private BtnListener btnL;
   private JButton btnAdmin,btnUser;
   private JLabel imglbl;
   private App ff;
   private AdminPanel add;
   public MainPanel(App f) {
      ff=f;
      setPreferredSize(new Dimension(1000,640));
       setBackground(Color.white);
       setLayout(null);
       
       btnL = new BtnListener();
       
       ImageIcon cir;
       cir = new ImageIcon("image\\camping.jpg");
       Image cir_1 = cir.getImage();
       Image cir_2 = cir_1.getScaledInstance((int) (1000), (int) (500), java.awt.Image.SCALE_SMOOTH);
       cir.setImage(cir_2);
       imglbl = new JLabel(cir);
       imglbl.setBounds(0, 0, 1000, 500);
       add(imglbl);
       
       admin = new JPanel();
       admin.setBounds(0, 500, 500, 140);
       admin.setLayout(null);
       add(admin);
       
       user = new JPanel();
       user.setBounds(500, 500, 500, 140);
       user.setLayout(null);
       add(user);
       
       Font font=new Font(null,Font.BOLD,100);
       
       btnAdmin = new JButton("ADMIN");
       btnAdmin.setBounds(0,0, 500, 140);
       btnAdmin.setBackground(new Color(0xef9252));
       btnAdmin.setForeground(Color.white);
       btnAdmin.setFont(font);
       btnAdmin.addActionListener(btnL);
       admin.add(btnAdmin);
       
       btnUser = new JButton("USER");
       btnUser.setBounds(0,0, 500, 140);
       btnUser.setBackground(new Color(0x336666));
       btnUser.setForeground(Color.white);
       btnUser.setFont(font);
       btnUser.addActionListener(btnL);
       user.add(btnUser);
   }
   
   private class BtnListener implements ActionListener{
         public void actionPerformed(ActionEvent event) {
            JButton b = (JButton) event.getSource();
            String btnName=null;
             btnName=b.getText();
             switch(btnName) {
             case "ADMIN":
                admin.setVisible(false);
                user.setVisible(false);
                ff.changePanel(1);
                break;
             case "USER":
                admin.setVisible(false);
                user.setVisible(false);
                ff.changePanel(2);
                break;
             }
         }
   }
}