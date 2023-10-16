<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type ="text/javascript">
	function deleteAction(){
		var check = confirm("삭제 하시겠습니까?");
		console.log(${vo.board_seq});
		if(!check){
			return;
		}
		
		location.href = '${pageContext.request.contextPath }/board/delete?board_seq=${vo.BOARD_SEQ}';
	}
	
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div align ="center">
	<table class ="boardTable" style="table-layout:fixed;">
                <tr>
                    <th>제목</th>
					<td>${vo.BOARD_TITLE }</td>
					<th>조회수</th>
					<td>${vo.BOARD_HIT }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${vo.M_ID}</td>
					<th>작성일</th>
					<td>${vo.BOARD_DATE }</td>
				</tr>
				<tr>
					<td colspan="4">
				${vo.BOARD_CONTENT }
			</td>
		</tr>
		<c:if test="${ilist != null }">
			<c:forEach var="img" items="${ilist }">
				<tr>
					<th>첨부파일</th>
						<td colspan = "3">
							<img src="${cpath }/resources/Board_img/${img.board_seq}/${img.board_img_name }"><br></a>			
						</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="btnBox">
		<c:if test="${login != null }">
			<button onclick="location.href='${pageContext.request.contextPath }/board/updateForm?board_seq=${vo.BOARD_SEQ}'">수정</button>
			<button onclick="deleteAction()"> 삭제 </button>
		</c:if>
			<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath }/board/list'"></div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
