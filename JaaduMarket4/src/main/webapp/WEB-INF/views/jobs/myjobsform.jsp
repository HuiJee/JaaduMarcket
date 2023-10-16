<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>


<h2>공고관리게시물</h2>

<c:forEach var="mjvo" items="${mjlist}">
	<div >
		<div >
			<img src="${cpath}/resources/jobs/${mjvo.j_img}" style="width: 250px;"
				name="j_img" value="${mjvo.j_img}"><br>
		</div>
		<div>
			
				<h3 ><a href="${cpath}/jobs/jobsContent?j_seq=${mjvo.j_seq}&m_seq=${mjvo.m_seq}">${mjvo.j_title}</a></h3>
			
			
			<p >${mjvo.addr1_name}${mjvo.addr2_name}
				${mjvo.addr3_name}</p>
			<div class="job-pay">
				<p class="job-pay">
					시급: <span class="hourly-pay">${mjvo.j_pay}</span>원
				</p>
			</div>

			<p>${mjvo.j_start }~${mjvo.j_finish }</p>
		</div>
	</div>
	
	${appCount }
	<div style="display: inline-block;" >	
	<input type="button" value="지원내역 &nbsp;${appCount}"onclick="location.href='${cpath}/jobs/applicants?j_seq=${mjvo.j_seq }'">
	<input type="button" value="수정하기" onclick="location.href='${cpath}/jobs/jobUpdateForm?j_seq=${mjvo.j_seq }'">
	<input type="button" name="j_done" value="삭제하기"onclick="location.href='${cpath}/jobs/jobDelete?j_seq=${mjvo.j_seq }'">
	<input type="button" name="j_done" value="구인완료"onclick="location.href='${cpath}/jobs/doneJob?j_seq=${mjvo.j_seq }'">
	</div>
</c:forEach>
<c:if test="${mvo.m_jobs_status==1 }">
<input type="button" name="j_done" value="공고등록"onclick="location.href='${cpath}/jobs/jobInsertform3?m_seq=${m_seq}'">
</c:if>
<c:if test="${mvo.m_jobs_status==0 }">
<input type="button" name="j_done" value="공고등록"onclick="location.href='${cpath}/jobs/mypage?m_seq=${m_seq}'">
</c:if>

<script type="text/javascript">
    const hourlyPayElements = document.querySelectorAll(".hourly-pay"); //class이름이 hourly-pay모든 요소 선택
    hourlyPayElements.forEach(element => {  //for문으로 현재요소는 element로 표현
        const j_pay = element.textContent; //요소의 텍스트
        const formatted_jpay = new Intl.NumberFormat().format(Number(j_pay)); // Intl.NumberFormat().format() 함수는 자동으로 숫자에 천 단위 구분 기호(일반적으로 쉼표)를 추가
        element.textContent = formatted_jpay;
    });
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>