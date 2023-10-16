<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	#outer{
		align : center;
		
	}
	
	#img{
		align : center;
		width : 800px;
	}
	
	#addbtn{
		align : right;
		width : 600px;
	}
</style>


<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<div id="outer" align="center">
	<div align="center">
		<h3>상품 수정</h3>
		<hr>
	</div>
	
	<form method="post" enctype="multipart/form-data" name="yaho">
	<input type="hidden" name="busi_seq" value="${busi_seq }">
	<input type="hidden" name="product_seq" value="${pvo.product_seq }">
		<div id="product">
			<div id="img" align="center">
				<table>
					<tr>
						<td>			
							상품 사진
						</td>
					</tr>
					<tr>
						<td>
							<input class="file" type="file" name="file">
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<table>
					<tr>
						<td>
							상품명*
						</td>
						<td>&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							가격*
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" class="product_name" name="product_name" size="40px" placeholder="고객에게 보여줄 상품의 이름을 적어주세요." value="${pvo.product_name }">
						</td>
						<td>&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							<input type="text" class="product_price" name="product_price" size="10px" value="${pvo.product_price }"> 원
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">
							상품 설명
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea name="product_info" class="product_info" rows="4" cols="62" placeholder="추가로 고객에게 상품에 대한 정보를 알려주세요.">${pvo.product_info }</textarea>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<hr width="600px">
		</div>
		<input type="button" value="수정하기" onclick="input()">
	</form>
</div>

<script type="text/javascript">
	function input(){
	
		const file = document.getElementsByClassName('file').value;
		const product_name = document.getElementsByClassName('product_name').value;
		const product_price = document.getElementsByClassName('product_price').value;
		const product_info = document.getElementsByClassName('product_info').value;
		
		if(product_name == ''){
			alert("상품명을 적어주세요.");
			document.yaho.product_name.focus();
			return;
			
		}
		if(product_price == ''){
			alert("상품 가격을 적어주세요.");
			document.yaho.product_price.focus();
			return;
		}
		yaho.action = "${cpath}/busi/product/productUpdateCheck";
		yaho.submit();
	}

</script>

  
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>