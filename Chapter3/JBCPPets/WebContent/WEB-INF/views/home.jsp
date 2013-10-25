<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<jsp:include page="common/footer.jsp"/>