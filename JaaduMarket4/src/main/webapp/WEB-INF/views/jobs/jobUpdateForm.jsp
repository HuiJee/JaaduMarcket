<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>


<style>
   	body {
			font-family: Arial, sans-serif;
			text-align: center;
			margin: 20px;
		}
		label {
			font-weight: bold;
		}
		input[type="text"], input[type="number"], textarea {
			width: 300px;
			padding: 5px;
			margin-bottom: 10px;
		}
		textarea {
			height: 100px;
		}
		input[type="file"] {
			margin-bottom: 10px;
		}
		input[type="submit"], input[type="button"] {
			padding: 10px 20px;
			background-color: #007bff;
			border: none;
			color: #fff;
			cursor: pointer;
		}
		input[type="submit"]:hover, input[type="button"]:hover {
			background-color: #0056b3;
		}
		#file-upload-container {
			margin-bottom: 20px;
		}
		#photo-input, #insert {
			display: inline-block;
			vertical-align: middle;
		}
		#photo-input {
			margin-right: 10px;
		}
		#description-count {
			font-size: 12px;
			color: #888;
		}
		#depMsg {
			font-size: 14px;
			font-weight: bold;
		}
  </style>

<script type="text/javascript">
	//hidden으로 주소 정보 보내기
	function submitForm() {
    const j_name = document.getElementById("j_name").value;
    const addr_details = document.getElementById("addr_details").value;
    const addr3_name = document.getElementById("addr3_name").value;

    const j_nameInput = document.createElement("input");
    j_nameInput.type = "hidden";
    j_nameInput.name = "j_name";
    j_nameInput.value = j_name;

    const addr_detailsInput = document.createElement("input");
    addr_detailsInput.type = "hidden";
    addr_detailsInput.name = "addr_details";
    addr_detailsInput.value = addr_details;

    const form = document.getElementById("update");
    form.appendChild(j_nameInput);
    form.appendChild(addr_detailsInput);

    if (addr3_name.trim() === "") {
        alert("주소 정보를 입력해주세요!");
        return;
    } else {
        var checkboxes = document.querySelectorAll('input[name="j_cate_seq"]');
        var isChecked = false;

        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            alert("하는 일을 선택해주세요!");
        } else {
            var termsCheckboxes = document.querySelectorAll('input[name="terms"]');
            var isAllChecked = true;

            for (var j = 0; j < termsCheckboxes.length; j++) {
                if (!termsCheckboxes[j].checked) {
                    isAllChecked = false;
                    break;
                }
            }

            if (!isAllChecked) {
                alert("자두 알바 준수 사항에 모두 동의해주세요!");
            } else {
                form.submit();
                // 사진 삭제
            }
        }
    }
}
	
	function clearPhotoInput() {
		photoInput = document.getElementById("photo-input");
		photoInput.value = null;

	}
</script>


