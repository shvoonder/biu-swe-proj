<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/NewManager.css"/> -->
<link rel="stylesheet" type="text/css" href="css/New/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/New/style.css"/>


<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
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
					<form action="ManagerSignUpStatus" method="post">
						<h3><strong>Manager Signup</strong></h3><br>
						<div class="login">
							Username:<input type="text" placeholder="Username" id="user_name" name="user_name" required> <br>
							Password:<input type="password" placeholder="Password" id="password" name="password" required> <br>
							<input type="submit" id="submit" value="Submit" class="site-btn sb-gradients">
						</div>
					</form>
				</div>
				<div class="col-md-6">
					<img src="Images/laptop.png" class="laptop-image" alt="">
				</div>
			</div>
		</div>
	</section>

<!-- Hero section end -->

</body>
</html>