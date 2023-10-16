<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pay</title>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
</head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/selectOption.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/buttonInput.css">

<style>
input[type="number"] {
	width: 200px;
}

h4 {
	margin-right: 10px;
	width: 100px;
}

form {
	display: flex;
	align-items: flex-start;
	justify-content: center;
	flex-direction: column;
	height: calc(100vh - 300px); /* 화면 높이에서 150px를 제외한 높이 */
	margin: 0px 210px;
	position: fixed;
}

form>div {
	margin-bottom: 5px; /* div 요소들 사이의 아래 여백 조정 */
	display: flex;
	align-items: center;
	justify-self: flex-start;
}
</style>

<script type="text/javascript">
	function check(f) {
		var charge = f.bank_point;
		if (charge.value == '') {
			alert("1만원 이상의 금액을 입력하세요.");
			charge.focus();
			return false;
		}
		return true;
	}
</script>

<c:set var="account" value="${bvo.bank_account_num}" />
<c:set var="accountNumber" value="${account.substring(0, 4)}*****${account.substring(account.length() - 3)}" />

<body>
	<div class="used-title">
		<h1>자두페이 충전</h1>
		<hr>
	</div>
	
	<form action="${cpath }/pay/charge" method="POST" onsubmit="return check(this)">
		<div>
			<h4>은행</h4>${bvo.bank_name}</div>
		<div>
			<h4>계좌번호</h4>${accountNumber}</div>
		<div>
			<h4>충전 금액</h4>
			<input type="number" name="bank_point" min="10000" placeholder="1만원부터 충전 가능">
		</div>
		<button type="submit">충전하기</button>
	</form>
</body>
</html>
