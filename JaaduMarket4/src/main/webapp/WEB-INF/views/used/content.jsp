<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script src="${cpath}/resources/js/httpRequest.js"></script>

<%@ include file="/WEB-INF/views/used/menu_head.jsp"%>

<script type="text/javascript">
	function boostThis() {
		var u_seq = document.getElementById("u_seq").value;
		var param = "u_seq=" + u_seq;
		var url = "${pageContext.request.contextPath}/used/boost/check";

		sendRequest(url, param, function() {
			if (xhr.readyState ===4 && xhr.status === 200) {
				var data = xhr.responseText;
				var boostButton = document.getElementById("boost");

				if (data == 'true') {
					alert("※끌올은 1일 1회 제한됩니다.");
					return;
				} else {
					boost();
				}
			}
		}, "POST");
	}

	function favIt() {
		var likeButton = document.getElementById("like");
		var url = null;
		if (likeButton.value === '♡') {
			url = "${pageContext.request.contextPath}/used/fav/add";
		} else {
			url = "${pageContext.request.contextPath}/used/fav/del";
		}
		var u_seq = document.getElementById("u_seq").value;
		var param = "u_seq=" + u_seq;

		sendRequest(url, param, function() {
			if (xhr.readyState === 4 && xhr.status === 200) {
				var data = xhr.responseText;
				var like = likeButton.value;
				console.log("실행??");
				likeButton.value = '';
				if (data == 'true' && like === '♡') {
					likeButton.value = '♥';
				} else if (data != 'true' && like === '♡') {
					likeButton.value = '♡';
				} else if (data == 'true' && like === '♥') {
					likeButton.value = '♡';
				} else {
					likeButton.value = '♥';
				}

				var u_seq = document.getElementById("u_seq").value;
				var param = "u_seq=" + u_seq;
				var url = "${pageContext.request.contextPath}/used/fav/count";

				sendRequest(url, param, function() {
					if (xhr.readyState === 4 && xhr.status === 200) {
						var data = xhr.responseText;
						var favCount = document.getElementById("favCount");

						favCount.innerText = data;
					}
				}, "POST");
			}
		}, "POST");
	}

	function sellThis() {
		var sellTitle = document.getElementById("selling");
		var confirmation = confirm("판매를 완료하시겠습니까?\r\n\r\n※구매자가 있을 경우 채팅방에서 판매완료 버튼을 눌러주세요.\r\n(구매자가 있을 경우 내역 저장 및 평가 가능)");

		if (confirmation) {
			var url = "${pageContext.request.contextPath}/used/sell";
			var u_seq = document.getElementById("u_seq").value;
			var param = "u_seq=" + u_seq;

			sendRequest(url, param, resultSell, "POST");
		}
	}

	function resultSell() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var sellTitle = document.getElementById("selling");

			sellTitle.innerText = '';
			if (data == 'true') {
				sellTitle.innerText = '거래완료  ';
				sellTitle.style.cssText = "font-weight: bold; color: darkgray; font-size: 15px;";

				// 판매종료 버튼 숨기기
				const sellButton = document.getElementById("sellButton");
				sellButton.style.display = "none";
				const updateButton = document.getElementById("updateButton");
				updateButton.style.display = "none";
				const boostButton = document.getElementById("boostButton");
				boostButton.style.display = "none";
			}
		}
	}

	function boost() {
		var confirmation = confirm("해당 게시물을 최신으로 끌어올리시겠습니까?");

		if (confirmation) {
			var u_seq = document.getElementById("u_seq").value;
			var param = "u_seq=" + u_seq;
			var url = "${pageContext.request.contextPath}/used/boost";

			sendRequest(url, param, function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							var boostButton = document.getElementById("boostDate");
							var data = xhr.responseText;

							if (data == 'true') {
								alert("끌올 성공!^^");
								var boostCount = document.getElementById("boostCount");
								var boostDate = document.getElementById("boostDate");
								var realBoostDate = document.getElementById("realBoostDate");

								var today = new Date();
								var year = today.getFullYear();
								var month = String(today.getMonth() + 1).padStart(2, '0');
								var day = String(today.getDate()).padStart(2,'0');

								var now = year + '-' + month + '-' + day;

								if (boostCount == null) {
									var today = new Date();
									var year = today.getFullYear();
									var month = String(today.getMonth() + 1).padStart(2, '0');
									var day = String(today.getDate()).padStart(2, '0');

									boostDate.innerText = "끌올 1회 / " + now;
								} else {
									boostCount.innerText = parseInt(boostCount.innerText)+ '1';
									realBoostDate.innerText = now;
								}

							} else {
								alert("끌올 실패!ㅜㅜ");
							}
						}
					}, "POST");
		}
	}
