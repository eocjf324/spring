<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 조회 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form action = "getEmp" method = "get">
			<label>사원번호<input type="number" name="employeeId"></label>
			<button type ="submit">검색</button>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>사원번호<th>
				<td>${empInfo.employeeId}</td>				
			</tr>
			<tr>
				<th>이름<th>
				<td>${empInfo.firstName}</td>				
			</tr>
			<tr>
				<th>업무<th>
				<td>${empInfo.jobId}</td>				
			</tr>
		</table>
	</div>
	<hr>
	<form>
		<table>
			<tr>
				<th>성</th>
				<td><input type = "text" name = "lastName"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type = "text" name = "email"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type = "text" name ="hireDate"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type = "text" name ="jobId"></td>
			</tr>
		
		</table>
		<button type="submit">등록</button> 
	</form>
	<script>
		$('form:eq(1)').on('submit', functionn(e)){
			
			e.preventDefault();
			
			//serialize 폼태그에만 작동한다.
			let formData = $('form:eq(1)').serializeArray();
			
			
			//return false;
		});
		
		/*
			Event Object
			-메소드
				1)preventDefault() : 해당 이벤트에 기본으로 설정된 동작을 막음.
				2)stopPropagation(): 이벤트 버블링을 막음.  --캡쳐링 ,버블링(예시 td->tr>table->body 위로 올라감)
			-필드
				1)target
				2)currentTarget
	
		*/
	</script>
</body>
</html>