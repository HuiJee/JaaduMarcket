<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<style>
	#A1, #A2, #A3, #A4, #term{
		display : none;
	}
	

</style>

<script type="text/javascript">
	var display = true;
	
	function doDisplay1(){
		var con = document.getElementById("A1");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	function doDisplay2(){
		var con = document.getElementById("A2");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	function doDisplay3(){
		var con = document.getElementById("A3");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	function doDisplay4(){
		var con = document.getElementById("A4");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	function terms(){
		var con = document.getElementById("term");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	var termAll = document.getElementById("term");
	termAll.forEach((all) => {
		if(all.checked){
			
			
		}
	})
</script>


<img src="${cpath }/resources/images/busi/product/상품소개1.jpg" width="1300px" height="480px">
<img src="${cpath }/resources/images/busi/product/상품소개2.jpg" width="1300px" height="480px">
<img src="${cpath }/resources/images/busi/product/상품소개3.jpg" width="1300px" height="480px">
<img src="${cpath }/resources/images/busi/product/상품소개4.jpg" width="1300px" height="450px">
<img src="${cpath }/resources/images/busi/product/상품소개5.jpg" width="1300px" height="370px">

<br>
<div>
	<p>
		<font size="4"><b>자주 묻는 질문</b></font>
	</p>
	
	<div>
		<a href="javascript:doDisplay1();">Q. 누가 신청할 수 있나요? ></a>
		<br>
			<div id="A1">
				방문 가능한 매장이 있는 식품, 운동/취미, 클래스 업종에서 신청할 수 있어요. 시범 운영 후 다른 업종으로 확대하여 운영할 예정이니 조금만 기다려주세요.<br>
				전자상거래만 가능한 온라인 쇼핑몰이나 주류, 담배 등 판매 불가능한 상품을 취급하는 가게는 입점이 제한될 수 있어요.
			</div>
		<br>
	</div>
	<div>
		<a href="javascript:doDisplay2();">Q. 수수료는 얼마인가요? ></a>
		<br>
			<div id="A2">
				상품 판매 수수료는 구매확정된 주문 금액에 대해 결제 수수료를 포함한 3.3%(부가세 포함)가 부가돼요.
			</div>
		<br>
	</div>
	<div>
		<a href="javascript:doDisplay3();">Q. 정산은 언제, 어떻게 되나요? ></a>
		<br>
			<div id="A3">
				구매확정된 주문 금액에 대해 구매확정일로부터 영업일 기준 3일 뒤 상품 판매 수수료를 제외한 금액을 계좌로 지급해드려요.
			</div>
		<br>
	</div>
	<div>	
		<a href="javascript:doDisplay4();">Q. 상품은 어디에 노출되나요? ></a>
		<br>
			<div id="A4">
			상품을 등록하면 내 비즈프로필에서 바로 볼 수 있어요. 또, 이웃들이 가장 많이 보는 당근마켓 홈에서 중고거래 게시글과 함께 노출되어 자연스럽게 홍보할 수 있어요.
			</div>
		<br>
	</div>
</div>


<hr>
<div>
	<p>
		<b>신청 안내</b>
			<ul>
				<li>상품 판매 기능은 일부 업종 대상으로 시범 운영하고 있으며, 신청 가능 업종은 수시로 변결될 수 있어요.</li>
				<li>상품 판매를 위해서는 당근마켓 비즈프로필이 있어야 해요.
				<li>상품 판매 신청 시, 사업자등록증과 통장 사본이 필요해요. 미리 준비하면 좋아요.</li>
			</ul>
	</p>
	<br>
	<p>
		<b>수수료/정산 안내</b>
			<ul>
				<li>상품 판매 수수료는 구매확정된 주문에 대해 결제 수수료를 포함한 3.3%(부가세 포함)가 부가돼요.</li>
				<li>구매확정된 주문 금액에 대해 구매확정일로부터 영업일 기준 3일 뒤 상품 판매 수수료를 제외한 금액을 계좌로 지금해드려요.</li>
			</ul>
	</p>
</div>

<br>
<input type="button" value="상품 판매 신청하기" onclick="location.href='${cpath }/busi/product/startProduct?busi_seq=${busi_seq }'">





<%@ include file="/WEB-INF/views/layout/footer.jsp"%>