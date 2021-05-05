<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="clearfix content">
	<c:if test="${not empty msg }">
		<div
			class="alert alert-success" role="alert">${msg }</div>
		<br />
		<br />
		<br />
	</c:if>
	<c:if test="${not empty err}">
		<div class="alert alert-warning" role="alert">${err}</div>
		<br />
		<br />
		<br />
	</c:if>

	<div class="contact_us">

		<h1>Liên hệ với chúng tôi</h1>

		<p>
			TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br /> Trụ sở: 154 Phạm Như
			Xương, Liên Chiểu, Đà Nẵng<br /> Web: <a
				href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
		</p>

		
		<form action="${pageContext.request.contextPath }/contact"
			method="post" id="contact_form">
			<form:errors path="contact.ct_fullname" cssStyle="color:red" cssClass="error" />
			<p>
				<input name="ct_fullname" type="text" class="wpcf7-text"
					placeholder="Họ tên *" />

			</p>
			<form:errors path="contact.ct_email" cssStyle="color:red" cssClass="error" />
			<p>
				<input name="ct_email" type="text" class="wpcf7-email"
					placeholder="Email *" />

			</p>
			<form:errors path="contact.ct_subject" cssStyle="color:red" cssClass="error" />
			<p>
				<input name="ct_subject" type="text" class="wpcf7-text"
					placeholder="Chủ đề *" />

			</p>
			<form:errors path="contact.ct_content" cssStyle="color:red" cssClass="error" />
			<p>
				<textarea name="ct_content" class="wpcf7-textarea"
					placeholder="Nội dung *"></textarea>

			</p>
			<p>
				<input type="submit" class="wpcf7-submit" value="Gửi liên hệ" />
			</p>
		</form>

	</div>
<script>
	$(document).ready(function () {
		$('#contact_form').validate({
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
				required : "Vui lòng nhập Tên",
				minlength : "Nhập tối thiểu 5 kí tự",
				maxlength : "nhập tối đa 25 kí tự",
			  },
			  "ct_email": {
				required: "vui lòng nhập email",
				email: "Vui lòng nhập đúng định dạng",
			  },
			  "ct_subject": {
				required: "Vui lòng nhập chủ đề",
			  },
			  "ct_content": {
					required: "Vui lòng nhập ý kiến",
				  },
			},
		});
	});	
	</script>
</div>

