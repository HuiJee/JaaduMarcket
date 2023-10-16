<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<style>
	.busi_img{
		border-radius: 100%;
		object-fit : cover;
	}

</style>


<div align="center" width="800px">
	<table width="800px" >
		<tr align="left">
			<td rowspan="2" width="9%">
				<img class="busi_img" width="60px" height="60px" src="${cpath }/resources/busiProfileImg/${bvo.busi_img }" onclick="location.href='${cpath}/busi/myBusi?busi_seq=${bvo.busi_seq }'">
			</td>
			<td width="76%">
				<font size="3"><b>${bvo.busi_name }</b></font>
			</td>
			
			<c:choose>
				<c:when test="${isRegular == 1 }">
					<td rowspan="2" width="15%" align="right">
						<input type="button" value="-단골끊기" onclick="location.href='${cpath}/busi/quitRegular2?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</td>
				</c:when>
				<c:otherwise>
					<td rowspan="2" width="15%" align="right">
						<input type="button" value="+단골맺기" onclick="location.href='${cpath}/busi/beRegular2?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>
				<font color=#A6A6A6 size="2">${addr3_name } | 단골 ${countRegular }</font>
			</td>
		</tr>
	</table>
</div>
<br>

<div align="center" width="800px">
	<c:if test="${cvo.coupon_limit_num != 0}">
		<table width="800px" style="background-color: #FFF3F6">
			<tr align="left">
				<td width="85%">
					<c:if test="${cvo.coupon_act == 0 }">
							<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중</font>
						</c:if>
						<c:if test="${cvo.coupon_act == 1 }">
							<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
						</c:if>
					<font size="2" color="#BE3455">남은 쿠폰: ${cvo.coupon_limit_num }</font>
				</td>
				<c:choose>
					<c:when test="${cvo.regular_status == 1}">
						<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</c:when>
					<c:otherwise>
						<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</c:otherwise>
				</c:choose>
						↓쿠폰 받기
					</td>
			</tr>
			<tr>
				<td>
					<font size="4"><b>${cvo.coupon_effect }</b></font>
				</td>
			</tr>
			<c:if test="${cvo.regular_status == 1}">
				<tr>
					<td><font size="3">단골 전용</font></td>
				</tr>
			</c:if>
			<tr>
				<td>
					<font size="2">${cvo.coupon_use_date } 까지</font>
				</td>
			</tr>
		</table>
		
	</c:if>
	
	<c:if test="${cvo.coupon_limit_num == 0}">
		<table width="800px" style="background-color: #FFF3F6">
			<tr align="left">
				<td>
					<c:if test="${cvo.coupon_act == 0 }">
						<font size="2" style="background-color: #EC7F99; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%; background-size: 120%">발급중</font>
					</c:if>
					<c:if test="${cvo.coupon_act == 1 }">
						<font size="2" style="background-color: #D0D0D0; border-bottom-left-radius: 15%; border-bottom-right-radius: 15%; border-top-left-radius: 15%; border-top-right-radius: 15%;">발급중단</font>
					</c:if>
				</td>
				<c:choose>
					<c:when test="${cvo.regular_status == 1}">
						<td rowspan="4" width="15%"  align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</c:when>
					<c:otherwise>
						<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${bvo.busi_seq }&coupon_seq=${cvo.coupon_seq }'">
					</c:otherwise>
				</c:choose>
						↓쿠폰 받기
				</td>
			</tr>
			<tr>
				<td width="85%">
					<font size="4"><b>${cvo.coupon_effect }</b></font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">${cvo.coupon_use_date } 까지</font>
				</td>
			</tr>
		</table>
		
	</c:if>
</div>
<br>
<div align="center" width="800px">
	<table width="800px">
		<tr align="left">
			<td>
				<p><b>쿠폰 이용안내</b></p>
			</td>
		</tr>
		<tr style="height: 10px;">
			<td>
				<c:if test="${cvo.coupon_info == null}">
					&nbsp;쿠폰 조건 없음
				</c:if>
				<c:if test="${cvo.coupon_info != null}">
					${cvo.coupon_info }
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<font size="2" color=#A6A6A6>${cvo.coupon_date } 생성</font>
			</td>
		</tr>
	</table>
</div>

<hr width="800px">

<div align="center" width="800px">
	<table width="800px">
		<tr align="left">
			<td>
				<p><b>찾아가는 길</b></p>
			</td>
		</tr>
		<tr>
			<td>
				${addr }
				<br>
				${bvo.busi_addr_detail }
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="지도보기" onclick="location.href='${cpath}/busi/home/map?busi_name=${bvo.busi_name }&addr=${addr }'">
			</td>
		</tr>
	</table>
</div>









<%@ include file="/WEB-INF/views/layout/footer.jsp"%>