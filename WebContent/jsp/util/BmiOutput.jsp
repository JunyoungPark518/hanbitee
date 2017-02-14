<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "util.Bmi" %>
<% request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>BMI 측정</title>
	<link rel="stylesheet" type="text/css" href="../../css/hanbit.css" />
</head>
<body>
	<% 
		int age = Integer.parseInt(request.getParameter("age"));
		double kg = Double.parseDouble(request.getParameter("weight"));
		double cm = Double.parseDouble(request.getParameter("height"))/ 100;
		String result[] = new Bmi().getBmi(age, kg, cm);
	%>
	<div style="width:300px; margin-top:50px">
		<table style="margin: 0 auto; text-align:center">
			<tr>
				<td>나이:<%= result[0] %> <br /> 몸무게:<%=request.getParameter("weight")%>
					<br /> 키:<%=request.getParameter("height")%> <br /> <b>당신의
						BMI 지수는 '<%= result[1] %>' 입니다.
				</b>
				</td>
			</tr>
		</table>
		<form action="BmiInput.jsp" style="margin-top:50px; text-align: center">
			<input type="submit" value="뒤로 가기"/>
		</form>
	</div>
	
</body>
</html>