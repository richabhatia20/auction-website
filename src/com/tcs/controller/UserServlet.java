package com.tcs.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.text.ParseException;
import java.text.SimpleDateFormat;*/
import java.util.ArrayList;
/*import java.util.Calendar;
import java.util.Date;
*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import sun.util.calendar.LocalGregorianCalendar.Date;

import com.tcs.beans.BidBean;
import com.tcs.beans.CategoryBean;
import com.tcs.beans.ItemBean;
import com.tcs.beans.UserBean;
import com.tcs.dao.BidDAO;
import com.tcs.dao.ItemDAO;
import com.tcs.dao.UserDAO;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("In user servlet");
			
			
			String req=request.getParameter("req");
			
			System.out.println(req);
			
			UserDAO objDAO=new UserDAO();
			ItemDAO itemDAO=new ItemDAO();
			BidDAO bidDAO=new BidDAO();
			if("enter".equalsIgnoreCase(req))
					{
						String userid=request.getParameter("userid");
						String password=request.getParameter("password");
						String username="";
						long contactno=0;
						UserBean user=new UserBean();
						user.setUserid(userid);
						user.setPassword(password);
						
							boolean flag=objDAO.validateUser(userid,password);
							
							if(flag==true)
							{	System.out.println("validated");
							
							ResultSet rs=objDAO.returnDetails(userid);
							
							try {
								while(rs.next())
								{
									username=rs.getString("USERNAME");
									contactno=rs.getLong("CONTACTNO");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String contact=String.valueOf(contactno);
								HttpSession session=request.getSession();
								session.setAttribute("userid", userid);
								session.setAttribute("username", username);
								session.setAttribute("contactno", contact);
								RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
								rd.forward(request, response);
							}
							else
							{
								System.out.println("not validated");
								response.sendRedirect("login.html");
								
							}
				
					}
			
			
			
			if("reg".equalsIgnoreCase(req))
			{
				String email=request.getParameter("email");
				String password=request.getParameter("passid");
				String username=request.getParameter("username");
				String address=request.getParameter("address");
				String gender=request.getParameter("sex");
				String contactno=request.getParameter("contactno");
				
				UserBean user=new UserBean();
				user.setUserid(email);
				user.setPassword(password);
				user.setName(username);
				user.setAddress(address);
				user.setGender(gender);
				user.setContactno(contactno);
				System.out.println(email+password+username+address+gender+contactno);
				
					boolean flag=objDAO.addUser(user);
					
					if(flag==true)
					{
					HttpSession session=request.getSession();
						session.setAttribute("userid", email);
						session.setAttribute("username",username);
						session.setAttribute("contactno", contactno);
						
						System.out.println("User added");
						RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
						rd.forward(request, response);
					}
					else
					{
						
						System.out.println("user not added");
						response.sendRedirect("errorpage.jsp");
					}
		
			}
			
			
			if("additem".equalsIgnoreCase(req))
			{
				ArrayList<CategoryBean> cList=objDAO.fetchCategories();
				
				
				request.setAttribute("cList", cList);
				
				RequestDispatcher rd=request.getRequestDispatcher("additem.jsp");
				
				rd.forward(request, response);	
		
			}
			
			if("itemadd".equalsIgnoreCase(req))
			{
				String customerName=request.getParameter("username"); 
				String emailId=request.getParameter("userid");
				String contactNo=request.getParameter("contactno"); 
				String itemName=request.getParameter("itemname");
				String itemCategory=request.getParameter("category");  
				String itemDescription=request.getParameter("description");
				
				
				String auctionStartDate=request.getParameter("from");
				String auctionEndDate=request.getParameter("to");
				
				
				String auctionedOn=null;
				
				System.out.println(auctionStartDate+"\t"+auctionEndDate+"\t"+auctionedOn);
				
				
				/*
				 SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
	    		 Date startDate = null;
	    		 Date endDate=null;
	    		 Date todayDate=null;
	    		 try {
	 				startDate = formatter.parse(auctionStartDate);
	 				endDate = formatter.parse(auctionEndDate);
	 				//todayDate=formatter.parse(auctionedOn);
	 			} catch (ParseException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 			 System.out.println(startDate);
	 			 System.out.println(endDate);*/
	 			 
				int minPrice=Integer.parseInt(request.getParameter("minprice")); 
				String auctionedTo=request.getParameter("auctionedto");
				
				//------------------------------------------
				 /*Calendar cal = Calendar.getInstance();
				 System.out.println(cal.getTime());
				 
				 Date auctionedOn=cal.getTime();
				 System.out.println(auctionedOn);
				 
				 cal.set(2014, 2, 17, 12, 0, 0);
				 
				 Date auctionStartDate=cal.getTime();
				 
				 System.out.println("Altered year is :" + auctionStartDate);

				 cal.set(2014, 2, 20, 12, 0, 0);
				 
				 Date auctionEndDate=cal.getTime();
				 
				 System.out.println("Altered year is :" + auctionEndDate);*/
				//------------------------------------------
				ItemBean ib=new ItemBean();
				ib.setCustomerName(customerName); 
				ib.setEmailId(emailId);
				ib.setContactNo(contactNo); 
				ib.setItemName(itemName);
				ib.setItemCategory(itemCategory);  
				ib.setItemDescription(itemDescription);
				ib.setAuctionStartDate(auctionStartDate);
				ib.setAuctionEndDate(auctionEndDate);
				ib.setMinPrice(minPrice); 
				ib.setAuctionedTo(auctionedTo);
				ib.setAuctionedOn(auctionedOn);
				
				
					boolean flag=itemDAO.addItem(ib);
					
					if(flag==true)
					{
					
						
						System.out.println("Item added");
						request.setAttribute("status", "Your Item has been added");
						RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
						rd.forward(request, response);
					}
					else
					{
						
						System.out.println("item not added");
						response.sendRedirect("errorpage.jsp");
					}
		
			}
			
			if("logout".equalsIgnoreCase(req))
			{
				
				HttpSession session=request.getSession();
				
				if(session != null){
		    		session.invalidate();
		    	}
		    	response.sendRedirect("login.html");
				
			}
			
			if("bidItem".equalsIgnoreCase(req))
			{
				ArrayList<ItemBean> itemList=itemDAO.returnAllItems();
				
				request.setAttribute("itemList", itemList);
				
				RequestDispatcher rd=request.getRequestDispatcher("biditem.jsp");
				rd.forward(request, response);
				
			}
			
			if("bid".equalsIgnoreCase(req))
			{
				String selected=request.getParameter("item");
			
				System.out.println(selected);
				
				request.setAttribute("selected",selected);
				RequestDispatcher rd=request.getRequestDispatcher("biddetails.jsp");
				rd.forward(request, response);
				
			}
			
			if("givebid".equalsIgnoreCase(req))
			{
				
				
				String email=request.getParameter("userid");
				
				String username=request.getParameter("username");
				String bidPrice=request.getParameter("bidprice");
				String contact=request.getParameter("contactno");
				long contactno=Long.valueOf(contact);
				
				int bprice=Integer.valueOf(bidPrice);
				
				
				int aucid=itemDAO.returnAuctionId(email);
				System.out.println("auctionid"+aucid);
				BidBean bb=new BidBean();
				
				
				bb.setCustomerEmail(email);
				bb.setCustomerName(username);
				bb.setBidPrice(bprice);
				bb.setContactNo(contactno);
				bb.setAuctionId(aucid);
				
				boolean flag=bidDAO.createBid(bb);
				
				if(flag==true)
				{
					System.out.println("bid added");
					request.setAttribute("status", "Your Bid has been added");
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}else
				{
					
					System.out.println("bid not added");
					response.sendRedirect("errorpage.jsp");
				}
			}
			
			
			if("updateitem".equalsIgnoreCase(req))
			{
				ArrayList<ItemBean> itemList=itemDAO.returnAllItems();
				
				request.setAttribute("itemList", itemList);
				
				RequestDispatcher rd=request.getRequestDispatcher("viewupdate.jsp");
				rd.forward(request, response);
			
				
			}
			
			if("update".equalsIgnoreCase(req))
			{
				String selected=request.getParameter("item");
			
				System.out.println(selected);
				
				int aucid=itemDAO.returnAucId2(selected);
				
				ArrayList<BidBean> bidList=bidDAO.returnBid(aucid);
				
				int i=bidList.size();
				
				if(i>0)
				{
					System.out.println("cant update");
					response.sendRedirect("errorpage.jsp");
				}
				else
				{
					ArrayList<ItemBean> itemL=itemDAO.returnItems2(aucid);
					request.setAttribute("itemL", itemL);
					
					RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
					rd.forward(request, response);
					
				}
			}
			
			if("upp".equalsIgnoreCase(req))
			{
				String customerName=request.getParameter("username"); 
				String emailId=request.getParameter("userid");
				String contactNo=request.getParameter("contactno"); 
				String itemName=request.getParameter("itemname");
				String itemCategory=request.getParameter("category");  
				String itemDescription=request.getParameter("description");
				
				
				String auctionStartDate=request.getParameter("from");
				String auctionEndDate=request.getParameter("to");
				
				
				String auctionedOn=null;
				int minPrice=Integer.parseInt(request.getParameter("minprice")); 
				String auctionedTo=request.getParameter("auctionedto");
				ItemBean ib=new ItemBean();
				ib.setCustomerName(customerName); 
				ib.setEmailId(emailId);
				ib.setContactNo(contactNo); 
				ib.setItemName(itemName);
				ib.setItemCategory(itemCategory);  
				ib.setItemDescription(itemDescription);
				ib.setAuctionStartDate(auctionStartDate);
				ib.setAuctionEndDate(auctionEndDate);
				ib.setMinPrice(minPrice); 
				ib.setAuctionedTo(auctionedTo);
				ib.setAuctionedOn(auctionedOn);
				
				
				boolean flag=itemDAO.updateItem(ib);
				
				if(flag==true)
				{
				
					
					System.out.println("Item updated");
					request.setAttribute("status", "Your Item has been updated");
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}
				else
				{
					
					System.out.println("item not updated");
					response.sendRedirect("errorpage.jsp");
				}
	
				
			}
	}

}
