<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<script type="text/javascript">

	function check(f) {
		alert("실행");
		if(f.type.value == "boare_seq"){
			var num_pattern = /^[0-9]{1,20}$/;
			
			if(f.word.value == "" || !num_pattern.test(f.word.value)){
				alert("글번호를 입력하십시오!");
				return false;
			}
		}else if(f.word.value == ""){
			alert("검색어를 입력하십시오!");
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<c:set var="cpath" value="${pageContext.request.contextPath }"/>		
	<div align="center">
	<h2>자유게시판</h2>
		<table class="boardTable">        
                        <tr>
                            <th>글번호</th>
                            <th>제목 </th>
                            <th>조회수</th>
                            <th>작성자</th>
                            <th>작성일</th>
                        </tr>
                   
			<c:choose>
				<c:when test="${list == null }">
					<tr>
						<td colspan="5" align="center">
							<span style="font-weight: bold;">작성한 글이 없습니다.</span>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td>${vo.board_seq }</td>
							<td>
								<a href="${pageContext.request.contextPath }/board/content?board_seq=${vo.board_seq }">${vo.board_title }</a>
							</td>
							<td>${vo.board_hit }</td>
							<td>${vo.m_id}</td>
							<td>${vo.board_date }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<form action="${cpath }/board/list" method="get" onsubmit="return check(this)" >
			<span style="float: center;">
				<select name="type">
					<option value="board_seq" ${param.type == 'board_seq' ? 'selected' : '' }>글번호로 검색</option>
					<option value="board_title" ${param.type == 'board_title' or empty param.type ? 'selected' : '' }>제목으로 검색</option>
					<option value="m_id" ${param.type == 'm_id' ? 'selected' : '' }>아이디로 검색</option>
					<option value="board_content" ${param.type == 'board_content' ? 'selected' : '' }>내용으로 검색</option>
				</select>
				<input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word }" autocomplete="off">
				<input class="btn" type="submit"  value="검색">
			</span>
		</form>
			<c:if test="${login != null }">
				<div class="btnBox">
					<button onclick="document.location.href='${pageContext.request.contextPath }/board/writeform'">글쓰기</button>
				</div>	
			</c:if>	
			<div align="center">
				<c:if test="${paging.prev }">
					<a href="${cpath }/board/list?page=${paging.begin -1 }&type=${param.type}&word=${param.word}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
					<c:choose>
						<c:when test="${i == paging.page }">
							<strong>[${i }]</strong>
						</c:when>
						<c:otherwise>
							<a href="${cpath }/board/list?page=${i}&type=${param.type}&word=${param.word}">[${i}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="${cpath }/board/list?page=${paging.end + 1}&type=${param.type}&word=${param.word}">[다음]</a>
				</c:if>		
			</div>
	</div>	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		

