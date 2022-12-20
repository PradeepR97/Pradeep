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
			<h1><% out.print("welcome"+session.getAttribute("user")); %></h1>
		<%
	}
	else{
		%>
<h1>Welcome
	<% 	
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		if(uname.equals("admin") && pword.equals("admin"))
		{
			session.setAttribute("user",uname); 
			 out.print(session.getAttribute("user"));
			 
			 Cookie ck=new Cookie("user",uname);//creating cookie object  
			 response.addCookie(ck);
		}
	}
	
	%>
	</h1>
</body>
</html>