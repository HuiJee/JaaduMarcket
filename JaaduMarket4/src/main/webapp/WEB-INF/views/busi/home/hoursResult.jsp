<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
<form action="${cpath }/busi/home/info?busi_seq=${busi_seq}" method="post">
<div>
	영업시간이 설정되었습니다.
	정보입력 페이지로 돌아갑니다.
	<br>
	<input type="button" value="확인" onclick="window.close()">
</div>
</form>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>