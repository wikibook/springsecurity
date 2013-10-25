<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Login"/>
</jsp:include>

<h1>Please Log Into Your Account</h1>
<p>
	Please use the form below to log into your account.
</p>
<form action="j_spring_security_check" method="post">
	<label for="j_username">Login</label>:
	<input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>
	<br />

<%--
	<input id="_remember_me" name="_remember_me" type="checkbox" value="true"/>
	<label for="_remember_me">Remember Me?</label>
	<br />
--%>

	<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/>
	<label for="_spring_security_remember_me">Remember Me?</label>
	<br />
	<label for="j_password">Password</label>:
	<input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>
	<br />

	<input type="submit" value="Login"/>
</form>

<%-- Chapter 8 - OpenID --%>

<h1>Or, Log Into Your Account with OpenID</h1>
<p>
	Please use the form below to log into your account with OpenID.
</p>
<form action="j_spring_openid_security_check" method="post">
	<label for="j_username">Login</label>:
	<input id="j_username" name="j_username" size="50" maxlength="100" type="text"/>
	<img src="images/openid.png" alt="OpenID"/>
	<br />
	<input type="submit" value="Login"/>
</form>

<%-- Chapter 8 - Sign in with Google --%>
<form action="j_spring_openid_security_check" method="post">
	<input name="j_username" size="50" maxlength="100" type="hidden" value="https://www.google.com/accounts/o8/id"/>
	<br />
	<input type="submit" value="Sign in with Google"/>
</form>

<%-- Chapter 10 - Sign in with CAS --%>
<form action="j_spring_cas_security_check" method="post">
	<input name="j_username" size="50" maxlength="100" type="hidden" value="_cas_stateful_"/>
	<br />
	<input type="submit" value="Sign in with CAS"/>
</form>

<jsp:include page="common/footer.jsp"/>