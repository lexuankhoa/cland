<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
<c:url value="/resources/cland" var="contextPath" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>CLand | VinaEnter Edu</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<!--Oswald Font -->
		<link href="${contextPath}/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet"/> 
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="${contextPath }/css/tooltipster.css" />
		<!-- home slider-->
		<link href="${contextPath }/css/pgwslider.css" rel="stylesheet"/>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${contextPath }/css/font-awesome.min.css"/>
		<link href="${contextPath }/style.css" rel="stylesheet" media="screen"/>	
		<link href="${contextPath }/responsive.css" rel="stylesheet" media="screen"/>	
		<script	type="text/javascript" src="${contextPath }/bootstrap/js/jquery-3.6.0.min.js"></script>
		<script	type="text/javascript" src="${contextPath }/bootstrap/js/jquery.js"></script>
		<script	type="text/javascript" src="${contextPath }/bootstrap/js/bootstrap.js"></script>
<script	type="text/javascript" src="${contextPath }/bootstrap/js/jquery.validate.min.js"></script>
	</head>

	<body>
	
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
				<tiles:insertAttribute name="content"></tiles:insertAttribute>

				</div>
				<div class="clearfix sidebar_container floatright">
				<tiles:insertAttribute name="rightbar"/>

				</div>
				</div>
		</section>
	<tiles:insertAttribute name="footer"/>
		
		<script type="text/javascript" src="${contextPath }/js/jquery.tooltipster.min.js"></script>		
		<script type="text/javascript">
			$(document).ready(function() {
				$('.tooltip').tooltipster();
			});
		</script>
		 <script type="text/javascript" src="${contextPath }/js/selectnav.min.js"></script>
		<script type="text/javascript">
			selectnav('nav', {
			  label: '-Navigation-',
			  nested: true,
			  indent: '-'
			});
		</script>		
		<script src="${contextPath }/js/pgwslider.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.pgwSlider').pgwSlider({
					
					intervalDuration: 5000
				
				});
			});
		</script>
		<script type="text/javascript" src="${contextPath }/js/placeholder_support_IE.js"></script>
		<script type="text/javascript" >
	$(document).ready(function () {
		$('.contact_form').validate({
			rules: {
				"ct_fullname": {
					required: true,
					minlength : 5,
					maxlength : 25,
				},
				"ct_email": {
					required: true,
					email: true,
				},
				"ct_subject": {
					required: true,
				},
				"ct_content": {
					required: true,
				},
			},
			messages: {
			  "ct_fullname": {
				required : "Vui l??ng nh???p T??n",
				minlength : "Nh???p t???i thi???u 5 k?? t???",
				maxlength : "nh???p t???i ??a 25 k?? t???",
			  },
			  "ct_email": {
				required: "vui l??ng nh???p email",
				email: "Vui l??ng nh???p ????ng ?????nh d???ng",
			  },
			  "ct_subject": {
				required: "Vui l??ng nh???p ch??? ?????",
			  },
			  "ct_content": {
					required: "Vui l??ng nh???p ?? ki???n",
				  },
			},
		});
	});	
	</script>
	</body>
</html>

		
