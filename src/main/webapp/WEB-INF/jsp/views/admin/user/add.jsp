<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm User</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>
					<c:if test="${not empty err }">
			<div class="alert alert-warning" role="alert">${err }</div>
		</c:if>
					<form action="${pageContext.request.contextPath }/admin/user/add" method="post" id="user_form">
						<div class="row">
							<div class="col-sm-6">
								
								<form:errors path="user.username" cssStyle="color:red" cssClass="error" />
								<div class="form-group">
									<label>Nhập username</label> <input type="text" name="username" placeholder="Nhập username"
										class="form-control">
								</div>
									<form:errors path="user.fullname" cssStyle="color:red" cssClass="error" />
								<div class="form-group">
									<label>Nhập fullname</label> <input type="text" name="fullname" placeholder="Nhập fullname"
										class="form-control">
								</div>
									<form:errors path="user.password" cssStyle="color:red" cssClass="error" />
								<div class="form-group">
									<label>Nhập password</label> <input type="password" name="password" placeholder="Nhập password"
										class="form-control">
								</div>
								<div class="form-group">
									<label>Role</label> <select name="role" class="form-control">
										<c:choose>
											<c:when test="${not empty roleList }">
												<c:forEach items="${roleList}" var="role">
													<option value=${role.id }>${role.name}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
						No data
					</c:otherwise>
										</c:choose>
									</select>
								</div>

							</div>
						</div>

						<hr>

						<div class="row">
							<div class="col-sm-12">
								<input type="submit" value="Thêm" class="btn btn-success" />
							</div>
						</div>
					</form>
					<script type="text/javascript">
	$(document).ready(function () {
		$('#user_form').validate({
			rules: {
				"username": {
					required: true,
				/* 	minlength : 5,
					maxlength : 25, */
				},
				"fullname": {
					required: true,
				/* 	minlength : 5,
					maxlength : 25, */
				},
				"password": {
					required: true,
				},
				"repassword": {
					required: true,
					equalTo: "#password"
				},
				
			},
			messages: {
			  "username": {
				required : "Vui lòng nhập tên đăng nhập",
			/* 	minlength : "Nhập tối thiểu 5 kí tự",
				maxlength : "nhập tối đa 25 kí tự", */
			  },
			  "fullname": {
				required: "vui lòng nhập tên người dùng",
	/* 			minlength : "Nhập tối thiểu 5 kí tự",
				maxlength : "nhập tối đa 25 kí tự", */
			  },
			  "password": {
				required: "Vui lòng nhập mật khẩu",
			  },
			},
		});
	});	
	</script>
		</div>
			</div>
		</div>
	</div>
	<!-- /.row col-size -->

</div>
<!-- /.col-md-10 -->
</div>
</div>