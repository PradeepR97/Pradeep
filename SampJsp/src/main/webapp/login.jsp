<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	if(session.getAttribute("user")!=null){
		%>
			<h1><% 
			Cookie[] every = request.getCookies();
			for(Cookie each:every){
				out.print("welcome"+each.getValue());
			}
			 %></h1>
		<%
	}
	else{
		%>
		<form action="loginCtrl.jsp" method="post">
			UserName<input type="text" name="uname"/>
			Password<input type="password" name="pword"/>
			<input type="submit" value="Login">
		</form>
		<%
	}
%>

	
</body>
</html>