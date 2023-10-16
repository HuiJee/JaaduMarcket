
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

<link type="text/css" rel="stylesheet"href="${pageContext.request.contextPath }/resources/css/selectOption.css">
<link type="text/css" rel="stylesheet"href="${pageContext.request.contextPath }/resources/css/buttonInput.css">
<link type="text/css" rel="stylesheet"href="${pageContext.request.contextPath }/resources/css/checkbox.css">

<style>
input[type="text"] {
	width: 200px;
}

form {
	display: flex;
	align-items: flex-start;
	justify-content: center;
	flex-direction: column;
	height: calc(100vh - 150px); /* 화면 높이에서 150px를 제외한 높이 */
	margin: 0px 210px;
	position: fixed;
}

form>div {
	margin-bottom: 5px; /* div 요소들 사이의 아래 여백 조정 */
	display: flex;
	align-items: center;
	justify-self: flex-start;
}

form>div>label {
	margin-right: 10px; /* 왼쪽에 여백을 주기 위한 오른쪽 여백 조정 */
}

h4 {
	margin-right: 10px;
}

#ck1 {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: flex-start;
	align-self: center;
	margin-top: 20px;
}
</style>


<script type="text/javascript">
	function check(f) {
		var account = f.bank_account_num;
		var bank = f.bank_seq.value;
		var account_check = /^[0-9]{11,15}$/;
		var point_check = /^[0-9]*$/;
		var point = f.bank_point;
		var all = document.getElementById("all");

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
		if (!all.checked) {
			alert('약관 동의는 필수입니다.');
			return false;
		}
		return true;
	}

	function checkAll() {
		var all = document.getElementById("all");
		var checkboxes = document.querySelectorAll("input[type='checkbox']");

		if (all.checked) {
			for (var i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = true;
			}
		} else {
			for (var i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = false;
			}
		}

		var status = true;
		for (var i = 0; i < checkboxes.length; i++) {
			if (!checkboxes[i].checked) {
				status = false;
				break;
			}
		}

		if (status) {
			all.checked = true;
			next.style.display = "block";
		} else {
			all.checked = false;
			next.style.display = "none";
		}
	}

	function checkOne() {
		var all = document.getElementById("all");
		var checkboxes = document.querySelectorAll("input[type='checkbox']");

		var unchecked = false;
		for (var i = 0; i < checkboxes.length; i++) {
			if (!checkboxes[i].checked) {
				unchecked = true;
				break;
			}
		}

		if (unchecked) {
			all.checked = false;
		}

		var status = true;
		for (var i = 0; i < checkboxes.length; i++) {
			if (!checkboxes[i].checked) {
				status = false;
				break;
			}
		}

		if (status) {
			all.checked = true;
		} else {
			all.checked = false;
		}
	}
</script>

<body>
	<div class="used-title">
		<h2>자두페이 등록하기</h2>
		<hr>
	</div>
	
	<form action="${cpath }/pay/insert" method="POST" onsubmit="return check(this)">
		<div>
			<h4>은행</h4>
			<select name="bank_seq">
				<option value=0>선택해주세요.</option>
				<c:forEach var="vo" items="${list }">
					<option value="${vo.bank_seq }">${vo.bank_name }</option>
				</c:forEach>
			</select>
		</div>
		
		<div>
			<h4>계좌번호</h4>
			<input type="text" name="bank_account_num"
				placeholder="계좌번호 '-'없이 입력" class="account">
		</div>
		
		<div>
			<label><input type="checkbox" id="all" name="all"
				onclick="checkAll()">약관 전체 동의(필수)</label>
		</div>
		
		<div id="ck1">
			<label><input type="checkbox" onclick="checkOne()">자두페이 서비스 약관</label> 
			<label><input type="checkbox" onclick="checkOne()">자두페이 전자금융거래 이용약관</label> 
			<label><input type="checkbox" onclick="checkOne()">개인정보 수집 및 이용 동의</label> 
			<label><input type="checkbox" onclick="checkOne()">개인정보 제3자 제공 동의(자두페이)</label> 
			<label><input type="checkbox" onclick="checkOne()">개인정보 제3자 제공 동의</label>
		</div>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>
