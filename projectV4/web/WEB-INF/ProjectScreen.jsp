<%@ page import="Model.User"%>
<%@ page import="Model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
    <h3>Project View</h3>
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
          <a class="w3-button w3-circle  w3-large w3-theme" href="NewTaskScreen"><i class="fa fa-plus"></i></a> &nbsp
        </div> Name Of Task</th>
        <th>Owner</th>
        <th>Priority</th>
        <th>Status</th>
      </tr>
      </thead>
      <tbody>
    <tr>
      </div></td>
<%
  List<Task> tasks =
          (ArrayList<Task>)request.getAttribute("tasks");
  for(Task t:tasks){%>
<tr>
  <td>
    <a href= <%="TaskScreen" + "?task=" + t.getId()%> >
      <%=t.getTask()%>
    </a>
  </td>
  <td>
    <%=t.getUser().getFirstName() + " " + t.getUser().getSureName()%>
  </td>
  <td>
    <%=t.getPriority().getName()%>
  </td>
    <td>
    <%if (t.getStatus() == 1){%>
    <%="Done"%>
    <%}%>
    <%if (t.getStatus() == 0){%>
    <%="Active"%>
    <%}%>
    </td>
</tr>
<%}%>
  </tr>
      </tbody>
        </table>
      </div>
    </div>
  </ul>
  </p>
</body>
</html>
