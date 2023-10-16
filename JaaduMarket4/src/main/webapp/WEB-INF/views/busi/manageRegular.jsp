<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>

<style>
	.img{
		border-radius: 100%;
		object-fit : cover;
	}

</style>
    
	


<div align="center" width="800px">

	<div>
		<table width="100%">
			<tr>
				<td width="33%">
					<input type="button" value="< home" onclick="location.href='${cpath }/busi/myBusi?busi_seq=${busi_seq }'">
				</td>
				<th width="33%">
					<font size="4"><b>단골 관리</b></font>
				</th>
				<td width="34%">
				
				</td>
			</tr>
		</table>
	</div>
	<hr>
	
	<div>
		<table width="800px">
			<tr align="left">
				<td rowspan="2" width="15%" align="center">
					<img class="img" width="80px" height="80px" src="${cpath }/resources/images/busiProfileImg/${vo.busi_img }">
				</td>
				<td width="85%">
					<font size="4"><b>${vo.busi_name }</b></font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="4"><b>단골 ${countRegular }명</b></font>
				</td>
			</tr>
		</table>
	</div>
	<hr width="800px">
	<div>
		<c:forEach var="reg" items="${rlist }">
			<br>
			<table width="800px" style="background-color: #FFF2F5">
				<tr align="left">
					<td width="10%" rowspan="2">
						<img class="img" width="80px" height="80px" src="${cpath }/resources/member/${reg.m_img }">
					</td>
					<td width="65%">
						${reg.m_nickname }
					</td>
				</tr>
				<tr>
					<td>
						${addr3_name } | 단골 등록 ${reg.regular_date }
					</td>
				</tr>
			</table>
		</c:forEach>
		<table width="800px">
			<tr align="center">
				<td width="50%">
				</td>
				<td width="50%">
				</td>
			</tr>
		</table>
	</div>
	
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>