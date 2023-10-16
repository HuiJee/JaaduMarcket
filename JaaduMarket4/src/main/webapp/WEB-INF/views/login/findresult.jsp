<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center">
	<c:choose>
		<c:when test="${!check }">
			<h3>아이디 혹은 비밀번호를 찾지 못하였습니다</h3>
			<a href="${cpath}/login/findform?mode=m_id">ID찾기</a>
			<a href="${cpath}/login/findform?mode=password">PW찾기</a>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${param.mode == 'm_id' }">
					<h3>ID : ${m_id }</h3>
					<a href="${cpath}/login/findform?mode=password">PW찾기</a>
				</c:when>
				<c:otherwise>
					<h3>PW : ${password }</h3>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<a href="${cpath }/login/loginform">로그인</a>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
