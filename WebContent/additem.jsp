<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>
    
<%@page import="com.tcs.beans.*" %>   

<html>

<%


String username=(String)session.getAttribute("username");
String email=(String)session.getAttribute("userid");
String contactno=(String)session.getAttribute("contactno");



Object obj=request.getAttribute("cList");

ArrayList<CategoryBean> cList=(ArrayList<CategoryBean>)obj;

if(session.getAttribute("username") == null){
	response.sendRedirect("login.html");
}


%>







<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<!--<script src="sample-registration-form-validation.js"></script> 
-->


<link rel="stylesheet" href="style.css">

<script src="http://code.jquery.com/jquery-	1.9.1.js"></script> 
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
 <link rel="stylesheet" 	href="/resources/demos/style.css" /> 
 <script> 


 $(function() {   


 $( "#from" ).datepicker({      defaultDate: "+1w",      changeMonth: true,      	numberOfMonths: 1,      onClose: function( selectedDate ) {        $( "#to" ).datepicker( "option", "minDate", selectedDate );      }    });    $( 	"#to" ).datepicker({      defaultDate: "+1w",      changeMonth: true,      numberOfMonths: 1,      onClose: function( selectedDate ) {        $( 	"#from" ).datepicker( "option", "maxDate", selectedDate );      }    });  });  </script>


</head>
<body onload="document.registration.userid.focus();">
<div id="header-wrapper">
<div id="header" class="container">
	<div id="logo">
		<h1><a href="#"><strong>Auction Store</strong></a></h1>
	</div>
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="#">AddItem</a></li>
			<li><a href="index.html">Home</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Functionality</a></li>
			<li><a href="user.do?req=logout">Logout</a></li>
		</ul>
	</div>
</div></div>
<div id="page" class="container">
	<div id="content">
		<div class="title">
			<h2>Welcome to our website</h2>
			<span class="byline">You buy, You sell</span> </div>
		<form name='registration' onSubmit="return formValidation();" action="user.do?req=itemadd" method="post">  
<ul>

<li><label for="username">User Name:</label></li>  
<li><input type="text" name="username" size="50" value="<%=username %>" readonly/></li>  

<li><label for="userid">Email id:</label></li>  
<li><input type="text" name="userid" size="50" value="<%=email %>" readonly/></li>  

<li><label for="contactno">Contact No:</label></li>  
<li><input type="text" name="contactno" size="50" value="<%=contactno %>" readonly/></li>  
  
<li><label for="itemname">Item name:</label></li>  
<li><input type="text" name="itemname" size="50" /></li>  


<li><label for="category">Category:</label></li>  
<li><select name="category">  
<option selected="" value="Default">(Please select a category)</option>  

<%

for(int i=0;i<cList.size();i++)
{
%>



<option value="<%=cList.get(i).getCategorydesc() %>"><%=cList.get(i).getCategorydesc() %></option>  
 


<% }%>
</select></li> 
<li><label for="description">Item Description:</label></li>  
<li><input type="text" name="description" size="50" /></li>  

<li><label for="minprice">Minimum Price:</label></li>  
<li><input type="text" name="minprice" /></li>  


<li>

<label for="">Auction Duration*</label> :</li>

<li><label for="">From </label> <input type="text" id="from" name="from" /></li>

<li><label for="">To </label><input type="text" id="to" name="to" /></li>





<li><label for="auctionedto">Auctioned To:</label></li>  
<li><input type="text" name="auctionedto" size="50" /></li>  




<li><input type="submit" name="submit" value="Submit" /></li>  
</ul>  
</form>  
		
	</div>
	<div id="sidebar">
		<ul class="style1">
			<li class="first">
				<h3>This is a heading</h3>
				<p><a href="#">This is a linkThis is a linkThis is a link </a> This is plaintextThis is plaintextThis is plaintextThis is plaintext</p>
			</li>
			<li>
				<h3>This is 2nd heading</h3>
				<p><a href="#">This is a linkThis is a linkThis is a link </a> This is plaintext.This is plaintextThis is plaintextThis is plaintext</p>
			</li>
		</ul>
		<div id="stwo-col">
			<div class="sbox1">
				<h2>Name of First Module</h2>
				<ul class="style2">
					<li><a href="#">First Function</a></li>
					<li><a href="#">Second Function</a></li>
					<li><a href="#">Third Function</a></li>
					<li><a href="#">Fourth Function</a></li>
					<li><a href="#">Fifth Function</a></li>
				</ul>
			</div>
			<div class="sbox2">
				<h2>Name of Second Module</h2>
				<ul class="style2">
					<li><a href="#">First Function</a></li>
					<li><a href="#">Second Function</a></li>
					<li><a href="#">Third Function</a></li>
					<li><a href="#">Fourth Function</a></li>
					<li><a href="#">Fifth Function</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="copyright">
	<p>Copyright (c) 2014 MySite.com. All rights reserved. | Richa Bhatia | Design by abcdef</p>
</div>
</body>
</html>