<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="Your Account"/>
</jsp:include>

<h1>Welcome to Your Account</h1>
<p>
	Please find account functions below...
</p>
<ul>
	<li><a href="changePassword.do">Change Password</a></li>
	<li><a href="viewLdapUserProfile.do">View LDAP User Profile</a></li>
</ul>

<jsp:include page="../common/footer.jsp"/>