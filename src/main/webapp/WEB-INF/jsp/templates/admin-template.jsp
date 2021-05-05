<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<c:url value="/resources/admin" var="contextPath" scope="application" />
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Admin Theme v3</title>
<link rel="shortcut icon" type="image/ico"
	href="images/icon-180x180.png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="${contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- styles -->
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link href="${contextPath}/css/style1.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script	type="text/javascript" src="${contextPath }/bootstrap/js/jquery-3.6.0.min.js"></script>
        <script	type="text/javascript" src="${contextPath }/bootstrap/jquery.js"></script>
<script	type="text/javascript" src="${contextPath }/bootstrap/js/jquery.validate.min.js"></script>
</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	<!-- /.header -->

	<div class="page-content">
		<div class="row">
			<div class="col-md-2">
				<div class="sidebar content-box" style="display: block;">
					<tiles:insertAttribute name="leftbar" />
				</div>
			</div>
			<tiles:insertAttribute name="content" />
			<footer>
				<tiles:insertAttribute name="footer" />
			</footer>
			<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
			<script src="${contextPath}/js/custom.js"></script>
</body>
</html>