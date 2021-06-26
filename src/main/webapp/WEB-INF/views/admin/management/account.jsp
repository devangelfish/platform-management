<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>관리자 계정 관리</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/account.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/modal.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/account.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/admin.js"></script>
<script src="${pageContext.request.contextPath }/assets/admin/ejs/ejs.js"></script>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/admin/includes/side-bar.jsp' />
		
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<!-- header -->
			<c:import url='/WEB-INF/views/admin/includes/header.jsp' />
			<span id="function-arrow">
				<button class="arrow-toggler"></button>
			</span>
			<div id="manager-box">
				<div id="info-text">계정</div>
				<div class="infomation top">
						<div class="info-row">
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">아이디</div>
									<div class="input-wrapper">
										<div class="uneditable" id="id">${user.id}</div>
									</div>
								</div>
							</div>
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">비밀번호</div>
									<div class="input-wrapper">
										<input class="editable" type="text" name="password" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="info-row">
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">이름</div>
									<div class="input-wrapper">
										<div class="uneditable">${user.name}</div>
									</div>
								</div>
							</div>
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">직책</div>
									<div class="input-wrapper">
										<div class="uneditable">${user.position}</div>
									</div>
								</div>
							</div>
						</div>
						<div class="info-row">
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">이메일</div>
									<div class="input-wrapper">
										<input class="editable" type="text" name="email" value="${user.email}">
									</div>
								</div>
							</div>
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">소속</div>
									<div class="input-wrapper">
										<div class="uneditable">${user.department}</div>
									</div>
								</div>
							</div>
						</div>
						<div class="info-row">
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">연락처</div>
									<div class="input-wrapper">
										<input class="editable" type="text" name="contactNo" value="${user.contactNo}">
									</div>
								</div>
							</div>
							<div class="info-one-box">
								<div class="box-section">
									<div class="info-item">팩스 번호</div>
									<div class="input-wrapper">
										<input class="editable" type="text" name="faxNo" value="${user.faxNo}">
									</div>
								</div>
							</div>
						</div>
						<div class="info-row">
							<div class="info-one-box">
							</div>
							<div class="info-one-box">
								<div class="box-section right-box">
									<div class="common-button" id="modify">수정</div>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>