<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa danh mục</div>
			</div>
			<c:if test="${not empty err }">
			<div class="alert alert-success" role="alert">${err }</div>
			</c:if>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>
					<form method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Nhập Username</label> <input type="text" name="username"
										class="form-control" value="${userFindId.username}">
								</div>
								<div class="form-group">
									<label>Nhập Fullname</label> <input type="text" name="fullname"
										class="form-control" value="${userFindId.fullname}">
								</div>
								<div class="form-group">
									<label>Nhập Password</label> <input type="text" name="password"
										class="form-control" value="">
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
								<input type="submit" value="Sửa" class="btn btn-success" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row col-size -->

</div>
<!-- /.col-md-10 -->
</div>
</div>