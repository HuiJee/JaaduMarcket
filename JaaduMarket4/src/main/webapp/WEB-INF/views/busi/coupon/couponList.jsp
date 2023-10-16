<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<div>
	<font size="5"><b>쿠폰 관리</b></font>
</div>
	<hr>
	
<div>
	<c:choose>
		<c:when test="${check == true }">
			<table>
				<tr>
					<td>
						<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
					</td>
					<th width="100%">
						<font size="4"><b>쿠폰</b></font>
					</th>
					<td>
						<input type="button" value="쿠폰 만들기" onclick="location.href='${cpath}/busi/coupon/makeCoupon?busi_seq=${busi_seq }'">
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
						<font size="4"><b>쿠폰</b></font>
					</th>
					<td width="34%">
					
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	
</div>
<br>
	
	<c:choose>
		<c:when test="${check == true }">
			<c:if test="${clist == null }">
				<div align="center">
					<img src="${cpath }/resources/busi/coupon/쿠폰관리.jpg" width="370px" height="280px">
					<br>
					<br>
					<input type="button" value="새 쿠폰 만들기" onclick="location.href='${cpath}/busi/coupon/makeCoupon?busi_seq=${busi_seq }'">
					<br>
					<br>
					<a href="${cpath }/busi/coupon/couponTip" target="_blank"><font color=#A6A6A6 size="2">쿠폰으로 홍보 효과를 높이는 꿀팁!</font></a>
					<br>
					<br>
				</div>
			</c:if>
			
			<c:if test="${clist != null }">
				<div align="center" width="800px">
			
					<c:forEach var="c" items="${clist }">
						<c:if test="${c.coupon_limit_num != 0}">
							<table width="770px" style="background-color: #FFF3F6">
								<tr align="left">
									<td width="85%">
										<c:if test="${c.coupon_act == 0 }">
											<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중</font>
										</c:if>
										<c:if test="${c.coupon_act == 1 }">
											<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
										</c:if>
										<font size="2" color="#BE3455">남은 쿠폰: ${c.coupon_limit_num }</font>
									</td>
									<c:choose>
										<c:when test="${c.regular_status == 1}">
											<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:when>
										<c:otherwise>
											<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:otherwise>
									</c:choose>
											쿠폰 수정
										</td>
								</tr>
								<tr>
									<td>
										<font size="4"><b>${c.coupon_effect }</b></font>
									</td>
								</tr>
								<c:if test="${c.regular_status == 1}">
									<tr>
										<td><font size="3">단골 전용</font></td>
									</tr>
								</c:if>
								<tr>
									<td>
										<font size="2">${c.coupon_use_date } 까지</font>
									</td>
								</tr>
							</table>
							<table width="770px" cellspacing="10">
								<tr align="center">
									<td>
										<input type="button" value="소식에 첨부하기" onclick="location.href='${cpath }/busi/coupon/attachCoupon?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
									</td>
									<td>
										<input type="button" value="상세보기" onclick="location.href='${cpath}/busi/coupon/selectCoupon?coupon_seq=${c.coupon_seq}'">
									</td>
								</tr>
							</table>
						</c:if>
						
						<c:if test="${c.coupon_limit_num == 0}">
							<table width="770px" style="background-color: #FFF3F6">
								<tr align="left">
									<td>
										<c:if test="${c.coupon_act == 0 }">
											<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%; background-size: 120%">발급중</font>
										</c:if>
										<c:if test="${c.coupon_act == 1 }">
											<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
										</c:if>
									</td>
									<c:choose>
										<c:when test="${c.regular_status == 1}">
											<td rowspan="4" width="15%"  align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:when>
										<c:otherwise>
											<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:otherwise>
									</c:choose>
											쿠폰 수정
										</td>
								</tr>
								<tr>
									<td width="85%">
										<font size="4"><b>${c.coupon_effect }</b></font>
									</td>
								</tr>
								<c:if test="${c.regular_status == 1}">
									<tr>
										<td><font size="3">단골 전용</font></td>
									</tr>
								</c:if>
								<tr>
									<td>
										<font size="2">${c.coupon_use_date } 까지</font>
									</td>
								</tr>
							</table>
							<table width="770px" cellspacing="10">
								<tr align="center">
									<td>
										<input type="button" value="소식에 첨부하기" onclick="location.href='${cpath}/busi/coupon/attachCoupon?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
									</td>
									<td>
										<input type="button" value="상세보기" onclick="location.href='${cpath}/busi/coupon/selectCoupon?coupon_seq=${c.coupon_seq}'">
									</td>
								</tr>
							</table>
						</c:if>
							<hr width="800px">
					</c:forEach>
				</div>
			</c:if>
			
		</c:when>
		<c:otherwise>
			<c:if test="${clist == null }">
				<div align="center">
					쿠폰이 없어요.
				</div>
			</c:if>
			
			<c:if test="${clist != null }">
				<div align="center" width="800px">
					<c:forEach var="c" items="${clist }">
						<c:if test="${c.coupon_limit_num != 0}">
							<table width="770px" style="background-color: #FFF3F6">
								<tr align="left">
									<td width="85%">
										<c:if test="${c.coupon_act == 0 }">
											<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중</font>
										</c:if>
										<c:if test="${c.coupon_act == 1 }">
											<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
										</c:if>
										<font size="2" color="#BE3455">남은 쿠폰: ${c.coupon_limit_num }</font>
									</td>
									<c:choose>
										<c:when test="${c.regular_status == 1}">
											<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:when>
										<c:otherwise>
											<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:otherwise>
									</c:choose>
											↓쿠폰 받기
										</td>
								</tr>
								<tr>
									<td>
										<a onclick="location.href='${cpath}/busi/coupon/detailCoupon?coupon_seq=${c.coupon_seq}&busi_seq=${busi_seq }'"><font size="4"><b>${c.coupon_effect }</b></font></a>
									</td>
								</tr>
								<c:if test="${c.regular_status == 1}">
									<tr>
										<td><font size="3">단골 전용</font></td>
									</tr>
								</c:if>
								<tr>
									<td>
										<font size="2">${c.coupon_use_date } 까지</font>
									</td>
								</tr>
							</table>
						</c:if>
						
						<c:if test="${c.coupon_limit_num == 0}">
							<table width="770px" style="background-color: #FFF3F6">
								<tr align="left">
									<td>
										<c:if test="${c.coupon_act == 0 }">
											<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%; background-size: 120%">발급중</font>
										</c:if>
										<c:if test="${c.coupon_act == 1 }">
											<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
										</c:if>
									</td>
									<c:choose>
										<c:when test="${c.regular_status == 1}">
											<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:when>
										<c:otherwise>
											<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
										</c:otherwise>
									</c:choose>
											↓쿠폰 받기
										</td>
								</tr>
								<tr>
									<td width="85%">
										<a onclick="location.href='${cpath}/busi/coupon/detailCoupon?coupon_seq=${c.coupon_seq}&busi_seq=${busi_seq }'"><font size="4"><b>${c.coupon_effect }</b></font></a>
									</td>
								</tr>
								<c:if test="${c.regular_status == 1}">
									<tr>
										<td><font size="3">단골 전용</font></td>
									</tr>
								</c:if>
								<tr>
									<td>
										<font size="2">${c.coupon_use_date } 까지</font>
									</td>
								</tr>
							</table>
						</c:if>
							<hr width="800px">
					</c:forEach>
				</div>
			</c:if>
			
		</c:otherwise>
	</c:choose>
	
	



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>