<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>
.content {
 	min-height: 1000px;
	width: 1100px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin-top: 10px;
	margin-botton: 10px;
}

.used-list-rest {
	display: flex;
	flex-direction: column;
}

.paging {
	display: flex;
	align-content: center;
	justify-content: center;
	margin: 30px;
}

.content div, h3 {
	margin: 10px;
}

.content a {
	flex-basis: calc(30% - 20px);
	margin: 10px;
	text-decoration: none;
}

.content img {
	width: 300px;
	height: 300px;
	box-sizing: border-box;
	border-radius: 12px;
	border: 1px solid lightgray;
}

.listnulltext {
	margin-top: 300px;
	margin-left: 400px;
	height: 30px;
}

.paging {
	width:1100px;
	display: flex;
	align-content: center;
	align-items: center;
	justify-content: center;
}
</style>

<div class="used-title">
	<h1>${msg }</h1>
	<hr>
</div>

<c:if test="${mode eq 'collection' }">
	<div style="display: flex; flex-direction: row; border: 1px solid black; width: 800px; justify-content: center;">
		<c:forEach var="mvo" items="${mlist }">
			<a href="${cpath }/seller/page?seller=${mvo.m_seq}">
				<div style="padding: 10px;">
					<!-- 가로로 정렬 -->
					<!-- 추후에 경로 member로 바꾸기 -->
					<c:if test="${mvo.m_img == null }">
						<img src="${cpath }/resources/member/no-imgage.png">
					</c:if>
					<c:if test="${mvo.m_img != null }">
						<img src="${cpath }/resources/member/${mvo.m_img }" width="50px" height="50px">
					</c:if>
					<br> ${mvo.m_nickname }
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<div class="list">
	<div class="content">
		<c:if test="${ulist != null }">
			<c:forEach var="vo" items="${ulist }" varStatus="loop">
				<a href="${cpath }/used/content?u_seq=${vo.u_seq }">
					<div>
						<c:if test="${vo.u_img_name == null }">
							<img src="${cpath }/resources/used/no-image.png">
						</c:if>
						<c:if test="${vo.u_img_name != null }">
							<img src="${cpath }/resources/used/${vo.u_seq}/${vo.u_img_name }">
						</c:if>
					</div>
					<h3>${vo.u_title }</h3>
					<div>${vo.addr1_name }&nbsp;${vo.addr2_name }&nbsp;${vo.addr3_name }</div>

					<div>
						<c:if test="${vo.u_trade_status=='1' }">
							<span style="color: #f00;" align="center"><b>거래완료!</b></span>
						</c:if>
						<c:if test="${vo.u_trade_status=='2' }">
							<span style="color: #00f;" align="center"><b>☆예약중☆</span>
						</c:if>
						<c:if test="${vo.u_share == '1' }">
							<span style="color: #D25A5A;">♥나눔♥</span>
						</c:if>
						<c:if test="${vo.u_share != '1' }">
							<span><fmt:formatNumber value="${vo.u_price}" pattern="#,##0" />원</span>
						</c:if>
					</div>
					<div class="card-counts">
						<span>관심&nbsp;${vo.fav_count}&nbsp;</span>&nbsp;∙&nbsp;<span>채팅&nbsp;${vo.chat}&nbsp</span>
					</div>
					<div>
						<c:if test="${vo.u_boost_count != 0}">
							끌올 ${vo.u_boost_count }회 / ${vo.u_boost }
						</c:if>
						<c:if test="${vo.u_boost_count == 0}">
							${vo.u_date }
						</c:if>
					</div>
				</a>
			</c:forEach>
		</c:if>
		<c:if test="${ulist == null }">
			<h2 class="listnulltext">게시물이 존재하지 않습니다.</h2>
		</c:if>
	</div>
	
	<c:if test="${u_cate_seq != 0 && ulist !=null}">
		<div align="center" class="paging">
			<c:if test="${paging.prev }">
				<a href="${cpath }${url }?page=${paging.begin - 1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
				<c:choose>
					<c:when test="${i == paging.page }">
						<strong>[${i}]</strong>
					</c:when>
					<c:otherwise>
						<a href="${cpath }${url }?page=${i}" style="width:20.37px;">[${i}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next }">
				<a href="${cpath }${url }?page=${paging.end + 1}">[다음]</a>
			</c:if>
		</div>
	</c:if>
</div>
<input type="button" value="MyPage"
	onclick="location.href='${cpath}/member/mypage'">

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
