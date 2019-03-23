<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="Model.Stock"%>
<%@ page import="Model.Portfolio"%>  
<%@ page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
<link href="css/InvestorDashError.css" rel="stylesheet" type="text/css"/>
</head>
<body>

Welcome <%= session.getAttribute("name") %> <br>
Your risk is  <%= session.getAttribute("risk") %>

<div class="alert">
<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  There is no portfolios in the choosen risk value in the site
</div>

  <h1> User portfolios </h1><br>
  <h1> Recommended portfolio with best Sharpe value for your risk </h1><br>
        <div>
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>ID</b></th> 
          <th><b>Stock 1</b></th>
          <th><b>Percentage 1</b></th> 
          <th><b>Stock 2</b></th>
          <th><b>Percentage 2</b></th>
          <th><b>Stock 3</b></th>
          <th><b>Percentage 3</b></th> 
          <th><b>Sharp</b></th>
         </tr> 

		</table>
		</div>

        <h1> All portfolios in your risk level </h1><br>
        <div>
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>ID</b></th> 
          <th><b>Stock 1</b></th>
          <th><b>Percentage 1</b></th> 
          <th><b>Stock 2</b></th>
          <th><b>Percentage 2</b></th>
          <th><b>Stock 3</b></th>
          <th><b>Percentage 3</b></th> 
          <th><b>Sharp</b></th>
         </tr> 

        </table>  
        </div>
        <hr/> 
        <h1> View all portfolios in a choosen risk </h1><br>
        <form action="InvestorDash" method="post">
		<div id="risk">
			<input class="risk" type="radio" name="risk" value="1" required> 1
			<input class="risk" type="radio" name="risk" value="2" required> 2
			<input class="risk" type="radio" name="risk" value="3" required> 3
			<input class="risk" type="radio" name="risk" value="4" required> 4
			<input class="risk" type="radio" name="risk" value="5" required> 5
			<br>
			<input type="submit" value="Submit">
		</div>
		</form>
</body>
</html>