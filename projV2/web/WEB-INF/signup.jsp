<!DOCTYPE html>
<html>
<title>Task Manegment Project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<body>
<!-- Header -->
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <div class="w3-center">
  <h1 class="w3-xxxlarge w3-animate-bottom">Sign up</h1>
</header>

<!-- Modal -->
<hr>
<h2 class="w3-xlarge w3-animate-top w3-center">Fill in your details </h2>
</div>

<div style="margin-right:400px; margin-left:400px" class="center">
<form class="w3-container w3-card-2" action=SignupPage method="post" id=login>
  <h2>Sign Up</h2>
  <div class="w3-section">
    <p>
    <label>
    <% if (request.getAttribute("error") != null && (request.getAttribute("error").equals(true))){%>
      <%= new String("this username is taken, please select another")%>
    <%}%>
    </label>
    </p>
    <label>First Name</label>
    <input class="w3-input"  name="first_name" type="text" required>
    <label>Last Name</label>
    <input class="w3-input"  name="last_name" type="text" required>
    <label>Username</label>
    <input class="w3-input"  name="user_name" type="text" required>
    <label>Password</label>
    <input class="w3-input"  name="password" type="password" required>
    <label>Email</label>
    <input class="w3-input"  name="email" type="email" required>
    <label>Admin Privileges</label>
    <input class="w3-input"  name="is_admin" type="checkbox" value="yes">
  </div>
  <div class="w3-section">
    <button class="w3-button w3-theme" type="submit" formmethod="post">Sign Up</button>
  </div>
  </div>
</form>
</div>
<hr>
</body>
</html>
