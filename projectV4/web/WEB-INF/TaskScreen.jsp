<%@ page import="Model.Task" %>
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
    <label>Project Name</label>
    <input class="w3-input" name="taskName" type="text" value="<%=task.getTask()%>" required>
    <select name="priority" required>
      <%if (task.getPriority().getId() == 1)%>
      <option value="1" <%="selected=selected"%>>
        Low
      </option>
      <%if (task.getPriority().getId() == 2)%>
      <option value="2" <%="selected=selected"%>>
        Medium
      </option>
      <%if (task.getPriority().getId() == 3)%>
      <option value="3" <%="selected=selected"%>>
        High
      </option>
    </select>
  </div>
    <select name="user" required>
      <option value="1">Low</option>

    </select>
  <div class="w3-section">
    <button class="w3-button w3-theme" type="submit" formmethod="post">Create Project</button>
  </div>

</form>
</div>
  </ul>
</body>

</html>
