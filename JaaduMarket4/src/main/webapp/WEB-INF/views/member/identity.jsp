
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

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/used/payPop.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/selectOption.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/buttonInput.css">

<script type="text/javascript">
	function check(f) {
		var name = f.m_name;
		var tel2 = f.m_tel2;
		var tel3 = f.m_tel3;
		var email1 = f.m_email1;
		var tel_check = /^[0-9]{4}$/;

		if (name.value == '') {
			alert('이름을 입력해주세요.');
			f.focus();
			return false;
		}
		if (tel2.value == '' || !tel_check.test(tel2.value)) {
			alert("전화번호를 정확히 입력하세요.");
			tel2.focus();
			return false;
		}
		if (tel3.value == '' || !tel_check.test(tel3.value)) {
			alert("전화번호를 정확히 입력하세요.");
			tel3.focus();
			return false;
		}
		return true;
	}
</script>

<body>
	<div class="used-title">
		<h2>본인인증</h2>
		<hr>
	</div>
	
	<form action="${cpath }/pay/check/${mode}" method="POST" onsubmit="return check(this)">
		<div>
			<h4>아이디</h4>
			<input name="m_id" type="text">
		</div>
		
		<div>
			<h4>전화번호</h4>
			<select name="m_tel1">
				<option>010</option>
				<option>011</option>
				<option>016</option>
			</select> 
			&nbsp;-&nbsp;<input type="text" name="m_tel2" class="tel" />
			&nbsp;-&nbsp;<input type="text" name="m_tel3" class="tel" />
		</div>
		
		<div>
			<h4>이메일</h4>
			<input type="text" name="email1" />
			&nbsp;@&nbsp; 
			<select name="email2">
				<option>naver.com</option>
				<option>google.com</option>
				<option>nate.com</option>
				<option>daum.net</option>
				<option>market.com</option>
			</select>
		</div>
		
		<button type="submit" style="font-weight: bold;">인증하기</button>
	</form>
</body>
</html>

