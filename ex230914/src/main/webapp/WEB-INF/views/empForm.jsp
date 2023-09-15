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
	</form>
</body>
</html>