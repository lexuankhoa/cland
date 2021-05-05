<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.html"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form method="get" action="${pageContext.request.contextPath}/index<c:if test="${not empty search }">?search=${search }</c:if>">
							<input type="text" placeholder="Search" name="search" value = '<c:if test="${not empty search }">${search }</c:if>'/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath}/index">Trang chủ</a></li>
							<li id="dropdown"><a href="${pageContext.request.contextPath}/cat/43/1">Bất động sản</a>
					<ul>		<c:choose>
			<c:when test="${not empty catList }">
				<c:forEach items="${catList}" var="category">	
									<li><a href="${pageContext.request.contextPath}/cat/${category.cid}/1">${category.cname}</a></li>
										</c:forEach>	</c:when>
			<c:otherwise>
						<div class="alert alert-warning" role="alert"><h4>	No data!!!</h4></div>
					</c:otherwise>
		</c:choose></ul>
							
		
							</li>
							<li><a href="${pageContext.request.contextPath}/detail/2">Giới thiệu</a></li>
							<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>