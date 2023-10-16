<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<style>
table {
  width: 600px;
  border:none;
  margin-top:50px;
}

th, td {
  padding: 8px;
  border-bottom: 1px solid lightgray;
  border-top: none; 
  border-left: none; 
  border-right: none;
  height:50px;
  font-size : 20px
}

.top{
  border-top: 2px bold gray;
}

.rank{
  text-align: center;
}

.rank-col {
  width: 20%;
}

.keyword-col {
  width: 80%;
}

a.key {
  display: flex;
  align-items: center;
  justify-content: center;
  color: inherit;
  width:100%;
  height:100%;
}

a.key:hover {
  background-color: #faebe5f7; 
}

</style>

<div class="used-title">
	<h1>오늘의 중고거래 인기 검색어</h1>
	<hr>
</div>

<c:if test="${list != null }">
	<div>
		<table>
			<tr class="top">
				<th class="rank-col">순위</th>
				<th class="keyword-col">검색어</th>
			</tr>
			<c:forEach var="key" items="${list}" varStatus="i">
				<tr>
					<td class="rank">${i.index + 1}</td>
					<td>
						<a class="key" href="${cpath }/used/search?which=key&word=${key}">${key}</a>
					</td>
				</tr>
			</c:forEach>
			<c:forEach varStatus="i" begin="${list.size() + 1}" end="15">
				<tr>
					<td class="rank">${i.index}</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
<c:if test="${list == null }">
	<div>
		<table>
			<tr class="top">
				<th class="rank-col">순위</th>
				<th class="keyword-col">검색어</th>
			</tr>
			<c:forEach varStatus="i" begin="1" end="15">
				<tr>
					<td class="rank">${i.index}</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>