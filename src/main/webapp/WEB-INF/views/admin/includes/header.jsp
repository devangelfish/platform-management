<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header --> 
<div id="status-bar">
	<div id="status-bar-left" class="status-bar-section">
		<ul>
			<li>STAR XR</li>
		</ul>
	</div>
	<div id="status-bar-right" class="status-bar-section">
		<ul>
			<c:if test="${not empty user.name}">
				<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
				<li>${user.name}</li>
			</c:if>
		</ul>
	</div>
</div>