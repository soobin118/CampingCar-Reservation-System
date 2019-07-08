package com.hee.ui;

import com.hee.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AdminPanel extends JPanel{

   private JPanel mainPanel;
   private JPanel tempPanel,tmpPanel;
   private JPanel menuPanel,choosePanel;
   private JPanel insertPanel;
   private JLabel tempLabel;
   
   private JTextField txtCompanyWhere;
   private JComboBox chooseTable;
   private JButton btnSearch,btnSelect;
   private JButton btnWholeData,btnDelete,btnIn,btnEdit,btnQuery,btnReset;
   private JLabel lblCompanySelect,lblCompanyWhere;
   private String[] tableNames= {"CAMPINGCAR","COMPANY", "CUSTOMER","RENTAL","REPAIRSHOP","REQUEST"};
   private JTable jTable;
   private DatabaseConnect dbConnect;
   private JScrollPane jScollPane;
   
   private JTextField txtLicense;
   private JTextField txtName;
   private JTextField txtAddress;
   private JTextField txtPhone;
   private JTextField txtEmail;
   
   private JLabel lblLicense;
   private JLabel lblName;
   private JLabel lblAddress;
   private JLabel lblPhone;
   private JLabel lblEmail;
   private JLabel lblInsertTitle;
   private JButton btnInsert;
   
   private BtnListener btnL;
   
   public AdminPanel() {
      dbConnect = new DatabaseConnect();
      btnL = new BtnListener();
      
      setPreferredSize(new Dimension(1000,640));
      setBackground(Color.white); // ???? ????
      setLayout(null); // ??????????? ?????
            
      mainPanel = new JPanel();               //??????? ????
      mainPanel.setBounds(30,180,940,420);
      mainPanel.setBackground(new Color(0xef9252));   
      mainPanel.setLayout(null);
      add(mainPanel);
      
      Font font=new Font(null,Font.BOLD,17);
      
      menuPanel = new JPanel();
      menuPanel.setBounds(30, 30, 936, 60);
      menuPanel.setBackground(new Color(0x336666));
      menuPanel.setLayout(null);
      add(menuPanel);
      
      btnWholeData = new JButton("WHOLEDATA");
      btnWholeData.setBackground(new Color(0x336666));
      btnWholeData.setForeground(Color.white);
      btnWholeData.setFont(font);
      btnWholeData.setBounds(0, 0, 156, 60);
      btnWholeData.addActionListener(btnL);
      menuPanel.add(btnWholeData);
      
      btnIn = new JButton("INSERTDATA");
      btnIn.setForeground(Color.white);
      btnIn.setBackground(new Color(0x336666));
      btnIn.setFont(font);
      btnIn.setBounds(156, 0, 156, 60);
      btnIn.addActionListener(btnL);
      menuPanel.add(btnIn);
      
      btnDelete = new JButton("DELETEDATA");
      btnDelete.setForeground(Color.white);
      btnDelete.setBackground(new Color(0x336666));
      btnDelete.setFont(font);
      btnDelete.setBounds(156*2, 0, 156, 60);
      btnDelete.addActionListener(btnL);
      menuPanel.add(btnDelete);
      
      btnEdit = new JButton("EDITDATA");
      btnEdit.setForeground(Color.white);
      btnEdit.setBackground(new Color(0x336666));
      btnEdit.setFont(font);
      btnEdit.setBounds(156*3, 0, 156, 60);
      btnEdit.addActionListener(btnL);
      menuPanel.add(btnEdit);
      
      btnQuery = new JButton("QUERY");
      btnQuery.setForeground(Color.white);
      btnQuery.setBackground(new Color(0x336666));
      btnQuery.setFont(font);
      btnQuery.setBounds(156*4, 0, 156, 60);
      btnQuery.addActionListener(btnL);
      menuPanel.add(btnQuery);
      
      btnReset = new JButton("RESET");
      btnReset.setForeground(Color.white);
      btnReset.setBackground(new Color(0x336666));
      btnReset.setFont(font);
      btnReset.setBounds(156*5, 0, 156, 60);
      btnReset.addActionListener(btnL);
      menuPanel.add(btnReset);
      btnWholeData.doClick();
      
     
   }
   public JPanel setSearchBar(String [] tableMenu) {
      choosePanel = new JPanel();
      choosePanel.setBounds(30, 100, 940, 80);
      choosePanel.setBackground(new Color(0xef9252));
      choosePanel.setLayout(null);
      add(choosePanel);
            
      chooseTable= new JComboBox(tableMenu);
      chooseTable.setBounds(30, 20, 120, 40);
      choosePanel.add(chooseTable);
      
      btnSearch = new JButton("Search");
      btnSearch.setBounds(160, 20, 80, 40);
      btnSearch.addActionListener(btnL);
      choosePanel.add(btnSearch);
      
     // insertPanel.setVisible(false);
      
      return choosePanel;
   }
   private JPanel getCompanyTable(String condition) {
      JPanel jPanel = new JPanel();
      jPanel.setBounds(0, 0, 940, 420);
      jPanel.setBackground(new Color(0xef9252));
      jPanel.setLayout(null);
      
      JTable jTable = new JTable();
      DefaultTableModel model = new DefaultTableModel();

      ArrayList<DescribeTableVO> arrDescribeTableVO = 
            dbConnect.getTableDescription("COMPANY");
      Object[] columnsName = new Object[arrDescribeTableVO.size()];
      for (int i = 0; i < arrDescribeTableVO.size(); i++) {
         columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
      }
      model.setColumnIdentifiers(columnsName);

      Object[] rowData = new Object[arrDescribeTableVO.size()];
      System.out.println(arrDescribeTableVO.size());
      ArrayList<CompanyVO> arrCompanyVO = 
            dbConnect.selectCompany(condition);
      for (int i = 0; i < arrCompanyVO.size(); i++) {
         System.out.println(arrCompanyVO.get(i).getCompanyID());
         rowData[0] = arrCompanyVO.get(i).getCompanyID();
         rowData[1] = arrCompanyVO.get(i).getCompanyName();
         rowData[2] = arrCompanyVO.get(i).getAddress();
         rowData[3] = arrCompanyVO.get(i).getPhoneNum();
         rowData[4] = arrCompanyVO.get(i).getManagerName();
         rowData[5] = arrCompanyVO.get(i).getManagerEmail();

         model.addRow(rowData);
      }

      jTable.setModel(model);
      jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
      jTable.setFillsViewportHeight(true);
      jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 15));
      jTable.setFont(new Font("Verdana", Font.PLAIN, 14));
      jTable.setRowHeight(33);
      jTable.getTableHeader().setReorderingAllowed(false);

      jScollPane = new JScrollPane(jTable);
      jScollPane.setPreferredSize(new Dimension(900, 340));
      jScollPane.setBounds(20, 40, 900, 340);
