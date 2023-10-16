<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header2.jsp"%>


<div>
	<h3>영업 시간</h3>
	<hr>
</div>

<div>
	<form action="${cpath }/busi/home/insertHours" method="post">
		<input type="hidden" name="busi_seq" value="${busi_seq }">
		
		<div class="filterBox">
			<c:set var="i" value="1"></c:set>
			
				<c:forEach var="day" items="${dayList }">
					<b>${day.day_name }</b>
					<label><input type="checkbox" class="run_status" name="run_status${i }">휴무</label>
					<br>
						<c:forEach var="run" items="${runtype }"> 
							${run.runtype_name }
								<select class="time1" name="time1">
									<option value="00:00">00:00</option>
									<option value="00:30">00:30</option>
									<option value="01:00">01:00</option>
									<option value="01:30">01:30</option>
									<option value="02:00">02:00</option>
									<option value="02:30">02:30</option>
									<option value="03:00">03:00</option>
									<option value="03:30">03:30</option>
									<option value="04:00">04:00</option>
									<option value="04:30">04:30</option>
									<option value="05:00">05:00</option>
									<option value="05:30">05:30</option>
									<option value="06:00">06:00</option>
									<option value="06:30">06:30</option>
									<option value="07:00">07:00</option>
									<option value="07:30">07:30</option>
									<option value="08:00">08:00</option>
									<option value="08:30">08:30</option>
									<option value="09:00">09:00</option>
									<option value="09:30">09:30</option>
									<option value="10:00">10:00</option>
									<option value="10:30">10:30</option>
									<option value="11:00">11:00</option>
									<option value="11:30">11:30</option>
									<option value="12:00">12:00</option>
									<option value="12:30">12:30</option>
									<option value="13:00">13:00</option>
									<option value="13:30">13:30</option>
									<option value="14:00">14:00</option>
									<option value="14:30">14:30</option>
									<option value="15:00">15:00</option>
									<option value="15:30">15:30</option>
									<option value="16:00">16:00</option>
									<option value="16:30">16:30</option>
									<option value="17:00">17:00</option>
									<option value="17:30">17:30</option>
									<option value="18:00">18:00</option>
									<option value="18:30">18:30</option>
									<option value="19:00">19:00</option>
									<option value="19:30">19:30</option>
									<option value="20:00">20:00</option>
									<option value="20:30">20:30</option>
									<option value="21:00">21:00</option>
									<option value="21:30">21:30</option>
									<option value="22:00">22:00</option>
									<option value="22:30">22:30</option>
									<option value="23:00">23:00</option>
									<option value="23:30">23:30</option>
								</select>
								~
								<select class="time2" name="time2">
									<option value="00:00">00:00</option>
									<option value="00:30">00:30</option>
									<option value="01:00">01:00</option>
									<option value="01:30">01:30</option>
									<option value="02:00">02:00</option>
									<option value="02:30">02:30</option>
									<option value="03:00">03:00</option>
									<option value="03:30">03:30</option>
									<option value="04:00">04:00</option>
									<option value="04:30">04:30</option>
									<option value="05:00">05:00</option>
									<option value="05:30">05:30</option>
									<option value="06:00">06:00</option>
									<option value="06:30">06:30</option>
									<option value="07:00">07:00</option>
									<option value="07:30">07:30</option>
									<option value="08:00">08:00</option>
									<option value="08:30">08:30</option>
									<option value="09:00">09:00</option>
									<option value="09:30">09:30</option>
									<option value="10:00">10:00</option>
									<option value="10:30">10:30</option>
									<option value="11:00">11:00</option>
									<option value="11:30">11:30</option>
									<option value="12:00">12:00</option>
									<option value="12:30">12:30</option>
									<option value="13:00">13:00</option>
									<option value="13:30">13:30</option>
									<option value="14:00">14:00</option>
									<option value="14:30">14:30</option>
									<option value="15:00">15:00</option>
									<option value="15:30">15:30</option>
									<option value="16:00">16:00</option>
									<option value="16:30">16:30</option>
									<option value="17:00">17:00</option>
									<option value="17:30">17:30</option>
									<option value="18:00">18:00</option>
									<option value="18:30">18:30</option>
									<option value="19:00">19:00</option>
									<option value="19:30">19:30</option>
									<option value="20:00">20:00</option>
									<option value="20:30">20:30</option>
									<option value="21:00">21:00</option>
									<option value="21:30">21:30</option>
									<option value="22:00">22:00</option>
									<option value="22:30">22:30</option>
									<option value="23:00">23:00</option>
									<option value="23:30">23:30</option>
								</select>
							<br>
						</c:forEach>
						<br>
							<c:set var="i" value="${i+1 }"></c:set>
				</c:forEach>
				
			<input type="submit" value="저장">
		
		</div>
	</form>
</div>

<script type="text/javascript">

const runStatus = document.querySelectorAll(".run_status");
const time1 = document.querySelectorAll(".time1");
const time2 = document.querySelectorAll(".time2");

console.log(runStatus);

	const clickHandler = (event) => {
		runStatus.forEach((e,i) => {
			if(e.checked === true){
				let index = i * 2;
				time1[index].disabled = true;
				time1[index+1].disabled = true;
				time2[index].disabled = true;
				time2[index+1].disabled = true;
			}else{
				let index = i * 2;
				time1[index].disabled = false;
				time1[index+1].disabled = false;
				time2[index].disabled = false;
				time2[index+1].disabled = false;
			}
		})
			
	};

runStatus.forEach(ck => ck.onclick = clickHandler);






</script>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>