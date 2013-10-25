<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="Change Password"/>
</jsp:include>

<h1>Change Password</h1>
<form method="post">
	<label for="password">New Password</label>:
	<input id="password" name="password" size="20" maxlength="50" type="password"/>
	<br />

	<input type="submit" value="Change Password"/>	
</form>

<jsp:include page="../common/footer.jsp"/>