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
				f.action="${cpath}/busi/updateBackImgCheck";
				f.submit();
			}
		</script>
	</div>
	
	<form method="POST" enctype="multipart/form-data">
		<c:if test="${busi_seq != null }">
			<input type="hidden" name="busi_seq" value="${busi_seq }">
		</c:if>
			<div style="display:block;background:#E9D7DB;width:100%;height:200px" align="center">
				<c:forEach var="img" items="${b_ImgList }">
					<img src="${cpath }/resources/busiBack/${busi_seq}/${img}" width="100%" height="200px">
				</c:forEach>			
			</div>
			<br>
			<div align="right">
				<input type="file" name="files" multiple="multiple">
				<input type="button" value="사진 수정" onclick="send(this.form);">
			</div>
	</form>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>