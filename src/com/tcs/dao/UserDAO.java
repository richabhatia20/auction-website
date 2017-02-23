package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.utility.JdbcConnection;
import com.tcs.beans.CategoryBean;
import com.tcs.beans.UserBean;

public class UserDAO {

	
	
	
	JdbcConnection connection=new JdbcConnection();
	
	public boolean validateUser(String userid, String password)
	{
		String query="SELECT * FROM AUCTION_USER_tbl";
		Connection con=connection.getConnection();
		
		
		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
		
			System.out.println(query);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				
				if(userid.equalsIgnoreCase(rs.getString("userid"))&&(password.equals(rs.getString("PASSWORD"))))
						{
					
					return true;
					
						}
				
			}
			
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	public boolean addUser(UserBean user)
	{
		String query="INSERT INTO AUCTION_USER_tbl VALUES(?,?,?,?,?,?)";
		Connection con=connection.getConnection();

		try
		{
			String userid=user.getUserid();
			String password=user.getPassword();
			String username=user.getName();
			String address=user.getAddress();
			String gender=user.getGender();
			String contactno=user.getContactno();
		/*	int contact=Integer.valueOf(contactno);*/
			long contact=Long.valueOf(contactno);
			System.out.println(userid+password+username+address+gender+contact);
			
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, userid);
			pst.setString(2, password);
			pst.setString(3, username);
			pst.setString(4, address);
			pst.setString(5, gender);
			pst.setLong(6, contact);
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
	
	
	
	
	
	
	public ArrayList<CategoryBean> fetchCategories()
	{
		ArrayList<CategoryBean> cList=new ArrayList<CategoryBean>();
		
			String query="select *from AUCTION_ITEM_CATEGORY_REF";
			Connection con=connection.getConnection();

		try
		{
			
			
			
			PreparedStatement pst=con.prepareStatement(query);
		
			System.out.println(query);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				
				CategoryBean cb=new CategoryBean();
				
				int cid=rs.getInt("item_categoryid");
				String cdesc=rs.getString("item_categorydesc");
				
				System.out.println(cid+"\t"+cdesc);
				cb.setCategoryId(cid);
				cb.setCategorydesc(cdesc);
				
				cList.add(cb);
				
			}
			
			con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		return cList;
		
	}
	
	
	
	
	
	public ResultSet returnDetails(String userid)
	{
		String query="SELECT * FROM AUCTION_USER_tbl where userid=?";
		Connection con=connection.getConnection();
		ResultSet rs=null;
		
		try
		{
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, userid);
			System.out.println(query);
			
			rs=pst.executeQuery();
			
			
			
			//con.close();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			
		}
		
		return rs;
		
	}
	
	
	
	
	
	
	
	
	
	
}
