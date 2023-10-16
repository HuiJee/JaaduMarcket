<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${su != 0 }">
		<script type="text/javascript">
			alert("${msg}");
			document.location.href='${url}';
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("${msg}");
			history.back();
		</script>
	</c:otherwise>
</c:choose>
    
