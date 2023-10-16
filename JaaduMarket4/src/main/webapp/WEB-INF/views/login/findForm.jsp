<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script type="text/javascript">
function check(f){
	if(f.m_id.value == ''){
		alert("아이디를 입력 하십시오!");
		f.m_id.focus();
		return false;
	}
	if(f.m_name.value == ''){
		alert("이름를 입력 하십시오!");
		f.name.focus();
		return false;
	}
	
	if(f.m_tel3.value == '' || f.m_tel2.value == ''){
		alert("전화번호를 입력하십시오!");
		f.m_tel2.focus();
		return false;
	}
	
	
	return true;
}

</script>
<div align = "center">
<form action="${ pageContext.request.contextPath }/login/find" onsubmit="return check(this);" method="post" name="find">
	<c:choose>
		<c:when test ="${param.mode == 'm_id' }">
			<input type="hidden" name="mode" value="m_id">
			<h3>아이디 찾기</h3>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="mode" value="password">
			<h3>패스워드 찾기</h3>
		</c:otherwise>
	</c:choose>
	<table>
		<c:if test="${param.mode == 'password' }">
			<tr>
				<th>ID</th>
				<td><input type="text" name="m_id"></td>
			</tr>
		</c:if>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="m_name"></td>
			</tr>
			<tr>
				<th>TEL</th>
				<td>
					<select name = "m_tel1">
					<option value="010" selected="selected">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="019">019</option>
					</select>
					-<input type="text" size = "5" maxlength="4" name = "m_tel2">
					-<input type="text" size = "5" maxlength="4" name = "m_tel3">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="찾기">
				<input type="button" value="다시작성" onclick="document.find.reset()">
				</td>
			</tr>
	</table>
</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
