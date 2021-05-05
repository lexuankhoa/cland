<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="clearfix slider">
<c:choose>
		<c:when test="${not empty landsList}">
			
	<ul class="pgwSlider">
	<c:forEach items="${landsList}" var="item">
		<li><img  src="${pageContext.request.contextPath}/resources/files/${item.picture }"
			alt="${item.address }" data-description="<c:if test="${fn:length(item.description)>100}">
								${item.description.substring(0, 100)}	</c:if>"
			data-large-src="${pageContext.request.contextPath}/resources/files/${item.picture }"/></li>
			</c:forEach>
	</ul>
			
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert"><h4>Không có tin nào!!!</h4></div>
		</c:otherwise>
	</c:choose>
</div>

<div class="clearfix content">
	<div class="content_title">
		<h2>Bài viết mới</h2>
	</div>

	<c:choose>
		<c:when test="${not empty landsList1}">
			<c:forEach items="${landsList1 }" var="item">
				<fmt:formatDate value="${item.date_create}" pattern="dd"
					var="fmtDate" />
				<fmt:formatDate value="${item.date_create}" pattern="MM"
					var="fmtDate1" />

				<div class="clearfix single_content">
					<div class="clearfix post_date floatleft">
						<div class="date">
							<h3>Ngày ${fmtDate }</h3>
							<p>Tháng ${fmtDate1 }</p>
						</div>
					</div>
					<div class="clearfix post_detail">
						<h2>
							<a href="">${item.lname }</a>
						</h2>
						<div class="clearfix post-meta">
							<p>
								<span><i class="fa fa-clock-o"></i>${item.address }</span> <span><i
									class="fa fa-folder"></i> Diện tích: ${item.area} m2</span>
							</p>
						</div>
						<div class="clearfix post_excerpt">
							<img
								src="${pageContext.request.contextPath}/resources/files/${item.picture }"
								alt="" />
								<c:if test="${fn:length(item.description)>350}">
								${item.description.substring(0, 350)}
								</c:if>
								<c:if test="${fn:length(item.description)<=350}">
								${item.description}
									</c:if>
						</div>
						<a href="${pageContext.request.contextPath}/detail/${item.lid}">Đọc
							Thêm</a>
					</div>
				</div>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert"><h4>Không có tin nào!!!</h4></div>
		</c:otherwise>
	</c:choose>


</div>

<div class="pagination">
			<c:if test="${totalPage > 1 and currentPage != ''}">
						<!-- Pagination -->
						<nav class="text-center" aria-label="...">
							<ul class="pagination">
							
								<li ><a href="${pageContext.request.contextPath}/index/page=${currentPage-1}<c:if test='${not empty search}'>?search=${search}</c:if>" aria-label="Previous"><span
										aria-hidden="true">«</span></a></li>
									<c:forEach begin="1" end="${totalPage }" var="i">
										<li <c:if test="${i == currentPage }" > active</c:if>><a href="${pageContext.request.contextPath}/index/page=${i}<c:if test='${not empty search}'>?search=${search}</c:if>"><span class="sr-only">${i } </span></a></li>
									</c:forEach>
								<li><a href="${pageContext.request.contextPath}/index/page=${currentPage+1}<c:if test='${not empty search}'>?search=${search}</c:if>" aria-label="Next"><span
										aria-hidden="true">»</span></a></li>
										
							</ul>
						</nav>
						
						<!-- /.pagination -->
							</c:if>
</div>