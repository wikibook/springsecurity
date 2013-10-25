<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="Active Users"/>
</jsp:include>

<h1>Active Users</h1>
<ul>
<c:forEach items="${activeUsers}" var="uinfo">
	<li><strong>${uinfo.key.username}</strong> / Last Active: <strong>${uinfo.value}</strong></li>
</c:forEach>
</ul>

<jsp:include page="../common/footer.jsp"/>