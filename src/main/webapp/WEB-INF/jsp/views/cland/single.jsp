<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="clearfix content">
	<c:choose>
		<c:when test="${not empty landsList1}">
			<fmt:formatDate value="${landsList1.date_create}" pattern="dd"
				var="fmtDate" />
			<fmt:formatDate value="${landsList1.date_create}" pattern="MM"
				var="fmtDate1" />
			<h1>${landsList1.lname }</h1>
			<div class="clearfix post-meta">
				<p>
					<span><i class="fa fa-clock-o"></i> Địa chỉ:
						${landsList1.address }</span> <span><i class="fa fa-folder"> </i>
						Diện tích: ${landsList1.area}m2</span>
				</p>
			</div>
			<div class="clearfix post_excerpt">
				<img
					src="${pageContext.request.contextPath}/resources/files/${landsList1.picture }"
					alt="" />
			</div>
			<div class="vnecontent">
				<p>${landsList1.description}</p>

			</div>
	<c:set value="${landsList1.lid }" var="lid"></c:set>
	<c:set value="${totalrow}" var="total"></c:set>
	<a class="btn" href="${pageContext.request.contextPath}/detail/${landsList1.lid-1}">Bài trước</a> <a class="btn" href="${pageContext.request.contextPath}/detail/<c:if test = "${lid==total}">
      <c:out value = "${landsList1.lid}"/>
      </c:if><c:out value = "${landsList1.lid+1}"/>">Bài kế</a>
	</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert">Không có tin !!!</div>
		</c:otherwise>
	</c:choose>
</div>

<div class="more_themes">
	<h2>
		Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i>
	</h2>
	<c:choose>
		<c:when test="${not empty landsList}">
			<c:forEach items="${landsList}" var="item">
	<div class="more_themes_container">
		<div class="single_more_themes floatleft">
			<img src="${pageContext.request.contextPath}/resources/files/${item.picture }"
								alt="" /> <a href="${pageContext.request.contextPath}/detail/${item.lid}">
								<h2>${item.lname}</h2></a>
		</div>
	</div>
				</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" role="alert"><h4>Không có tin nào!!!</h4></div>
		</c:otherwise>
	</c:choose>
</div>