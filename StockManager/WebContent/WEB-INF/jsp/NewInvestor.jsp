<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/NewInvestor.css"/>
<link rel="stylesheet" type="text/css" href="css/New/bootstrap.min.css"/>
<style>
.hero-section{
background-image:url("Images/hero-bg.png");
background-repeat:no-repeat;
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
					<form action="InvestorSignUpStatus" method="post">
					<h2 align="center">Customer Characterization Form</h2>
					<p><strong>Personal Information</strong></p>
					<div id="personalInfo">
					<p>
					Name:
					<input type="text" placeholder="Name" name="name" required>
					Age:
					<select id="age" name="age" required size="1">
					<option value="">None</option>
					<option class="age" value="2">0-20</option>
					<option class="age" value="5">20-40</option>
					<option class="age" value="4">40-60</option>
					<option class="age" value="3">60-80</option>
					<option class="age" value="2">80-100</option>
					<option class="age" value="1">100-120</option>
					</select>
					Family status:
					<select id="family_s" name="family_s" size="1" required>
					<option value="">None</option>
					<option class="family_s" value="5">Single</option>
					<option class="family_s" value="2">Married</option>
					<option class="family_s" value="3">Divorced</option>
					<option class="family_s" value="4">Widow/er</option>
					</select>
					Number of children under 21:
					<select id="child_num" name="child_num" required size="1">
					<option value="">None</option>
					<option class="child_num" value="5">0-1</option>
					<option class="child_num" value="4">2-3</option>
					<option class="child_num" value="3">4-5</option>
					<option class="child_num" value="2">6-7</option>
					<option class="child_num" value="1">7+</option>
					</select>
					</p>
					<p>
					Employment status:
					<input type="radio" class="employment_s" name="employment_s" value="1" required>Unemployed
					<input type="radio" class="employment_s" name="employment_s" value="3" required>Salaried employee
					<input type="radio" class="employment_s" name="employment_s" value="3" required>Self employed
					</p>
					</div>
					<br/>
					<p><strong>Financial status</strong></p>
					<div id="financial">
					<p>Monthly disposable income:
					<select id="income_s" name="income_s" size="1" required>
					<option value="">None</option>
					<option class="income_s" value="2">0-5000</option>
					<option class="income_s" value="3">5000-10000</option>
					<option class="income_s" value="4">10000-20000</option>
					<option class="income_s" value="5">Over 20000</option>
					</select>
					Apartments owned by the costumer:
					<input type="radio" class="apartment" name="apartment" value="5" required>Yes
					<input type="radio" class="apartment" name="apartment" value="3" required>No
					</p>
					<p>Total real and financial assets (excluding residential apartments):
					<select id="tot_assets" name="tot_assets" size="1" required>
					<option value="">None</option>
					<option class="tot_assets" value="2">0-100000</option>
					<option class="tot_assets" value="3">100000-200000</option>
					<option class="tot_assets" value="4">200000-300000</option>
					<option class="tot_assets" value="5">Over 300000</option>
					</select>
					</p>
					</div>
					<br/>
					<p><strong>Liquidity</strong></p>
					<div id="liquidity">
					<p>Desirable investment time range (years):
					<select id="time_range" name="time_range" size="1" required>
					<option value="">None</option>
					<option class="time_range" value="3">0-3</option>
					<option class="time_range" value="3">3-5</option>
					<option class="time_range" value="3">5-8</option>
					<option class="time_range" value="2">8-10</option>
					<option class="time_range" value="2">Over 10</option>
					</select>
					</p>
					</div>
					<br/>
					<p><strong>Previous experience in the capital market</strong></p>
					<div id="experience">
					<p>To what extent your portfolio previously included marketable products:
					<input type="radio" class="marketable_prod" name="marketable_prod" value="2" required>Low
					<input type="radio" class="marketable_prod" name="marketable_prod" value="3" required>Medium
					<input type="radio" class="marketable_prod" name="marketable_prod" value="4" required>High
					
					</p>
					<p>The frequency of monitoring of the investment portfolio:
					<input type="radio" class="frequency" name="frequency" value="3" required>Daily
					<input type="radio" class="frequency" name="frequency" value="2" required>Weekly
					<input type="radio" class="frequency" name="frequency" value="1" required>Monthly
					</p>
					</div>
					<br/>
					<p><strong>Financial goals and considerations</strong></p>
					<div id="goal">
					<p>The intended use of the invested funds:
					<input type="radio" class="goals" name="goals" value="3" required>Long term investment
					<input type="radio" class="goals" name="goals" value="4" required>Real estate
					<input type="radio" class="goals" name="goals" value="2" required>Pension savings
					<input type="radio" class="goals" name="goals" value="1" required>Monthly income
					
					</p>
					</div>
					<br/>
					<p><strong>Risk attitude</strong></p>
					<div id="risk">
					<p>What is your preference for fluctuations in the property being invested:
					<input type="radio" class="fluctuations" name="fluctuations" value="1" required>Low
					<input type="radio" class="fluctuations" name="fluctuations" value="3" required>Medium
					<input type="radio" class="fluctuations" name="fluctuations" value="5" required>High
					</p>
					</div>
					<br/>
					<p><strong>Login information</strong></p>
					<div id="login">
					<p>Username:<input type="text" placeholder="user name" id="user_name" name="user_name" required></p>
					<p>Password:<input type="password" placeholder="password" id="password" name="password" required></p>
					<p>Re-enter password:<input type="password" placeholder="password" id="re_password" onchange="check()" required><label id="message"></label></p>
					<input type="submit" id="submit" value="Submit">
					</div>
					</form>	
				</div>
<!-- 				<div class="col-md-6"> -->
<!-- 					<img src="Images/laptop.png" class="laptop-image" alt=""> -->
<!-- 				</div> -->
			</div>
		</div>
	</section>

<!-- Hero section end -->

<script>
function check() {
if (document.getElementById('password').value ==
document.getElementById('re_password').value) {
document.getElementById('message').style.color = 'green';
document.getElementById('message').innerHTML = 'matching';
} else {
document.getElementById('message').style.color = 'red';
document.getElementById('message').innerHTML = 'not matching';
}
}
</script>
</body>
</html>