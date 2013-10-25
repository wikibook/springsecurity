<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="View Profile"/>
</jsp:include>

<h1>View Profile</h1>
<p>
	Some information about you, from LDAP:
</p>
<ul>
	<li><strong>Username:</strong> ${user.username}</li>
	<li><strong>DN:</strong> ${user.dn}</li>
	<c:if test="${isLdapPerson}">
		<li><strong>Description:</strong> ${user.description}</li>
		<li><strong>Telephone:</strong> ${user.telephoneNumber}</li>
		<li><strong>Full Name(s):</strong>
		<c:forEach items="${user.cn}" var="cn">
			${cn}<br />
		</c:forEach>
		</li>
	</c:if>
	<c:if test="${isLdapInetOrgPerson}">
		<li><strong>Email:</strong> ${user.mail}</li>
		<li><strong>Street:</strong> ${user.street}</li>
	</c:if>
</ul>

<jsp:include page="../common/footer.jsp"/>