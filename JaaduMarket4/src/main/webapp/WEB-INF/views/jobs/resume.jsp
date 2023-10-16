<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div align="center">
  알바 지원서 상세
</div>
<hr>
<div>
  <table >
    <tr>
			
			<td><img src="${cpath }/resources/member/${mvo.m_img}" style="width: 250px;"></td>
			</tr>
    <tr>
      <td>${mvo.m_nickname}</td>
    </tr>
    <tr>
      <td>${degree}&#176;</td>
    </tr>
    <tr>
      <td>${mvo.m_gender == 0 ? '여성' : '남성'}</td>
    </tr>
    <tr>
      <td>
        <label>연령</label>
        <c:choose>
          <c:when test="${mvo.year <= 2013}">
            10대
          </c:when>
          <c:when test="${mvo.year <= 2003}">
            20대
          </c:when>
          <c:when test="${mvo.year <= 1993}">
            30대
          </c:when>
          <c:when test="${mvo.year <= 1983}">
            40대
          </c:when>
          <c:when test="${mvo.year <= 1973}">
            50대
          </c:when>
          <c:when test="${mvo.year <= 1963}">
            60대 이상
          </c:when>
          <c:otherwise>
            10대 미만
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
    <tr>
      <td>인증</td>
    </tr>
  </table>
  <div>
    <h2>자기소개</h2>
    <c:choose>
      <c:when test="${empty avo.my_info}">
        <p>등록된 자기소개가 없습니다.</p>
      </c:when>
      <c:otherwise>
        <p>${avo.my_info}</p>
      </c:otherwise>
    </c:choose>
    <hr>
    <h2>경력${excount}</h2>
    <c:choose>
      <c:when test="${empty elist}">
        <p>등록된 경험이 없습니다.</p>
      </c:when>
      <c:otherwise>
        <c:forEach items="${elist}" var="exp">
          <p>${exp.j_place}</p>
          <p>${exp.j_details}</p>
          <p>${exp.j_year}</p>
          <p>${exp.j_period}</p>
          ------------------------
        </c:forEach>
      </c:otherwise>
    </c:choose>
  </div>
</div>
<p>
<button onclick="history.back()">돌아가기</button>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
