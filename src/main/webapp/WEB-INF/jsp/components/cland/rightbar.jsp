<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix sidebar">
	<div class="clearfix single_sidebar category_items">
		<h2>Danh mục bất động sản</h2>
		<c:choose>
			<c:when test="${not empty catList2 }">
				<c:forEach items="${catList2}" var="category2">
					<ul>
						<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${category2.cid}/1">${category2.cname}</a>(${category2.totalLand })</li>
					</ul>
				</c:forEach>
			</c:when>
			<c:otherwise>
						No data
					</c:otherwise>
		</c:choose>
	</div>

	<div class="clearfix single_sidebar">
		<div class="popular_post">
			<div class="sidebar_title">
				<h2>Xem nhiều</h2>
			</div>
			<c:choose>
		<c:when test="${not empty landsList}">
			<c:forEach items="${landsList}" var="item">
	<ul >
				<li><a href="${pageContext.request.contextPath}/detail/${item.lid}">${item.lname }</a></li>
			</ul>
				</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert"><h4>Không có tin nào!!!</h4></div>
		</c:otherwise>
	</c:choose>
			
		</div>
	</div>

	<div class="clearfix single_sidebar">
		<h2>Danh mục hot</h2>
		<c:choose>
			<c:when test="${not empty catListHot }">
				<c:forEach items="${catListHot}" var="category">
					<ul>
						<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${category.cid}/1">${category.cname}</a>(${category.totalLand})</li>
					</ul>
				</c:forEach>
			</c:when>
			<c:otherwise>
					<div class="alert alert-warning" role="alert"><h4>No data category!!!</h4></div>
					</c:otherwise>
		</c:choose>
	</div>
</div>