<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

	<div class="title">
		<table>
			<tr>
				<td>
					<a onclick="history.back()">&lt; home</a>
				</td>
			</tr>
			<tr>
				<td>
					<font size="5"><b>비즈프로필 수정</b></font>
				</td>
			</tr>
		</table>
		<hr>
	</div>
	
	
	<form method="post" enctype="multipart/form-data">
		<div>
			<p>
				<b>프로필 사진 설정</b>
				<br>
					<font color=#A6A6A6 size="2">사진을 등록한 사장님이 단골을 10배 더 많이 모았어요.</font>
				<br>
					<input type="file" name="photo">
				
			</p>
		</div>
	
		<div>
			<p>
				<b>비즈프로필 이름</b>
				<br>
					<input type="text" value="${vo.busi_name }" name="busi_name" size="70px">
				<br>
					<font color=#A6A6A6 size="2">업체, 비즈니스 또는 단체를 나타내는 이름이 좋아요.</font>
			</p>
		</div>
		
		<div>
			<p>
				<b>활동 지역</b>
				<br>
					<input type="text" id="pInput" value="${addr_name }" name="addr_name" size="70px" readonly="readonly">
					<button type="button" onclick="javascript:searchAddr()">검색</button>
				<br>
			</p>
		</div>
		<div>
			<p>
				<b>카테고리</b>
				<br>
					<select name="busi_cate_seq">
						<option value="1" ${vo.busi_cate_seq == 1 ? 'selected' : '' }>음식점</option>
						<option value="2" ${vo.busi_cate_seq == 2 ? 'selected' : '' }>카페/디저트</option>
						<option value="3" ${vo.busi_cate_seq == 3 ? 'selected' : '' }>운동</option>
						<option value="4" ${vo.busi_cate_seq == 4 ? 'selected' : '' }>뷰티샵</option>
						<option value="5" ${vo.busi_cate_seq == 5 ? 'selected' : '' }>미용실</option>
					</select>
			</p>
		</div>
		
		<br><br>
		<input type="button" value="수정" onclick="edit(this.form);">
	</form>



<script type="text/javascript">
	function edit(f){
		var photo = f.photo.value;
		var busi_name = f.busi_name.value;
		var addr_name = f.addr_name.value;
		var busi_cate_seq = f.busi_cate_seq.value;
		
		if(photo == ''){
			alert("프로필 사진을 등록해주세요.");
			f.photo.focus();
			return;
		}
		if(busi_name == ''){
			f.busi_name.focus();
			return;
		}
		if(addr_name == ''){
			f.addr_name.focus();
			return;
		}
		if(busi_cate_seq == ''){
			f.busi_cate_seq.focus();
			return;
		}
		f.action = "${cpath}/busi/myBusiUpdateCheck?busi_seq=${vo.busi_seq}"
		f.submit();
	}
	
	
	function searchAddr(){
		var url = "${cpath}/addr/search?m_seq=${m_seq}";
		var name = "search";
		var option = "width = 700, height = 600, top = 100, left = 200, location = no";
		window.open(url, name, option);
	}


</script>



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>