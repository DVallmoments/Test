<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#writeBtn").click(function write() {
			location.href = "${path}/board/writer.do";
		});
	});
</script>
</head>
<body>
	<button type="button" id="writeBtn">글쓰기</button>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.bno}</td>
				<td>
					<a href="${path}/board/view.do?bno=${list.bno}">${list.title}</a>
				</td>
				<td>${list.writer}</td>
				<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm:ss" type="date"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>