<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>

#intro {
	width: 1000px;
	height: 100%;
	padding: 30px;
	display: flex;
	flex-direction: column;
	align-self: center;
	align-items: center;
}

#intro img {
	width:100%;
	padding: 50px 0px 50px 0px;
	align-self: center;
}

#intro-sub {
	display: flex;
	flex-direction: row;
	padding: 100px 0px 0px 0px;
	justify-content: center;
	align-items: center;
}

#intro-sub .info {
	width: 100%;
	padding: 60px 0px 0px 60px;
}

.info {
	display: flex;
	align-items: center;
	justify-content: center;
}

#intro-home {
	padding: 100px;
	display: flex;
	align-self: center;
	align-content: center;
	flex-direction: column;
}

#intro-home-sub {
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 50px;
	flex-direction: column;
}

#intro-home-sub a {
	width: 100%;
	display: flex;
	justify-content: center;
	padding-bottom: 15px;
}
</style>

<script type="text/javascript">
function notReady() {
  alert("현재 준비중인 페이지입니다. \r\n\r\n빠른 시일 내에 선보이겠습니다!");
}
</script>
<link type="text/css" rel="stylesheet"
	href="${cpath }/resources/css/intro.css">
<div id="intro">
	<h1>이웃과 더 가까워지는 따뜻한 동네를 만들어요!</h1>
	<div>
		<img src="${cpath }/resources/images/intro/intro.png">
	</div>
	<div class="info">
		<h2>월평균 1,800만 명의 사용자, 하루 평균 사용 시간 20분, 1억 2천만 번의 연결. 중고 직거래로 시작한
			자두마켓은 국내 최대의 지역 생활 커뮤니티 서비스로 나아가고 있어요. 이웃이 알려주는 진짜 우리 동네 정보, 내 근처에
			숨어있는 좋은 가게를 발견하고, 이웃과 함께 소소한 일상을 나눌 수 있는 따뜻하고 풍요로운 동네 생활을 꿈꿔요.</h2>
	</div>
	<div id="intro-sub">
		<div>
			<h4>자두마켓 팀</h4>
			<br> <br>
			<h1>대체 불가능한 지역 소셜 서비스를 지향합니다.</h1>
		</div>
		<div class="info">
			<h4>자두마켓의 목표는 동네 안에서 연결되지 못한 가치 있는 정보를 발견하고, 지역 생활 속의 불편함을 해소하기
				위해 모였습니다. 만드는 사람이 불편할수록, 쓰는 사람은 편하다는 신념으로 언제나 유저 관점에서 고민하며 지속적인 실험을
				통해 답을 찾습니다. 지역 커뮤니티와 이웃에 대한 온정, 동료를 향한 신뢰를 바탕으로 모두의 생활에 필수적인 최고의
				서비스를 제공하는 것이 자두마켓의 "WHY"입니다.</h4>
		</div>
	</div>
	<div>
		<img src="${cpath }/resources/images/intro/team.png">
	</div>
	<div id="intro-home">
		<h1>지금, 자두마켓의 여정에 함께 하세요!</h1>
		<div id="intro-home-sub">
			<a href="#" onclick="notReady()"><h2>자두마켓 공고보러 가기&gt;&gt;</h2></a>
			<a href="${cpath }"><h2>자두마켓 메인페이지 가기&gt;&gt;</h2></a>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>