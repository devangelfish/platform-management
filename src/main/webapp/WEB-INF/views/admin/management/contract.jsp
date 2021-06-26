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

<title>계약 관리</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css"	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/contract.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/ejs/ejs.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/contract.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/admin.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/modal.js"></script>
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
			<div id="contract-container">
				<div id="checked-section">
					<input type="radio" name="checked_info" value="all" checked>전체
					<input type="radio" name="checked_info" value="contract">계약
					<input type="radio" name="checked_info" value="noncontract">미계약
				</div>
				<div id="list-schema">
					<div class="list-item no-item">번호</div>
					<div class="list-item date-item">처리일시</div>
					<div class="list-item type-item">분류</div>
					<div class="list-item price-item">가격</div>
				</div>
				<div id="list-section">
					<c:forEach items="${list}" var="contractVo" varStatus="status">
						<c:choose>
							<c:when test="${not empty contractVo.contractDate}">
								<div class="list-group" data-no="${contractVo.no}" data-date="${contractVo.contractDate}">
							</c:when>
							<c:otherwise>
								<div class="list-group" data-no="${contractVo.no}">
							</c:otherwise>
						</c:choose>
							<div class="list-tuple">
								<div class="list-item no-item">${status.count}</div>
								<div class="list-item date-item">${contractVo.latestStatusDate}</div>
								<div class="list-item type-item">${contractVo.type}</div>
								<div class="list-item price-item">${contractVo.price}</div>
							</div>
						</div> 
					</c:forEach>
				</div>
				<div id="status-section">
					<div id="status-progress">
						<h1>&nbsp</h1>
						<div id="status-bar-wrapper">
							<div class="status-bar detacted"></div>
							<div class="status-bar undetacted"></div>
						</div>
						<div id="status-list-wrapper">
							<ul>
								<c:forEach items="${status}" var="statusVo" varStatus="status">
									<li data-no="${statusVo.statusNo}">${statusVo.name}</li>
								</c:forEach>
							</ul>
						</div>
					</div>	
				</div>
			<div id="status-editing-section">
				<form action="#">
					<div id=textarea-container></div>	
					<div id="button-section">							
						<a href="#" class="status-btn" id="next-btn">다음단계</a>
						<a href="#" class="status-btn" id="save-btn">저장</a>							
					</div>
				</form>
			</div>
			</div>
		</div>
	</div>
</body>
</html>