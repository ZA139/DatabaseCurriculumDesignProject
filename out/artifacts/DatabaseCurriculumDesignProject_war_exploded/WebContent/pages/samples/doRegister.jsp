<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.sql.*"%>
<%@ page import="serviceImpl.UserServiceImpl" %>
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
	String email=request.getParameter("email");
	User user=new User();
	user.setUsername(username);
	user.setPassord(password);
	user.setEmail(email);
	UserService us=UserServiceImp();
	us.register(user);
%>
</body>
</html>