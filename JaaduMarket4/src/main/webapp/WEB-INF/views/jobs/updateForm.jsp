<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div>
	알바 프로필 수정 페이지
	<hr>
	
	<div class="container">
	
		<form action="${cpath}/jobs/update" method="post">
			<!-- 기본 정보 입력 -->
			<h3>기본 정보</h3>
			<div class="info-row">
				<label for="name">이름(선택)</label><br> <input type="text"
					name="m_name" id="name" 
					value="${mvo.m_name}" readonly="readonly" />
			</div>
			<div class="info-row">
				<label for="contact">연락처</label><br> <select name="m_tel1" disabled>
					<option value="${mvo.m_tel1}">${mvo.m_tel1}</option>
					<option>011</option>
					<option>016</option>
				</select> -<input type="text" name="m_tel2" value="${mvo.m_tel2}" readonly="readonly">-<input
					type="text" value="${mvo.m_tel3}" name="m_tel3" readonly="readonly">
			</div>
			<div class="info-row">
				<label for="contact">이메일</label><br> <input type="text"
					value="${mvo.email1}" name="email1" readonly="readonly"> <select name="email2" disabled>
					<option value="${mvo.email2}">${mvo.email2}</option>
					<option>@naver.com</option>
					<option>@google.com</option>
					<option>@nate.com</option>
					<option>@daum.net</option>
					<option>@market.com</option>
				</select>
			</div>
			<div class="info-row">
				<label for="gender">성별</label><br> <select name="m_gender" disabled>
					<c:choose>
						<c:when test="${mvo.m_gender==0}">
							<option value="0" selected>여성</option>
							<option value="1">남성</option>
						</c:when>
						<c:when test="${mvo.m_gender==1}">
							<option value="0">여성</option>
							<option value="1" selected>남성</option>
						</c:when>
						<c:otherwise>
							<option value="0">여성</option>
							<option value="1">남성</option>
						</c:otherwise>
					</c:choose>


				</select>
			</div>
			<div class="info-row">
				<label for="year">태어난 연도(4자리만 입력 가능하게)</label><br> <input
					type="text" name="year" id="year" maxlength="4" value="${mvo.year}" readonly="readonly" />
			</div>
			
			<br>
			<input type="button" value="회원정보수정" onclick="location.href='${cpath}/member/updateForm'"/>
			<h3>경험</h3>
			<c:choose>
				<c:when test="${empty elist}">
					<p>등록된 경험이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<c:forEach items="${elist}" var="exp">
						<p>${exp.j_place}</p>
						<p>${exp.j_details}</p>
						<p>${exp.j_year}</p>
						<p>${exp.j_period}</p>
						<input type="button" value="수정하기"
							onclick="location.href='${cpath}/jobs/careerUpdateForm?experience_seq=${exp.experience_seq}'" />
						<input type="button" value="삭제하기"
							onclick="location.href='${cpath}/jobs/careeDelete?experience_seq=${exp.experience_seq}'" />
						<br>
					------------------------
				</c:forEach>
				</c:otherwise>
			</c:choose>

			<!-- 경력 등록 버튼 -->
			<div class="info-row">
				<a href="${cpath}/jobs/careerform?m_seq=${mvo.m_seq}" class="btn">경력
					등록</a>
			</div>

			<!-- 자기소개 입력 -->
			<h3>자기소개</h3>
			<textarea name="my_info" rows="8" cols="50">${avo.my_info}</textarea>
			<br>
			<p>
				<input type="submit" value="수정 완료">
		</form>

	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>