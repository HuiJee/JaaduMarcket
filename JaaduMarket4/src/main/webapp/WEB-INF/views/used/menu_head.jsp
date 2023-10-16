<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/used/menuHead.css">

<style>
  .recent-searches {
    display: none;
    position: absolute;
    top: 100%;
    left: 0;
    width: 370px;
    background-color: #FCEFF3;
    border-radius : 10px;
    border: 1px solid #dddddd;
    padding: 8px;
    z-index: 2; /* 다른 요소들 위에 표시되도록 설정 */
  }

  .search-container {
    position: relative;
  }
</style>



<script type="text/javascript">
	function check(f) {
		var key = f.key;
		if (key.value == '') {
			alert("키워드를 입력한 뒤 검색하세요.");
			key.focus();
			return false;
		}
		return true;
	}
	
</script>

<div class="used-banner">
<input type="hidden" id="me" value="${login }">
	<h1>우리 동네에서 다양한 물건을 찾아보세요!</h1>
	<form action="${cpath }/used/search" onsubmit="return check(this)">
		<select name="which" id="which">
			<option value="key" ${which eq 'key' ? 'selected':'' }>키워드</option>
			<option value="addr" ${which eq 'addr' ? 'selected':'' }>지역 상세</option>
		</select> 
		<div class="search-container">
			<input type="text" id="key" name="word" placeholder="키워드 또는 지역 입력" value="${word != ''? word:'' }" autocomplete="off">
  			<c:if test="${login !=null }">
	  			<div class="recent-searches" id="recent-searches" >
	    		</div>
  			</c:if>
		</div>
		<button type="submit">검색</button>
	</form>
</div>

<div class="used-list">
	<div class="menu-bar">
		<ul>
			<li><a href="${cpath }/used">중고거래</a></li>
			<li><a href="${cpath }/used/0">인기매물</a></li>
			<li><a href="${cpath }/used/1">디지털기기</a></li>
			<li><a href="${cpath }/used/2">유아동</a></li>
			<li><a href="${cpath }/used/3">의류/잡화</a></li>
			<li><a href="${cpath }/used/4">가구/생활가전</a></li>
			<li><a href="${cpath }/used/5">생활/주방</a></li>
			<li><a href="${cpath }/used/6">가공식품</a></li>
			<li><a href="${cpath }/used/7">스포츠/레저</a></li>
			<li><a href="${cpath }/used/8">취미/게임/음반</a></li>
			<li><a href="${cpath }/used/9">도서</a></li>
			<li><a href="${cpath }/used/10">뷰티/미용</a></li>
			<li><a href="${cpath }/used/11">기타 중고물품</a></li>
			<li><a href="${cpath }/used/12">삽니다</a></li>
		</ul>
	</div>
	<div class="used-body">
	
<script type="text/javascript">
	
	const keyInput = document.getElementById("key");
	const which = document.getElementById("which");
	const recentSearches = document.getElementById("recent-searches");
	const me = document.getElementById("me").value;
	
	keyInput.addEventListener('click', showRecentSearches);

	function showRecentSearches() {
		
		if (which.value == 'key' && me != ''){
			
			var url = "${pageContext.request.contextPath}/member/myKey";
			var param = "m_seq=" + me; 
			console.log(param);
			sendRequest(url, param, function() {
				if (xhr.readyState ===4 && xhr.status === 200) {
					var data = xhr.responseText;
					  // 실제로는 서버에서 최근 검색어 데이터를 가져와서 아래 배열에 할당하거나,
					  // 로컬 스토리지 등에 저장된 데이터를 불러와야 합니다.
					  /* const recentSearchList = ['사과', '바나나', '오렌지', '포도']; */
					  /* const recentSearchList = document.querySelectorAll(".my-key li"); */
					  if(data != ''){
							const recentSearchList = JSON.parse(data);
							// 최근 검색어 목록을 비웁니다.
							recentSearches.innerHTML = '나의 최근검색어<br>-----------------------------------------';
							
							// 최근 검색어 목록에 데이터를 동적으로 추가합니다.
							recentSearchList.forEach(searchItem => {
							  const link = document.createElement('a');
							  link.href = 'search?which=key&word='+searchItem; // 실제 검색 동작을 여기에 추가하시면 됩니다.
							  link.textContent = searchItem;
							  link.addEventListener('click', () => {
							    // 검색창에 선택한 최근 검색어 채우기
							    searchInput.value = searchItem;
							    // 최근 검색어 목록 숨기기
							    recentSearches.style.display = 'none';
							  });
							  recentSearches.appendChild(link);
							});
							
							// 최근 검색어 목록 보이기
							recentSearches.style.display = 'block';
					  }
				}
			}, "POST");
			
		}
	}
	
	document.addEventListener("click", function(event){
		if(!event.target.closest(".search-container") && me != ''){
			recentSearches.style.display = "none";
		}
	});
	
</script>




