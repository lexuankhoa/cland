<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa danh mục</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>
					<form method="post" id="cat_form">
						<div class="row">
							<div class="col-sm-6">
							<form:errors path="cat.cname" cssStyle="color:red" cssClass="error" />
								<div class="form-group">
									<label>Nhập tên danh mục</label>
									 <input type="text" name="cname" class="form-control">
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
					<script>
	$(document).ready(function () {
		$('#cat_form').validate({
			rules: {
				"cname": {
					required: true,
					minlength : 5,
					maxlength : 25,
				},
			},
			messages: {
			  "cname": {
				required : "Vui lòng nhập tên danh mục",
				minlength : "Nhập tối thiểu 5 kí tự",
				maxlength : "nhập tối đa 25 kí tự",
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