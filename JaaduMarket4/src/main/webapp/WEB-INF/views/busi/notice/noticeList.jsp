<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	
	.left{
		float : left;
		
	}
	
	.right{
		float : right;
	}
</style>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<div class="title">
	<c:choose>
		<c:when test="${check == true }">
			<table>
				<tr>
					<td>
						<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
					</td>
					<th width="100%">
						<font size="4"><b>소식</b></font>
					</th>
			
					<td>
						<input type="button" value="소식 작성하기" onclick="location.href='${cpath}/busi/notice/noticeForm?busi_seq=${busi_seq }'">
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table width="100%">
				<tr>
					<td width="33%">
						<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
					</td>
					<th width="33%">
						<font size="4"><b>소식</b></font>
					</th>
					<td width="34%">
					
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	
</div>

<c:if test="${noticeList == null }">
	<div id="none" align="center">
		<p><font color=#A6A6A6 size="2">아직 작성한 소식이 없어요.<br>첫 소식을 작성해 보세요.</font></p>
		<br>
	</div>
</c:if>

<c:if test="${noticeList != null }">
	<div align="center">
		<p>
			<c:forEach var="nvo" items="${noticeList }">
				<table width="800px">
					<tr align="left">
						<td rowspan="4" width="130px">
							<img src="${cpath }/resources/busiProfileImg/${nvo.busi_img}" height="100px" width="120px">
						</td>
						<td><font size="4px">${nvo.busi_name }</font></td>
					</tr>
					<tr>
						<td><font color=#A6A6A6 size="2">${nvo.addr3_name } | ${nvo.notice_date }</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
							<div align="left">
								<p>
									<font size="4"><a href="${cpath}/busi/notice/selectNotice?busi_seq=${busi_seq}&notice_seq=${nvo.notice_seq}"><b>${nvo.notice_title }</b></a></font>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							${nvo.notice_content } 
							<c:if test="${nvo.notice_content.length() >= 130 }">
								<a href="${cpath }/busi/notice/selectNotice?busi_seq=${busi_seq}&notice_seq=${nvo.notice_seq}">[더보기]</a>
							</c:if>
						</td>
					</tr>
				</table>
			<hr width="800px">
			</c:forEach>
		</p>
		
	</div>
</c:if>

<%-- <div align="center">
	<c:if test="${paging.prev }">	<!-- 범위번호가 0이 아닌경우 [이전] 생성 -->
		<a href="${cpath }/busi/notice/notice?page=${paging.begin - 1}&busi_seq=${busi_seq}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
		<c:choose>
			<c:when test="${i == paging.page }">
				<strong>[${i}]</strong>
			</c:when>
			<c:otherwise>
				<a href="${cpath }/busi/notice/notice?page=${i}&busi_seq=${busi_seq}">[${i }]</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${paging.next }">
		<a href="${cpath }/busi/notice/notice?page=${paging.end + 1}&busi_seq=${busi_seq}">[다음]</a>
	</c:if>
</div>
	 --%>

<br>
<br>
<br>
<br>
<br>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>