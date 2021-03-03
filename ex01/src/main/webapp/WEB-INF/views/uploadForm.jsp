<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>

	<!-- file upload는 무조건 post 방식 ,   enctype="multipart/form-data" 무조건  (string과 바이트가 함께넘어간다는 선언)
	  input type="file"  name은   Controller의 변수이름과 맞춘다   
	  
	  
	  주의 : Controller도  PostMapping 해주어야함 빠뜨리지말것 
	  
	  -->

	<form action="upload" method="post" enctype="multipart/form-data" >
		<div>
			<label for="file_input_id1">첨부 파일 : </label> <input type="file"
				name="files" id="file_input_id1">
		</div>
		<div>
			<label for="file_input_id2">첨부 파일 : </label> <input type="file"
				name="files" id="file_input_id2">
		</div>
		<div>
			<label for="file_input_id3">첨부 파일 : </label> <input type="file"
				name="files" id="file_input_id3">
		</div>

		<button>파일 올리기</button>
		<!-- button의 기본타입은 submit -->

	</form>

</body>
</html>