<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm danh mục</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>
					<form method="post">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Nhập tên danh mục</label> <input type="text"
										name="cname" class="form-control" value="${catFindId.cname}">
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