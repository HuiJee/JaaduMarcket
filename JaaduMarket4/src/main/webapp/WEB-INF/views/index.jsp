<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%-- <div id="banner">
	<img src="${cpath }/resources/images/banner.png"/>
</div> --%>

<style>
#banner img, #subbanner img{
	width:1691px;
	height:600px;
}

#keyword {
  display: flex;
  flex-direction:column;
  justify-content: space-between;
  align-items: center;
  margin: 0 auto; 
  max-width: 600px; 
}

a.ranking{
	margin : 50px 0px 30px;
	width:auto;
}

.topKey{
	display:flex;
	flex-direction: row;
	margin:30px 0px 50px;
}

.topKey a {
  margin-right: 10px; 
  text-align: center;
}
</style>
<div>
	<div id="banner">
		<img src="${cpath }/resources/images/mainbanner.png"/>
	</div>
	
	<div id="keyword">
		<a class="ranking" href="${cpath }/used/keyranking"><h1>인기 중고 검색어</h1></a>
		<div class="topKey">
			<c:forEach var="key" items="${list }">
				<a href="${cpath }/used/search?which=key&word=${key}"><h3>${key }</h3></a>
			</c:forEach>
		</div>
	</div>
	
<%-- 	<div id="subbanner">
		<img src="${cpath }/resources/images/subbanner.png"/>
	</div> --%>
	

</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
