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

<title>서비스 관리</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css"	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/service.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/list.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/service.js"></script>
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
				<button class="arrow-toggler">
				</button>
			</span>
			<div id="service-container">
				<div id="search-section">
					<input id="search-input" type="text" placeholder="검색">
					<button id="search-button" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</div>
				<div id="list-schema">
					<div class="list-item no-item">번호</div>
					<div class="list-item date-item">신청일</div>
					<div class="list-item desc-item">내용</div>
					<div class="list-item customer-item">고객명</div>
				</div>
				<div id="list-section">
					<c:forEach items="${list}" var="serviceVo" varStatus="status">
						<div class="list-group" data-no="${serviceVo.no}">	
							<div class="list-tuple">
								<div class="list-item no-item">${status.count}</div>
								<div class="list-item date-item">${serviceVo.date}</div>
								<div class="list-item desc-item">${serviceVo.name}</div>
								<div class="list-item customer-item">${serviceVo.userName}</div>						
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="more-arrow"><i class="fas fa-angle-double-down"></i></div>
			</div>
		</div>
	</div>
</body>

</html>