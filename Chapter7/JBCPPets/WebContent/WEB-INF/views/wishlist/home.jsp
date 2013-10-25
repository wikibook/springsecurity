<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="Your Wishlist"/>
</jsp:include>

<h1>Your Wish List</h1>
<p>
	Here are the items you've shown an interest in...
</p>
<ul class="wishlist">
<c:forEach items="${wishlistItems}" var="wishlistItem">
	<li><strong>${wishlistItem.title}</strong> Price: <em>${wishlistItem.displayPrice}</em>
	</li>
</c:forEach>
</ul>
<jsp:include page="../common/footer.jsp"/>