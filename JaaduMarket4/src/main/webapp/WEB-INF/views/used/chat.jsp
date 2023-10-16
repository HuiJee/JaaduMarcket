
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chat</title>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
</head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/buttonInput.css">

<style>
.seller {
	font-size: 20px;
	font-weight: bold;
}

.seller span {
	font-size: 17px;
	font-weight: normal;
}

.used {
	display: flex;
	justify-content: center;
}

.used img {
	width: 70px;
	height: 70px;
	margin-right: 20px;
}

a {
	text-decoration: none;
	color: black;
	display: flex;
	width: 100%;
	height: 70px;
	align-items: center;
	align-self: center;
}

#chat-header {
	text-align: center;
}

#chat-header hr {
	width: 80%;
	margin: 10px auto;
	border: 0;
	border-top: 1px solid #ccc;
}

#chat-body {
	width: 600px;
	margin: 0 auto;
}

#chat-body span {
	display: block;
	margin-bottom: 10px;
}

#chat-body span.left {
	text-align: left;
}

#chat-body span.center {
	text-align: center;
}

#chat-body span.right {
	text-align: right;
}

#chat-footer {
	width: 600px;
	margin: 10px auto;
	text-align: center;
}

#chat-footer textarea {
	width: 100%;
	box-sizing: border-box;
	resize: none;
}

#chat-footer button {
	margin-top: 10px;
	text-align: right;
}

.button-container {
	display: flex;
	justify-content: center;
}

</style>

