<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<div align="center" width="800px">

	<div>
		<table width="100%">
			<tr>
				<td width="33%">
					<input type="button" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
				</td>
				<th width="33%">
					<font size="4"><b>소식 선택</b></font>
				</th>
				<td width="34%">
				
				</td>
			</tr>
		</table>
	</div>
	<hr>

	<div>
		<input type="button" value="새 소식에 첨부하기" onclick="location.href='${cpath}/busi/notice/noticeFormCoupon?busi_seq=${busi_seq }&coupon_seq=${coupon_seq }'">
		<hr width="800px">
	</div>
	
	<div>
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
	</div>






</div>




<%@ include file="/WEB-INF/views/layout/footer.jsp"%>