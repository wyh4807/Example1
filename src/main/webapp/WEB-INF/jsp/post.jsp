<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>
var url = '/Board/' + ${boardModel.board_IDX};
	$(document).ready(function(){
		$('#post_delete').on('click',function(){
			$.ajax({
				url:url,
				type:'delete',
				success:function(data){
					if(data) location.href = '/';
					else alert("error");
				},
				error:function(xhr,status,error){
					alert("server error");
					location.href = '/';
				}
			})
		});
	});

</script>
</head>
<body>
		<p>
			<a href="Board/${boardModel.board_IDX}">${boardModel.board_IDX}</a>
			<a href="Board/${boardModel.board_IDX}">${boardModel.board_TITLE}</a>
		</p>
		<pre>${boardModel.board_CONTENT}</pre>
		
		<a href="/">목록으로</a>
		<a href="${boardModel.board_IDX}">수정</a>
		<a href="" id="post_delete">삭제</a>
</body>
</html>