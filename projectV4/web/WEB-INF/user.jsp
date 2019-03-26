<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<body>

<div class="w3-card white w3-row-padding w3-container w3-full">
    <div class=" w3-center">
        <h3>your tasks</h3> </div>
<p>
<div class="w3-card white w3-row-padding w3-container ">
    <ul class="w3-ul w3-border-top">
        <table class="w3-table w3-striped w3-bordered scrollWindows ">
            <thead>
            <tr class="w3-theme">
                <th> <div class="w3-left"></div>
                    <h3>name of project</h3></th>
                <th><h3> task</h3></th>
                <th><h3> priority</h3></th>
                <th><h3> done</h3></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=s.getProjectName%></td>
                <td><%=s.getTaskName()%><button class="w3-button w3-white ">task</button></td>
                <td><%=s.getPriority%></td>
                <td><%=s.updateStatus%><button class="w3-button w3-white ">done</button></td>
            </tr>
</table>
</ul>
</p>
</body>
</html>