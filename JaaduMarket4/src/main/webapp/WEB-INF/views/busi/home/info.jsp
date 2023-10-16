<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<script type="text/javascript">
	function searchAddr(){
		var url = "${cpath}/addr/search?busi_seq=${busi_seq}";
		var name = "search";
		var option = "width = 700, height = 600, top = 100, left = 200, location = no";
		window.open(url, name, option);
	}
	
	
	
	function inputHours(){
		var url = "${cpath }/busi/home/hours?busi_seq=${busi_seq}";
		var name = "hours";
		var option = "width = 700, height = 1000, top = 100, left = 200, location = no";
		window.open(url, name, option);
	}

</script>

<div>
	<h3>정보 관리</h3>
	<hr>
</div>


<form method="post">
<input type="hidden" name="busi_seq" value="${busi_seq }">
	<div>
		<p>
			<b>소개문구</b>
			<br>
			<textarea name="busi_information" rows="10" cols="100" placeholder="가게나 서비스의 강점이 드러나게 작성해보세요.">${vo.busi_information }</textarea>
		</p>
	</div>
	
	<div>
		<p>
			<b>주소*</b>
			<br>
			<input type="text" id="pInput" name="addr" value="${addr.addr1_name } ${addr.addr2_name } ${addr.addr3_name }" size="30px" readonly="readonly">
			<button type="button" onclick="javascript:searchAddr()">검색</button>
		<br>
			상세 주소*
			<br>
			<input type="text" name="busi_addr_detail" value="${vo.busi_addr_detail }" size="70px">
			<br>
			<font color=#A6A6A6 size="2">주소를 입력하면 활동 지역이 주소에 따라 변경돼요.</font>
		</p>
	</div>
	
	<div>
		<p>
			<b>전화번호*</b>
			<br>
			<select name="busi_tel1">
				<option value="02" ${vo.busi_tel1 == '02' ? 'selected' : '' }>02</option>
				<option value="031" ${vo.busi_tel1 == '031' ? 'selected' : '' }>031</option>
				<option value="055" ${vo.busi_tel1 == '055' ? 'selected' : '' }>055</option>
				<option value="010" ${vo.busi_tel1 == '010' ? 'selected' : '' }>010</option>
				<option value="011" ${vo.busi_tel1 == '011' ? 'selected' : '' }>011</option>
				<option value="016" ${vo.busi_tel1 == '016' ? 'selected' : '' }>016</option>
			</select>
			 - <input type="text" name="busi_tel2" size="5px" value="${vo.busi_tel2 }">
			 - <input type="text" name="busi_tel3" size="5px" value="${vo.busi_tel3 }">
			 <br>
			<font color=#A6A6A6 size="2">비즈프로필 홈에 전화문의 버튼이 생겨요.</font>
		</p>
	</div>
	
	<div>
		<p>
			<b>영업시간</b>
			<button type="button" onclick="javascript:inputHours()">영업시간 설정</button>
			<br>
				<div id="pHours">
				<c:if test="${hoursList != null }" >
					<%-- <c:forEach var="hours" items="${hoursList }"> --%>
						
						<c:forEach var="day" items="${dayList }" varStatus="status1">
							${day.day_name}
							<br>
								<c:forEach var="run" items="${runtypeList }" varStatus="status2">
									${run.runtype_name } - ${time[status1.index * 2 + status2.index]}
									<%-- <c:if test="${time.size() > i }">
										<c:set var="i" value="${i += 1 }"/>								
									</c:if> --%>
									<br>
								</c:forEach>
								<br>
						</c:forEach>
						<%-- <c:if test="${hours.day_seq == 1 }">
							
						</c:if> --%>
					<%-- </c:forEach> --%>
				</c:if>
				</div>
					
					<!-- <input type="text" id="pHours" size="98px" readonly="readonly" placeholder="고객이 방문할 수 있도록 영업 시간을 입력해주세요."> -->
					<%-- <input type="button" value="입력하기" onclick="location.href='${cpath }/busi/home/hours?busi_seq=${busi_seq}'"> --%>
					<!-- <font color=#A6A6A6 size="2">고객이 방문할 수 있도록 영업 시간을 입력해주세요.</font> -->
				<br>
		</p>
	</div>
	
	<div>
		<p>
			<b>휴무일</b>
			<br>
			<c:forEach var="hol" items="${holidayList }">
				<label><input type="radio" name="holiday_seq" value="${hol.holiday_seq}" ${vo.holiday_seq == hol.holiday_seq ? 'checked' : '' }>${hol.holiday_type }</label>
			</c:forEach>
			<br>
			<font color=#A6A6A6 size="2">공휴일은 일요일은 제외한 모든 법정 공휴일을 의미해요.</font>
		</p>
	</div>
	
	<div>
		<p>
			<b>기타 정보</b>
			<br>
			<textarea rows="4" cols="100" name="busi_details" placeholder="영업시간 관련 기타 정보 등을 작성해주세요.
예) 매월 첫째주 월요일 휴무">${vo.busi_details }</textarea>
		</p>
	</div>
	
	<div>
		<p>
			<b>홈페이지</b>
			<br>
			<input type="text" name="busi_website" value="${vo.busi_website }" placeholder="URL 주소를 입력하세요." size="98px">
		</p>
	</div>
	
	<input type="button" value="작성하기" onclick="update(this.form);">
	&nbsp;&nbsp;<input type="button" value="home" onclick="location.href='${cpath}/busi/myBusi?busi_seq=${busi_seq }'">

	
</form>
<script type="text/javascript">
	function update(f){
		var busi_information = f.busi_information.value;
		var addr = f.addr.value;
		var busi_addr_detail = f.busi_addr_detail.value;
		var busi_tel1 = f.busi_tel1.value;
		var busi_tel2 = f.busi_tel2.value;
		var busi_tel3 = f.busi_tel3.value;
		var holiday_seq = f.holiday_seq.value;
		var busi_details = f.busi_details.value;
		var busi_website = f.busi_website.value;
		
		if(addr == ''){
			alert("주소를 입력해주세요.");
			f.addr.focus();
			return;
		}
		if(busi_addr_detail == ''){
			alert("상세주소를 입력해주세요.");
			f.busi_addr_detail.focus();
			return;
		}
		if(busi_tel1 == ''){
			alert("전화번호를 입력해주세요.");
			f.busi_tel1.focus();
			return;
		}
		if(busi_tel2 == ''){
			alert("전화번호를 입력해주세요.");
			f.busi_tel2.focus();
			return;
		}
		if(busi_tel3 == ''){
			alert("전화번호를 입력해주세요.");
			f.busi_tel3.focus();
			return;
		}
		f.action = "${cpath }/busi/home/inputInfo";
		f.submit();
			
	}
</script>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>