//      jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
      
      jPanel.add(jScollPane);
      
      return jPanel;
   }
   private JPanel getCustomerTable(String condition) {
         JPanel jPanel = new JPanel();
            jPanel.setBounds(0, 0, 940, 420);
            jPanel.setBackground(new Color(0xef9252));
            jPanel.setLayout(null);
            JTable jTable = new JTable();
            DefaultTableModel model = new DefaultTableModel();

            ArrayList<DescribeTableVO> arrDescribeTableVO = 
                  dbConnect.getTableDescription("CUSTOMER");
            Object[] columnsName = new Object[arrDescribeTableVO.size()];
            for (int i = 0; i < arrDescribeTableVO.size(); i++) {
               columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
            }
            model.setColumnIdentifiers(columnsName);

            Object[] rowData = new Object[arrDescribeTableVO.size()];
            System.out.println(arrDescribeTableVO.size());
            ArrayList<CustomerVO> arrCustomerVO = 
                  dbConnect.selectCustomer(condition);
            for (int i = 0; i < arrCustomerVO.size(); i++) {
           //    System.out.println(arrCustomerVO.get(i).getCompanyID());
               rowData[0] = arrCustomerVO.get(i).getLicenseNum();
               rowData[1] = arrCustomerVO.get(i).getPhoneNum();
               rowData[2] = arrCustomerVO.get(i).getCusName();
               rowData[3] = arrCustomerVO.get(i).getEmail();
               rowData[4] = arrCustomerVO.get(i).getAddress();
               rowData[5] = arrCustomerVO.get(i).getPrevDate();
               rowData[6] = arrCustomerVO.get(i).getPrevCarInfo();
               model.addRow(rowData);
            }

            jTable.setModel(model);
            jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
            jTable.setFillsViewportHeight(true);
            jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 12));
            jTable.setFont(new Font("Verdana", Font.PLAIN, 13));
            jTable.setRowHeight(33);
            jTable.getTableHeader().setReorderingAllowed(false);

            jScollPane = new JScrollPane(jTable);
            jScollPane.setPreferredSize(new Dimension(920, 340));
            jScollPane.setBounds(10, 40, 920, 340);
