package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;*/

//import sun.util.calendar.LocalGregorianCalendar.Date;

import com.tcs.beans.ItemBean;
import com.tcs.utility.JdbcConnection;

public class ItemDAO {

	
	
	
	JdbcConnection connection=new JdbcConnection();
	
	//@SuppressWarnings("deprecation")
	public boolean addItem(ItemBean ib)
	{
		
		String customerName=ib.getCustomerName(); 
		String emailId=ib.getEmailId();
		String contactNo=ib.getContactNo(); 
		String itemName=ib.getItemName();
		String itemCategory=ib.getItemCategory();  
		String itemDescription=ib.getItemDescription();
		String auctionStartDate=ib.getAuctionStartDate();
		String auctionEndDate=ib.getAuctionEndDate();
		String auctionedOn=ib.getAuctionedOn();
		
		/*Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        System.out.println(cal.getTime());

		java.util.Date start= new java.util.Date();
		

    	//start= ib.getAuctionStartDate();
    	java.sql.Date startDate= new java.sql.Date(start.getTime()); 
    	
    	java.util.Date end= new java.util.Date();
    	//end= ib.getAuctionEndDate();
    	java.sql.Date endDate= new java.sql.Date(end.getTime()); 
		*/
		
		//Date auctionStartDate=ib.getAuctionStartDate();
		//Date auctionEndDate=ib.getAuctionEndDate();
		int minPrice=ib.getMinPrice(); 
		String auctionedTo=ib.getAuctionedTo();
		//Date auctionedOn=ib.getAuctionedOn();
		
		String query="INSERT INTO AUCTION_ITEM_TBL VALUES(AUCTIONID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection con=connection.getConnection();

		try
		{
			
			System.out.println();
			
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, customerName);
			pst.setString(2, emailId);
			pst.setString(3, contactNo);
			pst.setString(4, itemName);
			pst.setString(5, itemCategory);
			pst.setString(6, itemDescription);
			pst.setInt(7, minPrice);
			pst.setString(8,auctionedTo);
			pst.setString(9, auctionStartDate);
			pst.setString(10, auctionEndDate);
			pst.setString(11, auctionedOn);
			
			System.out.println(query);
			pst.execute();
			
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
	
	
	
	
	

	public ArrayList<ItemBean> returnAllItems()
	{
		
		ArrayList<ItemBean> itemList=new ArrayList<ItemBean>();
		
		String query="SELECT * FROM auction_item_tbl";
		
		Connection con=connection.getConnection();

		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
			
			System.out.println(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				ItemBean item=new ItemBean();
				
				String customerName=rs.getString("customerName"); 
				String emailId=rs.getString("emailId"); 
				String contactNo=rs.getString("contactNo");  
				String itemName=rs.getString("itemName"); 
				String itemCategory=rs.getString("itemCategory");  
				String itemDescription=rs.getString("itemDescription"); 
				String auctionStartDate=rs.getString("auctionStartDate"); 
				String auctionEndDate=rs.getString("auctionEndDate"); 
				int minPrice=rs.getInt("minPrice"); 
				String auctionedTo=rs.getString("auctionedTo"); 
				String auctionedOn=rs.getString("auctionedOn"); 
				
				item.setCustomerName(customerName);
				item.setEmailId(emailId);
				item.setContactNo(contactNo);
				item.setItemName(itemName);
				item.setItemCategory(itemCategory);
				item.setItemDescription(itemDescription);
				item.setAuctionStartDate(auctionStartDate);
				item.setAuctionEndDate(auctionEndDate);
				item.setMinPrice(minPrice);
				item.setAuctionedTo(auctionedTo);
				item.setAuctionedOn(auctionedOn);
				
				
				itemList.add(item);
				
				
				
			}
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		return itemList;
		
		
	}
	public int returnAuctionId(String email)
	{
		
		
		String query="SELECT auctionId FROM auction_item_tbl where emailId=?";
		
		Connection con=connection.getConnection();
		int aucid=0;
		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, email);
			System.out.println(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				aucid=rs.getInt("auctionId");
				
				
				
			}
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		
		
		
		return aucid;
	}
	public int returnAucId2(String itemName)
	
	
	{
		String query="SELECT auctionId FROM auction_item_tbl where itemName=?";
		
		Connection con=connection.getConnection();
		int aucid=0;
		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, itemName);
			System.out.println(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				aucid=rs.getInt("auctionId");
				
				
				
			}
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		
		
		
		return aucid;
		
	}
	
	public ArrayList<ItemBean> returnItems2(int aucid)
	{
		String auctnid=String.valueOf(aucid);
		
		
		ArrayList<ItemBean> itemList=new ArrayList<ItemBean>();
		
		String query="SELECT * FROM auction_item_tbl where auctionId=?";
		
		Connection con=connection.getConnection();

		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, auctnid);
			System.out.println(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				ItemBean item=new ItemBean();
				
				String customerName=rs.getString("customerName"); 
				String emailId=rs.getString("emailId"); 
				String contactNo=rs.getString("contactNo");  
				String itemName=rs.getString("itemName"); 
				String itemCategory=rs.getString("itemCategory");  
				String itemDescription=rs.getString("itemDescription"); 
				String auctionStartDate=rs.getString("auctionStartDate"); 
				String auctionEndDate=rs.getString("auctionEndDate"); 
				int minPrice=rs.getInt("minPrice"); 
				String auctionedTo=rs.getString("auctionedTo"); 
				String auctionedOn=rs.getString("auctionedOn"); 
				
				item.setCustomerName(customerName);
				item.setEmailId(emailId);
				item.setContactNo(contactNo);
				item.setItemName(itemName);
				item.setItemCategory(itemCategory);
				item.setItemDescription(itemDescription);
				item.setAuctionStartDate(auctionStartDate);
				item.setAuctionEndDate(auctionEndDate);
				item.setMinPrice(minPrice);
				item.setAuctionedTo(auctionedTo);
				item.setAuctionedOn(auctionedOn);
				
				
				itemList.add(item);
				
				
				
			}
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		return itemList;
		
		
		
		
		
	}
	
	public boolean updateItem(ItemBean ib)
	{
		
		/*String customerName=ib.getCustomerName(); 
		String emailId=ib.getEmailId();
		String contactNo=ib.getContactNo(); */
		String itemName=ib.getItemName();
		String itemCategory=ib.getItemCategory();  
		String itemDescription=ib.getItemDescription();
		String auctionStartDate=ib.getAuctionStartDate();
		String auctionEndDate=ib.getAuctionEndDate();
		int minPrice=ib.getMinPrice(); 
		String auctionedTo=ib.getAuctionedTo();
		String auctionedOn=ib.getAuctionedOn();
		
		String query="UPDATE AUCTION_ITEM_TBL SET itemName=?,itemCategory=?,itemDescription=?,minPrice=?,auctionedTo=?,auctionStartDate=?,auctionEndDate=?,auctionedOn=?";
		
		Connection con=connection.getConnection();

		try
		{
			
			System.out.println();
			
			
			PreparedStatement pst=con.prepareStatement(query);
			/*pst.setString(1, customerName);
			pst.setString(2, emailId);
			pst.setString(3, contactNo);*/
			pst.setString(1, itemName);
			pst.setString(2, itemCategory);
			pst.setString(3, itemDescription);
			pst.setString(4, auctionStartDate);
			pst.setString(5, auctionEndDate);
			pst.setInt(6, minPrice);
			pst.setString(7,auctionedTo);
			pst.setString(8, auctionedOn);
			
			System.out.println(query);
			pst.executeUpdate();
			
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
	
}
