<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	
	.left{
		float : left;
		
	}
	
	.right{
		float : right;
	}
	
	.middle{
		float : middle;
	}
	
	#proList{
		align : center;
		width : 900px;
	}
	
	#list{
		align : center;
	}
</style>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<c:choose>
	<c:when test="${check == true }">
		<c:if test="${productList == null }">
			<div align="center">
				<p>
					이웃들에게 상품을 판매해보세요!
					<br>
					<font color=#A6A6A6 size="2">우리 가게 상품을 등록하면<br>고객이 바로 결제하고 구매할 수 있어요.</font>
					<br><br>
					<input type="button" value="상품 판매 신청하기" onclick="location.href='${cpath}/busi/product/productIntro?busi_seq=${busi_seq }'">
				</p>
			</div>
		
		</c:if>
	</c:when>
	<c:otherwise>
		<c:if test="${productList == null }">
			<div align="center">
				<p>상품이 없어요.</p>
			</div>
		</c:if>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${check == true }">
		<div>
			<table>
				<tr>
					<td>
						<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
					</td>
					<th width="100%">
						<font size="4"><b>상품</b></font>
					</th>
					<td>
						<input type="button" class="right" value="상품올리기" onclick="location.href='${cpath}/busi/product/productForm?busi_seq=${busi_seq }'">
					</td>
				</tr>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<table width="100%">
			<tr>
				<td width="33%">
					<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
				</td>
				<th width="33%">
					<font size="4"><b>상품</b></font>
				</th>
				<td width="34%">
				
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

	
	
	
	
<c:if test="${productList != null }">
	<br><br>
	<div align="center">
		<table cellspacing="50px" width="900px" align="center">
			<c:forEach var="pro" items="${productList }" varStatus="i">
				<c:if test="${i.index % 2 == 0 }">
					<tr align="left">
						<td onclick="location.href='${cpath}/busi/product/selectProduct?product_seq=${pro.product_seq }&busi_seq=${busi_seq }'">
							<img src="${cpath }/resources/busi/product/${pro.product_img}" height="350px" width="350px">
							<br>
							${pro.product_name }
							<br>
							<b>${pro.product_price } 원</b>
							<br>
							<%-- ${pro.product_info }
							<br> --%>
						</td>
				</c:if>
				
				<c:if test="${i.index % 2 == 1 }">
						<td onclick="location.href='${cpath}/busi/product/selectProduct?product_seq=${pro.product_seq }&busi_seq=${busi_seq }'">
							<img src="${cpath }/resources/busi/product/${pro.product_img}" height="350px" width="350px">
							<br>
							${pro.product_name }
							<br>
							<b>${pro.product_price } 원</b>
							<br>
							<%-- ${pro.product_info }
							<br> --%>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
</c:if>












<%@ include file="/WEB-INF/views/layout/footer.jsp"%>