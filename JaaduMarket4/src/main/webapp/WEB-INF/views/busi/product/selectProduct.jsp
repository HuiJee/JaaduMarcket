<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#outer{
		align:center;
		width:800px;
	}
	#innerImg{
		align:center;
	}
</style>
<%@ include file="/WEB-INF/views/busi/busi_header.jsp"%>

<div align="center">
	<div align="center">
		<img src="${cpath }/resources/busi/product/${pvo.product_img}" height="600px" width="800px">
	</div>
	<br>
	<div align="center">
		<table width="800px" cellspacing="5px">
			<tr align="left">
				<td>
					<p><a href="${cpath}/busi/myBusi?busi_seq=${vo.busi_seq}"><font size="2">${vo.busi_name } ></font></a></p>
				</td>
			</tr>
			<tr>
				<td>
					<font size="4"><b>${pvo.product_name }</b></font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="5"><b>${pvo.product_price }</b></font> 원
				</td>
			</tr>
			<tr>
				<td>
					${pvo.product_info }
				</td>
			</tr>
			<c:if test="${check == true }">
				<tr align="right">
					<td>
						<input type="button" value="수정" onclick="location.href='${cpath}/busi/product/updateProduct?busi_seq=${busi_seq }&product_seq=${pvo.product_seq }'">
						<input type="button" value="삭제" onclick="location.href='${cpath}/busi/product/deleteProduct?busi_seq=${busi_seq }&product_seq=${pvo.product_seq }'">
					</td>
				</tr>
			</c:if>
				
		</table>
	</div>
	
</div>



	
	

    
  
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>