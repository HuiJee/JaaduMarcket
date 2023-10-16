<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header2.jsp"%>


<div>
	<font size="5"><b>쿠폰 만들기</b></font>
</div>
	<hr>
<div>
	<b>쿠폰을 받을 수 있는 대상을 선택해 주세요.</b>
	<br>
	<br>

	
	<form action="${cpath }/busi/coupon/insertCoupon" method="post">
		<input type="hidden" name="busi_seq" value="${busi_seq }">
		<input type="hidden" name="regular_status" id="statusValue">
		
		<div>
			<table border="1" cellspacing="0" cellpadding="8">
				<tr style="border-color: #FFCDD9" onclick="mouseEvent(this, 1);">
					<td width="480px" onclick="rstatus(1);">
						<b>단골 전용</b>
						<br>
						내 비즈프로필을 단골로 추가한 사람만 쿠폰을 받을 수 있어요.
					</td>
				</tr>
			</table>
			<br>
			<table border="1" cellspacing="0" cellpadding="8">
				<tr style="border-color: #FFCDD9" onclick="mouseEvent(this, 2);">
					<td id="status2" width="480px" onclick="rstatus(2);">
						<b>모든 이웃</b>
						<br>
						누구나 쿠폰을 받을 수 있어요.
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<p>
				<b>혜택</b>
				<br>
				<input type="text" name="coupon_effect" placeholder="예) 모든 메뉴 10% 할인" size="66px">
			</p>
		</div>
		<br>
		<div>
			<p>
				<b>사용기한</b>
				<br>
				<input type="date" name="coupon_use_date">
			</p>
		</div>
		<br>
		<div>
			<p>
				<b>발급 갯수 제한</b>
				<br>
					<label><input type="radio" name="coupon_limit_num" value="0" onclick="doDisplay();">제한없음</label>
					<label><input type="radio" name="coupon_limit_num" value="1" onclick="doDisplay();">제한있음</label>
				
				<div id="nolimit" style="display:none;">
					<font color=#A6A6A6 size="2">사용기한 내에 쿠폰을 개수 제한 없이 받을 수 있어요.</font>
				</div>
				<div id="limit" style="display:none;">
					<input type="text" name="limit_num" placeholder="발급 건수를 입력해 주세요.">
					<br>
					<font color=#A6A6A6 size="2">지정한 개수를 초과하면 쿠폰을 받을 수 없어요.</font>
				</div>	
			</p>
		</div>
		<br>
		<div>
			<p>
				<b>쿠폰 이용 안내</b><font color=#A6A6A6 size="2">(선택)</font>
				<br>
				<textarea rows="10" cols="70" name="coupon_info" placeholder="쿠폰 사용시 유의사항이나 이용조건이 따로 있다면 미리 알려주세요."></textarea>
			</p>
		</div>
		<br>
		<input type="button" value="쿠폰 만들기" onclick="makeCoupon(this.form);">
	</form>
	
	
</div>


<script type="text/javascript">
	
	
	function rstatus(value){
		document.getElementById("statusValue").value = value;
	}
	
	
	var pos = 0;
	function mouseEvent(obj, code){
		if(pos){
			pos.style.background = "white";
		}
			obj.style.background = "#FFD8E1";
			pos = obj;
	}
	
	
	function doDisplay(){
		var nolimit = document.getElementById("nolimit");
		var limit = document.getElementById("limit");
		var value = document.querySelector('input[name="coupon_limit_num"]:checked').value;
		
		if(value == 0){
			nolimit.style.display = 'block';
			limit.style.display = 'none';
		}else{
			nolimit.style.display = 'none';
			limit.style.display = 'block';
		}
	}
	
	function makeCoupon(f){
		var regular_status = f.regular_status.value;
		var coupon_effect = f.coupon_effect.value;
		var coupon_use_date = f.coupon_use_date.value;
		var coupon_limit_num = f.coupon_limit_num.value;
		var coupon_info = f.coupon_info.value;
		var limit_num = f.limit_num.value;
		
		if(regular_status == ''){
			alert("쿠폰 대상을 선택해주세요.");
			return;
		}
		if(coupon_effect ==''){
			alert("쿠폰 혜택을 입력해주세요.");
			return;
		}
		if(coupon_use_date == ''){
			alert("사용기한을 입력해주세요.");
			return;
		}
		if(coupon_limit_num == ''){
			alert("발급 갯수 제한을 체크해주세요.");
			return;
		}
		if(coupon_limit_num == 1){
			if(limit_num == ''){
				alert("발급 갯수를 입력해주세요.");
				return;
			}
		}
		
		f.submit();
	}
	
</script>



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>