</script>

<style>
* {
	font-family: "malgun gothic";
}

.used-body {
	margin-left: 180px;
}

#content-img {
	width: 800px;
	height: 500px;
}

#content-img img {
	width: 300px;
	height: 500px;
	box-sizing: border-box;
	border-radius: 12px;
	border: 1px solid lightgray;
}

.content {
	min-height: 600px;
	width: 1100px;
	margin-left: 10px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin-top: 10px;
}

.content div, h3 {
	margin: 10px;
}

.content a {
	flex-basis: calc(30% - 20px);
	margin: 10px;
	text-decoration: none;
	height: 500px;
}

img.d-block.w-100 {
	width: 300px;
	height: 500px;
	box-sizing: border-box;
	border-radius: 12px;
	border: 1px solid lightgray;
	z-index:1;
}

.content img {
	width: 300px;
	height: 300px;
	box-sizing: border-box;
	border-radius: 12px;
	border: 1px solid lightgray;
}

table, td, th {
	border-color: white;
	margin: 20px;
}

table {
	border-bottom-color: lightgray;
}

.profile table th img {
	border-color: 5px solid lightgray;
	width: 100%;
	height: 100%;
	border-radius: 100px;
}

progress {
	-webkit-appearance: none;
	border-radius: 15px;
}

::-webkit-progress-bar {
	background-color: lightgrey;
}

::-webkit-progress-value {
	background-color: red;
}

.detail {
	margin-top: 50px;
	width: 750px;
	min-height: 600px;
}

.cate-date {
	margin: 20px 0px;
	display: flex;
	flex-direction: row;
}

.textarea {
	padding:30px 10px 10px;
	min-height: 200px;
	display: flex;
	align-content: center;
	align-items: center;
	font-size: 20px;
}

.price {
	margin: 10px 0px;
}

.area {
	margin: 30px 0px;
}

.button {
	margin: 50px 0px;
	display: flex;
	font-weight: bold;
	width: 700px;
}

