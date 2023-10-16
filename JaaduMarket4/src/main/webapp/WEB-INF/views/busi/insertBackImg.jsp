<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<form method="POST" enctype="multipart/form-data">
		<input type="hidden" name="busi_seq" value="${busi_seq }">
		
			<div style="display:block;background:#E9D7DB;width:100%;height:200px" align="center">
				<c:if test="">
				<br><br><br>
					등록된 사진이 없어요.<br>
					사진등록 버튼을 눌러 사진을 추가해 보세요.
				</c:if>
			</div>
			<br>
				<input type="file" name="photo" multiple="multiple">
		<input type="button" value="사진 넣기" onclick="send(this.form);">
	</form>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>