<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<form>
		<div>
			<label>employee_Id : <input type="number" name="employeeId"
				value="${empInfo.employeeId}" readonly="readonly"></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName"
				value="${empInfo.firstName}"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"
				value="${empInfo.lastName}" readonly></label>
		</div>
		<div>
			<label>email : <input type="text" name="email"
				value="${empInfo.email}"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate"
				value='<fmt:formatDate value="${empInfo.hireDate}" pattern = "yyyy-MM-dd"/>' readonly></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"
				value="${empInfo.salary}"></label>
		</div>
		<button type="button">수정</button>
		<button type="reset">취소</button>
	</form>

	<script>
		
	/* 	$('button:eq(0)').on(click, function(){
			$.ajax('empUpdate',{
				type: 'post',
				contentType : 'application/json',
				data : JSON.stringify()
			})
			.done();
			.fail();
			
		}) */
		
		//Ajax 쓸때 함수형으로 쓰는걸 추천
		$('form > button[type="button"]').on('click', empUpdateHandler);
		
		function empUpdateHandler(event){
			//보낼 데이터
				
			let objData = getEmpInfo();
			
			//for in 쓸대 무조건 대괄호
			//객체 내부 순환
			for(let field in objData){
				// 대괄호 사용가능 경우
				// 1)변수에 필드명을 담아서 사용하는 경우
				// 2)필드명을 문자열로 접근하는 경우 : 특수문자사용(-),영어를 제외한 한글 
				console.log(objData[field]);
				
			}	
			//ajax
			$.ajax('empUpdate',{
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(objData)
			})
			//done 연속적으로 사용 가능(자바스크립트 ajax then과 같음) 제이쿼리는 done
			.done(result => {
				console.log(result);
				//객체 내부값 가져오는건 대괄호 필드명 한글일 경우 대괄호안에 ''이거 쓰기!
				let message = '결과 : ' + result['결과'] + ', 대상 사원번호 : ' + result['사원번호'];
				alert(message);
			})
			.fail(reject => console.log(reject));
		}
		
		
		function getEmpInfo(){
			//배열이라 그대로 사용X
			let formData = $('form').serializeArray();
			
			//반복문으로 배열을 깬다.
			let formObj = {};
			$.each(formData, function(idx,obj){
				formObj[obj.name] = obj.value;
			});
		
			return formObj;
		}
	</script>
</body>
</html>