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

	<button type ="button">선택삭제</button>
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
		
		//단건삭제 
		$('tr button').on('click', empInfoDel);
		//employeeId 찾기 부모에서 자식찾는 방법이 쉽다. 
		//tr -> td 2번째 
		function empInfoDel(){
			let trTag = event.currentTarget.closest('tr'); //버튼 위치에서 가까운 tr 찾기
			let empId = $(trTag).children().eq(1).text();  
			
			$.ajax('empDelete?employeeId='+empId)
			.done(result => {
				console.log(result);
				
				let deletedId = result.list[0];
				//배열에 값이 있어서 text 안됨 무조건 반복문 => each 
				//td:eq(1)X 안됨 :총결과에서 하나 값만 가져옴
				//nth-of-type   : 그룹중 하나 
				$('tbody > tr > td:nth-of-type(2)').each(function(idx, tag){//function(인덱스, 실제값) 
					if(tag.textContent == deletedId){
						$(tag).parent().remove();
					}
				})
			})
			.fail(reject => console.log(reject));
			
		}
		//선택삭제
		$('button:eq(0)').on('click', empListDelete);
		
		function empListDelete(event){
			//선택한 사원번호를 가지는 배열
			let empIdList = getEmpList();

			//ajax
			$.ajax('empDelete',{
				type: 'post',
				contentType : 'application/json',
				data : JSON.stringify(empIdList)
			})
			.done(result =>{
				if(result){
					//강제페이지전환 ->아작스 아니잖오~ 거진 안쓰는게..
					//예외적으로 쓸경우 배열을 보내고싶을때
					location.href="empList";
				}
				
			})
			.fail(reject => 
				console.log(reject));	
		}
		
		function getEmpList(){
			//[] 속성 검색, id,class 제외
			let checkTag = $('tbody input[type="checkbox"]:checked');
			
			let empList = [];
			checkTag.each(function(idx, intag){
				//input은 하위요소나 형제요소 x 따라사 부모요소로 접근 
				let empId = $(intag).parent().next().text();	
				empList.push(empId);
			});
			
			return empList;
		}
		
	</script>

</body>
</html>