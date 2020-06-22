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
	String isBreak=request.getParameter("isBreak");
	String isBorrow=request.getParameter("isBorrow");
	Device device=new Device();
	device.setEqid(number);
	device.setType("type");
	if(isBorrow=="未借出")
		device.setAvailiable(true);
	else
		device.setAvailiable(false);
	if(isBreak=="损坏")
		device.setBreak(true);
	else
		device.setBreak(false);
	DeviceService ds=DeviceServiceImp();
		ds.updateDevice(device);
%>
</body>
</html>