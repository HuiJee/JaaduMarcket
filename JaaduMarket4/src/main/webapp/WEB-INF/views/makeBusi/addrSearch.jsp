<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<style type="text/css">
	#body{
		height: 600px;
	}
</style>

</head>
<body>
<%-- <%@ include file="/WEB-INF/views/layout/header.jsp"%> --%>
	
	
	<div>
		<h3><b>지역 검색</b></h3>
		<hr>
	</div>
	<div id="body">
		<form action="${cpath }/makeBusi/searchCheck" method="post">
			<input type="text" placeholder="동,읍,면으로 검색(ex.서초동)" name="addr3_name" size="60px">
			<input type="submit" value="검색">
	</form>
	</div>




<%@ include file="/WEB-INF/views/layout/footer.jsp"%>