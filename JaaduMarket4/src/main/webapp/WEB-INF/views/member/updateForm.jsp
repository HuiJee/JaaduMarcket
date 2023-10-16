<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<script type="text/javascript">
function clearPhotoInput() {
	photoInput = document.getElementById("photo-input");
	photoInput.value = null;
}

function checkUpdate() {

	const namerg = /^[가-힣]+$/;
	const numrg = /^.{4,8}$/;
	const passrg = /^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{6,15}$/;
	

	 if (document.update.m_name.value == "") {
		alert("이름을 입력하십시오!");

	} else if (!namerg.test(document.update.m_name.value)) {
		alert("이름은 한글만 입력 가능합니다!");

	} else if (document.update.m_id.value.trim() == "") {
		alert("아이디를 입력하십시오!");

	} else if (document.update.password.value == "") {
		alert("비밀번호 입력하십시오!");

	} else if (!passrg.test(document.update.password.value)) {
		alert("비밀번호는 6~15글자,대소문 영문자로 이루어져야 합니다.!");

	} else if (document.update.email1.value == "") {
		alert("이메일을 입력하십시오!");

	} else if (document.update.email2.value == "") {
		alert("이메일을 입력하십시오!");

	} else if (document.update.m_tel1.value == "") {
		alert("전화번호를 입력하십시오!");

	} else if (document.update.m_tel2.value == "") {
		alert("전화번호를 입력하십시오!");

	} else if (document.update.m_tel3.value == "") {
		alert("전화번호를 입력하십시오!");


	} else if (document.update.m_gender.value == "") {
		alert("성별을 입력하십시오!");

	} else {
		document.update.submit();
	}
}
	 function checkId(f) {


			var url = "${pageContext.request.contextPath}/member/checkId";
			var param = "m_id=" + encodeURIComponent(f.m_id.value);

			sendRequest(url, param, resultFn, "POST");
		}

		function resultFn() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				//도착된 데이터를 읽어오기
				var data = xhr.responseText;
				const update = document.getElementById("update");
				const check = document.getElementById('check');
				const id = document.getElementById('m_id');

				check.innerText = '';

				if (data === '사용 가능한 ID입니다.') {
					check.style.cssText = "color: blue; font-size: 10px;";
					update.disabled = false;
					id.readOnly = true;
				} else {
					check.style.cssText = "color: red; font-size: 10px;";
					update.disabled = true;
				}

				check.innerText = data;
			}
		}


</script>
<h2>회원 정보 수정</h2>
<!-- 회원 정보 입력 -->

<form action="${cpath}/member/updateCheck?m_seq=${mvo.m_seq}" method="post" enctype="multipart/form-data" name="update">
	<input type="hidden" name="m_img" value="${mvo.m_img}">
	
	<label>프로필 이미지</label><br>
	 <img src="${cpath}/resources/member/${mvo.m_img}" style="width: 150px;" name="m_img1" value="${mvo.m_img}"><br>
	<div class="photo-Input">
	<input type="file" name="photo" id="photo-input" value="프로필 사진 변경"/><br>
	<button type="button" onclick="clearPhotoInput()">삭제</button>
	</div>
	<label>이름</label>
	<input type="text" name="m_name" value="${mvo.m_name}" id="m_name" />
	<br> <label>아이디</label><br> <input type="text" name="m_id"
		value="${mvo.m_id}" id="m_id" />
	<input type="button" value="중복체크" onclick="checkId(this.form)"><br> 
				<span id="check"></span>


<br> <label>비밀번호</label><br>
	<input type="password" name="password" id="password"
		value="${mvo.password}" /> <br> <label>이메일</label><br> <input
		type="text" value="${mvo.email1}" name="email1" /> <select
		name="email2">
		<option value="${mvo.email2}">${mvo.email2}</option>
		<option>@naver.com</option>
		<option>@google.com</option>
		<option>@nate.com</option>
		<option>@daum.net</option>
		<option>@market.com</option>
		<br>
	</select><br> 
	<label>연락처</label><br> <select name="m_tel1">
		<option value="${mvo.m_tel1}">${mvo.m_tel1}</option>
		<option>011</option>
		<option>016</option>
	</select> -<input type="text" name="m_tel2" value="${mvo.m_tel2}">-<input
		type="text" value="${mvo.m_tel3}" name="m_tel3"> <br> 
		<label>성별</label><br>
	<select name="m_gender">
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
				<option value="">--선택하세요--</option>
				<option value="0">여성</option>
				<option value="1">남성</option>
			</c:otherwise>
		</c:choose>


	</select> <br>
	<p>
	<input type="button" id="update" 
		value="update" onclick="javascript:checkUpdate()"> 
		<input
		type="button" value="Reset" onclick="document.update.reset()">


</form>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>