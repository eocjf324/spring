<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>도서등록</h3>
	
	<form name="insertBook" action="bookInsert" method="post">
		<table>
			<tr>
				<td>도서번호</td>
				<td><input type ="number" name ="bookNo" value= "${insert}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type ="text" name ="bookName"></td>
			</tr>
			<tr>
				<td>도서표지</td>
				<td><input type ="text" name ="bookCovering"></td>
			</tr>
			<tr>
				<td>출판일자</td>
				<td><input type ="text" name ="bookDate"></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type ="number" name ="bookPrice"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type ="text" name ="bookPublisher"></td>
		
			<tr>
				<td>도서소개</td>
				<td><textarea name = "bookInfo" rows="3" cols="100"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" >조회</button>
	</form>
	<script>
	$('[name="insertBook"]').on('submit', function(e){
			e.preventDefault();
			
			let bookName = $('[name="bookName"]');

			if(bookName.val() == ''){
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}
			alert('도서등록이 완료 되었습니다.');
			insertBook.submit();
		});
	</script>
</body>
</html>