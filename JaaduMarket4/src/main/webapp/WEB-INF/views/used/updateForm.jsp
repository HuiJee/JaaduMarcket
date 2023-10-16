<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link type="text/css" rel="stylesheet"
	href="${cpath }/resources/css/used.css">
<script type="text/javascript">
  $(document).ready(function() {
	  
	  share(document.forms[0]);
	  
    var topSelect = document.getElementById("cate");
    var subSelect = document.getElementById("subSelect");
    var textInput = document.getElementById("textInput");
    var summernoteElement = document.getElementById("summernote");
    var summernoteInstance;
    var middle = document.getElementById("middleCate");

    function cateChange() {
      var selecCate = topSelect.value;
      var placeholderText = "";

      // 선택한 카테고리에 따라 placeholder를 설정합니다.
      if (selecCate === "1" || selecCate === "5" || selecCate === "7") {
        placeholderText = "모델명, 구성품, 구매 시기, 사용감(흠집, 파손 여부, 수리 여부), 전자파 인증번호 등";
      } else if (selecCate === "2" || selecCate === "3") {
        placeholderText = "사이즈, 구매 시기, 사용감(색바램, 얼룩, 뜯어짐) 등";
      } else if (selecCate === "4") {
        placeholderText = "모델명, 구매 시기, 크기(가로/세로/높이), 사용감(흠집, 파손 여부) 등";
      } else if (selecCate === "6") {
        placeholderText = "구매시기, 유통기한 등<br>※ 의약품, 건강기능식품은 관련법에 따라 판매할 수 없어요. 의약품, 건강기능식품 라벨이 제품에 표시되어 있는지 반드시 확인해주세요.<br>※ 직접 만든 수제식품은 판매할 수 없어요.<br>※ 유통기한이 지나거나 개봉한 식품은 판매할 수 없어요.";
      } else if (selecCate === "8") {
        placeholderText = "구매 시기, 사용감(흠집, 파손 여부, 상세 사진)등<br>※ 게임, OTT 서비스 등의 계정 정보는 공유하거나 판매할 수 없어요.";
      } else if (selecCate === "9") {
        placeholderText = "권수(전집의 경우 누락 여부), 사용감(찢김, 색바램, 낙서) 등";
      } else if (selecCate === "10") {
        placeholderText = "구매 시기, 제조일자 또는 유통기한, 사용감(파손 여부) 등<br>※ 화장품 샘플은 판매할 수 없어요.";
      } else if (selecCate === "11") {
        placeholderText = "구매 시기, 사용감(흠집, 파손 여부) 등";
      } else {
        placeholderText = "제품명, 브랜드 등 자세하게 적을수록 좋아요.";
      }
      placeholderText += "<br><br>신뢰할 수 있는 거래를 위해 자세한 정보를 제공해주세요. 과학기술정보통신부, 한국인터넷진흥원이 함께 해요.";

      document.getElementById("content").setAttribute("placeholder", placeholderText);

      var two = document.getElementById("2");
      var three = document.getElementById("3");
      var nine = document.getElementById("9");
      
      // 하위 카테고리 체크박스 또는 입력 칸 표시
      if (selecCate == "2" || selecCate=="9") {
        subSelect.style.display = "block";
        textInput.style.display = "none";
        if(selecCate == "2"){
        	two.style.display = "block";
        	three.style.display = "none";
        	nine.style.display = "none";
        }else{
        	two.style.display = "none";
        	three.style.display = "none";
        	nine.style.display = "block";       	
        }
      } else if(selecCate=="1" || selecCate=="4" || selecCate=="10"){
        subSelect.style.display = "none";
        textInput.style.display = "block";
      } else if(selecCate=="3"){
    	subSelect.style.display = "block";
    	textInput.style.display = "block";  
    	
    	two.style.display = "none";
    	three.style.display = "block";
    	nine.style.display = "none";
      } else{
        subSelect.style.display = "none";
        textInput.style.display = "none";
      }
    
    }
    topSelect.addEventListener("change", cateChange);

    // 초기 로드 시에도 핸들러 호출
    cateChange();
  });
  

	function check(f) {
		var title = f.u_title;
		var price = f.u_price;
		var price_pattern = /^[0-9]*$/;
		var content = f.u_content;

		if (title.value == '') {
			alert("제목을 입력해주세요!");
			title.focus();
			return false;
		}
		if (price.value == '') {
			alert("가격을 입력해주세요!");
			price.focus();
			return false;
		}
		if (!price_pattern.test(price.value)) {
			alert("가격은 숫자만 입력하세요.");
			price.focus();
			return false;
		}
		if (content.value == '') {
			alert("내용을 자세히 적어주셔야 합니다!");
			content.focus();
			return false;
		}
		return true;
	}

	// 나눔 체크박스 클릭 이벤트 핸들러
	function share(f) {
		var share = f.u_share.checked;
		var price = document.getElementById("sharePrice");

		var OrPrice = price.value;

		if (share) {
			price.disabled = true;
			price.value = '0';
		} else {
			price.disabled = false;
			price.value = OrPrice;
		}
	}

	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}

					}
				}).open();
	}

	function deleteImage(filename) {
		var confirmation = confirm(filename + "사진을 삭제하시겠습니까?");

		if (confirmation) {
			var url = "${pageContext.request.contextPath}/used/photo/del";
			var param = "u_img_name=" + filename;

			sendRequest(url, param, function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					var data = xhr.responseText;

					if (data == 'true') {
						alert("사진이 삭제되었습니다.");
						var imageDiv = document.getElementById(filename);
						imageDiv.parentNode.removeChild(imageDiv);

						var inputContainer = document
								.getElementById("inputContainer");

						var newInput = document.createElement("input");
						newInput.type = "file";
						newInput.name = "photos";
						newInput.accept = "image/*";

						inputContainer.appendChild(newInput);
					} else {
						alert("사진 삭제에 실패했습니다.");
					}
				}
			}, "POST");
		}
		return false;
	}

	var inputContainer = document.getElementById("inputContainer");

	var newInput = document.createElement("input");
	newInput.type = "file";
	newInput.name = "photos";
	newInput.accept = "image/*";

	inputContainer.appendChild(newInput);
