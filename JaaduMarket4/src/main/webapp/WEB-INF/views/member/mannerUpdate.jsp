
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
		<h1>매너 칭찬 수정하기</h1>
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
		<form action="${cpath }/manner/default/update" onsubmit="return check(f)">
			<input type="hidden" value="${vo.m_seq }" name="seller_seq">
			<h3>어떤 점이 좋았나요?</h3>
			<br>
			<c:forEach var="mvo" items="${list }">
				<label> 
					<input type="checkbox" value="${mvo.manners_seq }" name="manners_seq"
					<c:forEach var="i" items="${mlist }"> ${i.manners_seq==mvo.manners_seq? 'checked':'' }</c:forEach>>${mvo.manners_key }
				</label>
				<br>
			</c:forEach>
			<div class="button">
				<button type="submit">칭찬 수정하기</button>
				<button type="button" onclick="location.href='${cpath}/manner/default/delete?seller=${vo.m_seq }'">삭제하기</button>
			</div>
		</form>
	</div>
</body>
</html>