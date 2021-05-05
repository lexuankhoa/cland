
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Sửa Lands</div>
		</div>
		<div class="content-box-large box-with-header">

			<form action="" method="post" enctype="multipart/form-data" id="land_form">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="lname">Tên tin</label> <input type="text"
									name="lname" class="form-control" value="${landFindId.lname }">
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
									<c:choose>
												<c:when test="${not empty landFindId.picture }">
													<img width="100px" height="70px" src="${pageContext.request.contextPath}/resources/files/${landFindId.picture }" />
												</c:when>
												<c:otherwise>
													<p>không có hình ảnh!!!</p>
												</c:otherwise>
											</c:choose>
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
							</div>

							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3" name = "description">${landFindId.description }</textarea>
							</div>
							<script type="text/javascript">
							CKEDITOR.replace("description");
							</script>
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text"
									name="address" class="form-control" value="${landFindId.address }">
							</div>
							<div class="form-group">
								<label for=area>Diện tích</label> <input type="text"
									name="area" class="form-control" value="${landFindId.area }">
							</div>
						</div>

						<div class="col-sm-6"></div>

						
						
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Sửa" class="btn btn-success" /> <!-- <input
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
