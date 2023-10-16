<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>


<script type="text/javascript">
	function send(f){
		var b_review_content = f.b_review_content.value;
		var checkboxes = document.getElementsByName('b_review_key_seq');
		var count = 0;
		
		for(var i = 0; i < checkboxes.length; i++){
			if(checkboxes[i].checked){
				count++;
			}
		}
		
		if(count === 0){
			alert("후기 키워드를 골라주세요.");
			return;
		}
		if(b_review_content == ''){
			alert("후기 내용을 적어주세요.");
			f.b_review_content.focus();
			return;
		}
		f.action = "${cpath}/busi/review/reviewInsert";
		f.submit();
		
	}
	
</script>

<table width="100%">
	<tr>
		<td width="33%">
			<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
		</td>
		<th width="33%">
			<font size="4"><b>후기 작성</b></font>
		</th>
		<td width="34%">
		
		</td>
	</tr>
</table>
<hr>
<div align="center" width="800px">
	<table width="800px" align="center">
		<tr>
			<th>
				<font size="4">${vo.m_nickname } 님, ${bvo.busi_name } 이용하셨나요?</font>
			</th>
		</tr>
		<tr align="center">
			<td>
				이웃에게 이용 경험을 알려보세요.
			</td>
		</tr>
	</table>
</div>

<br>

<div align="center">
	<form method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
	<input type="hidden" name="busi_seq" value="${bvo.busi_seq }">
		<div>
			<table cellspacing="10" cellpadding="5">
				<tr>
					<c:forEach var="key" items="${klist }" varStatus="i">
						<td style="background-color: #FFE6EC">
							<input type="checkbox" name="b_review_key_seq" value="${key.b_review_key_seq }">${key.b_review_key_name }
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	
		<br>
	
		<div align="center">
			<textarea rows="15" cols="70" placeholder="${bvo.busi_name }에 대한 후기를 남겨주세요." name="b_review_content"></textarea>
		</div>
		
		<br>
		
		<div align="center" width="520px">
			<table width="520px">
				<tr align="left">
					<td>
						<input type="file" name="files" multiple="multiple">
					</td>
				</tr>					
			</table>
		</div>
		<br>
		<div>
			<input type="button" value="작성하기" onclick="send(this.form)">
		</div>
	</form>
</div>




<%@ include file="/WEB-INF/views/layout/footer.jsp"%>