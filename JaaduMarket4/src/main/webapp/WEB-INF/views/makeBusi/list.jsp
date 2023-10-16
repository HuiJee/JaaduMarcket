<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 


<style>
	#hj{
		align: right;
	}

	#post-list{
		display: flex;
	   	flex-wrap: wrap;
	   	width:70%;
	   	margin: auto;
	}
	.post {
		float: left;
		height: 100%;
		width: 50%;
		padding:10px;
		box-sizing: border-box;
		text-align: center;   
    }
    .hidden{
    	display: none;
    }
    .block{
    	display: block;
    }
</style>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>
	<div align="center">
		<h1>다양한 동네가게를 볼 수 있어요</h1>
	</div>
	<div id="hj" align="right">
		<input type="button" value="비즈프로필 보기" onclick="location.href='${cpath}/makeBusi/myBusiList'">
		<input type="button" value="비즈계정생성" onclick="location.href='${cpath }/makeBusi/intro'">
	</div>
	<hr>
	
	<div align="center">
		<input type="button" id="all" value="전체" onclick="postAll()">
		<c:forEach var="cate" items="${busi_cateList }" varStatus="i">
			<input type="button" value="${cate.busi_cate_name }" onclick="category('${cate.busi_cate_name }')">
		</c:forEach>
		<br><br>
	</div>
	
	
	
<c:if test="${busiList == null }">
아직 준비된 가게가 없어요.<br>
조금만 기다려주시면 우리동네 다양한 가게들을 즐기실 수 있어요.
</c:if>

<c:if test="${busiList != null }">
	<div id="post-list">
		<c:forEach var="busi" items="${busiList }" varStatus="i">
				<div class="post" id="${busi.busi_cate_name }">
					<table>
						<tr>
							<td rowspan="3">
								<img src="${cpath }/resources/busiProfileImg/${busi.busi_img }" height="95px" width="120px">
							</td>
							<td>
								<a href="${cpath }/busi/myBusi?busi_seq=${busi.busi_seq }"><b>${busi.busi_name }</b></a> <font color=#A6A6A6 size="2">${busi.addr3_name }</font>
							</td>
						</tr>
						<tr>
							<td>
								${busi.busi_information }
							</td>
						</tr>
						<tr>
							<td>
								<font id="font"color=#A6A6A6>${busi.busi_cate_name }</font>
							</td>
						</tr>
					</table>
				</div>
		</c:forEach>
	</div>

</c:if>

<div align="center">
	<c:if test="${paging.prev }">	<!-- 범위번호가 0이 아닌경우 [이전] 생성 -->
		<a href="${cpath }/views/makeBusi?page=${paging.begin - 1}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
		<c:choose>
			<c:when test="${i == paging.page }">
				<strong>[${i}]</strong>
			</c:when>
			<c:otherwise>
				<a href="${cpath }/views/makeBusi?page=${i}">[${i }]</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${paging.next }">
		<a href="${cpath }/views/makeBusi?page=${paging.end + 1}">[다음]</a>
	</c:if>
</div>
	
<br>
<br>
<br>
<br>
<br>
<br>
		
<script type="text/javascript">

	function category(value){
		const busiList = document.querySelectorAll("#post-list div");
		busiArr = Array.from(busiList);
		
		
		
		for(let i = 0; i < busiArr.length; i++){
			var id = busiArr[i].id;
			if(id == value){
				busiArr[i].className="post";
			}else{9
				busiArr[i].className="hidden";
			}
			
		}
	}
	
	
	function postAll(){
		var busiList = document.querySelectorAll("#post-list div");
		busiArr = Array.from(busiList);
		for(let i = 0; i < busiArr.length; i++){
			busiArr[i].className = "post";
		}
	}
	

</script>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>