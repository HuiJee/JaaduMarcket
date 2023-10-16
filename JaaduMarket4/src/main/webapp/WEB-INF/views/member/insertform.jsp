<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/layout/header3.jsp"%>

<script type="text/javascript">
	function clearPhotoInput() {
		const photoInput = document.getElementById("photo-input");
		photoInput.value = null;

	}

	function checkJoin() {
		const addr3_name = document.getElementById("addr3_name").value;

		const namerg = /^[가-힣]+$/;
		const numrg = /^.{4,8}$/;
		const passrg = /^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{6,15}$/;
		const telrg2=/^[0-9]{3,4}$/;
		const telrg3=/^[0-9]{4}$/;
		
		if (addr3_name == "") {
			alert("주소를 입력하세요");
		

		} else if (document.join.m_name.value == "") {
			alert("이름을 입력하십시오!");

		} else if (!namerg.test(document.join.m_name.value)) {
			alert("이름은 한글만 입력 가능합니다!");

		} else if (document.join.m_nickname.value == "") {
			alert("닉네임을 입력하십시오!");

		} else if (!numrg.test(document.join.m_nickname.value)) {
			alert("닉네임은 4글자에서 8글자까지 입력가능합니다!");

		} else if (document.join.m_id.value.trim() == "") {
			alert("아이디를 입력하십시오!");

		} else if (document.join.password.value == "") {
			alert("비밀번호 입력하십시오!");

		} else if (!passrg.test(document.join.password.value)) {
			alert("비밀번호는 6~15글자,대소문 영문자로 이루어져야 합니다.!");

		} else if (document.join.password.value != document.join.repassword.value) {
			alert("비밀번호가 일치하지 않습니다");

		} else if (document.join.email1.value == "") {
			alert("이메일을 입력하십시오!");

		} else if (document.join.email2.value == "") {
			alert("이메일을 입력하십시오!");

		} else if (document.join.m_tel1.value == "") {
			alert("전화번호를 입력하십시오!");

		} else if (document.join.m_tel2.value == "") {
			alert("전화번호를 입력하십시오!");
			
		}else if(!telrg2.test(document.join.m_tel2.value)){
			alert("3글자에서 4글자 이내로 입력하십시오!");

		} else if (document.join.m_tel3.value == "") {
			alert("전화번호를 입력하십시오!");
			
		}else if(!telrg3.test(document.join.m_tel3.value)){	
			alert("4글자로 입력하십시오!");

		} else if (document.join.year.value == "") {
			alert("출생년도를 입력하십시오!");

		} else if (document.join.month.value == "") {
			alert("출생월을 입력하십시오!");

		} else if (document.join.bdate.value == "") {
			alert("출생일을 입력하십시오!");

		} else if (document.join.m_gender.value == "") {
			alert("성별을 입력하십시오!");

		} else {
			document.join.submit();
		}

	}

	function checkId(f) {
		if (f.id.value == "") {
			alert("아이디를 입력하십시오!");
			return;
		}

		var url = "${pageContext.request.contextPath}/member/checkId";
		var param = "m_id=" + encodeURIComponent(f.m_id.value);

		sendRequest(url, param, resultFn, "POST");
	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//도착된 데이터를 읽어오기
			var data = xhr.responseText;
			const join = document.getElementById("join");
			const check = document.getElementById('check');
			const id = document.getElementById('m_id');

			check.innerText = '';

			if (data === '사용 가능한 ID입니다.') {
				check.style.cssText = "color: blue; font-size: 10px;";
				join.disabled = false;
				id.readOnly = true;
			} else {
				check.style.cssText = "color: red; font-size: 10px;";
				join.disabled = true;
			}

			check.innerText = data;
		}
	}
</script>

<div class="used-title">
	<h1>회원가입페이지</h1>
	<hr>
</div>


<div >
	<h3>
		<b>회원 주소 입력</b>
	</h3>
	
	<form action="${cpath}/member/addr3Search" id="addreSearch"
		method="post">

		<c:choose>
			<c:when
				test="${advo.addr1_name != null && advo.addr2_name != null && advo.addr3_name != null}">
				<input type="text" name="addr3_name" size="60px" id="addr3_name"
					value="${advo.addr1_name} ${advo.addr2_name} ${advo.addr3_name}" />
			</c:when>
			<c:otherwise>
				<input type="text" placeholder="동,읍,면으로 검색(ex.서초동)" id="addr3_name"
					name="addr3_name" size="60px" id="addr3_name" value="" />
			</c:otherwise>
		</c:choose>
		<input type="submit" value="검색">
	</form>
</div>



<form action="${cpath}/member/insertCheckPohto" method="post"
	enctype="multipart/form-data" name="join">
	<input type="hidden" name="addr3_name" value="${advo.addr3_name}">
	<!--  <input type="hidden" name="m_img" value="${mvo.m_img}">-->
	<!-- 회원 가입 페이지-->

	<div>
		<label>프로필 이미지</label> <br> <input type="file" name="photo"
			id="photo-input"><br>
		<button type="button" onclick="clearPhotoInput()">삭제</button>


		<label>이름</label> <br> <input type="text" name="m_name"
			placeholder="실명을 입력해주세요" id="m_name" />


	</div>
	<div>
		<label>닉네임</label><br> <input type="text" name="m_nickname"
			style="width: 250px;" id="m_nickname"
			placeholder=" 4글자에서 8글자로 입력해주세요" />
	</div>

	<div>
		<label>아이디</label><br> <input type="text" name="m_id" id="m_id"
			placeholder="아이디를 입력해주세요" /> <input type="button" value="중복체크"
			onclick="checkId(this.form)"><br> <span id="check"></span>
	</div>
	<div>
		<label>비밀번호</label><br> <input type="password" name="password"
			style="width: 300px;" id="password"
			placeholder="영문자 대소문자 6~15글자이내로 입력해주세요" />
	</div>
	<div>
		<label>비밀번호확인</label><br> <input type="password"
			name="repassword" style="width: 300px;" id="repassword"
			placeholder="영문자 대소문자 6~15글자이내로 입력해주세요" />
	</div>
	<div>
		<label>이메일</label><br> <input type="text" name="email1" /> @ <select
			name="email2">
			<option value="">--선택안함--</option>
			<option>naver.com</option>
			<option>google.com</option>
			<option>nate.com</option>
			<option>daum.net</option>
			<option>market.com</option>
		</select>
	</div>
	<div>
		<label>연락처</label><br> <select name="m_tel1">
			<option value="">--선택해주세요--</option>
			<option>010</option>
			<option>011</option>
			<option>016</option>
		</select> - <input type="text" name="m_tel2" /> - <input type="text"
			name="m_tel3" />
	</div>
	<div>
		<label>출생 연도</label><br> <input type="text" name="year" id="year"
			maxlength="4" />
	</div>
	<div>
		<label>출생 월</label><br> <input type="text" name="month"
			id="month" maxlength="2" />
	</div>
	<div>
		<label>출생 일</label><br> <input type="text" name="bdate"
			id="bdate" maxlength="2" />
	</div>
	<div>
		<label>성별</label><br> <select name='m_gender'>
			<option value="">--선택안함--</option>
			<option value="0">여성</option>
			<option value="1">남성</option>
		</select>
	</div>
	<br> <input type="button" id="join" disabled="disabled"
		value="Join" onclick="javascript:checkJoin()"> <input
		type="button" value="Reset" onclick="document.join.reset()">

</form>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>