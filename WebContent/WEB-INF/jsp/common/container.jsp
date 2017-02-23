<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="container" class="con_setting" style="position: relative; top:200px">
		<!-- 여기까지 코드 복사&붙여넣기 -->
			<div>
				<table style="margin: 0 auto;">
					<tr>
						<td>
							<a class="login_main" href="${context}/patient.do?action=move&page=register">고객 회원가입</a>&nbsp; 
							<a class="login_main" href="${context}/patient.do?action=move&page=loginForm">고객:로그인</a>&nbsp; 
							<a class="login_main" href="${context}/patient.do?action=move&page=loginForm">스탭:로그인</a>&nbsp; 
							<a class="login_main" href="${context}/admin.do?action=move&page=main">관리자 아이디로 로그인</a>
							<a class="login_main" href="${context}/board.do?action=move&page=articleList">게시판으로 이동</a>&nbsp; 
							<a class="login_main" href="${context}/util.do?action=move&page=findId">ID/PW 찾기</a>
						</td>
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
												<td colspan="3" style="margin-right: 5px;"><a href=""><img src="${img}/common/bbs_btn01.png" alt="" /></a></td>
												<td colspan="3"><a href=""><img src="${img}/common/bbs_btn02.png" alt="" /></a></td>
											</tr>
											<tr style="margin-top: 5px;">
												<td colspan="6"><a href=""><img src="${img}/common/bbs_btn03.png" alt="" /></a></td>
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