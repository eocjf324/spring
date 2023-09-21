<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td> <!--  yyyy년 MM월dd일 -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items= "${boardList}" var = "boardlist">
				<tr>
					<td>${boardlist.bno}</td>
					<td>${boardlist.title}</td>
					<td>${boardlist.writer}</td>
					<td><fmt:formatDate value="${boardlist.regdate}" pattern="yyyy년MM월dd일"/>   </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	//자바스크립트로만 
	document.querySelectorAll('tbody > tr')
			.forEach(function(tag){
				tag.addEventListener('click',function(e){
					let bno = e.currentTarget.firstElementChild.textContent;
					
					location.href = 'boardInfo?bno='+ bno;
				})
			})
	
	/* 
	$('tbody > tr').on('click', boardInfo);
	
	function boardInfo(){
		let bno = $(this).find('td:nth-of-type(1)').text();
		console.log(bno);
		location.href = 'boardInfo?bno='+bno;
	} */
	</script>
</body>
</html>