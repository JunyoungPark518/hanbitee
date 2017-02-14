<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Month</title>
</head>
<body>
	<div style="width:90%; margin-top:100px; text-align:center">
	<form action="MonthOutput.jsp" style="width: 100%" method="post">
	<table style="width: 400px; height:100px; text-align:center;" >
		<tr>
			<td style="width:250px">연도 입력</td>
			<td><input type="text" name="year" size="10"/></td>
		</tr>
		<tr>
			<td style="width: 250px">월 입력</td>
			<td><input type="text" name="month" size="10"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>