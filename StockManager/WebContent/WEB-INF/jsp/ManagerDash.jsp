<%@ page language="java" contentType="text/html; charset=windows-1255"%> 
<%@ page import="Model.Stock"%>
<%@ page import="Model.Portfolio"%>  
<%@ page import="java.util.ArrayList"%> 
<%@ page import="java.util.List"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/ManagerDash.css"/>
<link rel="stylesheet" type="text/css" href="css/New/bootstrap.min.css"/>

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
		<h4>Welcome <%= session.getAttribute("name") %></h4>	
		<h4> Select 2 stocks together (in the select box), pick risk and press submit </h4>
		<br>
		<div class='vertical-align'>
		<form action="ManagerDash" method="post">
        <select class="allstocks" id="allStocks" name="allStocks" multiple="multiple" size="9">
        <% List<Stock> stocks = (ArrayList<Stock>)request.getAttribute("data"); %>
        <% for(Stock s:stocks){ %>
        	<% if (s.getName().equals("risklessStock")) 
        	   continue; %>
        	<% String str = s.getName(); %>
            <option name="1" value = <%= str %>> <%= s.getName()%></option>
        <% } %>
        </select>
        <br>
        <br>
		<h4 style="margin-left:135px;">Choose your risk</h4>
		<div class='btns'>
		<label>
			<input type="radio" name="risk" value="5" required>
				<span class='btn first'>5</span>
		</label>
		<label>
			<input type="radio" name="risk" value="4" required>
				<span class='btn'>4</span>
		</label>
		<label>
			<input type="radio" name="risk" value="3" required>
				<span class='btn'>3</span>
		</label>
		<label>
			<input type="radio" name="risk" value="2" required>
				<span class='btn'>2</span>
		</label>
		<label>
			<input type="radio" name="risk" value="1" required>
				<span class='btn last'>1</span>
		</label>
		</div>
		<br>
		<input style="margin-left:185px;" type="submit" value="Submit">
		</form>
		</div>
		<div class="table100">
			<h4> Manager portfolios </h4>
			<table>
				<thead>
					<tr class="table100-head">
						<th class="column1">ID</th>
						<th class="column2">Stock 1</th>
						<th class="column3">Percentage 1</th>
						<th class="column4">Stock 2</th>
						<th class="column5">Percentage 2</th>
						<th class="column6">Stock 3</th>
						<th class="column7">Percentage 3</th>
						<th class="column8">Sharp</th>
					</tr>
				</thead>
				<tbody>
					 <% List<Portfolio> portfolio = (ArrayList<Portfolio>)request.getAttribute("portfolio");
     						 int j=1;
      					 for(Portfolio p:portfolio){ %>
         					 <tr> 
		            	<td class="column1"> <%=j++%> </td> 
		            	<td class="column2"> <%= p.getStock1() %> </td>
		            	<td class="column3"> <%= p.getPercentage1() %> </td>
		            	<td class="column4"> <%= p.getStock2() %> </td>
		            	<td class="column5"> <%= p.getPercentage2() %> </td>
		            	<td class="column6"> <%= p.getStock3() %> </td>
		            	<td class="column7"> <%= p.getPercentage3() %> </td>
		            	<td class="column8"> <%= p.getSharp() %> </td>
		            </tr>
		        	<% } %>	
				</tbody>
			</table>
		</div>
	</section>
<!-- Hero section end -->
</body>
</html>

