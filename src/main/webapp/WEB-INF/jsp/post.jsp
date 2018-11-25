<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<p>
			<a href="Board/${boardModel.board_IDX}">${boardModel.board_IDX}</a>
			<a href="Board/${boardModel.board_IDX}">${boardModel.board_TITLE}</a>
		</p>
		<pre>${boardModel.board_CONTENT}</pre>
		
		<a href="/">목록으로</a>
		<a href="${boardModel.board_IDX}">수정</a>
</body>
</html>