
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

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/member/mannersPop.css">

<script type="text/javascript">
	function check(f) {
		var checkboxes = f.querySelectorAll('input[type="checkbox"]:checked');
		if (checkboxes.length === 0) {
			alert("하나 이상 선택해야 합니다.");
			return false;
		}
		return true;
	}
</script>

<body>
	<div class="used-title">
		<h2>매너 칭찬 남기기</h2>
		<hr>
	</div>

	<div class="profile">
		<img src="${cpath }/resources/member/${vo.m_img }">
		<div>
			<h4>${vo.m_nickname }&nbsp;#${vo.m_id}</h4>
			매너온도&nbsp;${vo.manners_degree_sum }&#8451;
		</div>
	</div>
	<hr>
	
	<div class="content">
		<div class="title">
			<h4>칭찬 인사를 남기면 상대방의 매너온도가 올라가요.</h4>
		</div>
		<hr>
		
		<form action="${cpath }/manner/default/insert" onsubmit="return check(this)">
			<input type="hidden" value="${vo.m_seq }" name="seller_seq">
			<h3>어떤 점이 좋았나요?</h3>
			<c:forEach var="mvo" items="${list }">
				<label> 
					<input type="checkbox" value="${mvo.manners_seq }" name="manners_seq">${mvo.manners_key }
				</label>
			</c:forEach>
			<button type="submit">칭찬하기</button>
		</form>
	</div>
</body>
</html>