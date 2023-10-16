<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div class="container">
  <h2>경력 수정 페이지</h2>
  <form action="${cpath}/jobs/careerUpdate?experience_seq=${evo.experience_seq}" method="post">
    <!-- 경력 정보 입력 -->
    <h3>경력 정보</h3>
    <div class="info-row">
      <label for="j_place">일한 곳</label><br>
      <input type="text" name="j_place" value=${evo.j_place } id="j_place" placeholder="예) 당근가게 역삼점" />
    </div>
    <div class="info-row">
      <label for="j_details">했던 일</label><br>
      <input type="text" name="j_details" value=${evo.j_details } id="j_details" placeholder="어떤 일을 했었는지 설명해주세요" />
    </div>
    <div class="info-row">
      <label for="j_year">일한 연도(일을 시작한 연도를 숫자 4자리로 입력해주세요)</label><br>
      <input type="text" value=${evo.j_year } name="j_year" id="j_year"value="${currentYear}" maxlength="4" />
    </div>
     <div class="info-row">
        <label for="j_period">일한 기간</label>
        <select name="j_period"  id="j_period">
          
          
          <c:choose>
          <c:when test="${empty evo.j_period }">
          <option value="">--선택하세요--</option>
          <c:forEach var="jperiod" items="${plist}">
          <option value="${jperiod.period}">${jperiod.period}</option>
          </c:forEach>
          </c:when>
          <c:otherwise>
         <option value="${jperiod.period}">${evo.j_period}</option>
         <c:forEach var="jperiod" items="${plist}">
          <option value="${jperiod.period}">${jperiod.period}</option>
          </c:forEach>
          </c:otherwise>
          </c:choose>
        </select>
      </div>
    
    <!-- 저장 버튼 -->
    <div class="info-row">
      <button type="submit" class="btn">수정</button>
    </div>
  </form>
</div>


	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>