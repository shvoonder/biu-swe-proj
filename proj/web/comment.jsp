<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 3/21/2019
  Time: 04:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method='post'>
    NAME:<br/>
    <input type='text' name='name' id='name' /><br />

    Comment: </br>
    <textarea name='comment' id='comment'></textarea><br />

    <input type='hidden' name='articleid' id='articleid' value='<? echo $_GET["id"]; ?>' />

    <input type='submit' value='Submit' />
</form>
