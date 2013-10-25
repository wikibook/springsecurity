<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>

<h1>Welcome to JBCP Petstore!</h1>
<p>
	We have many great breeds of pet available for your perusal.
</p>
<ul>
	<li><a href="listPets.do?species=dog">Dogs</a></li>
	<li><a href="listPets.do?species=cat">Cats</a></li>
</ul>

<h2>Categories</h2>
<ul>
<c:forEach var="category" items="${categories}">
<%-- Ch 7 Start --%>
	<li><a href="category.do?id=${category.name}">${category.name}</a></li>
<%-- Ch 7 ACL tag demo - note REMOVE this when testing SpEL hasPermission
<security:accesscontrollist hasPermission="READ,ADMIN_READ" domainObject="${category}">
	<li><a href="category.do?id=${category.name}">${category.name}</a></li>
</security:accesscontrollist>
 --%>
</c:forEach>
</ul>
<jsp:include page="common/footer.jsp"/>