//            jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
            
            jPanel.add(jScollPane);
            
            return jPanel;
   }
   private JPanel getRepairShopTable(String condition) {
       JPanel jPanel = new JPanel();
          jPanel.setBounds(0, 0, 940, 420);
          jPanel.setBackground(new Color(0xef9252));
          jPanel.setLayout(null);
          JTable jTable = new JTable();
          DefaultTableModel model = new DefaultTableModel();

          ArrayList<DescribeTableVO> arrDescribeTableVO = 
                dbConnect.getTableDescription("REPAIRSHOP");
          Object[] columnsName = new Object[arrDescribeTableVO.size()];
          for (int i = 0; i < arrDescribeTableVO.size(); i++) {
             columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
          }
          model.setColumnIdentifiers(columnsName);

          Object[] rowData = new Object[arrDescribeTableVO.size()];
          System.out.println(arrDescribeTableVO.size());
          ArrayList<RepairShopVO> arrRepairShopVO = 
                dbConnect.selectRepairShop(condition);
          for (int i = 0; i < arrRepairShopVO.size(); i++) {
         //    System.out.println(arrCustomerVO.get(i).getCompanyID());
             rowData[0] = arrRepairShopVO.get(i).getRepairShopID();
             rowData[1] = arrRepairShopVO.get(i).getRepairShopName();
             rowData[2] = arrRepairShopVO.get(i).getPhoneNum();
             rowData[3] = arrRepairShopVO.get(i).getAddress();
             rowData[4] = arrRepairShopVO.get(i).getManagerName();
             rowData[5] = arrRepairShopVO.get(i).getManagerEmail();
             model.addRow(rowData);
          }

          jTable.setModel(model);
          jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
          jTable.setFillsViewportHeight(true);
          jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 14));
          jTable.setFont(new Font("Verdana", Font.PLAIN, 13));
          jTable.setRowHeight(33);
          jTable.getTableHeader().setReorderingAllowed(false);

          jScollPane = new JScrollPane(jTable);
          jScollPane.setPreferredSize(new Dimension(920, 340));
          jScollPane.setBounds(10, 40, 920, 340);
