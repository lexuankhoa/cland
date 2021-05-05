<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý danh mục</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<c:if test="${not empty msg }">
			<div class="alert alert-success" role="alert">${msg }</div>
		</c:if>
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath }/admin/cat/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
		<div class="col-md-4">
		<form  method="get" action=" " >
			  <div class="input-group form">
					<input type="text" class="form-control" placeholder="Search..."
						name="search" value = '<c:if test="${not empty search }">${search }</c:if>' /> 
					<span class="input-group-btn">
						<button   class="btn btn-primary" type="submit">Search</button>
					</span>
								</div>
					</form>
		</div>
	</div>
		<c:choose>
						<c:when test="${not empty catList }">
	<div class="row">
		<div class="panel-body">

			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên Danh Mục</th>
						<th width="300px">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				
							<c:forEach items="${catList}" var="category">
								<tr class="odd gradeX">
									<td>${category.cid }</td>
									<td>${category.cname }</td>
									<td class="center text-center"><a href="${pageContext.request.contextPath }/admin/cat/edit?cid=${category.cid }" title=""
										class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span> Sửa</a> <a onclick="return confirm('Are you sure you want to delete this item?');" href="${pageContext.request.contextPath }/admin/cat/del?cid=${category.cid }"
										title="" class="btn btn-danger"><span
											class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
							</c:forEach>
						
				</tbody>
			</table>

		
							<c:if test="${totalPage > 1 and currentPage != ''}">
						<!-- Pagination -->
						<nav class="text-center" aria-label="...">
							<ul class="pagination">
							
								<li ><a href="${pageContext.request.contextPath}/admin/cat/index/page=${currentPage-1}<c:if test='${not empty search}'>?search=${search}</c:if>" aria-label="Previous"><span
										aria-hidden="true">«</span></a></li>
									<c:forEach begin="1" end="${totalPage }" var="i">
										<li <c:if test="${i == currentPage }" > class="active"</c:if>><a href="${pageContext.request.contextPath}/admin/cat/index/page=${i}<c:if test='${not empty search}'>?search=${search}</c:if>">${i } <span class="sr-only">(current)</span></a></li>
									</c:forEach>
								<li><a href="${pageContext.request.contextPath}/admin/cat/index/page=${currentPage+1}<c:if test='${not empty search}'>?search=${search}</c:if>" aria-label="Next"><span
										aria-hidden="true">»</span></a></li>
										
							</ul>
						</nav>
						
						<!-- /.pagination -->
							</c:if>
					</div>
				</div>
	<!-- /.row -->
	</c:when>
						<c:otherwise>
						<div class="alert alert-warning" role="alert"><h4>Không có tin nào!!!</h4></div>
					</c:otherwise>
					</c:choose>
</div>
<!-- /.content-box-large -->


</div>
</div>
