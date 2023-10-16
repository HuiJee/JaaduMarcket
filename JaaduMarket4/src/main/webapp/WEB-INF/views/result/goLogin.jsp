<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<script type="text/javascript">
			alert("로그인 후 이용 가능합니다.");
			
			 if (window.opener && !window.opener.closed) {
				    // 팝업 창이 열려있으면 닫기
				    window.opener.close();
				  }
			
			window.location.href="${pageContext.request.contextPath }/login/loginform";
		</script>
    