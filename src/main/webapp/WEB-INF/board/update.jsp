<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>
<%@include file="../include/authentication.jsp"%>

<div class="container">
	<form id="updateForm" action="/post/updateProc" method="put" onsubmit="return validate()">
		
		<input type="hidden" value="${boardDto.id}" name="id" />
		
		<div class="form-group">
			<label for="title">Title:</label> 
			<input value="${boardDto.title}" type="text" class="form-control" placeholder="title" id="title" name="title" required>
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" placeholder="내용을 입력하세요" id="content" name="content">${boardDto.content}</textarea>
		</div>

	</form>
	
		<button type="button" class="btn btn-primary" onclick="updateProc(${boardDto.id})" >수정하기</button>
		
</div>

<script>
	$('#content').summernote({
		placeholder : 'Hello Bootstrap 4',
		tabsize : 2,
		height : 400
	});
</script>

<script>

	function updateProc(id){
		
		let data = $("#updateForm").serialize();
		alert(data);
		
		$.ajax({
			
			type : "put",
			url : "/post/updateProc",
			data : data,
			dataType : "text"
	
		}).done(function(result) {
	
			if (result == 1) {
				alert("수정 성공");
				location.href = "/detail/"+id;
			} else {
				alert("수정 실패");
			}
	
		}).fail(function(result) {
	
			alert("서버 오류");
	
		}).always(function(result) {
	
		});
		
		
		
	}

	function validate() {

		var test = $("#title").val();
		var test1 = $("#content").val();

		if (test == null || test == "") {
			alert("제목을 입력해주세요.");
			return false;
		} else if (test1 == null || test1 == "") {
			alert("내용을 입력해주세요.");
			return false;
		}
		return true;
	}
</script>


<%@include file="../include/footer.jsp"%>