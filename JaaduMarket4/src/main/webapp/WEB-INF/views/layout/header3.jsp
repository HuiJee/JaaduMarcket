<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="cpath" value="${pageContext.request.contextPath }" />


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/home.css">
<!-- ///////////////////////////////////////////////////////////////////// -->
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="${cpath}/resources/js/httpRequest.js"></script>

<!-- 지도api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dc12c4a684add82a89a4d0e579d39bfc&libraries=services&autoload=false"></script>

<script type="text/javascript">
function notReady() {
  alert("현재 준비중인 페이지입니다. \r\n\r\n빠른 시일 내에 선보이겠습니다!");
}

</script>

<title>자두마켓</title>
</head>
<body>
 	<div id="header">
		<div id="header-area1">
			<a href="${cpath }">
				<img src="${cpath }/resources/images/logo.png" /></a>
			<div id="menu">
				<ul>
					<li><a href="${cpath }/used">중고거래</a>
						<ul>
							<li><a href="${cpath }/used/0">인기매물</a></li>
							<li><a href="${cpath }/used/1">디지털기기</a></li>
							<li><a href="${cpath }/used/2">유아동</a></li>
							<li><a href="${cpath }/used/3">의류/잡화</a></li>
							<li><a href="${cpath }/used/4">가구/생활가전</a></li>
							<li><a href="${cpath }/used/5">생활/주방</a></li>
							<li><a href="${cpath }/used/6">가공식품</a></li>
							<li><a href="${cpath }/used/7">스포츠/레저</a></li>
							<li><a href="${cpath }/used/8">취미/게임/음반</a></li>
							<li><a href="${cpath }/used/9">도서</a></li>
							<li><a href="${cpath }/used/10">뷰티/미용</a></li>
							<li><a href="${cpath }/used/11">기타 중고물품</a></li>
							<li><a href="${cpath }/used/12">삽니다</a></li>
						</ul></li>
					<li><a href="${cpath }/views/makeBusi">동네가게</a>
						<ul>
							<li><a href="${cpath }/views/makeBusi">음식점</a></li>
							<li><a href="${cpath }/views/makeBusi">카페/디저트</a></li>
							<li><a href="${cpath }/views/makeBusi">운동</a></li>
							<li><a href="${cpath }/views/makeBusi">뷰티샵</a></li>
							<li><a href="${cpath }/views/makeBusi">미용실</a></li>
						</ul></li>
					<li><a href="${cpath }/jobs/list">알바</a></li>
					<li><a href="${cpath }/board/list">자유게시판</a></li>
				</ul>
			</div>
		</div>
			<c:if test="${login !=null }">
				<a href="${cpath }/member/mypage?m_seq=${login}">MyPage</a>
				<a href="javascript:logoutButton()" >로그아웃</a>
			</c:if>
			<c:if test="${login == null }">
				<a href="${cpath }/login/loginform">
				<img src="${cpath }/resources/images/account.png" />로그인/회원가입</a>
			</c:if>
		</div>
	</div> 
	<div id="body">
	
	