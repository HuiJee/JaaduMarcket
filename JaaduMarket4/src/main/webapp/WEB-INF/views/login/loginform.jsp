<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>

</style>

<script type="text/javascript">
	//유효성 검사
	function check(f) {
		var m_id = f.m_id.value;
		var password = f.password.value;
		
		if(m_id == ''){
			alert("ID를 입력하시오!");
			f.m_id.focus();
			return false;
		}
		if(password == ''){
			alert("password를 입력하시오!");
			f.password.focus();
			return false;	
		}
		return true;
	}
</script>

<form method="post" action="${cpath }/login/check" onsubmit="return check(this)">
	<div align="center">
	<h2>로그인</h2>
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="m_id" value="${m_id }"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th colspan="2" align="right">
					<span class="ckid">
						<c:choose>
							<c:when test="${check }">
								<input type="checkbox" name="ckid" value="true" checked="checked">
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="ckid" value="true">
							</c:otherwise>
						</c:choose>
							아이디 기억하기
					</span>
						<button type="submit">Login</button>
				</th>
			</tr>
		</table>
	</div>
</form>
<div class="find" align="center" style="margin:3px; display:flex; flex-display:row; padding-top:50px;">
	<a href="${cpath}/login/findform?mode=m_id">ID찾기</a>|
	<a href="${cpath}/login/findform?mode=password">PW찾기</a>|
	<a href="${cpath}/member/insertform">회원가입</a>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>