<%@ page import="Model.Project"%>
<%@ page import="Model.User"%>
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

<body>
<p>
<div class="w3-card white w3-row-padding w3-container ">
<ul class="w3-ul w3-border-top">
      <h3>Projects</h3>
    <a class="w3-theme"> <a href="NewProjectName"</a><i class="fa fa-plus"></i></a>  &nbsp
    <table class="w3-table w3-striped w3-bordered scrollWindows "   >
        <th><b>Project Name</b></th>
        <th><b>Priority</b></th>
        <%
            List<Project> projects =
            (ArrayList<Project>)request.getAttribute("projects");
            for(Project p:projects){%>
        <tr>
            <td>
                <a href= <%="ProjectScreen" + "?project=" + p.getId()%> >
                <%=p.getName()%>
                </a>
            </td>
            <td><%=p.getPriority().getName()%></td>
        </tr>
        <%}%>
    </table>

  </tr>
      </tbody>
        </table>
      </div>
    </div>
  </ul>
  </p>


</body>
</html>