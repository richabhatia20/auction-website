<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%


String username=(String)session.getAttribute("username");

if(session.getAttribute("username") == null){
	response.sendRedirect("login.html");
}



String status=(String)request.getAttribute("status");
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Success</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
<div id="header" class="container">
	<div id="logo">
		<h1><a href="#"><strong>AuctionStore</strong></a></h1>
	</div>
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="#">Success</a></li>
			
			<li><a href="homepage.jsp">Home</a></li>
			
			<li><a href="user.do?req=updateitem">Update Item</a></li>
			<li><a href="#">Functionality</a></li>
			<li><a href="user.do?req=logout">Logout</a></li>
		</ul>
	</div>
</div></div>
<div id="page" class="container">
	<div id="content">
		<div class="title">
			<h2>Welcome to our website</h2>
			<span class="byline">You buy,You sell</span> </div>
		
		<p>Dear <strong><%=username %> </strong></p>
		<%=status %>
		
	</div>
	
</div>
<div id="copyright">
	<p>Copyright (c) 2014 MySite.com. All rights reserved. | Richa Bhatia | Design by abcdef</p>
</div>
</body>
</html>
