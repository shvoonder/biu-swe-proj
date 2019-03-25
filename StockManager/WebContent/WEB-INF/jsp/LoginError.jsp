<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Index.css">
<meta charset="windows-1255">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/LoginError.css"/> -->
<link rel="stylesheet" type="text/css" href="css/New/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/New/style.css"/>

<style>
.hero-section{
background-image:url("Images/hero-bg.png"); 
}
</style>
</head>
<body>
<!-- Header section -->
	<header class="header-section clearfix">
		<div class="container-fluid">
			<a href="/StockManager/Welcome" class="site-logo">
				<img src="Images/logoGrey.png" alt="">
			</a>
			<div class="responsive-bar"><i class="fa fa-bars"></i></div>
			<a href="" class="user"><i class="fa fa-user"></i></a>
			<nav class="main-menu">
			</nav>
		</div>
	</header>
<!-- Header section end -->

<!-- Hero section -->
	<section class="hero-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6 hero-text">		
					<div class="login">
						<form action="LoginPage" method="post">
							<input type="text" placeholder="Username" name="user_name" required><br>
							<input type="password" placeholder="Password" name="password" required><br>
							<div>
							<input type="submit" value="Login">
							</div>
						</form>	
						<br>
						<div class="new">
							<a href="NewInvestor">New Investor</a> / <a href="NewManager">New Investment Portfolio Manager</a>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<img src="Images/laptop.png" class="laptop-image" alt="">
				</div>
			</div>
		</div>
		<div class="alert">
			<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
 			 Username already in use, please signup with different username
		</div>
	</section>
<!-- Hero section end -->

</body>
</html>
