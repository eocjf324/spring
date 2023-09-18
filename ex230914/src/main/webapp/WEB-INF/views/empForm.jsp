<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 조회</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
	</script>
</head>
<body>
	<div>
		<form action="getEmp" method="get">
			<label>사원번호<input type="number" name="employeeId"></label>
			<button type="submit">검색</button>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>사원번호
				<th>
				<td>${empInfo.employeeId}</td>
			</tr>
			<tr>
				<th>이름
				<th>
				<td>${empInfo.firstName}</td>
			</tr>
			<tr>
				<th>업무
				<th>
				<td>${empInfo.jobId}</td>
			</tr>
		</table>
	</div>
	<hr>
	<form>
		<table>
			<tr>
				<th>성</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="hireDate"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="jobId"></td>
			</tr>

		</table>
		<button type="submit">등록</button>
	</form>
	<script>
		$('form:eq(1)').on('submit', function(e){
			e.preventDefault(); //submit 막기
			
			//serialize 폼태그에만 작동한다.
			let formDate = new FormData(document.getElementsByTagName('form')[1]); //자바스크립트
			let formData = $('form:eq(1)').serializeArray(); //제이쿼리

			//serialize() : QueryString - key=Value&key=Value&...
			//serrializeArray() : [{name : 'lastName', value : 'King'}],
			
			//{lastname : 'King'} 요런형태로 변환해야하ㅏㅁ
			formData = $('table input');
			
			let formObj = {};
			$.each(formData, function(idx,obj){
				//하나의 객체 => 하나의 필드
				formObj[obj.name] = obj.value;
			});
			
			console.log(formData, formObj);
			
			
			//데이트타입 주의점 아작스는 -로 디폴트되어있음 
			$.ajax('empInfoInsert', {
				type: 'post',
				contentType : 'application/json', 
				data : JSON.stringify(formObj)
			})
			.done(data => {
				console.log(data);
			})
			.fail(reject => console.log(reject));
			
			
			//$('form:eq(1)').submit(); submit 시키는 방법
			//return false;	
		})
		/*
			Event Object
			-메소드
				1)preventDefault() : 해당 이벤트에 기본으로 설정된 동작을 막음.
				2)stopPropagation(): 이벤트 버블링을 막음.  --캡쳐링 ,버블링(예시 td->tr>table->body 위로 올라감)
			-필드
				1)target	     :  이벤트가 발생한 태그(고정값)
				2)currentTarget  : 현재 이벤트 핸들러가 동작하는 태그 (변동값) => this  
	
		*/
	</script>
	
</body>
</html>