<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.sql.*"%>
<%@ page import="serviceImpl.UserServiceImpl.*,serviceImpl.UserService.*,entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String[] temp=request.getParameterValues("type");
	Boolean type=false;
	if(type!=null)
		type=true;
	UserService us=UserServiceImpl();
	User user=us.login(username,password,type);
	if(user==null){
		response.sendRedirect("login-2.html");
	}else{
		if(user.getType()==true){
			request.setAttribute("user",user);
			request.getRequestDispatcher("../../index.html");
		}else{
			request.setAttribute("user",user);
			request.getRequestDispatcher("../../index2.html");			
		}
	}
%>
</body>
</html>