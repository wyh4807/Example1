<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>게시판 목록</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<style>
.container {
	margin-top: 2%;
}
</style>


</head>
<body>
	<div class='container'>

		<h1 class="text-primary">게시판</h1>
		<br />

		<div class="card-body">
			<table class="table table-hover" id="board" cellspacing="0">
				<thead>
					<tr class="d-flex">
						<th class="col-sm-1"><input type="checkbox" id="checkall" /></th>
						<th class="text-center col-sm-2">글 번호</th>
						<th class="text-center col-sm-7">글 제목</th>
						<th class="col-sm-1">수정</th>
						<th class="col-sm-1">삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${boardModel}">
						<tr class="d-flex">
							<th class="col-sm-1"><input type="checkbox" class="checkthis" /></th>
							<td class="text-center col-sm-2"><a href="/Board/${list.board_IDX}" class="idx">${list.board_IDX}</a></td>
							<td class="col-sm-7"><a href="/Board/${list.board_IDX}">${list.board_TITLE}</a></td>
							<td class="col-sm-1"><a href="/Board/${list.board_IDX}" class="btn btn-outline-primary" title="게시글 수정"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
							<td class="col-sm-1"><button type="button" class="btn btn-outline-danger delete" title="게시글 삭제">
									<i class="fa fa-trash-o" aria-hidden="true"></i>
								</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-12">
			<p class="pull-right">
				<a href="/Write" class="btn btn-outline-dark"> 게시글 작성 </a>
			</p>
		</div>

		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-left" aria-hidden="true"></i></a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-right" aria-hidden="true"></i></a></li>
		</ul>
	</div>

	<script>
		$(document).ready(function() {
			$("#checkall").click(function() {
				if ($("#checkall").is(':checked')) {
					$("input[type=checkbox]").each(function() {
						$(this).prop("checked", true);
					});

				} else {
					$("input[type=checkbox]").each(function() {
						$(this).prop("checked", false);
					});
				}
			});

			$('.delete').on('click', function() {
				var idx = $(".delete").index(this);
				idx = $('.idx').eq(idx).text();
				var url = '/Board/' + idx;
				$.ajax({
					url : url,
					type : 'delete',
					success : function(data) {
						if (data)
							location.href = '/';
						else
							alert("error");
					},
					error : function(xhr, status, error) {
						alert("server error");
						location.href = '/';
					}
				});
			});

		});
	</script>


</body>
</html>