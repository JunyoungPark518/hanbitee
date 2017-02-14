<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>주민번호 환산</title>
	<link rel="stylesheet" type="text/css" href="../../css/hanbit.css" />
</head>
<body>
	<div style="width:90%; margin-top:100px; text-align:center">
	<form action="SsnOutput.jsp" style="width: 100%" method="post">
	<table style="width: 400px; height:100px; text-align:center;" >
		<tr>
			<td style="width:250px">이름</td>
			<td><input type="text" name="name" size="10"/></td>
		</tr>
		<tr>
			<td style="width: 250px">주민번호(Ex 900101-1)</td>
			<td><input type="text" name="sno" size="10"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT"/></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>