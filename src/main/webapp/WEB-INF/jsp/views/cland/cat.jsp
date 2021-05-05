<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="clearfix content">
	<div class="content_title">
	<c:if test="${not empty nameCat}"/>
		<h2>${nameCat}</h2>
	</div>

	<div class="clearfix single_work_container">
	<c:choose>
		<c:when test="${not empty getByCatId}">
			<c:forEach items="${getByCatId }" var="item">
				<fmt:formatDate value="${item.date_create}" pattern="dd"
					var="fmtDate" />
				<fmt:formatDate value="${item.date_create}" pattern="MM"
					var="fmtDate1" />
		<div class="clearfix single_work">
					<a href="${pageContext.request.contextPath}/detail/${item.lid}"><img class="img_top" src="${pageContext.request.contextPath}/resources/files/${item.picture }" alt="" /> <img
				class="img_bottom" src="${contextPath }/images/work_bg2.png" alt="" />
			<h2>${item.lname}</h2>
	<p class="caption">
			<c:if test="${fn:length(item.description)>200}">
			${item.description.substring(0, 200)}
			</c:if>
			<c:if test="${fn:length(item.description)<=200}">
			${item.description}
			</c:if>
			</p></a>
		</div>
		</c:forEach>
			</c:when>
		
		
		<c:otherwise>
			<div style="padding-left:20px;" class="alert alert-warning" role="alert">Không có tin!!!</div>
		</c:otherwise>
	</c:choose>
				<c:if test="${totalPage > 1 and currentPage != ''}">
			<div class="clearfix work_pagination">
				<nav>
					<a class="newer floatleft" href="${pageContext.request.contextPath}/cat/${cid}/${currentPage-1}"> < -- Trang trước</a> <a
						class="older floatright" href="${pageContext.request.contextPath}/cat/${cid}/${currentPage+1}">Trang kế -- ></a>
				</nav>
			</div>
		</c:if>

	</div>
			</div>

