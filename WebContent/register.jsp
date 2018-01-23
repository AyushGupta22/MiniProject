<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mini Project | Registration</title>
</head>
<body>
	<div class="header"><h1>Mini Project</h1></div>
	<div class="mainBody">
		<div class="login">
			<div class="loginHeader"><h3>Registration</h3></div>
			<div class="loginBody">
				<form action="save">
					<label>UserName : </label>
					<input type="text" name="login.user" pattern="[a-zA-Z0-9]{5,}" title="must be atleast 5 character and only alpha numeric" placeholder="enter user name" required><br><br>
					<label>Email ID : </label>
					<input type="email" name="login.email" placeholder="enter email address" required><br><br>
					<label>Password : </label>
					<input type="password" name="login.password" pattern="[a-zA-Z0-9]{8,40}" title="Must be 8-40 character and only alpha numeric" placeholder="enter password" required><br><br>
					
					<input type="submit" value="Register"><br>
				</form>
			</div>
			<div class="loginFooter"><a href="index.jsp">Login</a></div>
		</div>
	</div>
	<div class="footer"><p>Copyright &copy; Mini Project 2018</p></div>
</body>
</html>