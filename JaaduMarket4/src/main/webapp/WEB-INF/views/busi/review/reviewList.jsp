<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<style>
	.m_img{
		border-radius: 100%;
		object-fit : cover;
	}

</style>


<div>
	<table width="100%">
		<tr>
			<td width="33%">
				<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
			</td>
			<th width="33%">
				<font size="4"><b>후기</b></font>
			</th>
			<td width="34%" align="right">
				<c:if test="${check == false }">
					<input type="button" value="후기 작성" onclick="location.href='${cpath}/busi/reviewForm?busi_seq=${busi_seq }'">
				</c:if>
			</td>
		</tr>
	</table>
</div>
<hr>
<br>

<div align="center">
	<c:choose>
		<c:when test="${check == true }">
			<div>
				<c:if test="${rlist == null }">
					작성된 후기가 없습니다.
					<br><br>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<c:if test="${rlist == null }">
					아직 후기가 없어요. 비즈를 방문 후 후기를 남겨보세요.	
					<br><br>
				</c:if>
				</div>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="${rlist != null }">
	<div align="center" width="800px">
		<c:forEach var="r" items="${rlist }">
			<table width="800px">
				<tr align="left">
					<td rowspan="2" width="9%">
						<img class="m_img" width="60px" height="60px" src="${cpath }/resources/member/${r.m_img}">
					</td>
					<td width="76%">
						<font size="4"><b>${r.m_nickname }</b>&nbsp;&nbsp;${msg }</font>
					</td>
					<td rowspan="2" align="center" valign="middle">
						<input type="button" value="상세보기 >" onclick="location.href='${cpath}/busi/review/selectReview?busi_seq=${busi_seq }&b_review_seq=${r.b_review_seq }'">
					</td>
				</tr>
				<tr>
					<td>
						${r.addr3_name } | ${r.b_review_date }
					</td>
				</tr>
				<tr>
					<td colspan="2">
						${r.b_review_content }
					</td>
				</tr>
			</table>
			<hr width="800px">
		</c:forEach>
	</div>
</c:if>







<%@ include file="/WEB-INF/views/layout/footer.jsp"%>