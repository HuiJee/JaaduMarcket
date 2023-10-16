
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
		var account = f.bank_account_num;
		var bank = f.bank_seq.value;
		var account_check = /^[0-9]{11,15}$/;
		var point_check = /^[0-9]*$/;
		var point = f.bank_point;

		if (bank == 0) {
			alert('은행을 선택해주세요.');
			return false;
		}
		if (account.value == '') {
			alert("계좌번호를 입력하세요.");
			account.focus();
			return false;
		}
		if (!account_check.test(account.value)) {
			alert('계좌번호는 숫자 11~15자리만 입력 가능합니다.');
			account.focus();
			return false;
		}
		return true;
	}
</script>


<body>
	<div class="used-title">
		<h1>자두페이 계좌변경</h1>
		<hr>
	</div>
	
	<form action="${cpath }/pay/update" method="POST" onsubmit="return check(this)">
		<div>
			<h4>은행</h4>
			<select name="bank_seq">
				<option value=0>선택해주세요.</option>
				<c:forEach var="vo" items="${list }">
					<option value="${vo.bank_seq }"
						${bvo.bank_seq == vo.bank_seq ? 'selected':'' }>${vo.bank_name }</option>
				</c:forEach>
			</select>
		</div>
		
		<div>
			<h4>계좌번호</h4>
			<input type="text" name="bank_account_num"
				placeholder="계좌번호 '-'없이 입력" value="${bvo.bank_account_num }">
		</div>
		
		<button type="submit">변경하기</button>
	</form>
</body>
</html>
