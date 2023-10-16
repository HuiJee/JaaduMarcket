<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
	
	<div>
		<h3>나의 비즈프로필 목록</h3>
	</div>
	<br>
	<div>
	<c:if test="${busilist != null }">
		<table>
			<c:forEach var="vo" items="${busilist }">
				<tr>
					<td rowspan="2">
						<img width="170px" height="120px" src="${cpath }/resources/busiProfileImg/${vo.busi_img}">
					</td>
					<td><a href="${cpath }/busi/myBusi?busi_seq=${vo.busi_seq }"><b>${vo.busi_name }</b></a></td>
				</tr>
				<tr>
					<td>${vo.addr3_name }</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${busilist == null }">
			* 아직 비즈 계정을 생성하지 않았습니다.<br>
			<input type="button" value="비즈계정생성" onclick="location.href='${cpath }/makeBusi/intro'">
		</c:if>
	</div>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>