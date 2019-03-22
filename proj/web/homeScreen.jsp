<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 3/21/2019
  Time: 04:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
    div.scrollWindows {
        background-color: "w3-light-gray";
        width: 700px;
        height: 700px;
        overflow: scroll;
    }
</style>
<style>
    table, th, td {
        border: 0px solid black;
    }
</style>

<body>

<div class="w3-card white w3-row-padding w3-container w3-full">
    <div class=" w3-black w3-center">
        <h3>Project Name</h3>
    </div>
    <div class="w3-light-gray">
        <div id="myBar" class="w3-center w3-padding w3-theme" style="width:5%">danymic percentage</div>
    </div>
</div>

<p>
<div class="w3-card white w3-row-padding w3-container ">
    <ul class="w3-ul w3-border-top">
        <h3>Tasks</h3>
        <table class="w3-table w3-striped w3-bordered scrollWindows ">
            <thead>
            <tr class="w3-theme">
                <th> <div class="w3-left">
                    <a class="w3-button w3-circle  w3-large w3-theme"><i class="fa fa-plus"></i></a> &nbsp
                </div> Name Of Task</th>
                <th>Owner</th>
                <th>priority</th>
                <th>progress</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>&nbsp &nbsp &nbsp &nbsp &nbsp <button class="w3-btn w3-white" onclick="move()">Task</button>
</div></td>
<td>  <div class="w3-dropdown-hover">
    <button class="w3-button w3-white ">owner <i class="fa fa-caret-down"></i></button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
        <a href="#" class="w3-bar-item w3-button">noam</a>
        <a href="#" class="w3-bar-item w3-button">ronen</a>
        <a href="#" class="w3-bar-item w3-button">yarin</a>
    </div></td>
<td>  <div class="w3-dropdown-hover">
    <button class="w3-button w3-white ">priority <i class="fa fa-caret-down"></i></button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
        <a href="#" class="w3-bar-item w3-button">high</a>
        <a href="#" class="w3-bar-item w3-button">medium</a>
        <a href="#" class="w3-bar-item w3-button">low</a>
    </div></td>
<td>progress</td>
</tr>
</tbody>
</table>
</div>
</div>
</ul>
</p>

<div class="w3-container">
    <div class="w3-center">
        <h3>Comments fo all participants</h3>
    </div>
    <p>
    <div class="w3-left">
        <a class="w3-button w3-con w3-large w3-theme"><i class="fa fa-plus"></i></a> &nbsp
    </div></p>
    <div class="w3-row">
        <div class="w3-left">
            <div class="w3-col m2 text-center">
            </div>
            <div class="w3-col m10 w3-container">
                <h4>John <span class="w3-opacity w3-medium">relventTime</span></h4>
                <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
            </div>
        </div>
    </div>
    <br>
</body>
</html>
