<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/header3.jsp" %>

<div>공고 지원자 목록</div>
<div>
 
  <button data-category="waiting" onclick="showCategory(this)">구인중&nbsp;${appCount0}</button>
  <button data-category="done" onclick="showCategory(this)">채용됨&nbsp;${appCount1}</button>
  <button data-category="rejected" onclick="showCategory(this)">거절됨&nbsp;${appCount3}</button>
</div>
<hr>

<div id="waitingCategory" style="display: none;">
  <%-- 구인중 카테고리 목록 표시 --%>
   <table border="1" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th>이름</th>
        <th>닉네임</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>자기소개</th>
        <th>지원일시</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="apvo0" items="${aplist}">
        <tr>
          <td>${apvo0.m_name}</td>
          <td>${apvo0.m_nickname}</td>
          <td>${apvo0.m_tel1}${apvo0.m_tel2} ${apvo0.m_tel3}</td>
          <td>${apvo0.email1}${apvo0.email2}</td>
          <td>${apvo0.my_info}</td>
          <td>${apvo0.apply_date}</td>
          <td>
            <button type="button" onclick="location.href='${cpath}/jobs/resume?m_seq=${apvo0.m_seq }'">지원서보기</button>
            <button type="button" name="j_done" value="1" onclick="location.href='${cpath}/jobs/recruit?j_seq=${apvo0.j_seq}&app_seq=${apvo0.app_seq}'">채용하기</button>
            <button type="button" name="j_done" value="3" onclick="location.href='${cpath}/jobs/reject?j_seq=${apvo0.j_seq }&app_seq=${apvo0.app_seq}'">거절하기</button>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<div id="doneCategory" style="display: none;">
  <%-- 채용됨 카테고리 목록 표시 --%>
   <table border="1" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th>이름</th>
        <th>닉네임</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>자기소개</th>
        <th>지원일시</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="apvo1" items="${aplist1}">
        <tr>
          <td>${apvo1.m_name}</td>
          <td>${apvo1.m_nickname}</td>
          <td>${apvo1.m_tel1}${apvo1.m_tel2} ${apvo1.m_tel3}</td>
          <td>${apvo1.email1}${apvo1.email2}</td>
          <td>${apvo1.my_info}</td>
          <td>${apvo1.apply_date}</td>
          <td>
            <button type="button" onclick="location.href='${cpath}/jobs/resume?m_seq=${apvo1.m_seq }'">지원서보기</button>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<div id="rejectedCategory" style="display: none;">
  <%-- 거절됨 카테고리 목록 표시 --%>
   <table border="1" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th>이름</th>
        <th>닉네임</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>자기소개</th>
        <th>지원일시</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="apvo3" items="${aplist3}">
        <tr>
          <td>${apvo3.m_name}</td>
          <td>${apvo3.m_nickname}</td>
          <td>${apvo3.m_tel1}${apvo3.m_tel2} ${apvo3.m_tel3}</td>
          <td>${apvo3.email1}${apvo3.email2}</td>
          <td>${apvo3.my_info}</td>
          <td>${apvo3.apply_date}</td>
          <td>
            <button type="button" onclick="location.href='${cpath}/jobs/resume?m_seq=${apvo3.m_seq }'">지원서보기</button>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<script type="text/javascript">
window.addEventListener("DOMContentLoaded", function() {
	  // 페이지 로드 시 전체 카테고리를 보이도록 설정
	 document.getElementById("waitingCategory").style.display = "block";
	});

function showCategory(button) {
    var category = button.getAttribute("data-category");

    // 모든 카테고리를 숨김 처리
    document.getElementById("waitingCategory").style.display = "none";
    document.getElementById("doneCategory").style.display = "none";
    document.getElementById("rejectedCategory").style.display = "none";

    // 선택한 카테고리에 해당하는 목록을 보이도록 처리
    if (category === "waiting") {
        document.getElementById("waitingCategory").style.display = "block";
    } else if (category === "done") {
        document.getElementById("doneCategory").style.display = "block";
    } else if (category === "rejected") {
        document.getElementById("rejectedCategory").style.display = "block";
    }
}
</script>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>