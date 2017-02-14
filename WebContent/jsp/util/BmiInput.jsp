<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>BMI 측정</title>
	<link rel="stylesheet" type="text/css" href="../../css/hanbit.css" />
</head>
<body>
	<div style="width:90%; margin-top:100px; text-align:center">
	<form action="BmiOutput.jsp" style="width: 100%" method="post">
	<table style="width: 300px; height:100px; text-align:left;" >
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" size="10"/></td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight" size="20"/></td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height" size="20"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>