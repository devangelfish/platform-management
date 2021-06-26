<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>로그인</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css"	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/login.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2.2.1/src/js.cookie.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/login.js"></script>
</head>
<body>
	<div class="d-flex" id="wrapper">

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div id="login-container">
				<span class="navi-logo"></span>
				<div id="login-section">
					<form action="${pageContext.request.contextPath}/auth" method="post">
						<div id="id-section" class="input-section">
							<input class="id-password-input" name="id" type="text" placeholder="아이디">
						</div>
						<div id="password-section" class="input-section">
							<input class="id-password-input" name="password" type="password" placeholder="비밀번호">
							<i id="hidden" class="far fa-eye-slash"></i>
						</div>
						<p class="failMessage">
							${check }
						</p>
						<input type="submit" id="login-button-div" value="로그인">
						<div id="id-save-section">
							<div id="id-save-group">
								<input id="remember" name="remember" type="checkbox"><i class="far fa-check-circle"></i>
								<span id="id-save-text">아이디 저장</span>
							</div>
						</div>
					</form>
					<div id="contact-section">
						<p>로그인 문의 번호 : 031-xxx-xxxx</p>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
</body>

</html>
