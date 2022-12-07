<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form name="view" method="post">
		<div>작성일자 : ${boardDTO.regDate}</div>

		<div>
			제목
			<input name="title" id="title" value="${boardDTO.title}">
		</div>

		<div>
			내용
			<textarea name="content" id="content" rows="4" cols="80">${boardDTO.content}</textarea>
		</div>

		<div>
			작성자
			<input name="writer" id="writer" value="${boardDTO.writer}">
		</div>

		<input type="hidden" name="bno" value="${boardDTO.bno}">

		<button type="button" id="submitBtn">수정</button>
		<button type="button" id="deleteBtn">삭제</button>
	</form>

	<script>
		$("#deleteBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.view.action = "${path}/board/delete.do"
				document.view.submit();
			}
		});

		$("#submitBtn").click(function() {
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

			document.view.action = "${path}/board/update.do"
			document.view.submit();
		});
	</script>
</body>
</html>