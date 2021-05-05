
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm Lands</div>
		</div>
		<div class="content-box-large box-with-header">

			<form action="${pageContext.request.contextPath }/admin/news/add" method="post" enctype="multipart/form-data" id="land_form">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
						<form:errors path="lands.lname" cssStyle="color:red" cssClass="error" />
							<div class="form-group">
								<label for="lname">Tên tin</label> <input type="text"
									name="lname" class="form-control" placeholder="Nhập tên tin">
							</div>

							<div class="form-group">
								<label>Danh mục tin</label>
								 <select name="category.cid" class="form-control">
									<c:choose>
										<c:when test="${not empty catList }">
											<c:forEach items="${catList}" var="item">
												<option value="${item.cid}">${item.cname }</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<p>Không có danh mục!!!</p>
										</c:otherwise>
									</c:choose>
								</select>
							</div>

							<div class="form-group">
								<label>Thêm hình ảnh</label> <input type="file" name="file"
									class="btn btn-default" id="exampleInputFile1">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
							</div>
<%-- 	<form:errors path="lands.description" cssStyle="color:red" cssClass="error" /> --%>
							<div class="form-group">
								<label>Mô tả</label>
								<textarea id="description" class="form-control" rows="3" name = "description"></textarea>
							</div>
							<script type="text/javascript">
							CKEDITOR.replace("description");
							</script>
								<form:errors path="lands.address" cssStyle="color:red" cssClass="error" />
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text"
									name="address" class="form-control" placeholder="Nhập địa chỉ">
							</div>
								<form:errors path="lands.area" cssStyle="color:red" cssClass="error" />
							<div class="form-group">
								<label for=area>Diện tích</label> <input type="text"
									name="area" class="form-control" placeholder="Nhập diện tích">
							</div>
						</div>

						<div class="col-sm-6"></div>

						
						
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" /> <!-- <input
								type="reset" value="Nhập lại" class="btn btn-default" /> -->
						</div>
					</div>

				</div>
			</form>
			<script type="text/javascript">
	$(document).ready(function () {
		$('#land_form').validate({
			rules: {
				"lname": {
					required: true,
					minlength : 5,
				},
				"description": {
					required: true,
				},
				"address": {
					required: true,
				},
				"area": {
					required: true,
					number: true,
				},
			},
			messages: {
			  "lname": {
				required : "Vui lòng nhập Tên",
				minlength : "Nhập tối thiểu 5 kí tự",
			  },
			  "description": {
				required: "vui lòng nhập mô tả",
			  },
			  "address": {
				required: "Vui lòng nhập địa chỉ",
			  },
			  "area": {
					required: "Vui lòng nhập diện tích",
					number: "diện tích là số",
				  },
			},
		});
	});	
	</script>
		</div>
	</div>
</div>
<!-- /.row col-size -->

</div>
<!-- /.col-md-10 -->
</div>
</div>
