<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
<style>
	.busi_img{
		border-radius: 100%;
		object-fit : cover;
	}

</style>
    
	
	<div id="stores_header">
		<div>
			<h2><a href="${cpath }/busi/myBusi?busi_seq=${busi_seq }">비즈프로필</a></h2>
		</div>
		<hr>
	
		<c:if test="${b_ImgList == null }">
			<div style="display:block;background:#E9D7DB;width:100%;height:200px"></div>
			<br>
			
			<c:if test="${check == true }">
				<div align="right">
					<font color=#A6A6A6 size="2">배경 사진을 등록해주세요.</font>
					<input type="button" value="배경사진 설정" onclick="location.href='${cpath }/${url }'">
				</div>
			</c:if>
		</c:if>
		<c:if test="${b_ImgList != null }">
			<div style="display:block;background:#E9D7DB;width:100%;height:200px">
				<c:forEach var="img" items="${b_ImgList }">
					<img src="${cpath }/resources/busiBack/${busi_seq}/${img}" width="100%" height="200px">
				</c:forEach>
			</div>	
			<br>
			
			<c:if test="${check == true }">
				<div align="right">
					<font color=#A6A6A6 size="2">배경 사진 수정하기</font>
					<input type="button" value="배경사진 설정" onclick="location.href='${cpath }/${url }'">
				</div>
			</c:if>
			
		</c:if>
		<hr>
		
		<div>
			<table>
				<tr>
					<c:choose>
						<c:when test="${check == true }">
							<td rowspan="3" width="170px" align="center"><img class="busi_img" width="130px" height="130px" src="${cpath }/resources/images/busiProfileImg/${vo.busi_img }" onclick="location.href='${cpath}/busi/updateMyBusi?busi_seq=${busi_seq }'"></td>
						</c:when>
						<c:otherwise>
							<td rowspan="3" width="170px" align="center"><img class="busi_img" width="130px" height="130px" src="${cpath }/resources/images/busiProfileImg/${vo.busi_img }" onclick="location.href='${cpath}/busi/myBusi?busi_seq=${busi_seq }'"></td>
						</c:otherwise>
					</c:choose>
				
					<td><font size="4"><b>${vo.busi_name }</b></font></td>
				</tr>
				<tr>
					<td>${addr3_name } | ${busi_cate_name } | 단골 ${countRegular }</td>
				</tr>
				<c:choose>
					<c:when test="${check == true }">
						<tr>
							<td>
								<input type="button" value="단골관리 >" onclick="location.href='${cpath}/busi/regular?busi_seq=${busi_seq }'">
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${isRegular == 1 }">
								<tr>
									<td>
										<input type="button" value="-단골끊기" onclick="location.href='${cpath}/busi/quitRegular?busi_seq=${busi_seq }'">
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>
										<input type="button" value="+단골맺기" onclick="location.href='${cpath}/busi/beRegular?busi_seq=${busi_seq }'">
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
				
			</table>
		</div>
		<hr>
		
			<c:if test="${check == true }">
				<div>
					<table width="100%">
						<tr>
							<%-- <th width="33%">
								<input type="button" value="광고생성" onclick="location.href='${cpath}/busi/makeAd'">
							</th> --%>
							<th width="50%">
								<input type="button" value="소식작성" onclick="location.href='${cpath}/busi/notice/noticeForm?busi_seq=${vo.busi_seq }'">
							</th>
							<th width="50%">
								<input type="button" value="쿠폰관리" onclick="location.href='${cpath}/busi/coupon/coupon?busi_seq=${vo.busi_seq }'">
							</th>
						</tr>
					</table>
				</div>
				<hr>
			</c:if>
				<%-- <div>
					<table width="100%">
						<tr>
							<th width="33%">
								<input type="button" value="채팅" onclick="location.href='${cpath}/busi/chat'">
							</th>
							<th width="33%">
								<input type="button" value="관심" onclick="location.href='${cpath}/busi/fav?busi_seq=${vo.busi_seq }'">
							</th>
							<th width="34%">
								<input type="button" value="후기 작성" onclick="location.href='${cpath}/busi/reviewForm?busi_seq=${vo.busi_seq }'">
							</th>
						</tr>
					</table>
				</div> --%>
		
		
		
		
		<div>
			<table width="100%" cellpadding="15">
				<tr>
					<th>
						<a href="${cpath }/busi/myBusi?busi_seq=${busi_seq}">홈</a>
					</th>
					<th>
						<a href="${cpath }/busi/notice/notice?busi_seq=${busi_seq}">소식</a>
					</th>
					<th>
						<a href="${cpath }/busi/product/product?busi_seq=${busi_seq}">상품</a>
					</th>
					
					<c:choose>
						<c:when test="${check == true }">
							<th>
								<a href="${cpath }/busi/review?busi_seq=${busi_seq}">후기</a>
							</th>
						</c:when>
						<c:otherwise>
							<th>
								<a href="${cpath }/busi/review?busi_seq=${busi_seq}">후기</a>
							</th>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
			<br>
		</div>
	</div>
	