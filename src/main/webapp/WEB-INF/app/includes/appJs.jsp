<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<spring:url value="/application/app.js" var="app"/>
<script src="${app}"></script>

<%--<spring:url value="/application/location/location.js" var="location"/>--%>
<%--<script src="${location}"></script>--%>

<spring:url value="/application/security/securityService.js" var="auth"/>
<script src="${auth}"></script>

<spring:url value="/application/registration/registration.js" var="registration"/>
<script src="${registration}"></script>

<spring:url value="/application/login/login.js" var="login"/>
<script src="${login}"></script>

<spring:url value="/application/bonus/bonus.js" var="bonus"/>
<script src="${bonus}"></script>

<spring:url value="/application/test/test.js" var="test"/>
<script src="${test}"></script>

<spring:url value="/application/works/workForm.js" var="workForm"/>
<script src="${workForm}"></script>

<spring:url value="/application/works/worksJournal.js" var="worksJournal"/>
<script src="${worksJournal}"></script>
