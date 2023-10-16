<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type ="text/javascript">
	
	function checkWrite(f){
		if(f.board_title.value == ""){
			alert("제목을 입력하십시오!");
			f.board_title.focus();
			return;
		}else if(f.board_content.value == ""){
			alert("내용을 입력하십시오!");
			f.board_content.focus();
			return;
		}else{
			f.submit();
		}
	}
	
	/* function sand(f){
		
		var board_img_name = f.board_img_name.value;
		
		if( board_img_name == ''){
			alert("전송할 사진을 선택하세요");
			return;
		}
		
		f.action = "upload";
		f.submit();
	} */

</script>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div align ="center">
	<form action ="${pageContext.request.contextPath }/board/write" method="post" name="write" enctype="multipart/form-data">
		<table class = "boardTable">
			<tr>
				<th width="60"> 제목 </th>
				<td><input type = "text" name="board_title" size="53"></td>
			</tr>
			<tr>
				<td colspan ="2">
					<textarea rows="15" cols="65" name="board_content"></textarea>
				</td>
			</tr>
		</table>
		<div>
			<input type ="file" name="files" multiple="multiple">
		</div>
		<div class ="btnBox">
			<button value="쓰기" onclick="javascript:checkWrite()">쓰기</button>
		</div>
 	</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
