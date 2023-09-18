<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--날짜 변환  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<p>${result}</p>
	<table>
		<thead>
			<tr>
				<th>Check</th>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="list">
				<%-- <tr onclick ="location.href='empInfo?employeeId=${list.employeeId}'" > input , button누를경우도 onclick이 실행될 수 있다.--%>
				<tr>
					<td><input type="checkbox"></td>
					<td>${list.employeeId}</td>
					<td>${list.firstName}</td>
					<td>${list.lastName}</td>
					<td>${list.email}</td>
					<!--날짜타입 변환해주기 taglib fmt  -->
					<td><fmt:formatDate value="${list.hireDate}"
							pattern="yyyy년 MM월 dd일" /></td>
					<td>${list.jobId}</td>
					<td>${list.salary}</td>
					<td><button type="button" name="delbtn">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	
		////////////////////////////////////
		let message = `${result}`;
		if(message != ''){
			alert(message);
		}
		//이런방식도 있다리	
	/* 	let message = [
						<c:forEach begin ="1" end = "5">
							`${result}`,
						</c:forEach>
					  ];
		if(message.length > 0){
			alert(message.toString());
		} */
		///////////////////////////////
		//단건조회 다른 방법
		$('tbody > tr').on('click', function(e) {
			//td가 아닌경우 이벤트 동작하지 않겠다 (input, button)
			//주의. 대문자(TD)
			if (e.target.tagName != 'TD')
				return;

			//firstElementchild = td>input이다 
			//nextElementSibling 다음 td -> list.employeeId
			//let empId = e.currentTarget.firstElementChild.nextElementSibling.textContext;

			//Jquery 
			//td:nth-of-type 하위요소 중 td중 2번째 찾기 
			let empId = $(e.currentTarget).find('td:nth-of-type(2)').text();
			//다른 방식 eq
			//let empId = $(e.currentTarget).find('td:eq(1)').text();
			location.href = 'empInfo?employeeId=' + empId;
		});
	</script>

</body>
</html>