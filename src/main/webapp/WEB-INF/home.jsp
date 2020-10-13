<%-- <%@page import="com.cos.blog.model.Users"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/nav.jsp"%>

<div class="container">


	<div class="row col-md-12 m-2" style="height: 70px">
		<form class="form-inline col-md-12 justify-content-center"
			action="/blog/board?cmd=search">
			<input type="hidden" name="cmd" value="search" /> <input
				type="hidden" name="page" value="0" /> <input type="text"
				name="keyword" class="form-control mr-sm-2" placeholder="Search">
			<button class="btn btn-success" type="submit">검색</button>
		</form>
	</div>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="post" items="${postList}">

				<tr>
					<td>${post.id}</td>
					<td>
						<a href="/detail/${post.id}">
							${post.title}		
						</a>
					</td>	
					<td>${post.createDate}</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>

</div>

<%@include file="include/footer.jsp"%>



