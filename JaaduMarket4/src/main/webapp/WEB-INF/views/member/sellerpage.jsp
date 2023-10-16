<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>
#content-img {
	width: 800px;
	height: 500px;
}

#content-img img {
	width: 100%;
	height: 100%;
	border-inline-color: lightgray;
	border-radius: 15px;
}

.content {
	min-height: 600px;
	width: 1100px;
	margin-left: 10px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin-top: 30px;
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

.content img {
	width: 300px;
	height: 300px;
	box-sizing: border-box;
	border-radius: 12px;
	border: 1px solid lightgray;
}

progress {
	-webkit-appearance: none;
}

::-webkit-progress-bar {
	background-color: lightgrey;
}

::-webkit-progress-value {
	background-color: red;
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
	margin-top: 100px;
}

.other-content a {
	width: 200px;
	color: darkgray;
}

.profile table th img {
	border-color: 5px solid lightgray;
	width: 100%;
	height: 100%;
	border-radius: 100px;
}

table, td, th {
	border-color: white;
	margin: 20px;
}

.button {
	display: flex;
	flex-direction: row;
	height: 20px;
}

.nick-id {
	display: flex;
	align-items: center;
}
</style>

<script type="text/javascript">

 function sellerSellList() {
    var content = document.getElementById("content");
    var button = document.getElementById("sellButton");
    if (content.style.display === "none") {
        content.style.display = "block";
        button.style.fontWeight = "bold";
    } else {
        content.style.display = "none";
        button.style.fontWeight = "normal";
    }
} 

function selectorAddOrDel(login, m_seq) {
    if (login == 1) {
        alert("<모아보기>는 회원만 가능합니다!\r\n\r\n로그인/회원가입 후 이용해주세요.");
        return;
    } else {
    	
    	var blockButton = document.getElementById("blockButton").value;
    	console.log(blockButton);
    	if(blockButton == '차단하기 해제'){
    		alert('<차단하기>와 <모아보기>는 동시에 할 수 없습니다!');
    		return
    	}
    	
        var collection = document.getElementById("collectionButton").value;
        var confirmation = '';
        
        if(collection ==='모아보기'){
        	confirmation = confirm("<모아보기>에 등록하시겠습니까?");
        }else{
        	confirmation = confirm("<모아보기>를 해제하시겠습니까?");
        }
        var url = '';
        
        if (confirmation) {
            if (collection === '모아보기') {
                url = "${pageContext.request.contextPath}/member/collection/add";
            } else {
                url = "${pageContext.request.contextPath}/member/collection/del";
            }
            var param = "seller=" + m_seq;
            
            sendRequest(url, param, resultCollection, "POST");
        }
    }
}

function resultCollection() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var data = xhr.responseText;
        var collection = document.getElementById("collectionButton").value;
        
        if (data == 'true') {
            if (collection === '모아보기') {
                alert("<모아보기>가 등록되었습니다.");
                collection = '모아보기 해제';
            } else {
                alert("<모아보기>가 해제되었습니다.");
                collection = '모아보기';
            }
            document.getElementById("collectionButton").value = collection;
        } else {
            if (collection === '모아보기') {
                alert("<모아보기> 등록에 실패했습니다.");
            } else {
                alert("<모아보기> 해제에 실패했습니다.");
            }
        }
    }
}

function blockAddOrDel(login, m_seq) {
    if (login == 1 ) {
        alert("<차단하기>는 회원만 가능합니다!\r\n\r\n로그인/회원가입 후 이용해주세요.");
        return;
    } else {
    	
    	var collectionButton = document.getElementById("collectionButton").value;
    	if(collectionButton == '모아보기 해제'){
    		alert('<모아보기>와 <차단하기>는 동시에 할 수 없습니다!');
    		return
    	}
    	
        var block = document.getElementById("blockButton").value;
        var confirmation = '';
        
        if(block ==='차단하기'){
        	confirmation = confirm("<차단하기>에 등록하시겠습니까?");
        }else{
        	confirmation = confirm("<차단하기>를 해제하시겠습니까?");
        }
        var url = '';
        
        if (confirmation) {
            if (block === '차단하기') {
                url = "${pageContext.request.contextPath}/member/block/add";
            } else {
                url = "${pageContext.request.contextPath}/member/block/del";
            }
            var param = "seller=" + m_seq;
            
            sendRequest(url, param, resultBlock, "POST");
        }
    }
}


