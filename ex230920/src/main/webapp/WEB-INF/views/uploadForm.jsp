<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Form</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
<body>
	<!--  <form action="" method="post" enctype="multipart/form-data">-->
	<div>
		<input type="file" name="uploadFile" multiple>
		<button class="uploadBtn">등록</button>
	</div>
	<!-- </form>-->

	<script>
		//자바스크립트 fetch, formdata로 ajax
 	  		$('.uploadBtn').click(function() {
			//FormData 객체 생성  formdata  
			//  클래스이용할시 무조건 multipartresolver 필수!!(서블릿context에 빈등록하기)
		    //  헤더 선언 x		
		 	var formData = new FormData(); 
			var inputFile = $("input[type='file']");

			var files = inputFile[0].files;
			//files : 선택한 모든 파일을 나열하는 FileList 객체입니다.
			//multiple 특성을 지정하지 않닸다면 두 개 이상의 파일을 포함하지 않습니다.

			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append("uploadFiles", files[i]);//키,값으로 append 
			}
			
			//실제 업로드 Ajax 
			//자바스크립트 : fetch
/* 			fetch('uploadsAjax',{
				method : 'post',
				body : formData
			})
			.then(response => response.json())
			.then(data => console.log(data))
			.catch(err => console.log(err)); */
				
		    //jQuery.ajax 이미지 보낼때
	        $.ajax({
	            url: 'uploadsAjax',	
	            type: 'POST',
	          //기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다.
	          //이미지 폴더 그대로가야해서 가공하지마라
	            processData: false,	
	         // multipart/form-data타입을 사용하기위해 false 로 지정합니다.
	         // json으로 변환하지 않기 위해 
	            contentType: false,	
	            data: formData,               
	            success: function(result){
	                for(let image of result){
						   let path = '${pageContext.request.contextPath}/images/' + image;
						   let imgTag = $('<img/>').prop('src', path);
						   $('div').append(imgTag);
					   }
	            },
	            error: function(reject){	
	                console.log(reject);
	            }
	        }); 
		});  
		
		
    
	</script>

</body>

</html>