<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div>공고 지원 내역 페이지</div>

<div>
	전체: <span>${totalCount}</span> | 응답대기: <span>${waitingCount}</span> | 연락중: <span>${waitingCount}</span> |
	채용됨: <span>${hiredCount}</span> | 거절됨: <span>${rejectedCount}</span>
</div>

<hr>


<c:choose>
	<c:when test="${empty apclist }">
		<p>지원한 내역이 없습니다.</p>
	</c:when>
	<c:otherwise>






		<c:forEach var="app" items="${ apclist}">


			<div>
				<img src="${cpath}/resources/jobs/${app.j_img}" alt="알바사진"
					width="100px" value="${app.j_img}">


				<div>
					<h3>${app.j_title}</h3>
					<p>${app.j_name}</p>
					<p>지원 일시: ${app.apply_date}</p>
				</div>
			</div>

			<div>

			</div>

			<div>
				<%-- Buttons for different actions --%>
				<button onclick="sendReview('${application.id}')">후기보내기</button>
				<button onclick="startChat('${application.id}')">채팅하기</button>
				<button onclick="('${application.id}')">채팅하기</button>
				
				<button onclick="report('${application.id}')">신고하기</button>

			</div>

			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>




<button onclick="report('${application.id}')">지원하러 가기</button>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
