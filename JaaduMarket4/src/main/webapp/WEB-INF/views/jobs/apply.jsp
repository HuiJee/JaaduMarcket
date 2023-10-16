<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>

<script type="text/javascript">
function checkSubmit() {
    var myInfo = document.apply.my_info.value;
    
    if (myInfo.trim() === '') {
        alert("나의 정보를 입력해주세요!");
        return false; // 작성 완료 동작 중지
    }
    
    // 추가적인 유효성 검사 또는 작성 완료 동작 수행
    
    // 유효성 검사 통과 시
    document.apply.submit(); // 작성 완료 동작 수행
}

</script>

<div>지원서 작성 페이지</div>
<hr>
<!-- 지원서 작성 페이지 -->
<div>
<div class="container">
	<h2>지원서 작성 페이지</h2>
	<form action="${cpath}/jobs/applycheck" method="post" name="apply">
		<!-- 기본 정보 입력 -->
		
		<h3>기본 정보</h3>
		
		<label for="name">사진(선택)</label><br>
		<img src="${cpath }/resources/member/${mvo.m_img}" style="width:100px; ">
		</div>
		
		
		<div class="info-row">
		
			<label for="name">이름(선택)</label><br> <input type="text"
				name="m_name" id="name" 
				value="${mvo.m_name}" readonly="readonly"/>
		</div>
		<div class="info-row">
			<label for="contact">연락처</label><br> <select name="m_tel1" disabled>
				<option value="${mvo.m_tel1}" name="m_tel1">${mvo.m_tel1}</option>
				<option>011</option>
				<option>016</option>
			</select> -<input type="text" value="${mvo.m_tel2}" name="m_tel2" readonly="readonly">-<input
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
			<label for="gender">성별</label><br> <select name="m_gender"disabled>
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
			<label for="year">태어난 연도</label><br> <input
				type="text" name="year" id="year" maxlength="4" value="${mvo.year}" readonly="readonly" />
		</div>
		<p>
		<div>
		<c:choose>
		<c:when test="${empty avo }">
			<input type="button" value="회원정보수정" onclick="location.href='${cpath}/member/updateForm'"/>
		</c:when>
		</c:choose>
		
		</div>
		<h3>경력</h3>
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
					<c:if test="${empty avo }">
						<input type="button" value="수정하기"
							onclick="location.href='${cpath}/jobs/careerUpdateForm?experience_seq=${exp.experience_seq }'" />
						<input type="button" value="삭제하기"
							onclick="location.href='${cpath}/jobs/careeDelete?experience_seq=${exp.experience_seq }'" />
					</c:if>
					<br>
					------------------------
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<!-- 경력 등록 버튼 -->
		<div class="info-row">
			<c:choose>
				<c:when test="${empty avo }">
					<input type="button"
						onclick="location.href='${cpath}/jobs/careerform?m_seq=${mvo.m_seq}'"
						value="경력등록">

				</c:when>
			</c:choose>
		</div>

		<!-- 자기소개 입력 -->
		<h3>자기소개</h3>
		<textarea name="my_info" id="my_info" rows="8" cols="50">${avo.my_info}</textarea>

		<div>
			<p>
				<c:choose>
					<c:when test="${empty avo }">
						<input type="button" value="작성 완료 "  onclick="checkSubmit();"/>
					</c:when>
				</c:choose>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
