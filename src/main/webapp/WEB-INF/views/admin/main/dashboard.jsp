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
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/admin.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/list.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/dashboard.js"></script>
<script src="${pageContext.request.contextPath }/assets/admin/ejs/ejs.js"></script>
<title>대시보드</title>
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
			<div id="dashboard-wrapper">
				<div id="pie-chart-container">
					<div class="pie-chart">
						<canvas class="canvas" id="user-identifier"></canvas>
					</div>
					<div class="pie-chart">
						<canvas class="canvas" id="contract"></canvas>
					</div>
				</div>
				<div id="question-list">
					<div id="list-title">
						답변목록
					</div>
					<div id="search-section">
						<input id="search-input" type="text" placeholder="검색">
						<button id="search-button" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
					<div id="contract-container">
						<div id="list-schema">
							<div class="list-item no-item">번호</div>
							<div class="list-item name-item">이름</div>
							<div class="list-item title-item list-disabled">문의제목</div>
							<div class="list-item count-item list-disabled">답글 수</div>
						</div>
						<div id="list-section">
							<c:forEach items="${list}" var="list" varStatus="status">
								<div class="list-group" data-no="${list.no}">
									<div class="list-tuple">
										<div class="list-item no-item">${status.count}</div>
										<div class="list-item name-item">${list.userName}</div>
										<div class="list-item title-item list-disabled">${list.title}</div>
										<div class="list-item count-item list-disabled">${list.answerCount}</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div id="more-arrow"><i class="fas fa-angle-double-down"></i></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>