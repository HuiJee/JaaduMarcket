<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	#addr_detail, #hours{
		display: none; 
	}
	
	.outer{
		align : center;
	}
	
	.inner{
		width : 800px;
		align : left;
	
	}
	
	.title{
		background-color:#F7E7EA;
		border-radius: 5px;
	}
	
	#left{
		width: 90%;
		background-color:#F7E7EA;
		border-radius: 5px;
		float : left;
	}
	
	.right{
		background-color:#F7E7EA;
		border-radius: 5px;
		float : right;
	}
	
	#left2{
		width: 100%;
		background-color:#F7E7EA;
		border-radius: 5px;
		float : left;
	}

</style>

<script type="text/javascript">
	
	var display = true;
	
	function doDisplay(){
		
		var con = document.getElementById("addr_detail");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	function doDisplay2(){
		
		var con = document.getElementById("hours");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
</script>
<%@ include file="/WEB-INF/views/busi/busi_header.jsp"%>
	
	
<div class="outer" align="center">	
	<div class="inner" align="left">
		
		<div>
			<c:choose>
				<c:when test="${check == true }">
					<div class="title">
						<p id="left"><font size="4px"><b>정보</b></font></p><p class="right"><input type="button" value="정보 설정" onclick="location.href='${cpath}/busi/home/info?busi_seq=${busi_seq }'"></p>
					</div>
				</c:when>
				<c:otherwise>
					<div class="title">
						<p id="left2"><font size="4px"><b>정보</b></font></p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
			
		<br>
		<br>
			
		<div>
			<p>
				${vo.busi_information }
			</p>
		</div>
		
		<div>
			<input type="button" value="지도보기" onclick="location.href='${cpath}/busi/home/map?busi_name=${vo.busi_name }&addr=${addr }'">
		</div>
			
		
			
		<div>
			<p>
				<div>
					<a href="javascript:doDisplay();">${addr } ></a>
				</div>
				<div id="addr_detail">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상세주소: ${vo.busi_addr_detail }
				</div>
			</p>
		</div>
			
		<div>
			<div>
				<p>
					<a href="javascript:doDisplay2();">영업 시간 ></a>
				</p>
			</div>
			<div id="hours">
				<c:if test="${hoursList != null }">
					<c:forEach var="day" items="${dayList }" varStatus="status1">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ㆍ${day.day_name}
						<br>
							<c:forEach var="run" items="${runtypeList }" varStatus="status2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${run.runtype_name } - ${time[status1.index * 2 + status2.index]}
								<br>							
							</c:forEach>
							<br>
					</c:forEach>
				</c:if>
				<c:if test="${hoursList == null }">
				<font color=#A6A6A6 size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;영업시간을 설정해주세요.</font>
				</c:if>
			</div>
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=#A6A6A6 size="2">${vo.busi_details }</font>
			</div>
			<div>
				<p>
					<a href="http://${vo.busi_website }" target="_blank">${vo.busi_website }</a>
				</p>
			</div>
		</div>	
	
	
		<hr color="#B96475" size="3">
		
		<div>
			<table class="title" width="800px">
				<tr>
					<td align="left" width="90%">
						<font size="4"><b>소식</b></font>
					</td>
					<td align="right" width="10%">
						<a href="${cpath }/busi/notice/notice?busi_seq=${busi_seq }">더보기 ></a>
					</td>
				</tr>
			</table>
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

		<hr color="#B96475" size="3">
	
		<div>
			<table class="title" width="800px">
				<tr>
					<td align="left" width="90%">
						<font size="4"><b>상품</b></font>
					</td>
					<td align="right" width="10%">
						<a href="${cpath }/busi/product/product?busi_seq=${busi_seq }">더보기 ></a>
					</td>
				</tr>
			</table>
			<p>
				<table cellspacing="10px">
					<c:forEach var="pro" items="${productList }">
						<tr>
							<td rowspan="2" valign="top" width="15%" align="left">
								<img src="${cpath }/resources/busi/product/${pro.product_img}" height="100px" width="120px">
							</td>
							<td valign="top" width="45%">
								<a href="${cpath }/busi/product/selectProduct?product_seq=${pro.product_seq }&busi_seq=${busi_seq}"><b>${pro.product_name }</b></a>
							</td>
							<td valign="top" align="right" width="40%">
								------------------------------ ${pro.product_price } 원
							</td>
						</tr>
						<tr>
							<td valign="top" width="45%">
								${pro.product_info }
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
				
					</c:forEach>
				</table>
			</p>
		</div>
		
		<hr color="#B96475" size="3">
		
		<div>
			<table class="title" width="800px">
				<tr>
					<td align="left" width="90%">
						<font size="4"><b>쿠폰</b></font>
					</td>
					<td align="right" width="10%">
						<a href="${cpath }/busi/coupon/coupon?busi_seq=${busi_seq }">더보기 ></a>
					</td>
				</tr>
			</table>
			<p>
				<c:if test="${availableCouponList != null }">
					<div align="center" width="800px">
				
						<c:forEach var="c" items="${availableCouponList }">
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
											<c:when test="${check == true }">
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
											</c:when>
											
											<c:otherwise>
												<c:choose>
													<c:when test="${c.regular_status == 1}">
														<c:choose>
															<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																<td rowspan="4" width="15%" align="center">
															</c:when>
															<c:otherwise>
																<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																<td rowspan="3" width="15%" align="center">
															</c:when>
															<c:otherwise>
																<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
														발급 완료
													</c:when>
													<c:otherwise>
														↓쿠폰 받기
													</c:otherwise>
												</c:choose>
													</td>
												</tr>
											</c:otherwise>
										</c:choose>
										
										
										
									<c:choose>
										<c:when test="${check == true }">
											<tr>
												<td>
													<font size="4"><b>${c.coupon_effect }</b></font>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>
													<a onclick="location.href='${cpath}/busi/coupon/detailCoupon?coupon_seq=${c.coupon_seq}&busi_seq=${busi_seq }'"><font size="4"><b>${c.coupon_effect }</b></font></a>
												</td>
											</tr>
										</c:otherwise>
									</c:choose>	
										
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
								<%-- <table width="600px" cellspacing="10">
									<tr align="center">
										<td>
											<input type="button" value="소식에 첨부하기">
										</td>
										<td>
											<input type="button" value="상세보기" onclick="location.href='${cpath}/busi/coupon/selectCoupon?coupon_seq=${c.coupon_seq}'">
										</td>
									</tr>
								</table> --%>
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
											<c:when test="${check == true }">
													<c:choose>
														<c:when test="${c.regular_status == 1}">
															<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
														</c:when>
														<c:otherwise>
															<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponUpdate?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
														</c:otherwise>
													</c:choose>
														쿠폰 수정
														<%-- <c:choose>
															<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																발급 완료
															</c:when>
															<c:otherwise>
																↓쿠폰 받기
															</c:otherwise>
														</c:choose> --%>
														</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:choose>
														<c:when test="${c.regular_status == 1}">
															<c:choose>
																<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																	<td rowspan="4" width="15%" align="center">
																</c:when>
																<c:otherwise>
																	<td rowspan="4" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
																</c:otherwise>
															</c:choose>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																	<td rowspan="3" width="15%" align="center">
																</c:when>
																<c:otherwise>
																	<td rowspan="3" width="15%" align="center" onclick="location.href='${cpath}/busi/coupon/couponDown?busi_seq=${busi_seq }&coupon_seq=${c.coupon_seq }'">
																
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
														<c:choose>
															<c:when test="${cdvo2.m_seq == m_seq && cdvo2.coupon_seq == c.coupon_seq }">
																발급 완료
															</c:when>
															<c:otherwise>
																↓쿠폰 받기
															</c:otherwise>
														</c:choose>
														</td>
												</tr>
											</c:otherwise>
										</c:choose>
									<c:choose>
										<c:when test="${check == true }">
											<tr>
												<td>
													<font size="4"><b>${c.coupon_effect }</b></font>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>
													<a onclick="location.href='${cpath}/busi/coupon/detailCoupon?coupon_seq=${c.coupon_seq}&busi_seq=${busi_seq }'"><font size="4"><b>${c.coupon_effect }</b></font></a>
												</td>
											</tr>
										</c:otherwise>
									</c:choose>	
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
								<%-- <table width="600px" cellspacing="10">
									<tr align="center">
										<td>
											<input type="button" value="소식에 첨부하기">
										</td>
										<td>
											<input type="button" value="상세보기" onclick="location.href='${cpath}/busi/coupon/selectCoupon?coupon_seq=${c.coupon_seq}'">
										</td>
									</tr>
								</table> --%>
							</c:if>
								<hr width="800px">
						</c:forEach>
					</div>
				</c:if>
			
			
			
			
			
			
		</div>
	
	
	
	
	
	
	</div>
</div>	



    
  
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>