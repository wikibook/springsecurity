<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<c:url value="/styles/style.css" var="cssUrl"/>
<link rel="stylesheet" type="text/css" href="${cssUrl}"/>
<title>JBCP Pets: ${pageTitle}</title>
</head>
<body>
<div id="header">
<%-- End of Ch 3 --%>
	<div class="username">
		<c:if test="${principal.username}">
	    	Welcome,  <strong><sec:authentication property="principal.username"/></strong  >
	    </c:if>
	    <c:if test="${!principal.username}">
	    	Welcome,  <strong><sec:authentication property="name"/></strong>
	    </c:if>
	</div>
<ul>
	<c:url value="/" var="homeUrl"/>
	<li><a href="${homeUrl}">Home</a></li>

<%-- Early Ch 3 --%>
	<c:url value="/j_spring_security_logout" var="logoutUrl"/>
	<li><a href="${logoutUrl}">Log Out</a></li>

<%-- Late Ch 3 after logout URL customization
	<c:url value="/logout" var="logoutUrl"/>
	<li><a href="${logoutUrl}">Log Out</a></li>
--%>
	<c:url value="/account/home.do" var="accountUrl"/>
	<li><a href="${accountUrl}">My Account</a></li>

	<c:url value="/wishlist/home.do" var="wishlistUrl"/>
	<li><a href="${wishlistUrl}">My Wishlist</a></li>
	
</ul>
<br />
</div>

