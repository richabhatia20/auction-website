package com.tcs.beans;

//import sun.util.calendar.LocalGregorianCalendar.Date;

public class ItemBean {

	
	private String customerName; 
	private String emailId;
	private String contactNo; 
	private String itemName;
	private String itemCategory;  
	private String itemDescription;
	private String auctionStartDate;
	private String auctionEndDate;
	private int minPrice; 
	private String auctionedTo;
	private String auctionedOn;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getAuctionStartDate() {
		return auctionStartDate;
	}
	public void setAuctionStartDate(String auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}
	public String getAuctionEndDate() {
		return auctionEndDate;
	}
	public void setAuctionEndDate(String auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public String getAuctionedTo() {
		return auctionedTo;
	}
	public void setAuctionedTo(String auctionedTo) {
		this.auctionedTo = auctionedTo;
	}
	public String getAuctionedOn() {
		return auctionedOn;
	}
	public void setAuctionedOn(String auctionedOn) {
		this.auctionedOn = auctionedOn;
	}
	
	
}
