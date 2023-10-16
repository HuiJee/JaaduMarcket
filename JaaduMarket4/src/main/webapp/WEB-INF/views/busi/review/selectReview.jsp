<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<style>
	.m_img{
		border-radius: 100%;
		object-fit : cover;
	}

</style>
<div>
	<table width="100%">
		<tr>
			<td width="33%">
				<input type="button" class="left" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
			</td>
			<th width="33%">
				<font size="4"><b>후기</b></font>
			</th>
			<td width="34%">
			
			</td>
		</tr>
	</table>
</div>

<hr>
<br>
<div align="center" width="800px">
	<table width="800px">
		<tr align="left">
			<td rowspan="2" width="9%">
				<img class="m_img" width="60px" height="60px" src="${cpath }/resources/member/${rvo.m_img}">
			</td>
			<td width="76%">
				<font size="4"><b>${rvo.m_nickname }</b>&nbsp;&nbsp;${msg }</font>
			</td>
		</tr>
		<tr>
			<td>
				${addr3_name } | ${rvo.b_review_date }
			</td>
		</tr>
	</table>
</div>
<br>
<div align="center" width="800px">
	<table width="800px" border="1" cellspacing="0" height="300px">
		<tr align="left" valign="top">
			<td colspan="2">
				${rvo.b_review_content }
			</td>
		</tr>
	</table>
</div>	
<br>
<div align="center" width="800px">
	<table cellpadding="3" cellspacing="10">
		<tr align="left">
			<c:forEach var="key" items="${b_review_key_name }">
				<td style="background-color: #FFE6EC">
					${key }
				</td>
			</c:forEach>
		</tr>
	</table>
</div>
    			
<br>

<div align="center" width="800px">
	<table width="800px">
		<c:forEach var="img" items="${imgList }">
			<tr align="center">
				<td>
					<img width="700px" height="100%" src="${cpath }/resources/images/b_review_img/${b_review_seq}/${img.b_review_img_name}">
				</td>
			</tr>
		</c:forEach>
	</table>
</div>  
  
<hr width="800px" align="center">

<div align="center" width="800px">
	<table width="800px">
		<tr align="right">
			<td>
				<input type="button" value="삭제" onclick="location.href='${cpath}/busi/review/reviewDelete?b_review_seq=${b_review_seq }&busi_seq=${busi_seq }'">
			</td>
		</tr>
	</table>
</div>
  
  
  
  
  
  
  
  
  
  
  
   
    
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>