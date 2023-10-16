<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div>
	<div class="used-title">
		<h1>마이 알바 페이지</h1>
		<hr>
	</div>

	<div  align="center">
		<table class=s"main">
			<tr>
				<td colspan="2"><img src="${cpath }/resources/member/${vo.m_img}"
					style="width: 200px;" onclick="location.href='${cpath}/jobs/applyform'"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.m_name}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${vo.m_nickname}</td>
			</tr>
			<tr>
				<th>회원번호</th>
				<td>${vo.m_tel1}-${vo.m_tel2}-${vo.m_tel3}</td>
			</tr>
			<tr>
				<th>매너온도</th>
				<td>${degree}&#176;</td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="jobs">
		<input type="button" value="내 지원서 관리 "
			onclick="location.href='${cpath}/jobs/content'"> <input
			type="button" value="공고 관리"
			onclick="location.href='${cpath}/jobs/myjobsform?m_seq=${vo.m_seq}'">
		<input type="button" value="알바지원하기"
			onclick="location.href='${cpath}/jobs/list?m_seq=${vo.m_seq}'">
	</div>

	<div class="extramenu">

		<div class="jobs">
			<input type="button" value="내 지원내역"
				onclick="location.href='${cpath}/jobs/applyList?m_seq=${vo.m_seq }'">
			<c:if test="${vo.m_jobs_status!=1 }">
    <div id="status">
        <label>자두 알바 계정</label><br>
        <span id="m_jobs_status">미등록</span>
        <input type="button" value="등록하기" id="register" onclick="check(this.form)" />
        <input type="hidden" name="m_seq" id="m_seq" value="${vo.m_seq}">
    </div>
</c:if>
<c:if test="${vo.m_jobs_status==1 }">
    <input type="button" value="공고 등록하기" onclick="location.href='${cpath}/jobs/jobInsertform3?m_seq=${vo.m_seq }'">
    <div style="display: none">
        <input type="text" name="m_jobs_status" id="m_jobs_status">
    </div>
</c:if>
			


		</div>
		<hr>
	</div>

	<script type="text/javascript">
	
		function check(form) {
		    var busiNo = prompt("사업자번호를 입력하세요");
		    var busiNumPattern = /^\d{10}$/;
		    var m_seq = document.getElementById("m_seq").value;

		    if (!busiNumPattern.test(busiNo)) {
		        alert("사업자 번호는 10자리 숫자여야 합니다.");
		        return;
		    }

		    var xhr = new XMLHttpRequest();
		    xhr.open("POST", "${pageContext.request.contextPath}/member/checkStatus", true);
		    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		    xhr.onreadystatechange = function() {
		        if (xhr.readyState === 4 && xhr.status === 200) {
		            var data = xhr.responseText;

		            const registerButton = document.getElementById('register');
		            const statusField = document.getElementById('m_jobs_status');

		            statusField.innerText = '';

		            if (data === '등록완료') {
		                registerButton.disabled = true;
		                statusField.innerText = '등록완료'; // 스팬 요소의 텍스트를 변경
		                var jobInsertButton = document.createElement('input');
		                jobInsertButton.setAttribute('type', 'button');
		                jobInsertButton.setAttribute('value', '공고 등록하기');
		                jobInsertButton.setAttribute('onclick', "location.href='${cpath}/jobs/jobInsertform3?m_seq=${vo.m_seq }'");
		                document.getElementById('status').appendChild(jobInsertButton); // "공고 등록하기" 버튼 생성 및 추가
		            }
		        }
		    };

		    var params = "m_seq=" +m_seq; 
		    xhr.send(params);
		}
	</script>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>