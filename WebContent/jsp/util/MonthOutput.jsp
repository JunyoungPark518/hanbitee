<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Month" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<%
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String output = new Month().month(Integer.parseInt(year), Integer.parseInt(month));
	%>
	<div>
		<%= year %>년 <%= month %>월은 <%= output %>일까지 입니다.
	</div>	

</body>
</html>