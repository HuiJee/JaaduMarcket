
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manners</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/buttonInput.css">

<style>
.bad-title, .good-title {
	font-size: 20px;
	font-weight: bold;
}

.bad-title img, .good-title img {
	margin-right: 10px;
	width: 50px;
	height: 50px;
}

.notice {
	padding: 20px;
	font-size: 17px;
	border-radius: 20px;
	width: 60%;
	background-color: lightgray;
}

.bad, .good {
	font-size: 18px;
	padding: 10px;
}

.bad img, .good img {
	width: 50px;
	height: 50px;
}

.item-container {
	width: 500px;
	display: flex;
}

.count {
	margin-right: 10px;
}

.item-details {
	display: flex;
	align-items: center;
}

.manners-key {
	margin-right: 10px;
}

.cnt {
	margin-right: 10px;
}
</style>

<c:set var="cpath" value="${pageContext.request.contextPath }" />
</head>
<body>
	<div class="used-title">
		<h2>매너 상세</h2>
		<hr>
	</div>
	
	<div class="good-title">
		<img src="${cpath }/resources/images/manners/smile.png">받은 매너 칭찬
	</div>
	
	<div class="good">
		<c:if test="${good !=null}">
			<c:forEach var="gvo" items="${good }" varStatus="i">
				<div class="item-container">
					<div class="count">${i.count}.</div>
					<div class="item-details">
						<div class="manners-key">${gvo.manners_key}</div>
						<img src="${cpath}/resources/images/manners/mannerPerson.png">
						<div class="cnt">${gvo.cnt}</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${good==null }">
			<h5>아직 받은 매너 칭찬이 없습니다.</h5>
		</c:if>
	</div>

	<c:if test="${login==m_seq}">
		<div class="bad-title">
			<img src="${cpath }/resources/images/manners/bad.png">받은 비매너 평가
		</div>
		<div class="bad">
			<c:if test="${bad != null }">
				<c:forEach var="bvo" items="${bad }" varStatus="j">
					<div class="item-container">
						<div class="count">${i.count}.</div>
						<div class="item-details">
							<div class="manners-key">${bvo.manners_key}</div>
							<img src="${cpath}/resources/images/manners/mannerPerson.png">
							<div class="cnt">${bvo.cnt}</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${bad==null }">
				<h5>아직 받은 비매너 평가가 없습니다.</h5>
			</c:if>
		</div>
	</c:if>
	<div class="notice">
		<h4>참고사항</h4>
		<h5>- 받은 비매너 내역은 나에게만 보입니다.</h5>
		<h5>- 매너 온도가 올라가는 경우 (가산점 높은 순)</h5>
		<h5>1. 거래 상대에게 받은 긍정 거래 후기</h5>
		<h5>2. 거래 상대에게 받은 매너 칭찬</h5>
		<h5>3. 일반 사용자에게 받은 매너 칭찬</h5>
		<h5>- 매너 온도가 내려가는 경우 (가산점 높은 순)</h5>
		<h5>1. 이용정지 징계</h5>
		<h5>2. 거래 상대의 비매너 평가</h5>
		<h5>3. 일반 사용자의 비매너 평가</h5>
	</div>
	<button type="button" id="exitButton">닫기</button>
</body>

<script type="text/javascript">
	function closePopupWindow() {
		window.close();
	}

	document.getElementById("exitButton").addEventListener("click",
			closePopupWindow);
</script>
</html>
