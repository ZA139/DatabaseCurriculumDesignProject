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
	String username=request.getParameter("number");
	String password=request.getParameter("type");
	Device device=new Device();
	device.setEqid(number);
	device.setType("type");
	device.setAvailiable(true);
	device.setBreak(false);
	DeviceService ds=DeviceServiceImp();
	ds.addDevice(device);
%>
</body>
</html>