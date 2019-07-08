package com.hee.model;

import java.sql.*;
import java.util.ArrayList;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Optional;

public class DatabaseConnect {

   private Connection conn = null;
   //private Statement stmt = null;
   public Date realdate=null;
   //Integer integerr =null;
   private static final String USERNAME = "s16010988";
   private static final String PASSWORD = "shineefx97";
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

   public DatabaseConnect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
         System.out.println("DB Connection OK!");
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("DB Driver Error!");
      }catch(SQLException se) {
         se.printStackTrace();
         System.out.println("DB Connection Error!");
         
      }
   }
   public ArrayList<CompanyVO> selectCompany(String condition) {
      String sql = "select * from company ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<CompanyVO> arrCompanyVO = new ArrayList<CompanyVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            CompanyVO tempCompanyVO = new CompanyVO(rs.getInt("COMPANYID"),
                   rs.getString("COMPANY_NAME"),
                   rs.getString("ADDRESS"),
                   rs.getString("PHONE_NUM"),
                   rs.getString("MANAGER_NAME"),
                   rs.getString("MANAGER_EMAIL"));
            arrCompanyVO.add(tempCompanyVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrCompanyVO;
   }
   public ArrayList<CustomerVO> selectCustomer(String condition) {
      String sql = "select * from customer ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<CustomerVO> arrCustomerVO = new ArrayList<CustomerVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            CustomerVO tempCompanyVO = new CustomerVO(rs.getString("DRIVER_LICENSE_NUM"),
                   rs.getString("PHONE_NUM"),
                   rs.getString("CUSTOMER_NAME"),
                   rs.getString("ADDRESS"),
                   rs.getString("EMAIL"),
                   rs.getDate("PREVIOUS_USE_DATE"),
                   rs.getInt("PREVIOUS_CAR_INFO"));
            arrCustomerVO.add(tempCompanyVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrCustomerVO;
   }
   public ArrayList<RepairShopVO> selectRepairShop(String condition) {
      String sql = "select * from repairshop ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<RepairShopVO> arrRepairShopVO = new ArrayList<RepairShopVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            RepairShopVO tempRepairShopVO = new RepairShopVO(rs.getInt("REPAIRSHOPID"),
                   rs.getString("REPAIRSHOP_NAME"),
                   rs.getString("PHONE_NUM"),
                   rs.getString("ADDRESS"),
                   rs.getString("MANAGER_NAME"),
                   rs.getString("MANAGER_EMAIL"));
            arrRepairShopVO.add(tempRepairShopVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrRepairShopVO;
   }
   
   public ArrayList<RequestVO> selectRequest(String condition) {
      String sql = "select * from request ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<RequestVO> arrRequestVO = new ArrayList<RequestVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            RequestVO tempRequestVO = new RequestVO(rs.getInt("REPAIR_NUM"),
                   rs.getInt("CARID"),
                   rs.getInt("COMPANYID"),
                   rs.getString("DRIVER_LICENSE_NUM"),
                   rs.getDate("DUEDATE"),
                   rs.getString("REPAIR_DETAILS"),
                   rs.getDate("REPAIR_DATE"),
                   rs.getInt("REPAIR_COST"),
                   rs.getString("OTHER_REPAIR_DETAILS"),
                   rs.getInt("REPAIRSHOPID"));
            arrRequestVO.add(tempRequestVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrRequestVO;
   }
   
   public ArrayList<RentalVO> selectRental(String condition) {
      String sql = "select * from rental ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<RentalVO> arrRentalVO = new ArrayList<RentalVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            RentalVO tempRentalVO = new RentalVO(rs.getInt("RENTAL_NUM"),
                   rs.getInt("CHARGES"),
                   rs.getInt("CARID"),
                   rs.getString("DRIVER_LICENSE_NUM"),
                   rs.getInt("COMPANYID"),
                   rs.getDate("STARTDATE"),
                   rs.getInt("RENTAL_PERIOD"),
                   rs.getDate("DUEDATE"),
                   rs.getString("OTHER_CHARGES_DETAILS"),
                   rs.getInt("OTHER_CHARGES"));
            arrRentalVO.add(tempRentalVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrRentalVO;
   }
   public ArrayList<CampingCarVO> selectCampingCar(String condition) {
      String sql = "select * from campingcar ";
      sql+=condition;
      PreparedStatement pstmt = null;
      ArrayList<CampingCarVO> arrCampingCarVO = new ArrayList<CampingCarVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            CampingCarVO tempCampingCarVO = new CampingCarVO(rs.getInt("CARID"),
                   rs.getString("CAR_NAME"),
                   rs.getString("CAR_NUM"),
                   rs.getBlob("CAR_IMG"),
                   rs.getString("CAR_DETAILS"),
                   rs.getInt("NUM_OF_PASSENGER"),
                   rs.getDate("CAR_REGISTER_DATE"),
                   rs.getInt("COMPANYID"),
                   rs.getInt("RENTAL_COST"));
            arrCampingCarVO.add(tempCampingCarVO);
         }
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrCampingCarVO;
   }
   public ArrayList<DescribeTableVO> getTableDescription(String tableName) {
      String sql = "select COLUMN_NAME from COLS where table_name=?";
      PreparedStatement pstmt = null;
      ArrayList<DescribeTableVO> arrDescribeTableVO = new ArrayList<DescribeTableVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tableName.toUpperCase());
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            System.out.println("getTableDescription");
            System.out.println(rs.getString("COLUMN_NAME"));
            DescribeTableVO tempDescribeTableVO = new DescribeTableVO(rs.getString("COLUMN_NAME"));
            arrDescribeTableVO.add(tempDescribeTableVO);
         }
   
         
      } catch(SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
      return arrDescribeTableVO;
   }
   public void insertCustomer(String licenseNum, String phoneNum, String cusName, 
         String address, String email) {
      String sql = "insert into customer values (?,?,?,?,?,?,?)";
      PreparedStatement pstmt = null;

      try {
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, licenseNum);
         pstmt.setString(2, phoneNum);
         pstmt.setString(3, cusName);
         pstmt.setString(4, address);
         pstmt.setString(5, email);
         pstmt.setDate(6,realdate);
         pstmt.setNull(7,Types.INTEGER);
         pstmt.executeUpdate();
      } catch (SQLException e) {

         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null && !pstmt.isClosed())
               pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}