<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

	<div align="center" width="800px">
		<c:if test="${vo.coupon_limit_num != 0}">
			<table width="600px" style="background-color: #FFF3F6">
				<tr align="left">
					<td width="85%">
						<c:if test="${vo.coupon_act == 0 }">
								<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중</font>
							</c:if>
							<c:if test="${vo.coupon_act == 1 }">
								<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
							</c:if>
						<font size="2" color="#BE3455">남은 쿠폰: ${vo.coupon_limit_num }</font>
					</td>
					<c:choose>
						<c:when test="${vo.regular_status == 1}">
							<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${vo.coupon_seq }'">
						</c:when>
						<c:otherwise>
							<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${vo.coupon_seq }'">
						</c:otherwise>
					</c:choose>
							쿠폰 수정
						</td>
				</tr>
				<tr>
					<td>
						<font size="4"><b>${vo.coupon_effect }</b></font>
					</td>
				</tr>
				<c:if test="${vo.regular_status == 1}">
					<tr>
						<td><font size="3">단골 전용</font></td>
					</tr>
				</c:if>
				<tr>
					<td>
						<font size="2">${vo.coupon_use_date } 까지</font>
					</td>
				</tr>
			</table>
			
		</c:if>
		
		<c:if test="${vo.coupon_limit_num == 0}">
			<table width="600px" style="background-color: #FFF3F6">
				<tr align="left">
					<td>
						<c:if test="${vo.coupon_act == 0 }">
							<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%; background-size: 120%">발급중</font>
						</c:if>
						<c:if test="${vo.coupon_act == 1 }">
							<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
						</c:if>
					</td>
					<c:choose>
						<c:when test="${vo.regular_status == 1}">
							<td rowspan="4" width="15%"  align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${vo.coupon_seq }'">
						</c:when>
						<c:otherwise>
							<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${vo.coupon_seq }'">
						</c:otherwise>
					</c:choose>
							쿠폰 수정
					</td>
				</tr>
				<tr>
					<td width="85%">
						<font size="4"><b>${vo.coupon_effect }</b></font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="2">${vo.coupon_use_date } 까지</font>
					</td>
				</tr>
			</table>
			
		</c:if>
	</div>
	<br>
	<div align="center" width="600px">
		<table width="600px">
			<tr align="left">
				<td>
					<p><b>쿠폰 이용안내</b></p>
				</td>
			</tr>
			<tr style="height: 10px;">
				<td>
					<c:if test="${vo.coupon_info == null}">
						&nbsp;쿠폰 조건 없음
					</c:if>
					<c:if test="${vo.coupon_info != null}">
						${vo.coupon_info }
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2" color=#A6A6A6>${vo.coupon_date } 생성</font>
				</td>
			</tr>
		</table>
	</div>
	<hr width="600px">
	
	<div align="center" width="600px">
		<table width="600px">
			<c:if test="${vo.coupon_limit_num != 0}">
				<tr align="left">
					<td width="85%">
						총 발급 수
					</td>
					<td width="15%" align="right">
						${vo.coupon_limit_num }장
					</td>
				</tr>
			</c:if>
			<!-- <tr align="left">
				<td width="85%">
					받은 쿠폰
				</td>
				<td width="15%" align="right">
					~~장
				</td>
			</tr>
			<tr align="left">
				<td width="85%">
					사용한 쿠폰
				</td>
				<td width="15%" align="right">
					~~장
				</td>
			</tr> -->
					
		</table>
	
	


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>