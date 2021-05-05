<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="clearfix slider">
	<ul class="pgwSlider">
		<li><img src="${contextPath }/images/thumbs/megamind_07.jpg"
			alt="Paris, France" data-description="Eiffel Tower and Champ de Mars"
			data-large-src="${contextPath }/images/slides/megamind_07.jpg" /></li>
		<li><img src="${contextPath }/images/thumbs/wall-e.jpg"
			alt="MontrÃ©al, QC, Canada"
			data-large-src="${contextPath }/images/slides/wall-e.jpg"
			data-description="Eiffel Tower and Champ de Mars" /></li>
		<li><img
			src="${contextPath }/images/thumbs/up-official-trailer-fake.jpg"
			alt="Shanghai, China"
			data-large-src="${contextPath }/images/slides/up-official-trailer-fake.jpg"
			data-description="Shanghai ,chaina"></li>


	</ul>
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
									class="fa fa-folder"></i> Diện tích: ${item.area}</span>
							</p>
						</div>
						<div class="clearfix post_excerpt">
							<img
								src="${pageContext.request.contextPath}/resources/files/${item.picture }"
								alt="" />
							<p>${item.description}</p>
						</div>
						<a href="${pageContext.request.contextPath}/detail/${item.lid}">Đọc
							Thêm</a>
					</div>
				</div>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Không có tin!!!</p>
		</c:otherwise>
	</c:choose>


</div>

<div class="pagination">
	<nav>
		<ul>
			<li><a href=""> << </a></li>
			<li><a href="">1</a></li>
			<li><a href="">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href=""> >> </a></li>
		</ul>
	</nav>
</div>