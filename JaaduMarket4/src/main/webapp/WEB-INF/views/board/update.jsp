<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type ="text/javascript">
	function checkWrite(){
		if(document.write.board_title.value == ""){
			alert("제목을 입력하십시오");
			document.write.title.focus();
		}else if(document.write.board_content.value == ""){
			alert("내용을 입력하십시오");
			docuemt.write.content.focus();
		}else{
			document.write.submit();
		}
	}

</script>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div align ="center">
	<form action ="${pageContext.request.contextPath }/board/update" method="post" name="write">
		<input type = "hidden" name="board_seq" value="${vo.board_seq}">
		<table class = "boardTable">
			<tr>
				<th width="60"> 제목 </th>
				<td><input type = "text" value="${vo.board_title }" name ="board_title" size="53"></td>
			</tr>
			<tr>
				<td colspan ="2">
				<textarea rows="15" cols="65" name="board_content">${vo.board_content }</textarea></td>
			</tr>
		</table>
		<div class ="btnBox">
			<button onclick="javascript:checkWrite()">수정 </button>		
	</div>
 	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
