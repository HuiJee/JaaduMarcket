<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<div>
	<h3>소식 수정</h3>
	<hr>
</div>
<div>
<script type="text/javascript">
	function upload(f){
		var files = f.files.value;
		var notice_title = f.notice_title.value;
		var notice_content = f.notice_content.value;
		
		if(notice_title == ''){
			alert("소식 제목을 적어주세요.");
			f.notice_title.focus();
			return;
		}
		if(notice_content == ''){
			alert("소식 내용을 적어주세요.");
			f.notice_content.focus();
			return;
		}
		f.action = "${cpath}/busi/notice/noticeUpdateCheck";
		f.submit();
	}


</script>

</div>

<form method="POST" enctype="multipart/form-data">
	<input type="hidden" name="busi_seq" value="${busi_seq }">
	<input type="hidden" name="notice_seq" value="${notice_seq }">
		<div>
			<input type="file" name="files" multiple="multiple">
			<hr>
		</div>
		
		<div>
			<input type="text" placeholder="소식 제목" name="notice_title" size="40px" value="${vo.notice_title }">
			<hr>
		</div>
		
		<div>
			<textarea rows="30" cols="150" placeholder="상품/서비스 소개, 새로운 메뉴, 이벤트 등 다양한 소식을 알려보세요." name="notice_content">${vo.notice_content }</textarea>
		</div>
	<br>
	<input type="button" value="완료" onclick="upload(this.form);">

</form>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>