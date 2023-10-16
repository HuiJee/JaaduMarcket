<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div class="used-title">
	<h1>지역 검색 페이지</h1>
	<hr>
</div>

<form action="${cpath}/jobs/addrCheck2?j_seq=${j_seq}" method="post">
    <select name="addr3_name">
        <option value="">--선택하세요--</option>
        <c:forEach var="addr" items="${addrlist}">
            <option value="${addr.addr3_name}">${addr.addr1_name} ${addr.addr2_name} ${addr.addr3_name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="선택">
</form>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
