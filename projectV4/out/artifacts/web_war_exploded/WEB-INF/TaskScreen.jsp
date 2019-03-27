<%@ page import="Model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<body>
<form class="w3-container w3-card-2">
  <h2>Task View</h2>
  <div class="w3-section">
    <% Task task = (Task)request.getAttribute("task"); %>
    <label>Task Name</label>
    <input class="w3-input" name="taskName" type="text" value="<%=task.getTask()%>" required>
    <select name="priority" required>
      <option value="1" <%if((task.getPriority().getId() == 1)){%> selected <%}%>>Low</option>
      <option value="2" <%if((task.getPriority().getId() == 2)){%> selected <%}%>>Medium</option>
      <option value="3" <%if((task.getPriority().getId() == 3)){%> selected <%}%>>High</option>
    </select>
  </div>
    <select name="user" required>
      <%List<User> users = (List<User>)request.getAttribute("users");%>
      <%for(User u:users){%>
      <option value="<%=u.getId()%>"<%if(task.getUser().getId() == u.getId()){%> selected <%}%>><%=u.getFirstName() + " " + u.getSureName()%></option>
      <%}%>
    </select>
  <div class="w3-section">
    <button class="w3-button w3-theme" type="submit" action="TaskScreen" formmethod="post">Submit</button>
  </div>
</form>
</div>
  </ul>
</body>

</html>
