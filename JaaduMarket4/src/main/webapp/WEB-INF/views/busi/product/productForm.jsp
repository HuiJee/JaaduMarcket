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
		<h3>상품 등록</h3>
		<hr>
	</div>
	
	<form method="post" enctype="multipart/form-data" name="yaho">
	<input type="hidden" name="busi_seq" value="${busi_seq }">
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
							<input type="text" class="product_name" name="product_name" size="40px" placeholder="고객에게 보여줄 상품의 이름을 적어주세요.">
						</td>
						<td>&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							<input type="text" class="product_price" name="product_price" size="10px"> 원
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
							<textarea name="product_info" class="product_info" rows="4" cols="62" placeholder="추가로 고객에게 상품에 대한 정보를 알려주세요."></textarea>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<hr width="600px">
		</div>
		
		<div id="addbtn" align="right" width="600px">
			<input type="button" value="+추가하기" onclick="add()">
		</div>
		<input type="button" value="등록" onclick="input()">
	</form>
</div>

<script type="text/javascript">
	var stop = 1;
	function add(){
		if(stop == 5){
			alert("상품 등록은 한번에 5개까지만 가능해요.");
			return;
		}
		
		var pro = document.getElementById("product");
		const div = document.createElement("div");
		div.id = "img";
		
		div.innerHTML = '<table>'
			+ '<tr>'
			+ '<td>'			
				+ '상품 사진'
			+ '</td>'
		+ '</tr>'
		+ '<tr>'
			+'<td>'
				+'<input class="file" type="file" name="file">'
			+'</td>'
		+'</tr>'
	+'</table>'
+'</div>'
+'<br>'
+'<div>'
	+'<table>'
		+'<tr>'
			+'<td>'
				+'상품명*'
			+'</td>'
			+'<td>&nbsp;&nbsp;&nbsp;'
			+'</td>'
			+'<td>'
				+'가격*'
			+'</td>'
		+'</tr>'
		+'<tr>'
			+'<td>'
				+'<input type="text" class="product_name" name="product_name" size="40px" placeholder="고객에게 보여줄 상품의 이름을 적어주세요.">'
			+'</td>'
			+'<td>&nbsp;&nbsp;&nbsp;'
			+'</td>'
			+'<td>'
				+'<input type="text" class="product_price" name="product_price" size="10px"> 원'
			+'</td>'
		+'</tr>'
		+'<tr>'
			+'<td colspan="3">&nbsp;&nbsp;&nbsp;</td>'
		+'</tr>'
		+'<tr>'
			+'<td colspan="3">'
				+'상품 설명'
			+'</td>'
		+'</tr>'
		+'<tr>'
			+'<td colspan="3">'
				+'<textarea name="product_info" class="product_info" rows="4" cols="62" placeholder="추가로 고객에게 상품에 대한 정보를 알려주세요."></textarea>'
			+'</td>'
		+'</tr>'
	+'</table>';
	
	pro.appendChild(div);
	const br = document.createElement("br");
	const hr = document.createElement("hr");
	hr.width = "600px";
	pro.appendChild(br);
	pro.appendChild(hr);
	
	stop += 1;
	}
		/*pro.innerHTML += '<div id="img" align="center">'
					+ '<table>'
				+ '<tr>'
					+ '<td>'			
						+ '상품 사진'
					+ '</td>'
				+ '</tr>'
				+ '<tr>'
					+'<td>'
						+'<input class="file" type="file" name="file">'
					+'</td>'
				+'</tr>'
			+'</table>'
		+'</div>'
		+'<br>'
		+'<div>'
			+'<table>'
				+'<tr>'
					+'<td>'
						+'상품명*'
					+'</td>'
					+'<td>&nbsp;&nbsp;&nbsp;'
					+'</td>'
					+'<td>'
						+'가격*'
					+'</td>'
				+'</tr>'
				+'<tr>'
					+'<td>'
						+'<input type="text" class="product_name" name="product_name" size="40px" placeholder="고객에게 보여줄 상품의 이름을 적어주세요.">'
					+'</td>'
					+'<td>&nbsp;&nbsp;&nbsp;'
					+'</td>'
					+'<td>'
						+'<input type="text" class="product_price" name="product_price" size="10px"> 원'
					+'</td>'
				+'</tr>'
				+'<tr>'
					+'<td colspan="3">&nbsp;&nbsp;&nbsp;</td>'
				+'</tr>'
				+'<tr>'
					+'<td colspan="3">'
						+'상품 설명'
					+'</td>'
				+'</tr>'
				+'<tr>'
					+'<td colspan="3">'
						+'<textarea name="product_info" class="product_info" rows="4" cols="62" placeholder="추가로 고객에게 상품에 대한 정보를 알려주세요."></textarea>'
					+'</td>'
				+'</tr>'
			+'</table>'
		+'</div>'
		+'<br>'
		+'<hr width="600px">'
		stop += 1;
	}*/
	
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
		yaho.action = "${cpath}/busi/product/productInsert";
		yaho.submit();
	}

</script>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>