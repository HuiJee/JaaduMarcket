<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<style type="text/css">
	#body{
		height: 600px;
	}
</style>

</head>
<body>
	<script type="text/javascript">
		
		function setParentText(i){
			//console.log(document.getElementsByClassName("cInput")[i]);
			opener.document.getElementById("pInput").value = document.getElementsByClassName("cInput")[i].innerText;
		}
		
		
		
	</script>

 	<div>
		<h3><b>지역 검색</b></h3>
		<hr>
	</div>
	
	<form action="${cpath }/makeBusi/searchCheck" method="post">
		<input id="kiki" type="text" placeholder="동,읍,면으로 검색(ex.서초동)" name="addr3_name" size="60px" value="${addr3_name}">
		<input type="submit" value="검색">
	</form>

	
	<div id="body">
		
		
			<table>
				<tr>
					<th colspan="3">주소</th>
				<c:forEach var="vo" items="${addrlist }" varStatus="i">
					<tr>
						<td><a class="cInput" href="javascript:setParentText(${i.index })" onclick="window.close()">${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }</a></td>
					</tr>
					
					<%-- <tr>
						<td>
							<input type="radio" id="cInput" onclick="setParentText()" value="${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }">${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }
						</td>
					</tr>
					
					<tr>
						<td><a id="cInput" href="#none" onclick="test(this)">${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }</a></td>
					</tr> --%>
					
				</c:forEach>
			</table>
			
			
			
			<%-- <h3>주소</h3>
			<br>
			<c:forEach var="vo" items="${addrlist }">
				<p class="cInput" href="javascript:setParentText()" onclick="setParentText()"><a id="cInput" href="javascript:setParentText()" onclick="window.close()">${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }</a></p>
			</c:forEach> --%>
			
		
	</div>
	 
	
	
	
<%-- <div>

	
	
	<div>
		<h3><b>지역 검색</b></h3>
		<hr>
	</div>
	
	<form action="${cpath }/busi/searchCheck" method="post">
		<input id="cInput" type="text" placeholder="동,읍,면으로 검색(ex.서초동)" name="addr3_name" size="100px" value="${addr3_name}">
		<input type="submit" value="검색">
	</form>

	
	
		<table>
			<tr>
				<th colspan="3" align="left">주소</th>
			<c:forEach var="vo" items="${addrlist }">
				<tr>
					<td><a id="cAddrlist" href="javascript:setCInputText()">${vo.addr1_name } ${vo.addr2_name } ${vo.addr3_name }</a></td>
				</tr>
					
			</c:forEach>
		</table>
		<br><br>
		<input type="button" value="확인" onclick="window.close()">
		
		<script type="text/javascript">
		function setParentText(){
			opener.document.getElementById("pInput").value = document.getElementById("cInput")
		}
		
		function setCInputText(){
			document.getElementById("cInput").value = document.getElementById("cAddrlist")
		}
	</script>
	
	
	
</div> --%>
	




<%@ include file="/WEB-INF/views/layout/footer.jsp"%>