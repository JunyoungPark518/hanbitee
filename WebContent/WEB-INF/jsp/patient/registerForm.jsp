<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/hanbit.css" />
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<div id="wrapper" class="width100" style="height: 80px; border-top: 2px solid darkgray;">
		<div id="header" class="wtac" style="height: 100px;">
			<table style="margin: 0 auto; width: 1000px;">
				<tr>
					<td style="width: 230px;"><a href="../../index.html"><img
							src="<%= application.getContextPath() %>/images/common/logo.png" alt="병원 로고" width="200px"
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
		<!-- start to here -->
		<div style="width: 100%;">
		<table class="reg_intro">
			<tr>
				<th colspan="2"><span class="reg_introtext">회원 가입</span></th>
			</tr>
			<tr>
				<td class="reg_active"><span>STEP 01</span><br/><b style="font-size: 16px;">약관 / 정보입력</b></td>
				<td class="reg_inactive"><span>STEP 02</span><br/><b style="font-size: 16px;">가입완료</b></td>
			</tr>
		</table>
		<div style="margin-top: 20px;"></div>
		<table class="reg_table">
			<tr>
				<td colspan="2"><input type="text" name="username" size="50" placeholder="이름" style="border: none;" /> 
				<br/><span class="reg_span">한글 또는 영문으로 입력해주세요.</span>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="email" name="email" size="50" placeholder="E-mail" style="border: none;" /> 
				<input class="reg_dupcheck" type="submit" value="중복확인" /><br/>
					<span class="reg_span">자주 사용하시는 이메일주소로 입력해주세요.</span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="password" name="password" size="50" placeholder="비밀번호" style="border: none;" /> 
				<br/><span class="reg_span">8~15자의 영문자, 숫자, 특수문자를 함께 입력해주세요.</span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="password" name="repassword" size="50" placeholder="비밀번호 확인" style="border: none;" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="f_birth">
						<select name="birthy" style="width: 150px">
							<option value="year">생년</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
							<option value="2015">2015</option>
							<option value="2014">2014</option>
							<option value="2013">2013</option>
							<option value="2012">2012</option>
							<option value="2011">2011</option>
							<option value="2010">2010</option>
							<option value="2009">2009</option>
							<option value="2008">2008</option>
							<option value="2007">2007</option>
							<option value="2006">2006</option>
						</select> <select name="birthm" style="width: 150px">
							<option value="month">월</option>
							<option value="jan">1월</option>
							<option value="feb">2월</option>
							<option value="mar">3월</option>
							<option value="apr">4월</option>
							<option value="may">5월</option>
							<option value="jun">6월</option>
							<option value="jul">7월</option>
							<option value="aug">8월</option>
							<option value="sep">9월</option>
							<option value="oct">10월</option>
							<option value="nov">11월</option>
							<option value="dec">12월</option>
						</select> <select name="birthd" style="width: 150px">
							<option value="day">일</option>
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
							<option value="8">8일</option>
							<option value="9">9일</option>
							<option value="10">10일</option>
							<option value="11">11일</option>
							<option value="12">12일</option>
							<option value="13">13일</option>
							<option value="14">14일</option>
							<option value="15">15일</option>
							<option value="16">16일</option>
							<option value="17">17일</option>
							<option value="18">18일</option>
							<option value="19">19일</option>
							<option value="20">20일</option>
							<option value="21">21일</option>
							<option value="22">22일</option>
							<option value="23">23일</option>
							<option value="24">24일</option>
							<option value="25">25일</option>
							<option value="26">26일</option>
							<option value="27">27일</option>
							<option value="28">28일</option>
							<option value="29">29일</option>
							<option value="30">30일</option>
							<option value="31">31일</option>
						</select>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="f_phone">
						<select name="telecom" style="width: 150px">
							<option value="skt">SKT</option>
							<option value="kt">KT</option>
							<option value="lg">LG</option>
						</select> <select name="phone_1" style="width: 80px">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select> - <input type="text" name="phone_2" style="width: 80px">
						- <input type="text" name="phone_3" style="width: 80px">
					</form>
				</td>
			</tr>
		</table>
		<table class="reg_table">
			<tr style="font-size: 12px;">
				<td class="reg_borderNoneWidth120"><b>정보수신 동의</b></td>
				<td style="text-align: right; border: none;"><b>전체선택</b> <input
					type="checkbox" name="selectall" value="All" /></td>
			</tr>
			<tr style="font-size: 12px;">
				<td class="reg_borderNoneWidth120"><b>L.POINT</b></td>
				<td style="border: none;"><input type="checkbox" name="email"
					value="Email" />E-Mail <input type="checkbox" name="sms"
					value="SMS" />SMS
			</tr>
			<tr style="font-size: 12px;">
				<td class="reg_borderR"><b>롯데시네마</b></td>
				<td style="border: none;"><input type="checkbox" name="email"
					value="Email" />E-Mail <input type="checkbox" name="sms"
					value="SMS" />SMS</td>
			</tr>
			<tr>
				<td colspan="2" class="reg_borderNone"><span class="reg_span2">*
						정보수신동의를 하시면, 고객혜택 및 이벤트 등 다양한 정보를 받으실 수 있습니다</span></td>
			</tr>
		</table>
		<table class="reg_table">
			<tr style="font-size: 12px;">
				<td width="100px" class="reg_borderR"><b>개인정보<br />유효기간
				</b></td>
				<td class="reg_borderNone"><input type="radio" name="personalLimit"
					value="signout">탈퇴 시 파기 <input type="radio"
					name="personalLimit" value="year" />1년
			</tr>
			<tr>
				<td colspan="2" class="reg_borderNone"><span class="reg_span2">*
						개인정보 유효기간 경과 이후 개인정보를 분리 저장관리 또는 파기합니다.</span></td>
			</tr>
		</table>
		<table class="reg_table">
			<tr>
				<td colspan="2" class="reg_borderNone"><span class="reg_span"><b>* 선택항목에
							동의하지 않으셔도 정상적인 서비스를 이용하실 수 있습니다.</b></span></td>
			</tr>
			<tr style="text-align: center; height: 100px;">
				<td colspan="2" class="reg_borderNone"><a href="<%= application.getContextPath() %>/index.jsp"><input type="button" value="이전" class="reg_btnBack" ></a> 
				&nbsp;&nbsp; <a href="registerSuccessForm.jsp"><input type="button" value="다음" class="reg_btnCont"></a></td>
			</tr>
		</table>
		<div style="height: 200px;"></div>
	</div>
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