//          jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
          
          jPanel.add(jScollPane);
          
          return jPanel;
 }
   private JPanel getRequestTable(String condition) {
       JPanel jPanel = new JPanel();
          jPanel.setBounds(0, 0, 940, 420);
          jPanel.setBackground(new Color(0xef9252));
          jPanel.setLayout(null);
          JTable jTable = new JTable();
          DefaultTableModel model = new DefaultTableModel();

          ArrayList<DescribeTableVO> arrDescribeTableVO = 
                dbConnect.getTableDescription("REQUEST");
          Object[] columnsName = new Object[arrDescribeTableVO.size()];
          for (int i = 0; i < arrDescribeTableVO.size(); i++) {
             columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
          }
          model.setColumnIdentifiers(columnsName);

          Object[] rowData = new Object[arrDescribeTableVO.size()];
          System.out.println(arrDescribeTableVO.size());
          ArrayList<RequestVO> arrRequestVO = 
                dbConnect.selectRequest(condition);
          for (int i = 0; i < arrRequestVO.size(); i++) {
         //    System.out.println(arrCustomerVO.get(i).getCompanyID());
             rowData[0] = arrRequestVO.get(i).getRepairNum();
             rowData[1] = arrRequestVO.get(i).getCarID();
             rowData[2] = arrRequestVO.get(i).getCompanyID();
             rowData[3] = arrRequestVO.get(i).getLicenseNum();
             rowData[4] = arrRequestVO.get(i).getDueDate();
             rowData[5] = arrRequestVO.get(i).getRepairDetails();
             rowData[6] = arrRequestVO.get(i).getRepairDate();
             rowData[7] = arrRequestVO.get(i).getRepairCost();
             rowData[8] = arrRequestVO.get(i).getOtherRepairDetails();
             rowData[9] = arrRequestVO.get(i).getRepairShopID();
             model.addRow(rowData);
          }

          jTable.setModel(model);
          jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
          jTable.setFillsViewportHeight(true);
          jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setRowHeight(33);
          jTable.getTableHeader().setReorderingAllowed(false);

          jScollPane = new JScrollPane(jTable);
          jScollPane.setPreferredSize(new Dimension(920, 340));
          jScollPane.setBounds(10, 40, 920, 340);
//          jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
          
          jPanel.add(jScollPane);
          
          return jPanel;
 }
   private JPanel getRentalTable(String condition) {
       JPanel jPanel = new JPanel();
          jPanel.setBounds(0, 0, 940, 420);
          jPanel.setBackground(new Color(0xef9252));
          jPanel.setLayout(null);
          JTable jTable = new JTable();
          DefaultTableModel model = new DefaultTableModel();

          ArrayList<DescribeTableVO> arrDescribeTableVO = 
                dbConnect.getTableDescription("RENTAL");
          Object[] columnsName = new Object[arrDescribeTableVO.size()];
          for (int i = 0; i < arrDescribeTableVO.size(); i++) {
             columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
          }
          model.setColumnIdentifiers(columnsName);

          Object[] rowData = new Object[arrDescribeTableVO.size()];
          System.out.println(arrDescribeTableVO.size());
          ArrayList<RentalVO> arrRentalVO = 
                dbConnect.selectRental(condition);
          for (int i = 0; i < arrRentalVO.size(); i++) {
         //    System.out.println(arrCustomerVO.get(i).getCompanyID());
             rowData[0] = arrRentalVO.get(i).getRentalNum();
             rowData[1] = arrRentalVO.get(i).getCharges();
             rowData[2] = arrRentalVO.get(i).getCarID();
             rowData[3] = arrRentalVO.get(i).getLicenseNum();
             rowData[4] = arrRentalVO.get(i).getCompanyID();
             rowData[5] = arrRentalVO.get(i).getStartDate();
             rowData[6] = arrRentalVO.get(i).getRentalPeriod();
             rowData[7] = arrRentalVO.get(i).getDueDate();
             rowData[8] = arrRentalVO.get(i).getOtherChargesDetails();
             rowData[9] = arrRentalVO.get(i).getOtherCharges();
             model.addRow(rowData);
          }

          jTable.setModel(model);
          jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
          jTable.setFillsViewportHeight(true);
          jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setRowHeight(33);
          jTable.getTableHeader().setReorderingAllowed(false);

          jScollPane = new JScrollPane(jTable);
          jScollPane.setPreferredSize(new Dimension(920, 340));
          jScollPane.setBounds(10, 40, 920, 340);
//          jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
          
          jPanel.add(jScollPane);
          
          return jPanel;
 }
   private JPanel getCampingCarTable(String condition) {
       JPanel jPanel = new JPanel();
          jPanel.setBounds(0, 0, 940, 420);
          jPanel.setBackground(new Color(0xef9252));
          jPanel.setLayout(null);
          JTable jTable = new JTable();
          DefaultTableModel model = new DefaultTableModel();

          ArrayList<DescribeTableVO> arrDescribeTableVO = 
                dbConnect.getTableDescription("CAMPINGCAR");
          Object[] columnsName = new Object[arrDescribeTableVO.size()];
          for (int i = 0; i < arrDescribeTableVO.size(); i++) {
             columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
          }
          model.setColumnIdentifiers(columnsName);

          Object[] rowData = new Object[arrDescribeTableVO.size()];
          System.out.println(arrDescribeTableVO.size());
          ArrayList<CampingCarVO> arrCampingCarVO = 
                dbConnect.selectCampingCar(condition);
          for (int i = 0; i < arrCampingCarVO.size(); i++) {
         //    System.out.println(arrCustomerVO.get(i).getCompanyID());
             rowData[0] = arrCampingCarVO.get(i).getCarID();
             rowData[1] = arrCampingCarVO.get(i).getCarName();
             rowData[2] = arrCampingCarVO.get(i).getCarNum();
             rowData[3] = arrCampingCarVO.get(i).getImg();
             rowData[4] = arrCampingCarVO.get(i).getCarDetails();
             rowData[5] = arrCampingCarVO.get(i).getNumOfPassenger();
             rowData[6] = arrCampingCarVO.get(i).getCarRegisterDate();
             rowData[7] = arrCampingCarVO.get(i).getCompanyID();
             rowData[8] = arrCampingCarVO.get(i).getRentalCost();
             model.addRow(rowData);
          }

          jTable.setModel(model);
          jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
          jTable.setFillsViewportHeight(true);
          jTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
          jTable.setRowHeight(33);
          jTable.getTableHeader().setReorderingAllowed(false);

          jScollPane = new JScrollPane(jTable);
          jScollPane.setPreferredSize(new Dimension(920, 340));
          jScollPane.setBounds(10, 40, 920, 340);
//          jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());
          
          jPanel.add(jScollPane);
          
          return jPanel;
 }
   private JPanel getInsertPanel() {
      insertPanel = new JPanel();
         insertPanel.setBounds(30,180,940,420);
         insertPanel.setBackground(new Color(0xef9252));   
         insertPanel.setLayout(null);
                 
         lblLicense = new JLabel("License Number");
         lblLicense.setBounds(70,60,145,40);
         lblLicense.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(lblLicense);
         txtLicense = new JTextField();
         txtLicense.setBounds(220, 60, 180, 40);
         txtLicense.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(txtLicense);
         
         lblName = new JLabel("Name ");
         lblName.setBounds(490,60,100,40);
         lblName.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(lblName);
         txtName = new JTextField();
         txtName.setBounds(640, 60, 180, 40);
         txtName.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(txtName);
         
         lblAddress = new JLabel("Address ");
         lblAddress.setBounds(70,140,100,40);
         lblAddress.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(lblAddress);
         txtAddress = new JTextField();
         txtAddress.setBounds(220, 140, 180, 40);
         txtAddress.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(txtAddress);
         
         lblPhone = new JLabel("Phone Number ");
         lblPhone.setBounds(490,140,145,40);
         lblPhone.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(lblPhone);
         txtPhone = new JTextField();
         txtPhone.setBounds(640, 140, 180, 40);
         txtPhone.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(txtPhone);
         
         lblEmail = new JLabel("Email ");
         lblEmail.setBounds(70,220,100,40);
         lblEmail.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(lblEmail);
         txtEmail = new JTextField();
         txtEmail.setBounds(220, 220, 260, 40);
         txtEmail.setFont(new Font("Verdana", Font.PLAIN,17));
         insertPanel.add(txtEmail);
         
         btnInsert = new JButton("SIGNUP");
         btnInsert.setBounds(410, 320, 120, 50);
         btnInsert.addActionListener(btnL);
         insertPanel.add(btnInsert);
         
         return insertPanel;
      
   }
   private JLabel getTitle() {
      lblInsertTitle = new JLabel("< CUSTOMER TABLE >");
         lblInsertTitle.setBounds(340, 120, 300, 40);
         lblInsertTitle.setFont(new Font("Verdana",Font.BOLD,20));
         add(lblInsertTitle);
         
         return lblInsertTitle;
   }
   private class BtnListener implements ActionListener{
      public void actionPerformed(ActionEvent event) {
         JButton b = (JButton) event.getSource();
         String tableName;
         String condition = "";
         String btnName=null;
         btnName=b.getText();
         switch(btnName) {
         case "WHOLEDATA" :
            btnWholeData.setBackground(new Color(0xef9252));
            btnIn.setBackground(null);
            btnDelete.setBackground(null);
            btnEdit.setBackground(null);
            btnQuery.setBackground(null);
            btnReset.setBackground(null);
            //insertPanel.setVisible(false);
            // 버튼 색 다 죽이기
           
            mainPanel.removeAll();
            mainPanel.setLayout(null);
            tempPanel = setSearchBar(tableNames);
            add(tempPanel);
            setVisible(true);
            validate();
            repaint();
            //lblInsertTitle.setVisible(false);
            break;
         case "INSERTDATA":
            btnWholeData.setBackground(null);
            btnIn.setBackground(new Color(0xef9252));
            btnDelete.setBackground(null);
            btnEdit.setBackground(null);
            btnQuery.setBackground(null);
            btnReset.setBackground(null);
            // 버튼 색 다 죽이기
            
            mainPanel.setVisible(false);
            mainPanel=getInsertPanel();
            add(mainPanel);
            setVisible(true);
            validate();
            repaint();
            break;
         case "DELETEDATA":
            btnWholeData.setBackground(null);
            btnIn.setBackground(null);
            btnDelete.setBackground(new Color(0xef9252));
            btnEdit.setBackground(null);
            btnQuery.setBackground(null);
            btnReset.setBackground(null);
            // 버튼 색 다 죽이기
            break;
         case "EDITDATA":
            btnWholeData.setBackground(null);
            btnIn.setBackground(null);
            btnDelete.setBackground(null);
            btnEdit.setBackground(new Color(0xef9252));
            btnQuery.setBackground(null);
            btnReset.setBackground(null);
            // 버튼 색 다 죽이기
            break;
         case "QUERY":
            btnWholeData.setBackground(null);
            btnIn.setBackground(null);
            btnDelete.setBackground(null);
            btnEdit.setBackground(null);
            btnQuery.setBackground(new Color(0xef9252));
            btnReset.setBackground(null);
            // 버튼 색 다 죽이기
            break;
         case "RESET":
            btnWholeData.setBackground(null);
            btnIn.setBackground(null);
            btnDelete.setBackground(null);
            btnEdit.setBackground(null);
            btnQuery.setBackground(null);
            btnReset.setBackground(new Color(0xef9252));
            // 버튼 색 다 죽이기
            break;
            
         case "Search":
               mainPanel.removeAll();
               mainPanel.setLayout(null);

               tableName = tableNames[chooseTable.getSelectedIndex()];
               condition = "";
               jTable = null;
               tempPanel = null;

               switch (tableName) {
               case "CAMPINGCAR":
                  tempPanel = getCampingCarTable(condition);//getCampingCarTable(condition);
                  break;
               case "COMPANY":
                  tempPanel = getCompanyTable(condition);
                  break;
               case "CUSTOMER":
                  tempPanel=getCustomerTable(condition);
                  break;
               case "REPAIRSHOP":
                  tempPanel=getRepairShopTable(condition);
                  break;
               case "RENTAL":
                  tempPanel=getRentalTable(condition);
                  break;
               case "REQUEST":
                  tempPanel=getRequestTable(condition);
                  break;
               }

               mainPanel.add(tempPanel);
               add(mainPanel);

               setVisible(true);
               validate();
               repaint();
               break;
         case "Select":
            mainPanel.removeAll();
            mainPanel.setLayout(null);

            tableName = tableNames[chooseTable.getSelectedIndex()];
            jTable = null;
            tempPanel = null;
            switch (tableName) {
            case "COMPANY":
               condition="where ";
               condition+=txtCompanyWhere.getText();
               tempPanel = getCompanyTable(condition);
               break;
            
            }

            mainPanel.add(tempPanel);
            add(mainPanel);

            setVisible(true);
            validate();
            repaint();
            break;
         case "SIGNUP":
            dbConnect.insertCustomer(txtLicense.getText(), txtPhone.getText(), 
                  txtName.getText(), txtAddress.getText(), txtEmail.getText());
            break;
      }
      
      }
   }
}
   
   