<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
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

#success {
	display: none;
}

#cancle {
	display: none;
}

</style>
</head>
<body>
	<div class="container">
		<h1 class="text-primary">게시글 작성</h1>
		<br />

		<form:form modelAttribute="boardModel" action="/Write" method="put" id="boardModel">
			<div class="form-group">
				<form:label path="board_TITLE">게시글 제목</form:label>
				<form:input type="text" class="form-control" path="board_TITLE" id="board_TITLE" name="board_TITLE" placeholder="게시글 제목을 입력하세요." required="required" disabled="true"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="board_PWD">게시글 패스워드</form:label>
				<form:input type="password" class="form-control" path="board_PWD" id="board_PWD" name="board_PWD" placeholder="게시글 패스워드를 입력하세요." required="required" disabled="true"></form:input>
			</div>
			
			<div class="form-group">
				<form:label path="board_CONTENT">내용</form:label>
				<form:textarea class="form-control" path="board_CONTENT" id="board_CONTENT" name="board_CONTENT" rows="15" required="required" disabled="true"></form:textarea>
			</div>

			<div class="form-group pull-right">
				<a href="/Write" id="write" class="btn btn-outline-dark">게시글 작성</a>
				<a href="#" id="modify" class="btn btn-outline-success">수정</a>
				<button id="success" type="submit" class="btn btn-outline-success">확인</button>
				<a href="#" id="cancle" class="btn btn-outline-warning">취소</a>
				<a href="#" id="delete" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteModal">삭제</a>
				<a href="/" class="btn btn-outline-dark">목록</a>
			</div>
		</form:form>
	</div>
	
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-danger" id="myModalLabel">삭제 하시겠습니까?</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h5>패스워드를 입력하세요.</h5>
					<input type="password" id="input_PWD">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="delete_BTN">확인</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#modify").on('click', function() {
				$("#board_TITLE").removeAttr('disabled');
				$("#board_PWD").removeAttr('disabled');
				$("#board_CONTENT").removeAttr('disabled');	
				$("#success").css('display', 'inline');
				$("#cancle").css('display', 'inline');
				$("#modify").css('display', 'none');
				$("#delete").css('display', 'none');			
			});
			
			$("#cancle").on('click', function() {
				$("#board_TITLE").attr('disabled', 'disabled');
				$("#board_PWD").attr('disabled', 'disabled');
				$("#board_CONTENT").attr('disabled', 'disabled');	
				$("#success").css('display', 'none');
				$("#cancle").css('display', 'none');
				$("#modify").css('display', 'inline');
				$("#delete").css('display', 'inline');		
			});
			
			
			var url = '/Board/' + ${boardModel.board_IDX} + '/';
			$(document).ready(function(){
				$('#delete_BTN').on('click',function(){
					url += $('#input_PWD').val();
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
		});
	</script>
</body>
</html>