<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body>
	<form name="write" method="post" action="${path}/board/insert.do">
		<div>
			제목
			<input name="title" id="title">
		</div>

		<div>
			내용
			<textarea name="content" id="content" rows="4" cols="80"></textarea>
		</div>

		<div>
			작성자
			<input name="writer" id="writer">
		</div>
		<button type="button" id="writeBtn">작성</button>
		<button type="reset">취소</button>
	</form>

	<script>
		$("#writeBtn").click(function() {
			var title = $("#title").val();
			var content = $("#content").val();
			var writer = $("#writer").val();

			if (title == "") {
				alert("제목을 입력하세요");
				return;
			}
			if (content == "") {
				alert("내용을 입력하세요");
				return;
			}
			if (writer == "") {
				alert("작성자를 입력하세요");
				return;
			}

			document.write.submit();
		});
	</script>
</body>
</html>