<body>

	<div id="chat-header">
		<div class="seller">
			${vo.m_nickname } <span>${vo.manners_degree_sum }&#8451;</span>
		</div>
		<hr>
		<div class="used">
			<a href="javascript:goContent(${vo.u_seq })" style="display: flex; align-items: center; justify-content: center;"> 
				<c:if test="${vo.u_img_name != null}">
					<img src="${cpath }/resources/used/${vo.u_seq}/${vo.u_img_name}">
				</c:if> 
				<c:if test="${vo.u_img_name == null }">
					<img src="${cpath }/resources/used/no-image.png">
				</c:if>
				<div>
					<b>${vo.u_title }</b>
					<br>
					<c:if test="${vo.u_share == '1' }">
						<span style="color: #D25A5A;">♥나눔♥</span>
					</c:if>
					<c:if test="${vo.u_share != '1' }">
						<span><fmt:formatNumber value="${vo.u_price}" pattern="#,##0" />원</span>
					</c:if>
				</div>
			</a>
		</div>
		<hr>
		
		<!-- 채팅 내용 있을 때 버튼 나타나기 : 안내문구 *채팅이 시작된 이후 거래가 가능합니다. / 물어보고 데이터 넘기기 -->
		<div>
			<c:if test="${vo.u_trade_status==0 && login==vo.m_seq}">
				<c:if test="${list != null }">	
					<!-- 기본적으로 생성하는 거래 버틍 -->
					<input type="button" onclick="return tradeCheck('noPay')" value="거래하기">
					<c:if test="${use == 2 }"><!-- 둘 다 자두페이가 있을 때만 생성하는 거래버튼 -->
						<input type="button" onclick="return tradeCheck('pay')" value="자두 페이 거래">
					</c:if>
				</c:if>
				<c:if test="${list == null }">
					<h5>* 채팅이 시작된 이후 거래가 가능합니다.</h5>
				</c:if>
			</c:if>
			
			
			<c:if test="${vo.u_trade_status == 1}">
				<h5>거래가 완료된 게시물입니다.</h5>
				<c:if test="${glist == null }">
					<c:if test="${login == buyer}">
						<input type="button" value="구매후기 남기기" onclick="location.href='${cpath}/manners?u_seq=${u_seq}'">
					</c:if>
					<c:if test="${login == vo.m_seq && m_seq == buyer}">
						<input type="button" value="판매후기 남기기" onclick="location.href='${cpath}/manners?receive=${buyer}&u_seq=${u_seq}'">
					</c:if>
				</c:if>

				<c:if test="${glist != null }">
					<c:if test="${login == buyer}">
						<input type="button" value="보낸 후기 보기" onclick="location.href='${cpath}/manners/give?u_seq=${u_seq}'">
					</c:if>
					<c:if test="${login == vo.m_seq && m_seq == buyer}">
						<input type="button" value="보낸 후기 보기" onclick="location.href='${cpath}/manners/give?receive=${buyer}&u_seq=${u_seq}'">
					</c:if>
				</c:if>
				<c:if test="${rlist != null }">
					<c:if test="${login == buyer}">
						<input type="button" value="받은 후기 보기" onclick="location.href='${cpath}/manners/receive?u_seq=${u_seq}'">
					</c:if>
					<c:if test="${login == vo.m_seq && m_seq == buyer}">
						<input type="button" value="받은 후기 보기" onclick="location.href='${cpath}/manners/receive?give=${buyer}&u_seq=${u_seq}'">
					</c:if>
				</c:if>
				<c:if test="${login==vo.m_seq && buyer==m_seq}">
					<input type="button" value="거래 취소" onclick="location.href='${cpath}/trade/delete?buyer=${buyer }&u_seq=${u_seq }'">
				</c:if>
			</c:if>
			
			
			<c:if test="${vo.u_trade_status == 3 }">
				<h5>${login==vo.m_seq? nickname : '' }예약중인거래입니다.</h5>
				<c:if test="${login==vo.m_seq }">
					<input type="button" value="예약 취소" onclick="location.href='${cpath}/chat/pay/noreserve?m_seq=${m_seq }&u_seq=${vo.u_seq }'">
				</c:if>
				<c:if test="${reserve!=0 && login!=vo.m_seq}">
					<input type="button" value="자두페이 결제" onclick="location.href='${cpath}/chat/pay?m_seq=${m_seq }&u_seq=${vo.u_seq }'">
				</c:if>
			</c:if>
		</div>
	</div>
	<hr>
	
	
	<div id="chat-body">
		<c:forEach var="vo" items="${list }">
			<c:if test="${login == vo.m_seq }">
				<span class="${vo.chat_who==0 ? 'right' : vo.chat_who==2 ? 'center' : 'left' }">${vo.chat_content }</span>
				<br>
			</c:if>
			<c:if test="${login != vo.m_seq }">
				<span class="${vo.chat_who==1 ? 'right' : vo.chat_who==2 ? 'center' : 'left' }">${vo.chat_content }</span>
				<br>
			</c:if>
		</c:forEach>
	</div>
	
	
	<div id="chat-footer">
		<form action="${cpath }/chat/insert/${login != vo.m_seq? 0:1}" onsubmit="return check(this)">
			<input type="hidden" id="m_seq" name="m_seq" value="${m_seq }">
			<input type="hidden" id="seller_seq" name="seller_seq" value="${vo.m_seq }"> <input type="hidden" id="u_seq" name="u_seq" value="${vo.u_seq }">
			<div style="display: flex;">
				<textarea name="chat_content" cols="50" rows="3"></textarea>
				<button type="submit" id="sendButton">전송</button>
			</div>
		</form>
	</div>


	<div class="button-container">
		<button type="button" id="exitButton">채팅 종료하기</button>
		<button type="button" onclick="location.href='${cpath}/chatList'">나의 채팅</button>
	</div>
</body>



<script type="text/javascript">
	function closePopupWindow() {
		window.close();
	}

	document.getElementById("exitButton").addEventListener("click",closePopupWindow);

	function tradeCheck(mode) {
		const m_seq = document.getElementById("m_seq").value;
		const u_seq = document.getElementById("u_seq").value;

		if (mode == 'noPay') {
			var confirmation = confirm("해당 회원과 별도로 거래하시겠습니까?\r\n자두 페이 사용을 원하는 경우 <자두 페이 거래>를 클릭하세요.");
			if (confirmation) {
				location.href = "${pageContext.request.contextPath}/used/trade?m_seq="+ m_seq + "&u_seq=" + u_seq;
				return true;
			} else {
				return false;
			}
		} else {
			var confirmation = confirm("자두페이로 거래하시겠습니까?\r\n구매자가 송금 후 거래가 완료됩니다.");
			if (confirmation) {
				location.href = "${pageContext.request.contextPath}/used/notrade?m_seq="+ m_seq + "&u_seq=" + u_seq;
				return true;
			} else {
				return false;
			}
		}
	}

	function goContent(u_seq) {
		window.opener.location.href = '${pageContext.request.contextPath }/used/content?u_seq='+ u_seq;
		window.close();
	}
</script>

</html>