.other-content {
	width: 1000px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.other-content a {
	width: 200px;
	color: darkgray;
}

.carousel-control-prev:hover,
.carousel-control-next:hover {
	background-color: transparent;
	border-color: transparent;
}

/* 외부css 참조로 인해 꺠지므로 한번 더 추가 */
.used-banner {
	background-color: #FECCBE;
	width: 1244px;
	height:114px;
	padding: 10px;
}

.used-banner form {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	align-content: center;
	align-items: center;
	height:51.33px;
	font: 16px "malgun gothic";
}

h1 {
    display: block;
	margin: 0px;
    height:42.67px;
	font-size:32px;
	font-weight:bold;
}

h3 {
	font-size: 18.72px;
	font-weight: bold;
}

h2 {
	font-weight :bold;
}

ul {
	margin:0px;
	padding:0px;
}

.used-banner form select {
    width:95.33px;
    height:27.07px;
	font: 13.3333px "Arial";
    margin:10px;
    padding:5px;
}

button {
    background-color: #f2f2f2;
    color: #333;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    margin: 5px;
    font-size: 16px;
    cursor: pointer;
}


</style>

<div>
	<input type="hidden" id="u_seq" value="${vo.u_seq }"> 
	<input type="hidden" id="m_seq" value="${login }"> 
	<input type="hidden" id="u_trade_status" value="${vo.u_trade_status }">

	<article id="content-img">
		<c:if test="${flist == null }">
			<img src="${cpath}/resources/used/no-image.png" >
		</c:if>
		
		<c:if test="${flist !=null }">
			<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-inner">
					<c:forEach var="filename" items="${flist }" varStatus="i">
						<c:if test="${i.index ==0}">
							<div class="carousel-item active">
								<img src="${cpath}/resources/used/${vo.u_seq}/${filename }" class="d-block w-100" alt="..." >
							</div>
						</c:if>
						
						<c:if test="${i.index >0}">
							<div class="carousel-item">
								<img src="${cpath}/resources/used/${vo.u_seq}/${filename }" class="d-block w-100" alt="...">
							</div>
						</c:if>
					</c:forEach>
				</div> 
				
				<c:set var="lastIndex" value="${flist.size() - 1}" />
				
				<c:if test="${lastIndex != 0 }">
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleControls" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true" style="font-weight: bold; font-size: 20px;"></span>
					</button>
				
				
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleControls" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true" style="font-weight: bold; font-size: 20px;"></span>
					</button>
				</c:if>
			</div>
		</c:if>
	</article>

	<div class="profile">
		<a href="${cpath }/seller/page?seller=${vo.m_seq}">
			<table width="750px" height="100px" padding="10px">
				<tr>
					<th rowspan="2" width="100px"><img src="${cpath }/resources/member/${vo.m_img }"></th>
					<th align="left" width="600px">&nbsp;&nbsp;${vo.m_nickname }</th>
					<td align="right">${vo.manners_degree_sum }&#8451;</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;${vo.addr3_name }</td>
					<td><progress id="progress" value="${vo.manners_degree_sum }" min="0" max="100"></progress></td>
				</tr>
			</table>
		</a>
	</div>
	<hr>
	<div class="detail">
		<span id="selling" style="font-weight: bold; color: lightgray;">
			<c:if test="${vo.u_trade_status ==1 }">거래완료</c:if>
		</span>
		<h1>${vo.u_title }</h1>

		<div class="cate-date">
			<a href="${cpath }/used/${ vo.u_cate_seq}">${vo.u_cate_name }</a>
			<div>
				<c:if test="${vo.u_boost_count != 0 }">
						끌올&nbsp;<span id="boostCount">${vo.u_boost_count }</span>회&nbsp;<span
						id="realBoostDate">.&nbsp;${vo.u_boost}</span>
				</c:if>
				<c:if test="${vo.u_boost_count == 0 }">
					<span id="boostDate">${vo.u_date }</span>
				</c:if>
			</div>
		</div>

		<div class="price">
			<h2>
				<c:if test="${vo.u_share == '1' }">
					<span style="color: #D25A5A;">♥나눔♥</span>
				</c:if>
				<c:if test="${vo.u_share != '1' }">
					<fmt:formatNumber value="${vo.u_price}" pattern="#,##0" />원
				</c:if>
			</h2>
		</div>

		<div class="textarea">${vo.u_content }</div>

		<div>
			<b> 
				<c:if test="${vo.u_cate_name != null}">
					<c:if test="${vo.u_cate_seq==2}">
						<br>&nbsp;사용 나이&nbsp;&nbsp; 
		    		</c:if>
					<c:if test="${vo.u_cate_seq==3}">
						<br>&nbsp;사이즈&nbsp;&nbsp; 
		    		</c:if>
					<c:if test="${vo.u_cate_seq==9}">
						<br>&nbsp;장르&nbsp;&nbsp; 
		    		</c:if>
	    			${vo.cate_check_name }
    			</c:if> 
    			<c:if test="${vo.cate_input !=null }">
					<br>&nbsp;브랜드&nbsp;&nbsp;${vo.cate_input } 
    			</c:if>
			</b>
		</div>

		<div class="area">
			<b> <c:if test="${vo.u_addr_main != null }"> 
					거래희망장소 : <span id="u_addr">${vo.u_addr_main }</span>
					<c:if test="${vo.u_addr_sub !=null }">
						&nbsp;(${vo.u_addr_sub })
			    	</c:if>
					<div id="map" style="width: 100%; height: 350px;"></div>
						*지도상의 위치는 불명확할 수 있으니 판매자에게 질의하시기바랍니다.*
		    	</c:if>
			</b>
		</div>

		<div>
			조회&nbsp;${vo.u_views }
			<c:if test="${favCount!=null }">
    			/ 관심&nbsp;<span id="favCount">${favCount}</span>
			</c:if>
			/ 채팅&nbsp;${chat }
		</div>
	</div>
	<hr>
</div>

<div class="button">
	<c:if test="${login == null }">
		구매, 채팅 등은 로그인/회원가입 후 가능합니다 >> <a href="${cpath }/login/loginform">로그인/회원가입</a>
	</c:if>
	
	<c:if test="${login !=null }">
		<input type="button" onclick="javascript:favIt()" id="like" style="color: red; font-size: 30px;" value=${check? '♥︎': '♡'}>
		<c:if test="${vo.m_seq != login}">
			<input type='button' value="채팅" onclick="window.open('${cpath}/chat/${vo.u_seq }?m_seq=${login }','채팅하기',
			'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
		</c:if>
		<c:if test="${vo.m_seq == login }">
			<input type='button' value="채팅&nbsp;${chat }" onclick="window.open('${cpath}/chatList/${vo.u_seq }','채팅하기',
			'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
		</c:if>
	</c:if>
	
	<c:if test="${vo.m_seq == login}">
		<c:if test="${vo.u_trade_status!=1 }">
			<input type="button" value="수정하기" onclick="location.href='${cpath}/used/updateform?u_seq=${vo.u_seq }'" id="updateButton" style="display: block">
			<input type="button" value="끌어올리기" onclick="boostThis()" id="boostButton" style="display: block">
			<input type="button" value="판매완료" onclick="sellThis()" id="sellButton" style="display: block">
		</c:if>
		<input type="button" value="삭제하기"onclick="location.href='${cpath}/used/delete/${vo.u_seq }'">
	</c:if>
</div>

<c:if test="${ulist != null }">
	<hr>
	<div class="other-content">
		<h2 style="margin-right: auto;">* ${vo.m_nickname }님의 다른 게시물</h2>
		<h4 style="margin-left: auto; font-size:16px; font-weight:bold;">
			<a href="${cpath }/seller/sell/${vo.m_seq}">판매자의 게시물 더보기</a>
		</h4>
		<!-- 오른쪽에 배치 -->
	</div>
	
	<div class="content">
		<c:forEach var="uvo" items="${ulist }" varStatus="loop">
			<a href="${cpath }/used/content?u_seq=${uvo.u_seq }">
				<div>
					<c:if test="${uvo.u_img_name == null }">
						<img src="${cpath }/resources/used/no-image.png">
					</c:if>
					<c:if test="${uvo.u_img_name != null }">
						<img src="${cpath }/resources/used/${uvo.u_seq}/${uvo.u_img_name }">
					</c:if>
				</div>
				
				<h3>${uvo.u_title }</h3>
				<div>${uvo.addr1_name }&nbsp;${uvo.addr2_name }&nbsp;${uvo.addr3_name }</div>

				<div>
					<c:if test="${uvo.u_trade_status=='1' }">
						<span style="color: #f00;" align="center"><b>거래완료!</b></span>
					</c:if>
					<c:if test="${uvo.u_trade_status=='2' }">
						<span style="color: #00f;" align="center"><b>☆예약중☆</span>
					</c:if>
					<c:if test="${uvo.u_share == '1' }">
						<span style="color: #D25A5A;">♥나눔♥</span>
					</c:if>
					<c:if test="${uvo.u_share != '1' }">
						<span><fmt:formatNumber value="${uvo.u_price}" pattern="#,##0" />원</span>
					</c:if>
				</div>
				
				<div class="counts">
					<span>관심&nbsp;${uvo.fav_count}&nbsp;</span>&nbsp;∙&nbsp;<span>채팅&nbsp;${uvo.chat}&nbsp</span>
				</div>
				
				<div>
					<c:if test="${vo.u_boost_count != 0}"> 끌올 ${vo.u_boost_count }회 / ${vo.u_boost } </c:if>
					<c:if test="${vo.u_boost_count == 0}"> ${vo.u_date } </c:if>
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<script>
	kakao.maps.load(function() {
				// v3가 모두 로드된 후, 이 콜백 함수가 실행됩니다.
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level : 3
				// 지도의 확대 레벨
				};

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption);

				var addr = document.getElementById("u_addr").innerHTML;

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr,function(result, status) {

									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});

										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : '<div style="width:150px;text-align:center;padding:6px 0;">거래 희망 장소</div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			});

	function noChat() {
		alert('대화중인 채팅방이 존재하지 않습니다.');
	}

	document.getElementById("chatButton").addEventListener("click", noChat);
</script>
<%@ include file="/WEB-INF/views/used/menu_foot.jsp"%>
