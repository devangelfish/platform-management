<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>회원 관리</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/admin/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/admin/css/admin.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/member.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/admin/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/arrow.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/member.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/list.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/js/modal.js"></script>
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

			<div id="member-box">
				<div id="info-text">회원정보</div>
				<div class="infomation top">
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">아이디</div>
								<div class="input-wrapper">
									<div id="id"  class="uneditable">
										아이디
									</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">비밀번호</div>
								<div id="password-item">
									<button id="info-password-re">비밀번호 재발급</button>
								</div>
							</div>
						</div>
					</div>
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">기업명</div>
								<div class="input-wrapper">
									<div id="company-name" class="uneditable">
										기업명
									</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">사업자번호</div>
								<div class="input-wrapper">
									<div id="company-number" class="uneditable">
										사업자번호
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">사용자명</div>
								<div class="input-wrapper">
									<div id="name" class="uneditable">
										사용자명
									</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">회원구분</div>
								<div class="input-wrapper">
									<div id="identifier" class="uneditable">회원구분</div>
								</div>
							</div>
						</div>
					</div>
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">이메일주소</div>
								<div class="input-wrapper">
									<div id="email" class="uneditable">이메일주소</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">이메일수신</div>
								<div class="toggle-item">
									<div class="toggleable-item">
										<div id="email-receive" class="reception-toggle-wrapper">
											<div class="reception-toggle-circle"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">휴대폰 번호</div>
								<div class="input-wrapper">
									<div id="mobi-no" class="uneditable">휴대폰 번호</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">전화번호</div>
								<div class="input-wrapper">
									<div id="tel-no" class="uneditable">전화 번호</div>
								</div>
							</div>
						</div>
					</div>
					<div class="info-row">
						<div class="info-one-box">
							<div class="box-section">
								<div class="info-item">SMS수신</div>
								<div class="toggle-item">
									<div class="toggleable-item">
										<div id="sms-receive" class="reception-toggle-wrapper">
											<div class="reception-toggle-circle"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="info-one-box">
							<div class="box-section right-box">
								<div id="modify" class="common-button ">수정</div>
								<div id="delete" class="common-button withdrawal">탈퇴</div>
							</div>
						</div>
					</div>
					
				</div>
				<div class="infomation">
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
							<div class="list-item com-item list-disabled">사명</div>
							<div class="list-item class-item list-disabled">회원구분</div>
							<div class="list-item email-item list-disabled">이메일</div>
							<div class="list-item phone-item">전화번호</div>
						</div>
						<div id="list-section">
							<c:forEach items="${list}" var="list" varStatus="status">
								<div class="list-group" data-no="${list.no}">
									<div class="list-tuple">
										<div class="list-item no-item">${status.count}</div>
										<div class="list-item name-item">${list.name}</div>
										<div class="list-item com-item list-disabled">${list.companyName}</div>
										<div class="list-item class-item list-disabled">${list.identifier}</div>
										<div class="list-item email-item list-disabled">${list.email}</div>
										<div class="list-item phone-item">${list.telNo}</div>
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