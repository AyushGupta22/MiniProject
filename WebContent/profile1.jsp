<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="S" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:useBean id="obj" class="User"/>   --%>
<%
String s = (String)session.getAttribute("login");
if(s == "true"){
%><br>

<form action="update" >
<input type="number" name="pro.userId" value='<S:property value="#session.id"/>' readonly style="display:none;">
<label>First Name : </label>
<input type="text" name="pro.fname" value='<S:property value="pro.fname"/>' placeholder="Enter First Name here" required/><br><br>
<label>Last Name : </label>
<input type="text" name="pro.lname" value='<S:property value="pro.lname"/>' placeholder="Enter Last Name here" required/><br><br>
<label>Date of Birth : </label>
<input type="date" name="pro.dob" value='<S:property value="pro.dob"/>' placeholder="enter DOB" required/><br><br>
<label>Address : </label>
<input type="text" name="pro.address" value='<S:property value="pro.address"/>' placeholder="enter address here" required/><br><br>
<label>City : </label>
<input type="text" name="pro.city" value='<S:property value="pro.city"/>' pattern="[a-zA-Z]{2,}" title="must be alphabets of atleast length 2" placeholder="Enter City Here" required/><br><br>
<label>State : </label>
<input type="text" name="pro.state" value='<S:property value="pro.state"/>' pattern="[a-zA-Z]{2,}" title="must be alphabets of atleast length 2" placeholder="Enter State here" required/><br><br>
<label>Mobile Number : </label>
<input type="text" name="pro.mobile" pattern="[0-9]{10}" title="must be numbers of length 10" value='<S:property value="pro.mobile"/>'  placeholder="Enter Mobile Number here" required/><br><br>
<label>Gender : </label>
<select name="pro.gender" required>
	<option value="M" selected>Male</option>
	<option value="F" >Female</option>
	<option value="O" >Other</option>
</select><br><br>
<input type="submit" value="save">
</form>
<a href="dashboard.jsp">Go to Dashboard</a>
<a href="logout">Logout</a>
<%}
else{
	out.print("go to login<br>");
	out.print("<a href='index.jsp'>login</a>");
	
}
%>
</body>
</html>