</script>

<style>

.category {
	display: flex;
	flex-direction: row;
	align-content: center;
	align-items: center;
}

select {
	border: none;
	background-color: #f2f2f2;
	height: 35px;
	border-radius: 10px;
	text-align: center;
	margin: 10px;
}

input[type="text"] {
	border: none;
	background-color: #f2f2f2;
	height: 15px;
	border-radius: 10px;
	text-align: center;
	padding-bottom:10px;
}

.title input[type="text"]{
	width:700px;
}

textarea {
	border: none;
	background-color: #f2f2f2;
	border-radius: 10px;
	padding : 10px;
}

.area {
	padding: 30px 0px;
}

form {
	padding-top: 50px;
	width:800px;
}

section {
	padding-top: 50px;
}

hr{
	margin:10px 0px;
}

h2{
	padding-top : 20px;
}

.price{
	display:flex;
	align-items:center;
}

</style>

<div>
  <h1>중고거래 수정</h1>
  <hr>
</div>

<form method="POST" enctype="multipart/form-data" action="${cpath}/used/update?u_seq=${u_seq}" onsubmit="return check(this)">
  <section class="category">
    <select name="u_cate_seq" id="cate">
      <c:forEach var="vo" items="${clist }">
        <option value="${vo.u_cate_seq }" ${vo.u_cate_seq == uvo.u_cate_seq? 'selected' : '' }>${vo.u_cate_name }</option>
      </c:forEach>
    </select>
    <input type="text" id="textInput" style="display: none;" placeholder="브랜드를 입력하세요.(선택사항)" width="auto" value="${uvo.cate_input }">
    
    <div id="subSelect" style="display: none;">
		<select name="cate_check_name">
			<option value="" selected>---선택하세요---</option>
			<c:forEach var="sub" items="${subList }">
				<option value="${sub.cate_check_name }" style="display: none;" ${sub.cate_check_name == uvo.cate_check_name ? 'selected' : '' }>${sub.cate_check_name }</option>
			</c:forEach>
		</select>
	</div>
  </section>
  
    <div class="area">
  	<h4>* 거래 희망 장소가 별도로 있는 경우 아래에서 선택 후 정해주세요!</h4>
		<input type="text" id="sample4_postcode" placeholder="우편번호">
		<input type="button" onclick="sample4_execDaumPostcode()"value="우편번호 찾기">
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="u_addr_main" value="${uvo.u_addr_main }">
		<input type="text" placeholder="건물명 등 상세 장소" name="u_addr_sub" value="${uvo.u_addr_sub }">
		<span id="guide" style="color: #999; display: none"></span>
  </div>
  
	<section class="form">
    	<div class="title">
      	<h2>제목</h2>
     	 <hr>
     	 <input type="text" name="u_title" value="${uvo.u_title }">
    	</div>
    	<div>
			<h2>가격</h2>
			<hr>
			<div class="price">
     	 		<input type="text" name="u_price" id="sharePrice" value="${uvo.u_price }" disabled="disabled">원
      			<h4 style="padding-left:50px;">나눔 여부</h4>(나눔의 가격은 0원입니다.)&nbsp;
      			<input type="checkbox" name="u_share" value="1" onclick="share(this.form)" <c:if test="${uvo.u_share==1}">checked</c:if>>
   			</div>
    	</div>
		<div>
     		<h2>설명</h2>
			<hr>
      		<textarea id="content" name="u_content" cols="100" rows="30" >${uvo.u_content }</textarea></td>
    	</div>
   		<div>
			<h2>사진</h2>(최대 5개 첨부 가능)
			<hr>
			<div class="photo">
				<c:forEach var="filename" items="${flist}">
					<div id="${filename }">
						<span>${filename}</span> 
						<input type="button" value="X" onclick="deleteImage('${filename}')">
					</div>
				</c:forEach>
				<!-- 새로운 이미지 파일 추가 -->
				<div id="inputContainer">
					<c:forEach var="i" begin="1" end="${5-size }" step="1">
						<input type="file" name="photos" accept="image/*" style="margin:5px;">
					</c:forEach>
				</div>
			</div>
      	</div>
  </section>
  <button type="submit" style="margin:30px 0px;">수정하기</button>
</form>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

