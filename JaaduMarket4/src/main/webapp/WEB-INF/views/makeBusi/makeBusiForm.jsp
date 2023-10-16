<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
	<div align="right">
		<font color=#A6A6A6 size="2">도움이 필요하신가요?<a style="color:#C77B8D" href="${cpath}/views/makeBusi/makeBusiExplain" target="_blank"> 비즈프로필 만드는 법</a></font>
	</div>
	
	<div>
		<h3>비즈프로필 등록</h3>
		<hr>
	</div>
	
	
	
	<div>
		<script type="text/javascript">
			
		
		
			function makeBusi(){
				var url = "${cpath}/addr/search?m_seq=${m_seq}";
				var name = "search";
				var option = "width = 700, height = 600, top = 100, left = 200, location = no";
				window.open(url, name, option);
			}
			
			function send(f){
				var num_pattern = /^\d{10}$/;
				var tel_pattern = /^\d{4}$/;
				
				var photo = f.photo.value;
				var busi_name = f.busi_name.value;
				var addr3_name = f.addr3_name.value;
				var busi_addr_detail = f.busi_addr_detail.value;
				var busi_tel1 = f.busi_tel1.value;
				var busi_tel2 = f.busi_tel2.value;
				var busi_tel3 = f.busi_tel3.value;
				var busi_cate_seq = f.busi_cate_seq.value;
				var busi_number = f.busi_number.value;
				
				if(busi_name == ''){
					alert("비즈프로필 이름을 적어주세요.");
					f.busi_name.focus();
					return;
				}
				if(addr3_name == ''){
					alert("활동 지역을 설정해주세요.");
					f.addr3_name.focus();
					return;
				}
				if(busi_tel1 == ''){
					alert("전화번호를 입력해주세요.");
					f.busi_tel1.focus();
					return;
				}
				if(busi_tel2 == '' || !tel_pattern.test(f.busi_tel2.value)){
					alert("전화번호를 확인해주세요.");
					f.busi_tel2.focus();
					return;
				}
				if(busi_tel3 == '' || !tel_pattern.test(f.busi_tel3.value)){
					alert("전화번호를 확인해주세요.");
					f.busi_tel3.focus();
					return;
				}
				if(busi_cate_seq == ''){
					alert("카테고리를 지정해주세요.");
					f.busi_cate_seq.focus();
					return;
				}
				if(busi_number == '' || !num_pattern.test(f.busi_number.value)){
					alert("사업자번호는 숫자 10자리로 입력해주세요.");
					f.busi_number.focus();
					return;
				}
				
				f.action = "${cpath}/makebusi/myBusi";
				f.submit();
				
			}
			
			
		</script>
			<form method="POST" enctype="multipart/form-data">
			
				<div>
					<p>
						<b>프로필 사진 설정</b>
						<br>
							<font color=#A6A6A6 size="2">사진을 등록한 사장님이 단골을 10배 더 많이 모았어요.</font>
						<br>
							<input type="file" name="photo">
						
					</p>
				</div>
			
				<div>
					<p>
						<b>비즈프로필 이름</b>
						<br>
							<input type="text" placeholder="예)자두베이커리, 자두슈퍼" name="busi_name" size="70px">
						<br>
							<font color=#A6A6A6 size="2">업체, 비즈니스 또는 단체를 나타내는 이름이 좋아요.</font>
					</p>
				</div>
				
				<div>
					<p>
						<b>활동 지역</b>
						<br>
							<%-- <c:if test="${vo != null }">
								<input type="text" id="pInput" placeholder="활동 지역을 설정해주세요" name="addr3_name" size="100px" readonly="readonly" value="${vo.addr1_name } ${vo.addr2_name} ${vo.addr3_name}">
								<input type="button" value="검색" onclick="location.href='${cpath}/addr/search?m_seq=${m_seq}'">
							</c:if>
							
							<c:if test="${vo == null }"> --%>
								<input type="text" id="pInput" placeholder="활동 지역을 설정해주세요" name="addr3_name" size="70px" readonly="readonly">
								<%-- <input type="button" value="검색" onclick="location.href='${cpath}/addr/search?m_seq=${m_seq}'"> --%>
								<button type="button" onclick="javascript:makeBusi()">검색</button>
							<%-- </c:if> --%>
						<br>
							상세 주소
							<br>
							<input type="text" name="busi_addr_detail" size="70px">
					</p>
				</div>
				
				<div>
					<p>
						<b>비즈 전화번호</b>
						<br>
							<select name="busi_tel1">
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="055">055</option>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
							</select>
							- <input type="text" name="busi_tel2" size="5px">
							- <input type="text" name="busi_tel3" size="5px">
					</p>
				</div>
				
				<div>
					<p>
						<b>카테고리</b>
						<br>
							<select name="busi_cate_seq">
								<option value="1">음식점</option>
								<option value="2">카페/디저트</option>
								<option value="3">운동</option>
								<option value="4">뷰티샵</option>
								<option value="5">미용실</option>
							</select>
					</p>
				</div>
				
				<div>
					<p>
						<b>사업자번호 등록</b>
						<br>
						<input type="text" placeholder="-없이 숫자로만 적어주세요" id="busi_number" name="busi_number" size="30px">
					</p>
				</div>
				
				
				
				<input type="button" value="비즈 생성하기" onclick="send(this.form);">
			</form>
				
	</div>
	


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>