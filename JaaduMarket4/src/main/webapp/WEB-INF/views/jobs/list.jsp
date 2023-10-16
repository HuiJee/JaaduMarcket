<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header3.jsp" %>



<div>알바 게시물 페이지</div>

<div align="center">
  <form action="${cpath}/jobs/list" method="get" onsubmit="return check(this)">
    <div style="display: flex; align-items: center;">
      <select name="type">
        <option value="j_title" ${param.type == 'j_title' or empty param.type ? 'selected' : ''}>제목으로 검색</option>
        <option value="j_details" ${param.type == 'j_details' ? 'selected' : ''}>내용 검색</option>
        <option value="addr3_name" ${param.type == 'addr3_name' ? 'selected' : ''}>동 검색</option>
        <option value="j_pay" ${param.type == 'j_pay' ? 'selected' : ''}>시급 검색</option>
      </select>
      <input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word}" autocomplete="off">
      <input class="btn" type="submit" value="검색">
    </div>
  </form>
  <input type="button" value="단기" onclick="location.href='${cpath}/jobs/shortList'">
</div>

<hr>


  <c:forEach var="jvo" items="${jlist}">
    <div class="job-post" align="center">
      <div class="job-image">
        <img src="${cpath}/resources/jobs/${jvo.j_img}" style="width: 200px;"   alt="Job Image">
      </div>
      <div class="job-details">
        <h3 class="job-title"><a href="${cpath}/jobs/jobsContent?j_seq=${jvo.j_seq}&m_seq=${login}">${jvo.j_title}</a></h3>
        <p class="job-location">${jvo.addr1_name} ${jvo.addr2_name} ${jvo.addr3_name}</p>
        <div class="job-pay">
          <p class="job-pay">시급: <span class="hourly-pay">${jvo.j_pay}</span>원</p>
        </div>
        <p class="job-hours">${jvo.j_start} ~ ${jvo.j_finish}</p>
      </div>
    </div>
  </c:forEach>


<div style="display: flex; justify-content: center; margin-top: 20px;">
<c:if test="${mvo.m_jobs_status==0 }">
  <input type="button" value="마이페이지" onclick="location.href='${cpath}/jobs/mypage?m_seq=${login}'">
  </c:if>
  <c:if test="${mvo.m_jobs_status==1 }">
  <input type="button" value="자두 알바 등록" onclick="location.href='${cpath}/jobs/jobInsertform3'">
  <input type="button" value="마이페이지" onclick="location.href='${cpath}/jobs/mypage?m_seq=${login}'">
  </c:if>
</div>

<div style="display: flex; justify-content: center;">
  <c:if test="${paging.prev}">
    <a href="${cpath}/jobs/list?page=${paging.begin - 1}">[이전]</a>
  </c:if>

  <c:forEach var="i" begin="${paging.begin}" end="${paging.end}" step="1">
    <c:choose>
      <c:when test="${i == paging.page}">
        <strong>[${i}]</strong>
      </c:when>
      <c:otherwise>
        <a href="${cpath}/jobs/list?page=${i}">[${i}]</a>
      </c:otherwise>
    </c:choose>
  </c:forEach>

  <c:if test="${paging.next}">
    <a href="${cpath}/board/jobs?page=${paging.end + 1}">[다음]</a>
  </c:if>
</div>

<script type="text/javascript">
  const hourlyPayElements = document.querySelectorAll(".hourly-pay");
  hourlyPayElements.forEach(element => {
    const j_pay = element.textContent;
    const formatted_jpay = new Intl.NumberFormat().format(Number(j_pay));
    element.textContent = formatted_jpay;
  });
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
