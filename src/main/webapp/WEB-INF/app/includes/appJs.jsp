<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<spring:url value="/application/app.js" var="app"/>
<script src="${app}"></script>

<spring:url value="/application/test/test.js" var="test"/>
<script src="${test}"></script>
