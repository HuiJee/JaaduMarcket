<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

	<div>
		<script type="text/javascript">
			function send(f){
				var files = f.files.value;
				
				if(files == ''){
					alert("사진을 첨부해주세요.");
					return;
				}
				f.action="${cpath}/busi/insertBackImg";
				f.submit();
			}
		</script>
	</div>
	
	<form method="POST" enctype="multipart/form-data">
		<c:if test="${busi_seq != null }">
			<input type="hidden" name="busi_seq" value="${busi_seq }">
		</c:if>
			<div style="display:block;background:#E9D7DB;width:100%;height:200px" align="center">
				<c:if test="">
				<br><br><br>
					등록된 사진이 없어요.<br>
					사진등록 버튼을 눌러 사진을 추가해 보세요.
				</c:if>
			</div>
			<br>
			<input type="file" name="files" multiple="multiple">
			<input type="button" value="사진 넣기" onclick="send(this.form);">
	</form>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>