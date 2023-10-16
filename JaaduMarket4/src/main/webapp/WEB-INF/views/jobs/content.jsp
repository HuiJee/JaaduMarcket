<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header3.jsp"%>
<div>
  알바 지원서 상세
</div>
<hr>
<div >
  <table>
    <tr>
			
	<td><img src="${cpath }/resources/member/${mvo.m_img}"  style="width:200px;"></td>
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
<hr>
<div style="display:inline-block;">
<c:choose>
  <c:when test="${empty avo}">
    <input type="button" value="작성하기" onclick="location.href='${cpath}/jobs/applyform?m_seq=${mvo.m_seq}'"/>
  </c:when>
  <c:otherwise>
    <input type="button" value="수정하기" onclick="location.href='${cpath}/jobs/updateform?m_seq=${mvo.m_seq}'">
    <input type="button" value="삭제하기" onclick="location.href='${cpath}/jobs/delete?m_seq=${mvo.m_seq }'">
  </c:otherwise>
</c:choose>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

