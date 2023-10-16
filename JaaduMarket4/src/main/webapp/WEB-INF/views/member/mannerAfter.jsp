<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manners</title>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
</head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/buttonInput.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/checkbox.css">

<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	padding: 0;
}

.used-title {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 80px;
	padding: 10px;
	text-align: left;
}

.profile {
	position: fixed;
	top: 80px;
	left: 10px;
}

.buttons {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	padding: 10px;
	align-self: center;
}

.buttons button {
	margin: 0 5px;
}

.content-wrapper {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 20px;
	position: fixed;
	top: 150px;
}

.content-wrapper h5 {
	margin-bottom: 10px;
	position: fixed;
	top: 250px;
}

.content-wrapper form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 10px;
	position: fixed;
	top: 300px;
}

.content-wrapper form h3 {
	margin-bottom: 10px;
}

.content-wrapper form label {
	margin-bottom: 5px;
}

.button-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 10px;
}
</style>

<script type="text/javascript">
	function check(f) {
		var checkboxes = f.querySelectorAll('input[type="checkbox"]:checked');
		if (checkboxes.length === 0) {
			alert("하나 이상 선택해야 합니다.");
			return false;
		}
		return true;
	}

	function selectManner(mannerId) {
		var bad = document.getElementById('div_1');
		var good = document.getElementById('div_2');
		var excellent = document.getElementById('div_3');

		if (mannerId == 1) {
			bad.style.display = "block";
			good.style.display = "none";
			excellent.style.display = "none";
		} else if (mannerId == 2) {
			bad.style.display = "none";
			good.style.display = "block";
			excellent.style.display = "none";
		} else {
			bad.style.display = "none";
			good.style.display = "none";
			excellent.style.display = "block";
		}

		var buttons = document.querySelectorAll('input[type="button"]');
		buttons.forEach(function(button) {
			if (button.id === mannerId) {
				button.classList.add('selected-button');
			} else {
				button.classList.remove('selected-button');
			}
		});
	}
</script>

<body>

	<div class="used-title">
		<h2>매너 칭찬 남기기</h2>
		<hr>
	</div>

	<div class="profile">
		<h3>${gvo.m_nickname }님,<br>${rvo.m_nickname }님과 거래가 어떠셨나요?
		</h3>
		<span style="color: darkgray;">거래 선호도는 나만 볼 수 있어요.</span>
	</div>

	<div class="content-wrapper">
		<div class="buttons">
			<input type="button" value="별로예요" onclick="selectManner('1')" id="1">
			<input type="button" value="좋아요" onclick="selectManner('2')" id="2">
			<input type="button" value="최고예요" onclick="selectManner('3')" id="3">
		</div>
		<h5>칭찬 인사를 남기면 상대방의 매너온도가 올라가요.</h5>
	</div>

	<hr>

	<div class="content-wrapper">
		<form action="${cpath }/manners/insert/${u_seq}" onsubmit="return check(this)">
			<input type="hidden" value="${rvo.m_seq }" name="receive">
			<h3>어떤 점이 좋았나요?</h3>
			
			<div id="div_1" style="display: none;">
				<c:forEach var="vo" items="${list }">
					<c:if test="${vo.manners_why == 1 }">
						<label> 
							<input type="checkbox" value="${vo.manners_seq }" name="manners_seq"> ${vo.manners_key }
						</label>
						<br>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="div_2" style="display: none;">
				<c:forEach var="vo" items="${list }">
					<c:if test="${vo.manners_why == 2 }">
						<label> 
							<input type="checkbox" value="${vo.manners_seq }" name="manners_seq"> ${vo.manners_key }
						</label>
						<br>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="div_3" style="display: none;">
				<c:forEach var="vo" items="${list }">
					<c:if test="${vo.manners_why == 3 }">
						<label> 
							<input type="checkbox" value="${vo.manners_seq }" name="manners_seq"> ${vo.manners_key }
						</label>
						<br>
					</c:if>
				</c:forEach>
			</div>
			
			<div class="button-wrapper">
				<button type="submit">칭찬하기</button>
				<button type="button" onclick="history.back()">뒤로 가기</button>
			</div>
		</form>
	</div>

</body>
</html>
