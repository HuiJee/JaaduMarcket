<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
<style>
	#term{
		display : none;
	}
</style>

<script type="text/javascript">

	function terms(){
		var con = document.getElementById("term");
		if(con.style.display == 'block'){
			con.style.display = 'none';
		}else{
			con.style.display = 'block';
		}
	}
	
	
	function checkAll(){
		var all = document.getElementById("all");
		var checkboxes = document.querySelectorAll("input[type='checkbox']");
		var next = document.getElementById("next");
		
		if(all.checked){
			for(var i = 0; i < checkboxes.length; i++){
				checkboxes[i].checked = true;
			}
		}else{
			for(var i = 0; i < checkboxes.length; i++){
				checkboxes[i].checked = false;
			}
		}
		
		
		var status = true;
		for(var i = 0; i < checkboxes.length; i++){
			if(!checkboxes[i].checked){
				status = false;
				break;
			}
		}
		
		if(status){
			all.checked = true;
			next.style.display = "block";
		}else{
			all.checked = false;
			next.style.display = "none";
		}
	}
	
	function checkAct(){
		var all = document.getElementById("all");
		var checkboxes = document.querySelectorAll("input[type='checkbox']");
		
		var unchecked = false;
		for(var i = 0; i < checkboxes.length; i++){
			if(!checkboxes[i].checked){
				unchecked = true;
				break;
			}
		}
		
		if(unchecked){
			all.checked = false;
		}
		
		var status = true;
		for(var i = 0; i < checkboxes.length; i++){
			if(!checkboxes[i].checked){
				status = false;
				break;
			}
		}
		
		if(status){
			all.checked = true;
			next.style.display = "block";
		}else{
			all.checked = false;
			next.style.display = "none";
		}
	}
	
	function send(f){
		var busi_number = f.busi_number.value;
		
		if(busi_number == ''){
			alert("사업자등록번호를 적어주세요.");
			f.busi_number.focus();
			return;
		}
		f.action = "${cpath}/busi/product/busi_numberCheck";
		f.submit();
	}
	
</script>


<div>
	<h3>사업자 인증</h3>
	<hr>
</div>

<form method="post">
<input type="hidden" name="busi_seq" value="${busi_seq }">
	<div>
		<font size="4"><b>사업자등록번호를 알려주세요.</b></font>
		<br><br>
		<input type="text" name="busi_number" size="30px">
		<input type="button" value="확인" onclick="javascript:terms()">
	</div>
	
	<div id="term">
		<br>
		<div>
			<input type="radio" id="all" name="all" onclick="javascript:checkAll()">약관 전체 동의
		</div>
		<div id="ck1">
			<input type="checkbox" onclick="javascript:checkAct()">서비스 이용약관(필수)<br>
			<input type="checkbox" onclick="javascript:checkAct()">개인정보 수집 및 이용(필수)<br>
			<input type="checkbox" onclick="javascript:checkAct()">제3자 정보 제공 동의(필수)<br>
		</div>
	</div>
	
	<input type="button" id="next" value="동의하고 계속하기" style="display: none;" onclick="send(this.form);">
</form>
    
    
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>