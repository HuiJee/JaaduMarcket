<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>
progress {
	-webkit-appearance: none;
}

::-webkit-progress-bar {
	background-color: lightgrey;
}

::-webkit-progress-value {
	background-color: red;
}

.profile table th img {
	border-color: 5px solid lightgray;
	width: 100%;
	height: 100%;
	border-radius: 100px;
}

.profile table, .profile td, .profile th {
	border-color: white;
	margin: 20px;
}

table, td, th {
	margin-top: 20px;
}

.button {
	display: flex;
	flex-direction: row;
	height: 20px;
}

.nick-id {
	display: flex;
	align-items: center;
}

.pay {
	width: 900px;
	height: 50px;
	display: flex;
	align-items: center;
	justify-content: flex-start;
	margin-top: 30px;
}

span h3 {
	width: 900px;
	display: flex;
	align-self: flex-start;
	justify-content: flex-start;
	margin-top: 30px;
}

.detail, .else, .login-status, .my-block {
	margin-top: 30px;
	width: 900px;
}

.login-status {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
}

#blockButton {
	width: 400px;
}

.block img {
	width: 50px;
	height: 50px;
}
</style>

<script type="text/javascript">
	function notReady() {
		alert("현재 준비중인 페이지입니다. \r\n\r\n빠른 시일 내에 선보이겠습니다!");
	}

	function myBlock() {
		var block = document.getElementById("blockList");
		var button = document.getElementById("blockButton");
		if (block.style.display === "none") {
			block.style.display = "block";
			button.style.fontWeight = "bold";
		} else {
			block.style.display = "none";
			button.style.fontWeight = "normal";
		}
	}
</script>

<div class="used-title">
	<h1>마이 페이지</h1>
	<hr>
</div>

<div class="profile">
	<table width="900px" height="100px" padding="10px">
		<tr>
			<th rowspan="2" width="100px">
				<c:if test="${vo.m_img==null }">
					<img src="${cpath }/resources/member/no-image.png">
				</c:if> 
				<c:if test="${vo.m_img != null }">
					<img src="${cpath }/resources/member/${vo.m_img }">
				</c:if>
			</th>
			<th class="nick-id" align="left" width="600px">&nbsp;&nbsp;
				<h3>${vo.m_nickname }</h3>#${vo.m_id }
			</th>
			<td align="right">${vo.manners_degree_sum }&#8451;</td>
		</tr>
		<tr>
			<td>${vo.email1 }@ ${vo.email2 }</td>
			<td align="right">
				<progress id="progress" value="${vo.manners_degree_sum }" min="0" max="100"></progress>
			</td>
		</tr>
	</table>
	<hr>
</div>

<span><h3>---자두 페이 관리---</h3></span>
<div class="pay">
	<c:if test="${vo.m_pay_status == 0 }">
		<input type="button" value="자두페이 등록하기" onclick="window.open('${cpath }/pay/identity/insert','자두페이 등록하기',
		'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
	</c:if>
	
	<c:if test="${vo.m_pay_status == 1 }">
		자두페이 잔여금액 <b><fmt:formatNumber value="${vo.bank_point}" pattern="#,##0" />원</b>
		<input type="button" value="충전하기" onclick="window.open('${cpath}/pay/chargeform','충전 하기',
		'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
		<input type="button" value="계좌 변경" onclick="window.open('${cpath}/pay/identity/update','계좌 변경',
		'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
	</c:if>
</div>

<div class="detail">
	<hr>
	<br>
	<h3>나의 거래</h3>
	<table border=1 height="100px" width="100%">
		<tr>
			<th><a href="${cpath }/member/fav">♡ 관심목록</a></th>
			<th><a href="${cpath }/member/sell">▷ 판매내역</a></th>
			<th><a href="${cpath }/member/buy">◁ 구매내역</a></th>
			<th><a href="${cpath }/member/collection">▣ 모아보기</a></th>
		</tr>
	</table>
</div>
<div class="else">
	<h3>기타 메뉴</h3>
	<table border=1 height="100px" width="100%">
		<tr>
			<th><a href="${cpath }/makeBusi/myBusiList">나의 자두 비즈</a></th>
			<th><a href="${cpath}/jobs/mypage">나의 자두 알바</a></th>
			<th><input type="button" value="받은 매너평가" onclick="window.open('${cpath}/manners/mymanner','나의 매너평가',
			'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')"></th>
			<th><input type="button" value="나의 채팅" onclick="window.open('${cpath}/chatList','채팅하기',
			'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')"></th>
		</tr>
	</table>
</div>
<hr>

<div class="my-block">
	<input type="button" onclick="myBlock()" id="blockButton" value="※내가 차단한 사용자 차단해제하고 싶어요!(클릭)">
	<div id="blockList" style="display: none;">
		<c:if test="${list == null }"> => 아직 차단한 내역이 없어요.</c:if>
		<c:forEach var="bvo" items="${list }">
			<a href="${cpath }/seller/page?seller=${bvo.m_seq}">
				<div class="block">
					<c:if test="${bvo.m_img == null }">
						<img src="${cpath}/resources/member/no-image.png">
					</c:if>
					<c:if test="${bvo.m_img != null }">
						<img src="${cpath}/resources/member/${bvo.m_img }">
					</c:if>
					(${bvo.m_nickname })
				</div
			></a>
		</c:forEach>
	</div>
</div>

<div class="login-status">
	<input type="button" value="회원 정보 수정" onclick="location.href='${cpath}/member/updateForm'"> 
	<input type="button" value="회원 탈퇴하기" onclick="location.href='${cpath}/member/deleteform'">
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
