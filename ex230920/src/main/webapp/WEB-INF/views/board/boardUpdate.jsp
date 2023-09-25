<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
</script>
	
</head>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="bno"  value="${boardInfo.bno}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"  value="${boardInfo.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"  value="${boardInfo.writer}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image"  value="${boardInfo.image}"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input type="date" name="update" value='<fmt:formatDate value="${boardInfo.updatedate}" pattern = "yyyy-MM-dd"/>'></td>
			</tr>
		</table>
		<button type="button" id = "saveBtn" >수정</button>
		<button type="button" onclick="location.href='boardInfo?bno=${boardInfo.bno}'">취소</button>
	</form>
	<script>
		$('#saveBtn').on('click', updateBoard);
		
		function updateBoard(){
			
			let objData = getBoardInfo();
			
			$.ajax('boardUpdate',{
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(objData)
			})
			.done(result => {
				if(result){
					alert('정상적으로 수정되었습니다.');
				}
				else{
					alert('입력한 데이터를 확인해주세요.');
				}
			})
			.fail(reject => 
				console.log(reject));
		}
		function getBoardInfo(){
			
			//폼안에 input 태그안 데이터 가져오기 name,value
			let formData = $('form').serializeArray();//입력태그 배열 
			
			let formObj = {};
			$.each(formData, function(idx, obj){
				//각 입력태그 -> 하나의 필드로 변환 
				formObj[obj.name] = obj.value;
			});
			return formObj;
		}
	</script>
</body>
</html>