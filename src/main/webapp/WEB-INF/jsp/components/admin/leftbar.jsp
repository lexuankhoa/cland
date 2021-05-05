<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Nav-bar -->
<ul class="nav">
	<!-- Main menu -->
	<li class="current"><a href="${pageContext.request.contextPath }/admin/index"><i
			class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
	<li><a href="${pageContext.request.contextPath }/admin/cat/index/page=1"><i
			class="glyphicon glyphicon-list"></i> Danh mục</a></li>
	<li><a href="${pageContext.request.contextPath }/admin/user/index/page=1"><i
			class="glyphicon glyphicon-book"></i> User</a></li>
	<li><a href="${pageContext.request.contextPath }/admin/news/index/page=1"><i
			class="glyphicon glyphicon-book"></i> Land</a></li>
	<li><a
		href="${pageContext.request.contextPath }/admin/contact/index/page=1"><i
			class="glyphicon glyphicon-book"></i> Contact</a></li>
	<!-- <li><a href="add.html"><i class="glyphicon glyphicon-plus"></i>
			Thêm</a></li> -->
	<li class="submenu"><a href="#"> <i
			class="glyphicon glyphicon-list"></i> Pages <span
			class="caret pull-right"></span>
	</a> <!-- Sub menu -->
		<ul>
			<li><a href="${pageContext.request.contextPath }/auth/login">Login</a></li>
			<li><a href="javascript:void(0)">Signup</a></li>
		</ul></li>
</ul>
<!-- /.nav-bar -->