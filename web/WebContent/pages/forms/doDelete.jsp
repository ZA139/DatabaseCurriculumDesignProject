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
	String number=request.getParameter("number");
	DeviceService ds=DeviceServiceImp();
	ds.removeDevice(number);
%>
</body>
</html>