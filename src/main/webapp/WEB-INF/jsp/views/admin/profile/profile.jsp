<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div class="col-md-10">
 				<div class="row">
  				<div class="panel-heading">
  					<div class="panel-title ">Thông tin cá nhân</div>
	  			</div>
			</div>
			<hr>	
			<div class="row">
				<div class="col-md-8">

				</div>
			</div>

			<div class="row">
 				<div class="panel-body">
 					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
					<thead>
						<tr>
							<th>Tên tài khoản</th>
							<th>Tên đầy đủ</th>
							<th>Loại tài khoản</th>
						</tr>
					</thead>
					<tbody>
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
					<tr class="odd gradeX">
						<td>${sessionScope.user.username}</td>
						<td>${sessionScope.user.fullname}</td>
						<td>${sessionScope.user.role.name}</td>
					</tr>
			</c:when>
			<c:otherwise>
				<p>Không tìm thấy dữ liệu</p>
			</c:otherwise>				
		</c:choose>
						
					</tbody>
				</table>
</div></div>
 				</div>
 				</div><!-- /.row -->
 			</div><!-- /.content-box-large -->