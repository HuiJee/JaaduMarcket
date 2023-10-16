<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/busi/busi_header.jsp"%>
	
	<div align="center">
		<c:if test="${imgList != null }">
			<c:forEach var="img" items="${imgList }" varStatus="i">
				<img src="${cpath }/resources/notice_img/${vo.notice_seq}/${img}" height="600px" width="800px">
				<br>
			</c:forEach>
		</c:if>
		
		<c:if test="${imgList == null }">
			소식 이미지 없음
		</c:if>
	</div>
	
	<br>
	
	<div align="center">
		<table width="800px">
			<tr align="left">
				<td rowspan="2" width="130px">
					<img width="100%" height="100%" src="${cpath }/resources/busiProfileImg/${bvo.busi_img }">
				</td>
				<td><a href="${cpath }/busi/myBusi?busi_seq=${bvo.busi_seq }"><b>${bvo.busi_name}</b></a></td>
			</tr>
			<tr>
				<td>${addr3_name } | 단골수</td>
			</tr>
		
		</table>
		<hr width="800px">
	</div>
	
	<div align="center">
		<table width="800px">
			<tr align="left">
				<td colspan="2"><font size="5"><b>${vo.notice_title }</b></font></td>
			</tr>
			<tr>
				<td colspan="2"><font color=#A6A6A6 size="2">${busi_cate_name } | ${vo.notice_date }</font></td>
				
			</tr>
				<c:if test="${cvo != null}">
				<tr align="left" width="400px" style="background-color: #FFF3F6">
					<td>
						<b>${cvo.coupon_effect }</b>
					</td>
					<c:if test="${check == false }">
						<c:choose>
							<c:when test="${cvo.regular_status == 1}">
								<c:choose>
									<c:when test="${cdvo.m_seq == login.m_seq && cdvo.coupon_seq == cvo.coupon_seq }">
										<td rowspan="4" width="15%" align="center">
									</c:when>
									<c:otherwise>
										<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${cdvo.m_seq == login.m_seq && cdvo.coupon_seq == cvo.coupon_seq }">
										<td rowspan="3" width="15%" align="center">
									</c:when>
									<c:otherwise>
										<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
									
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
							<c:choose>
								<c:when test="${cdvo.m_seq == login.m_seq && cdvo.coupon_seq == cvo.coupon_seq }">
									발급 완료
								</c:when>
								<c:otherwise>
									↓쿠폰 받기
								</c:otherwise>
							</c:choose>
							</td>
						</c:if>
					</tr>
				<c:if test="${cvo.regular_status == 1}">
					<tr width="400px" style="background-color: #FFF3F6">
						<td>
							<font size="3">단골 전용</font>
						</td>
					</tr>
				</c:if>
				<tr width="400px" style="background-color: #FFF3F6">
					<td>
						<font size="2">${cvo.coupon_use_date } 까지</font>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="2" width="750px" height="200px" valign="top"><br>${vo.notice_content }</td>
			</tr>
								
						
						
			<c:choose>
				<c:when test="${check == true }">
					<tr>
						<td><br><font color=#A6A6A6 size="2">조회 ${vo.notice_views }</font></td>
						<td align="right">
							<input type="button" value="수정" onclick="location.href='${cpath }/busi/notice/noticeUpdate?busi_seq=${busi_seq }&notice_seq=${vo.notice_seq }'">
							<input type="button" value="삭제" onclick="location.href='${cpath }/busi/notice/noticeDelete?busi_seq=${busi_seq }&notice_seq=${vo.notice_seq }'">
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="2"><br><font color=#A6A6A6 size="2">조회 ${vo.notice_views }</font></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<hr width="800px">
	</div>
	<div align="center">
		<input type="button" value="home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
		<input type="button" value="이전으로" onclick="history.back()">
		<hr width="800px">
	</div>
	<div align="center">
		<form action="${cpath }/busi/notice/notice_cmt?notice_seq=${vo.notice_seq }" method="post">
			<input type="hidden" name="busi_seq" value="${busi_seq }">
			<table width="800px">
				<tr align="left">
					<td>
						<img src="${cpath }/resources/member/${mvo.m_img}" height="70px" width="70px">
					</td>
					<td>
						<textarea name="cmt" placeholder="댓글을 남겨보세요." rows="4" cols="90"></textarea>
					</td>
					<td>
						<input type="submit" value="등록">
					</td>
				</tr>
			</table>	
		</form>
	</div>
	
	<br>
	<div align="center">
		<c:if test="${cmtList != null }">
			<c:forEach var="cmt" items="${cmtList }">
				<table width="800px">
						<tr align="left">
							<td rowspan="4" width="10%" valign="top">
								<img src="${cpath }/resources/member/${cmt.m_img}" height="70px" width="70px">
							</td>
							<td valign="top" width="90%">
								${cmt.m_nickname }&nbsp;&nbsp;&nbsp;<font color=#A6A6A6 size="2">${cmt.cmt_date }</font>
							</td>
						</tr>
						<tr>
							<td rowspan="3" valign="top" width="90%">
								${cmt.cmt }
							</td>
						</tr>
				</table>
				<br>
			</c:forEach>
		
		</c:if>
		<c:if test="${cmtList == null}">
			<font color=#A6A6A6 size="3">작성된 댓글이 없어요.<br><br></font>
		</c:if>
	</div>
	
	
	
	
	
	
	
	
	
	
	

    
  
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>