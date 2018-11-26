<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<style>
.container {
	margin-top: 2%;
}

textarea {
	resize: none;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-primary">게시글 작성</h1>
		<br />

		<form:form modelAttribute="boardModel" action="/Write" method="Post" id="boardModel">
			<div class="form-group">
				<form:label path="board_TITLE">게시글 제목</form:label>
				<form:input type="text" class="form-control" path="board_TITLE" name="board_TITLE" placeholder="게시글 제목을 입력하세요." required="required"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="board_PWD">게시글 패스워드</form:label>
				<form:input type="password" class="form-control" path="board_PWD" name="board_PWD" placeholder="게시글 패스워드를 입력하세요." required="required"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="board_CONTENT">내용</form:label>
				<form:textarea class="form-control" path="board_CONTENT" name="board_CONTENT" rows="15"></form:textarea>
			</div>

			<div class="form-group pull-right">
				<button type="submit" class="btn btn-outline-success">저장</button>
				<button type="reset" class="btn btn-outline-warning">초기화</button>
				<a href="/" class="btn btn-outline-dark">취소</a>
			</div>
		</form:form>
	</div>
</body>
</html>