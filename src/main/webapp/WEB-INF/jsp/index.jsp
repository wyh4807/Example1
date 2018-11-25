<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="list" items="${boardModel}">
		<p>
			<a href="Board/${list.board_IDX}">${list.board_IDX}</a>
			<a href="Board/${list.board_IDX}">${list.board_TITLE}</a>
		</p>
		
		
	</c:forEach>
</body>
</html>