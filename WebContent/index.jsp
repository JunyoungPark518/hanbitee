<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/hanbit.css" />
<meta charset="UTF-8">
<title>한빛 병원</title>
</head>
<body>
	<div id="wrapper" class="width100" style="height: 80px; border-top: 2px solid darkgray;">
		<div id="header" class="wtac" style="height: 100px;">
			<table style="margin: 0 auto; width: 1000px;">
				<tr>
					<td style="width: 230px;"><a href="index.html"><img
							src="images/common/logo.png" alt="병원 로고" width="200px"
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
					<a class="index_gnb_index" href="html/common/intro.html">병원소개</a>
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
					<a class="index_gnb_index" href="html/common/usage.html">이용안내</a>
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
					<a class="index_gnb_index" href="html/common/treat.html">진료안내</a>
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
					<a class="index_gnb_index" href="html/common/info.html">의학정보실</a>
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
					<a class="index_gnb_index" href="html/common/customer.html">고객참여마당</a>
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
		<div id="container" class="width100">
		<!-- 여기까지 코드 복사&붙여넣기 -->
			<div>
				<table style="margin: 0 auto;">
					<tr>
						<td>
							<a class="login_main" href="<%= application.getContextPath() %>/patient.do?action=move&page=registerForm">회원가입</a>&nbsp; 
							<a class="login_main" href="<%= application.getContextPath() %>/patient.do?action=move&page=loginForm">로그인</a>&nbsp; 
							<a class="login_main" href="<%= application.getContextPath() %>/board.do?action=move&page=articleList">게시판으로 이동</a>&nbsp; 
							<a class="login_main" href="<%= application.getContextPath() %>/common.do?action=move&page=findId">ID/PW 찾기</a></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align: right;"><a class="login_main" href="<%= application.getContextPath() %>/admin.do?action=move&page=main">관리자 아이디로 로그인</a></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div style="margin-top: 50px;"></div>
			<div style="width: 100%; margin-bottom: 100px;">
				<table class="index_notice">
					<tr>
						<td style="width: 600px;">
						<div class="wtac">
							<table>
								<tr>
									<td>
									<div>
										<table class="index_nboard">
											<tr style="height: 30px;">
												<th><span>병원뉴스</span></th>
												<th><span>병원신문</span></th>
												<th><span>입찰공고</span></th>
												<th><span>채용공고</span></th>
												<th><span>강좌소식</span></th>
												<th><span>더보기</span></th>
											</tr>
											<tr style="height: 150px;">
												<td colspan="6">
													<a class="login_input text_no_underline" href="html/bbs/bbs_list.html">게시판 페이지로 가기</a>
												</td>
											</tr>
											<tr>
												<td colspan="3" style="margin-right: 5px;"><a href=""><img src="images/common/bbs_btn01.png" alt="" /></a></td>
												<td colspan="3"><a href=""><img src="images/common/bbs_btn02.png" alt="" /></a></td>
											</tr>
											<tr style="margin-top: 5px;">
												<td colspan="6"><a href=""><img src="images/common/bbs_btn03.png" alt="" /></a></td>
											</tr>
										</table>
									</div>
									</td>
								</tr>
							</table>
						</div>
						</td>
						<td>
						<div class="wtac">
							<table class="index_notice">
								<tr>
									<td>
									<div>
										<table class="index_nboard">
											<tr style="height: 20px;">
												<th><span>병원뉴스</span></th>
												<th><span>병원신문</span></th>
												<th><span>입찰공고</span></th>
												<th><span>채용공고</span></th>
												<th><span>강좌소식</span></th>
												<th><span>더보기</span></th>
											</tr>
											<tr>
												<td colspan="6">
												내용물
												</td>
											</tr>
										</table>
									</div>
									</td>
								</tr>
							</table>
						</div>
						</td>
					</tr>
				</table>
			</div>
		<!-- 여기까지 코드 복사&붙여넣기 -->
		</div>
		<div style="height: 200px;"></div>
		<div id="footer" class="width100">
			<table class="policy">
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