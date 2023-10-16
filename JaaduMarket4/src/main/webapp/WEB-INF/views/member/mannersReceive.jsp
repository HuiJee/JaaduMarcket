
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
	position: fixed; /* 상단에 고정 */
	top: 0;
	left: 0;
	width: 100%;
	height: 80px;
	padding: 10px;
	display: flex;
	border-bottom: 1px solid lightgray;
}

.used-title h2 {
	width: 80%;
}

.sub-title {
	position: fixed; /* 상단에 고정 */
	top: 100px;
	left: 0;
	width: 100%;
	height: 80px;
	padding: 10px;
}

.content-wrapper {
	position: fixed;
	top: 300px;
	width: 60%;
	padding: 20px;
	background-color: #fff;
	text-align: center;
	display: center;
}

.content-wrapper img {
	position: fixed;
	top: 100px;
	width: 500px;
	height: 500px;
	left: 80px;
}

.content-wrapper ul {
	position: fixed;
	top: 380px;
	width: 350px;
	text-align: left;
	padding: 0;
	margin: 0;
	background-color: white;
	border: 1px solid lightgray;
	border-radius: 20px;
	min-height: 200px;
}

.content-wrapper ul li {
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 100px;
}

input[type="button"] {
	margin: 30px;
	width: 100px;
	height: 30px;
	background-color: #f2f2f2;
	color: #333;
	border-radius: 10px;
	border: none;
	display: flex;
	justify-content: center;
	align-items: center;
	align-self: center;
}

input[type="button"]:hover {
	background-color: #edeaef;
}
</style>

</head>
<body>

	<div class="used-title">
		<h2>내가 받은 매너</h2>
		<input type="button" value="뒤로 가기" onclick="history.back()">
	</div>
	<hr>

	<div class="sub-title">
		<h3>${nickname }님에게<br>따뜻한 후기가 왔어요.</h3>
	</div>
	<hr>

	<div class="content-wrapper">
		<img src="${cpath }/resources/images/manners/002.png" alt="아이콘">
		<ul>
			<c:forEach var="string" items="${list }">
				<li>${string }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