<div align="center">
    <label>일할 장소에 대해 알려주세요</label><br><br> 
    <label>상호명(일하는 곳)</label> <input
        type="text" name="j_name" id="j_name" value="${jvo.j_name }"  style="width:300px "
        placeholder="예) 자두가게" /><br> 

    <form action="${cpath}/jobs/addr3Search2?j_seq=${jvo.j_seq}" method="post">
        <label>주소</label>
        <c:choose>
            <c:when test="${advo.addr1_name != null && advo.addr2_name != null && advo.addr3_name != null}">
                <input type="text" name="addr3_name" size="60px" id="addr3_name" value="${advo.addr3_name}" />
            </c:when>
            <c:otherwise>
                <input type="text" placeholder="동,읍,면으로 검색(ex.서초동)" name="addr3_name" size="60px" id="addr3_name" />
            </c:otherwise>
        </c:choose>
        <input type="submit" value="검색">
    </form>

    <label>주소 상세</label> <input type="text" name="addr_details" value="${jvo.addr_details }" id="addr_details"><br>
	<form action="${cpath}/jobs/jobUpdateCheck" method="post" enctype="multipart/form-data" accept="image/*" id="update">

		<input type="hidden" name="addr3_name" value="${advo.addr3_name}" />
		<input type="hidden" name="j_seq" value="${jvo.j_seq}" />
		<input type="hidden" name="m_seq" value="${jvo.m_seq}" />
		<input type="hidden" name="j_img" value="${jvo.j_img}">

		<div id="file-upload-container">
			<label>(선택) 일하는 공간이나 일과 관련된 사진을 올려보세요
			</label> <br> <img src="${cpath}/resources/jobs/${jvo.j_img}"
			style="width:200px"	 name="j_img1" value="${jvo.j_img}"><br>
			<div class="photo-Input">
				<input type="file" name="photo" id="photo-input" value="사진 변경" />&nbsp &nbsp&nbsp &nbsp &nbsp<br>
				<button type="button" onclick="clearPhotoInput()">삭제</button>&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp
			</div>
		</div>

		<p>
		<div>
			<label>제목</label> <input type="text"
				placeholder="구인 내용 요약 최소 6글자에서 최대 30자까지 입력할 수 있어요" name="j_title"
				value="${jvo.j_title }" id="title" style="width: 500px;">
		</div>

		<div>

			<label>하는 일(최대 3개)</label><br>
			<!-- 등록할 때 선택한 하는 일 -->
			<c:forEach var="jcnvo" items="${jcnlist}" varStatus="loop">
				<div style="display: inline-block;">[${jcnvo.j_cate_name}]${not loop.last ? ',':'' }</div>

			</c:forEach>
			<br>
			<p>
				<c:forEach var="jcvo" items="${jclist}" varStatus="loop">
					<input type="checkbox" name="j_cate_seq" value="${jcvo.j_cate_seq}"
						onclick="limitCheck(this, 3)">
				${jcvo.j_cate_name}
				<c:if test="${loop.index % 5 == 4}">
						<br>
					</c:if>
				</c:forEach>
		</div>
		<div>
			${jvo.j_long==1?'단기':'장기' }
			<!-- 선택한 요일 또는 날짜 -->
			<c:forEach var="jtvo" items="${jtlist }" varStatus="loop">
				<p style="display: inline-block;">${jtvo.j_time_type}${not loop.last ? ',':'' }</p>
				<!-- 마지막 반복이면 쉼표 추가 하지말고 마지막 반복이 아니면 쉼표 추가 -->
			</c:forEach>
			시작 : ${jvo.j_start} ~ 종료 : ${jvo.j_finish}
		</div>
		<div>
			<label>일하는 기간</label><br> <select name="j_long"
				onchange="showDateOrDaySelection(this.value)">
				<option value="1" <c:if test="${jvo.j_long==1}">selected</c:if>>단기</option>
				<option value="0" <c:if test="${jvo.j_long==0}">selected</c:if>>장기</option>
			</select>

			<div id="dateSelection" style="display: none;">
				<label>일하는 날짜</label><br>
				<div id="selectedDatesContainer">
					<input type="date" name="j_time_type1">
				</div>
				<button type="button" onclick="addDateInput()">날짜 추가</button>
				<br>
			</div>

			<div id="daySelection" style="display: none;">
				<label>일하는 요일</label><br>
				<c:forEach var="d" items="${dlist}">
					<input type="checkbox" name="j_time_type2" value="${d.day_name}">${d.day_name}
    </c:forEach>
			</div>

			<label>일하는 시간</label><br> 시작: <input type="time" name="j_start"
				value="${jvo.j_start }"> 종료: <input type="time"
				name="j_finish" value="${jvo.j_finish }"> <select
				name="j_time_nego">
				<c:if test="${jvo.j_time_nego==0 }">
					<option value="0" selected>협의가능</option>
					<option value="1">협의 불가능</option>
				</c:if>
				<c:if test="${jvo.j_time_nego==1 }">
					<option value="0">협의가능</option>
					<option value="1" selected>협의 불가능</option>
				</c:if>
			</select> <br> 시급: <input type="number" name="j_pay"
				value="${jvo.j_pay }" min="0" id="jPayInput"
				oninput="updateWageMessage()">원<br> <span
				id="min-wage-message">2023년 최저시급은 9,620원입니다.</span>
		</div>

		<div>
			<label>상세내용</label><br>
			<textarea rows="8" cols="50"
				placeholder="예)업무 예시,근무 여건, 지원자가 갖추어야 할 능력, 우대 사항 등"
				name="j_details" oninput="countCharacters()">${jvo.j_details}</textarea>
			<br> <span id="description-count">0/2000</span><br> <span
				id="depMsg" style="display: none; color: red;">상세내용을 입력해주세요!</span>
		</div>

		<label>연락처</label> <input type="text" name="j_tel"
			value="${jvo.j_tel }"><br> <select name="j_tel_status">

			<c:if test="${jvo.j_tel_status==0 }">
				<option value="0" selected>전화 받기</option>
				<option value="1">전화 안 받기</option>

			</c:if>
			<c:if test="${jvo.j_tel_status==1 }">
				<option value="0">전화 받기</option>
				<option value="1" selected>전화 안 받기</option>
			</c:if>
		</select>

		<div>
			<label>당근 알바 준수 사항 동의</label> <br>
			<c:forEach var="ter" items="${tlist}">
				<input type="checkbox" name="terms" value="${ter.terms_title}">
				<label for="terms">${ter.terms_title}</label>
				<br>
			</c:forEach>
		</div>
		<br>

		<div>
			<input type="button" onclick="submitForm();" value="수정하기" />
		</div>
	</form>
</div>

<script type="text/javascript">
	function addDateInput() {

		const selectedDatesContainer = document
				.getElementById("selectedDatesContainer");

		const newDateInput = document.createElement("input");
		newDateInput.type = "date";
		newDateInput.name = "j_time_type1";

		selectedDatesContainer.appendChild(newDateInput);
	}

	function clearPhotoInput() {
		photoInput = document.getElementById("photo-input");
		photoInput.value = null;

	}

	//드롭다운 마다의 날짜
	function showDateOrDaySelection(value) {
		if (value == "1") { // 단기 선택
			document.getElementById("dateSelection").style.display = "block";
			document.getElementById("daySelection").style.display = "none";
		} else if (value == "0") { // 장기 선택
			document.getElementById("dateSelection").style.display = "none";
			document.getElementById("daySelection").style.display = "block";
		}
	}

	//하는일 최대 3개
	function limitCheck(checkbox, limit) {
		var checkedBoxes = document
				.querySelectorAll('input[name="j_cate_seq"]:checked');
		if (checkedBoxes.length > limit) {
			checkbox.checked = false;
		}
	}
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>