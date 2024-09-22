<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form id="loginForm" action="Login" method="post">
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
            <p>Don't have an account? <a href="signup.html">Sign up</a></p>
        </form>
        
        <%
        	String status = request.getParameter("status");
            if("userNotExist".equals(status)){    		
        %>
        	<script>
        		alert("User not registered.");
        	</script>
        	
        <%
            } else if("incorrectCredential".equals(status)){
        
        %>
        	<script>
        		alert("incorrect username/password.")
        	</script>
        <%
            }
        %>
        
    </div>

    <script src="app.js">
    
    </script>
</body>
</html>
