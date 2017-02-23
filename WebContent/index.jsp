<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="width:100%; text-align: center">
	<img src="${img}/index/loading.gif" alt="" /><br />		
	<a onclick="goMain()">메인 페이지로 이동</a>
</div>
<script>
	function goMain() {
		alert('메인 페이지로 이동합니다.');
		location.href="${context}/home.do?action=move&page=main";
	}
</script>