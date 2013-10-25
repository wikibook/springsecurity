<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="View Profile"/>
</jsp:include>

<h1>View Profile</h1>
<p>
	Some information about you, from CAS:
</p>
<ul>
	<li><strong>Auth:</strong> ${auth}</li>
	<li><strong>Username:</strong> ${auth.principal}</li>
	<li><strong>Credentials:</strong> ${auth.credentials}</li>
	<c:if test="${isCasAuthentication}">
		<li><strong>Assertion:</strong> ${auth.assertion}</li>
		<li><strong>Assertion Attributes:</strong>
		<c:forEach items="${auth.assertion.attributes}" var="attr">
			${attr.key}:${attr.value}<br />
		</c:forEach>
		</li>
		<li><strong>Assertion Attribute Principal:</strong> ${auth.assertion.principal}</li>
		<li><strong>Assertion Principal Attributes:</strong>
		<c:forEach items="${auth.assertion.principal.attributes}" var="attr">
			${attr.key}:${attr.value}<br />
		</c:forEach>
		</li>
	</c:if>
</ul>

<jsp:include page="../common/footer.jsp"/>