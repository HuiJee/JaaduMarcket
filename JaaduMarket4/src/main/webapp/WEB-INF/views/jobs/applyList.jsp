<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<h2>알바 지원내역 페이지</h2>
<br>
<div>
  <input type="button" data-category="all" onclick="showCategory(this)" value="전체&nbsp;${allCount}">
  <input type="button" data-category="waiting" onclick="showCategory(this)" value="응답대기중&nbsp;${appCount0}">
  <input type="button" data-category="done" onclick="showCategory(this)" value="채용완료목록&nbsp;${appCount1}">
  <input type="button" data-category="rejected" onclick="showCategory(this)" value="거절목록&nbsp;${appCount3}">
</div>

<div id="allCategory">
  <hr>

  <c:choose>
    <c:when test="${empty apclist }">
      <h1>지원한 내역이 없습니다.</h1>
    </c:when>
    <c:otherwise>
      <c:forEach var="app" items="${apclist}">
        <div>
          <img src="${cpath}/resources/jobs/${app.j_img}" style="width: 200px;" value="${app.j_img}" />
          <div>
            <h3>${app.j_title}</h3>
            <p>${app.j_name}</p>
            <p>지원 일시: ${app.apply_date}</p>
          </div>
        </div>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</div>

<div id="waitingCategory" style="display: none">
  <c:forEach var="app0" items="${apclist0}">
    <div>
      <img src="${cpath}/resources/jobs/${app0.j_img}" style="width: 200px;" value="${app0.j_img}" />
      <div>
        <h3>${app0.j_title}</h3>
        <p>${app0.j_name}</p>
        <p>지원 일시: ${app0.apply_date}</p>
      </div>
    </div>
    <div></div>
    <div>
    
      <input type="button" name="app_status" value="지원취소하기" id="app0_change" onclick="location.href='${cpath}/jobs/deleteApp?j_seq=${app0.j_seq}&app_seq=${app0.app_seq}'">
      <input type="button" onclick="report('${application.id}')" value="신고하기">
    </div>
  </c:forEach>
</div>

<div id="doneCategory" style="display: none">
  <c:forEach var="app1" items="${apclist1}">
    <div>
      <img src="${cpath}/resources/jobs/${app1.j_img}" style="width: 200px;" value="${app1.j_img}" />
      <div>
        <h3>${app1.j_title}</h3>
        <p>${app1.j_name}</p>
        <p>지원 일시: ${app1.apply_date}</p>
      </div>
    </div>
    <div></div>
    <div>
      <input type="button" onclick="report('${application.id}')" value="신고하기">
    </div>
  </c:forEach>
</div>

<div id="rejectedCategory" style="display: none">
  <c:forEach var="app3" items="${apclist3}">
    <div>
      <img src="${cpath}/resources/jobs/${app3.j_img}" style="width: 200px;" value="${app3.j_img}" />
      <div>
        <h3>${app3.j_title}</h3>
        <p>${app3.j_name}</p>
        <p>지원 일시: ${app3.apply_date}</p>
      </div>
    </div>
    <div></div>
    <div>
      <input type="button" name="app_status" value="지원취소하기" id="app3_change" onclick="location.href='${cpath}/jobs/deleteApp?j_seq=${app3.j_seq}&app_seq=${app3.app_seq}'">
      <input type="button" onclick="report('${application.id}')" value="신고하기">
    </div>
  </c:forEach>
</div>

<input type="button" onclick="location.href='${cpath}/jobs/list?m_seq=${m_seq }'" value="지원하러가기">

<script type="text/javascript">
  window.addEventListener("DOMContentLoaded", function() {
    //페이지 로드 시 전체 카테고리 보이도록 설정
    document.getElementById("allCategory").style.display = "block";
  });

  function showCategory(button) {
    var category = button.getAttribute("data-category");

    //선택한 카테고리에 해당하는 목록을 보이도록 처리
    if (category == "all") {
      document.getElementById("allCategory").style.display = "block";
      document.getElementById("waitingCategory").style.display = "none";
      document.getElementById("doneCategory").style.display = "none";
      document.getElementById("rejectedCategory").style.display = "none";
    } else if (category == "waiting") {
      document.getElementById("allCategory").style.display = "none";
      document.getElementById("waitingCategory").style.display = "block";
      document.getElementById("doneCategory").style.display = "none";
      document.getElementById("rejectedCategory").style.display = "none";
    } else if (category == "done") {
      document.getElementById("allCategory").style.display = "none";
      document.getElementById("waitingCategory").style.display = "none";
      document.getElementById("doneCategory").style.display = "block";
      document.getElementById("rejectedCategory").style.display = "none";
    } else if (category == "rejected") {
      document.getElementById("allCategory").style.display = "none";
      document.getElementById("waitingCategory").style.display = "none";
      document.getElementById("doneCategory").style.display = "none";
      document.getElementById("rejectedCategory").style.display = "block";
    }
  }
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
