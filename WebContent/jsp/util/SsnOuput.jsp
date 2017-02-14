<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Ssn" %>
<% request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>주민번호 결과</title>
</head>
<body>
<%
	String ssn = new Ssn().ssn(request.getParameter("sno"));
	String name = request.getParameter("name");
%>
	 <b><%= name %> 님은 <%= ssn %> 입니다.</b>
</body>
</html>