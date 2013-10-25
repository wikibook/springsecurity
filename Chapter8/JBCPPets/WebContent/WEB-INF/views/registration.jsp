<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Register"/>
</jsp:include>

<h1>Please Register Your New Account</h1>
<p>
	Please use the form below to create a new account.
</p>
<form action="registration.do" method="post">
	<label for="userid">Login</label>:
	<input id="userid" name="userid" size="20" maxlength="50" type="text"/>
	<br />

	<label for="password">Password</label>:
	<input id="password" name="password" size="20" maxlength="50" type="password"/>
	<br />

	<label for="email">Email</label>:
	<input id="email" name="email" size="20" maxlength="50" type="email"/>
	<br />

	<input type="submit" value="Login"/>
</form>

<%-- Chapter 8 - OpenID --%>

<h1>Or, Register with OpenID</h1>
<p>
	Please use the form below to register your account with OpenID.
</p>
<form action="j_spring_openid_security_check" method="post">
	<label for="openid_identifier">Login</label>:
	<input id="openid_identifier" name="openid_identifier" size="50" maxlength="100" type="text"/>
	<img src="images/openid.png" alt="OpenID"/>
	<br />
	<input type="submit" value="Login"/>
</form>

<jsp:include page="common/footer.jsp"/>