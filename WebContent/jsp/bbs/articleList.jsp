<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.BoardService" %>
<%@ page import="serviceImpl.BoardServiceImpl" %>
<%@ page import="domain.ArticleBean" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/hanbit.css" />
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<%
	BoardService service = BoardServiceImpl.getInstance();
	List<ArticleBean> list = service.list();
	String qs = request.getQueryString();
	String finding = "", keyword = "";
	ArticleBean article = new ArticleBean();
	 if(!qs.equals("")) {
		finding = qs.split("=")[1].split("&")[0];
		keyword = qs.split("=")[2];
		if(finding.equals("title")) {
			article.setTitle(keyword);
		} else if(finding.equals("userid")) {
			article.setId(keyword);
		} else if(finding.equals("content")) {
			article.setContent(keyword);
		} else if(finding.equals("regdate")) {
			article.setRegdate(keyword);
		}
		list = service.findSome(article);
	} 
	
%>
	<div id="wrapper" class="width100" style="height: 80px; border-top: 2px solid darkgray;">
		<div id="header" class="wtac" style="height: 100px;">
			<table style="margin: 0 auto; width: 1000px;">
				<tr>
					<td style="width: 230px;"><a href="../../index.html"><img
							src="../../images/common/logo.png" alt="병원 로고" width="200px"
							height="75px" /></a></td>
					<td class="index_main"><span class="index_mainlogo"><b>한빛병원</b></span></td>
					<td><input class="index_search" type="search" name="search"
						placeholder="검색어를 입력해주세요" /> <a class="index_search_btn1" href="">검색</a>
					</td>
				</tr>
			</table>
			<div class="index_gnbtab">
			<ul class="index_gnb">
				<li>
					<div class="index_gnb_dropdown">
					<a class="index_gnb_index" href="../common/intro.html">병원소개</a>
						<div class="index_gnb_dropdown_content">
						<table class="index_gnb_ddltable">
							<tr><td><a href=""><span class="index_gnb_ddl">병원소개</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">병원소식</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">병원장인사말</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">병원조직</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">웹링크</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">매거진</span></a></td></tr>
						</table>
						</div>
					</div>
				</li>
				<li>
					<div class="index_gnb_dropdown">
					<a class="index_gnb_index" href="../common/usage.html">이용안내</a>
						<div class="index_gnb_dropdown_content">
						<table class="index_gnb_ddltable">
							<tr><td><a href=""><span class="index_gnb_ddl">오시는 길</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">주차/편의시설</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">가정간호</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">문병안내</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">신청/발급안내</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">장례식장</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">FAQ</span></a></td></tr>
						</table>
						</div>
					</div>
				</li>
				<li>
					<div class="index_gnb_dropdown">
					<a class="index_gnb_index" href="../common/treat.html">진료안내</a>
						<div class="index_gnb_dropdown_content">
						<table class="index_gnb_ddltable">
							<tr><td><a href=""><span class="index_gnb_ddl">진료안내</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">입/퇴원안내</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">진료과/의료진</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">인터넷 진료예약</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">응급의료센터</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">건강검진</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">FAQ</span></a></td></tr>
						</table>
						</div>
					</div>
				</li>
				<li>
					<div class="index_gnb_dropdown">
					<a class="index_gnb_index" href="../common/info.html">의학정보실</a>
						<div class="index_gnb_dropdown_content">
						<table class="index_gnb_ddltable">
							<tr><td><a href=""><span class="index_gnb_ddl">자가진단서비스</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">의학백과사전</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">종합질병정보</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">의료기기정보</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">건강FAQ</span></a></td></tr>
						</table>
						</div>
					</div>
				</li>
				<li>
					<div class="index_gnb_dropdown">
					<a class="index_gnb_index" href="../common/customer.html">고객참여마당</a>
						<div class="index_gnb_dropdown_content">
						<table class="index_gnb_ddltable">
							<tr><td><a href=""><span class="index_gnb_ddl">고객의 소리</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">서비스 현장</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">자원봉사센터</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">정보공개제도안내</span></a></td></tr>
							<tr><td><a href=""><span class="index_gnb_ddl">사업실명제</span></a></td></tr>
						</table>
						</div>
					</div>
				</li>
			</ul>
			</div>
		</div>
		<div style="height: 150px;"></div>
		<div id="container">
		<!-- 여기까지 코드 복사&붙여넣기 -->
		<div style="margin-top: 50px;"></div>
		<div>
			<table class="bbs_table">
				<tr>
					<th style="width: 50px;"><span>No</span></th>
					<th style="width: 200px;"><span>제목</span></th>
					<th style="width: 100px;"><span>작성자</span></th>
					<th style="width: 100px;"><span>작성일</span></th>
					<th style="width: 50px;"><span>조회수</span></th>
				</tr>
				<%  
					int rowCount = 5, card = service.count();
					for(int i=0; i<rowCount; i++) { 
					ArticleBean bean = list.get(i);
				%>
				<tr>
					<td><span><%= bean.getSeq() %></span></td>
					<td><span><a href="article.jsp?seq=<%= bean.getSeq() %>"><%= bean.getTitle() %></a></span></td>
					<td><span><%= bean.getId() %></span></td>
					<td><span><%= bean.getRegdate() %></span></td>
					<td><span><%= bean.getReadCount() %></span></td>
				</tr>
				<% } %>
				<tr>
					<td colspan="5"> 
					<% 
					int pageCount = (card%rowCount==0) ? card/rowCount : card/rowCount+1;
					for(int j=0; j<pageCount; j++) { %>
					<span style="font-size: 15px"><a href="articleList.jsp?"><%= j+1 %></a></span>&nbsp;&nbsp;&nbsp;
					<%  } %>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-top:30px; text-align:right">
			<form action="">
				<table style="width:800px; margin: 0 auto">
				<tr>
					<td style="text-align:left; width:100px">
					<a href="articleWrite.jsp"><input type="button" value="글 작성"/>
					</a>
					</td>
					<td style="text-align:right; width:300px">
						<select name="finding">
							<option value="userid">작성자</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="regdate">날짜</option>
						</select>
					<input type="text" name="search"/>
					<input type="submit" value="검색"/>
					</td>
				</tr>
				</table>
			</form>
		</div>
		
		<!-- 내용물 공간 -->
		<!-- 여기까지 코드 복사&붙여넣기 -->
		</div>
		<div style="height: 200px;"></div>
		<div id="footer" class="width100">
			<table class="policy" >
				<tr>
					<td><a href="http://www.navercorp.com/" target="_blank"	id="plc.intronhn">병원소개</a></td>
					<td><a href="http://mktg.naver.com/" id="plc.adinfo">광고</a></td>
					<td><a href="https://submit.naver.com/" id="plc.search">마이비즈니스</a></td>
					<td><a href="https://www.navercorp.com/ko/company/proposalGuide.nhn" target="_blank" id="plc.contact">제휴제안</a></td>
					<td><a href="rules/service.html" id="plc.service">이용약관</a></td>
					<td><a href="rules/privacy.html" id="plc.privacy"><strong>개인정보처리방침</strong></a></td>
					<td><a href="rules/youthpolicy.html" id="plc.youth">청소년보호정책</a></td>
					<td><a href="rules/spamcheck.html" id="plc.policy">한빛병원 정책</a></td>
					<td><a href="https://help.naver.com/" id="plc.helpcenter">한빛병원 고객센터</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>