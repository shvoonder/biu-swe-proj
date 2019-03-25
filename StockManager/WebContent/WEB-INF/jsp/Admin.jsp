<%@page import="Model.Stock"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Stocks List</title> 
  </head> 
  <body> 
      <h1>Displaying Stocks List</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Stock Name</b></th> 
          <th><b>Stock Risk</b></th> 
          <th><b>Stock Returns</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%List<Stock> stocks =  
            (ArrayList<Stock>)request.getAttribute("data"); 
        for(Stock s:stocks){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getName()%></td> 
                <td><%=s.getRisk()%></td> 
                <td><%=s.getReturns()%></td> 
            </tr> 
            <%}%> 
        </table>  
        <hr/> 

<form action="Admin" method="post">
<h2 align="center">Add stock</h2>

<div id="AddStock">
<p>Stock Name<input type="text" placeholder="name" id="name" name="name" required></p>
<p>January<input type="number" step="0.001" placeholder="1st value" id="january" name="first" required></p>
<p>February<input type="number" step="0.001" placeholder="2nd value" id="February" name="second" required></p>
<p>March<input type="number" step="0.001" placeholder="3rd value" id="March" name="third" required></p>
<p>April<input type="number" step="0.001" placeholder="4th value" id="April" name="fourth" required></p>
<p>May<input type="number" step="0.001" placeholder="5th value" id="May" name="fifth" required></p>
<p>June<input type="number" step="0.001" placeholder="6th value" id="June" name="sixth" required></p>
<p>July<input type="number" step="0.001" placeholder="7th value" id="July" name="seventh" required></p>
<p>August<input type="number" step="0.001" placeholder="8th value" id="August" name="eighth" required></p>
<p>September<input type="number" step="0.001" placeholder="9th value" id="September" name="nineth" required></p>
<p>October<input type="number" step="0.001" placeholder="10th value" id="October" name="tenth" required></p>
<p>November<input type="number" step="0.001" placeholder="11th value" id="November" name="eleventh" required></p>
<p>December<input type="number" step="0.001" placeholder="12th value" id="December" name="twelvth" required></p>

<input type="submit" id="submit" value="Submit">
</div>
</form>
<!-- להוסיף אפשרות לעוד submit -->
</body> 
</html> 