function resultBlock() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var data = xhr.responseText;
        var block = document.getElementById("blockButton").value;
        
        if (data == 'true') {
            if (block === '차단하기') {
                alert("<차단하기>가 등록되었습니다.");
                block = '차단하기 해제';
            } else {
                alert("<차단하기>가 해제되었습니다.");
                block = '차단하기';
            }
            document.getElementById("blockButton").value = block;
        } else {
            if (block === '차단하기') {
                alert("모아보기 등록에 실패했습니다.");
            } else {
                alert("모아보기 해제에 실패했습니다.");
            }
        }
    }
}


</script>


<div id="seller-page">
	<div class="used-title">
		<input type="hidden" value="${login }" id="login"> <input
			type="hidden" value="${vo.m_seq }" id="seller">
		<h1>${vo.m_nickname }님의프로필</h1>
		<br>
		<hr>
	</div>

	<div class="profile">
		<table width="900px" height="100px" padding="10px">
			<tr>
				<th rowspan="2" width="100px"><img
					src="${cpath }/resources/member/${vo.m_img }"></th>
				<th class="nick-id" align="left" width="600px">&nbsp;&nbsp;
					<h3>${vo.m_nickname }</h3>#${vo.m_id }
				</th>
				<td align="right">${vo.manners_degree_sum }&#8451;</td>
			</tr>
			<tr>
				<td>${vo.email1 }@ ${vo.email2 }</td>
				<td align="right"><progress id="progress"
						value="${vo.manners_degree_sum }" min="0" max="100"></progress></td>
			</tr>
		</table>
	</div>

	<hr>
	<c:if test="${login != vo.m_seq }">
		<div class="button">
			<c:if test="${mlist ==null }">
				<input type="button" value="매너 평가하기"
					onclick="window.open('${cpath }/manner/default?seller=${vo.m_seq }','매너평가하기',
					'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
			</c:if>
			<c:if test="${mlist != null }">
				<input type="button" value="매너 수정하기"
					onclick="window.open('${cpath }/manner/default/updateform?seller=${vo.m_seq }','매너평가하기',
					'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
			</c:if>
			<input type="button" value="${collection == true ? '모아보기 해제' : '모아보기' }" onclick="selectorAddOrDel(${login==null? 1:0}, ${vo.m_seq })" id="collectionButton"> 
			<input type="button" value="${block == true ? '차단하기 해제' : '차단하기' }" onclick="blockAddOrDel(${login==null? 1:0}, ${vo.m_seq })" id="blockButton">
			<input type="button" value="받은 매너평가" onclick="window.open('${cpath}/manners/sellermanner?seller=${vo.m_seq }','나의 매너평가',
			'width = 550px, height=550px, top=300px, left=300px, scrollbars=yes')">
		</div>
		<span>※ 차단한 사용자의 게시물은 앞으로 보여지지 않습니다.</span>
		<br>
		<span>※ 페이지를 벗어나 모아보기 해제, 차단하기 해제를 원하는 경우 [MyPage]에서 가능합니다.</span>
	</c:if>
	
	<c:if test="${login == vo.m_seq }">
	  	* 해당 판매자가 나와 같은 경우 추가 기능이 제공되지 않습니다.
	  </c:if>
	<hr>
</div>

<div class="other-content">
	<h2 style="margin-right: auto;">* ${vo.m_nickname }님의 다른 게시물</h2>
	<h4 style="margin-left: auto;">
		<a href="${cpath }/seller/sell/${vo.m_seq}">판매내역 더보기</a>
	</h4>
</div>
	
<c:if test="${ulist != null }">
	<div class="content">
		<c:forEach var="uvo" items="${ulist }">
			<a href="${cpath }/used/content?u_seq=${vo.u_seq }">
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
					<span>관심&nbsp;${uvo.fav_count}&nbsp;</span>&nbsp;∙&nbsp;<span>채팅&nbsp;${uvo.chat}&nbsp;</span>
				</div>
				
				<div>
					<c:if test="${uvo.u_boost_count != 0}"> 끌올 ${uvo.u_boost_count }회 / ${uvo.u_boost }</c:if>
					<c:if test="${uvo.u_boost_count == 0}">${uvo.u_date }</c:if>
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<c:if test="${ulist ==null }">
	<b>판매 내역이 존재하지 않습니다.</b>
</c:if>
<hr>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
