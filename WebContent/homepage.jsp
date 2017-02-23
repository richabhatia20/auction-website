<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%


String username=(String)session.getAttribute("username");

if(session.getAttribute("username") == null){
	response.sendRedirect("login.html");
}




%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome</title>
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
			<li class="current_page_item"><a href="#">Homepage</a></li>
			
			<li><a href="user.do?req=additem">Add Item</a></li>
			
			<li><a href="user.do?req=updateitem">Update Item</a></li>
			<li><a href="user.do?req=bidItem">Bid Item</a></li>
			<li><a href="user.do?req=logout">Logout</a></li>
		</ul>
	</div>
</div></div>
<div id="page" class="container">
	<div id="content">
		<div class="title">
			<h2>Welcome to our website</h2>
			<span class="byline">You buy,You sell</span> </div>
		<a href="#" class="image image-full"><img src="images/image1.png" alt="Image1" /></a>
		<p>Welcome <strong><%=username %> </strong></p>
		
		<div id="onecolumn">
			<div class="title">
				<h2>This is a heading</h2>
			</div>
			<p>This is another text dehwdhiwhdiwhdiwifihdihidweiojdijsfihsifhihfihfugufufhihfishjfi</p>
		</div>
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
