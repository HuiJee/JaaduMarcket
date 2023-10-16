<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<script type="text/javascript">
	function check(f) {
		if (f.password.value == "") {
			alert("비밀번호를 입력하십시오!!!");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>

<div>
	<b>${nick } 님과 이별인가요? 너무 아쉬워요.</b> 
	<br>계정을 삭제하면 매너온도, 게시글, 관심, 채팅 등 모든 활동 정보가 삭제됩니다.
</div>
<br>

<div>
	<b>${nick }님이 계정을 삭제하려는 이유가 궁금해요.</b> 
	
	<br>
	
	<select id="deleteReason">
		<option value=0>선택해주세요.</option>
		<option value=1>너무 많이 이용해요.</option>
		<option value=2>사고 싶은 물품이 없어요.</option>
		<option value=3>물품이 안팔려요.</option>
		<option value=4>비매너 사용자를 만났어요.</option>
		<option value=5>억울하게 이용이 제한됐어요.</option>
		<option value=6>알림이 너무 많이 와요.</option>
		<option value=6>새 계정을 만들고 싶어요.</option>
	</select>
	
	 <br> <br>
	 
	<form action="${cpath }/member/delete" method="post" onsubmit="return check(this)">
		<table border="1">
			<tr>
				<th>비밀번호 확인</th>
			</tr>
			<tr>
				<td><input type="password" name="password"
					placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				<td align="right">
					<button type="submit">탈퇴하기</button> <input type="button" onclick="history.back()" value="돌아가기">
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
