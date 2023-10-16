<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


</div>
<div id="footer">
	<div id="footer-area1">
		<a href="${cpath }/used">중고거래</a> | <a href="${cpath }/views/makeBusi">동네가게</a>
		| <a href="${cpath }/jobs/list">알바</a> | <a href="${cpath }/board/list">자유게시판</a> | <a href="${cpath }/intro">자두마켓이란?</a>
	</div>
	<div id="footer-area2">
		<b>대표 </b> 구현지, 원희지, 이새미, 장단비 | <b>사업자번호 </b>123-87-45678 <br> <b>주소
		</b>서울특별시 강남구 테헤란로 146 H호 (자두마켓) <br> <b>전화 </b>1544-1234 | <b>고객문의
		</b>cs@jaaduservice.com
	</div>
</div>
</body>

<script type="text/javascript">
function logoutButton() {
	
		  // 팝업 창이 열려있는지 확인
		  if (window.opener && !window.opener.closed) {
		    // 팝업 창이 열려있으면 닫기
		    window.opener.close();
		  }
		  // 메인 페이지로 이동
		  window.location.href = '${pageContext.request.contextPath }/login/logout';
  }
</script>
</html>