package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.beans.BidBean;
//import com.tcs.beans.CategoryBean;
import com.tcs.utility.JdbcConnection;

public class BidDAO {
	JdbcConnection connection=new JdbcConnection();
	
	public boolean createBid(BidBean bb)
	{
		String customerEmail=bb.getCustomerEmail();
		int bidPrice=bb.getBidPrice();
		int auctionId=bb.getAuctionId();
		String customerName=bb.getCustomerName();
		long contactNo=bb.getContactNo();
		
		
		System.out.println(customerEmail+bidPrice+auctionId+customerName+contactNo);
		
		
		
		
		String query="INSERT INTO bid_item_tbl VALUES(BIDID_SEQ.NEXTVAL,?,?,?)";
		
		Connection con=connection.getConnection();

		try
		{
			
			System.out.println();
			
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, customerEmail);
			pst.setInt(2,bidPrice );
			pst.setInt(3, auctionId);
			
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
	public ArrayList<BidBean> returnBid(int auctionId)
	{
		
		
			ArrayList<BidBean> bidList=new ArrayList<BidBean>();
			
				String query="select *from bid_item_tbl where auctionid=?";
				Connection con=connection.getConnection();

			try
			{
				
				
				
				PreparedStatement pst=con.prepareStatement(query);
				pst.setInt(1, auctionId);
				System.out.println(query);
				
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					
					
					
				BidBean bb=new BidBean();
					
					String bidId=rs.getString("bidid");
					String cemail=rs.getString("customer_email");
					int bPrice=rs.getInt("bidprice");
					
					
					System.out.println(bidId+"\t"+cemail+"\t"+bPrice);
					bb.setCustomerEmail(cemail);
					bb.setBidPrice(bPrice);
					bb.setAuctionId(auctionId);
					bidList.add(bb);
				}
				
				con.close();
				
				
			}
			catch(SQLException e)
			{
				
				e.printStackTrace();
				
			}
			
			return bidList;
			
		}
		
		
	}

