<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>문의 관리</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css"	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/answer.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/answer.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/admin.js"></script>
</head>
<body>
	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/admin/includes/side-bar.jsp' />

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<!-- header --> 
			<c:import url='/WEB-INF/views/admin/includes/header.jsp' />
			<div class="toolbar-wrapper">
				<div id="floating-toolbar" class="hide">
					<i class="fas fa-cog"></i>
					<a id="back-space" href="${pageContext.request.contextPath}/question"><i class="fas fa-backward"></i></a>
					<i class="fas fa-angle-double-up"></i>
					<i class="fas fa-angle-double-down"></i>
				</div>
			</div>
			<span id="function-arrow">
				<button class="arrow-toggler">
				</button>
			</span>
			<div id="q-container">
				<div class="main-section" id="main-question">
					<div id="title-section">${question.title}</div>
					<div class="contents-section">${question.contents}</div>
					<div class="info-section">
						<div class="writing-profile"></div>
						<div class="writing-author">${question.userName}</div>
						<div class="writing-time">${question.date}</div>
					</div>
				</div>
			</div>
			<div id="w-container">
				<c:forEach items="${list}" var="list">
					<c:choose>
						<c:when test="${not empty list.adminNo}">
							<div class="common-section">
								<div class="head-section">${list.adminName}(관리자)</div>
								<div class="contents-section">${list.contents}</div>
								<div class="info-section">
									<div class="writing-time">${list.date}</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="common-section">
								<div class="head-section">${list.userName}(작성자)</div>
								<div id="author-writing"><i class="fas fa-user-edit"></i></div>
								<div class="contents-section">${list.contents}</div>
								<div class="info-section">
									<div class="writing-time">${list.date}</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<div id="a-container">
				<div id="profile-section">'${question.userName}' 님에게 답변하기</div>
				<div id="writing-section">
					<form action="${pageContext.request.contextPath}/question" method="post">
						<textarea id="writing-textarea" name="contents" placeholder="답변할 내용을 입력해주세요."></textarea>
						<input type="hidden" name="inquiryNo" value="${question.no}">
						<input type="hidden" name="adminNo" value="${user.no}">
						<input type="hidden" name="adminName" value="${user.name}">
						<input id="reply-confirm" type="submit" value="답변하기">
					</form>
					<div id="status-section">
						<select name="status">
							<c:forEach items="${status}" var="status">
								<c:choose>
									<c:when test="${status.no eq question.statusNo}">
										<option value="${status.no}" selected="selected">${status.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${status.no}">${status.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>