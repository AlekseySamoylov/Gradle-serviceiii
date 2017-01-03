<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/22/16
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html data-ng-app="serviceiii">
<head>
    <meta charset="utf-8">
    <title><spring:message code="app.title"/></title>

    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrap"/>
    <link rel="stylesheet" href="${bootstrap}">

    <%-- JS необходимые до загрузки страницы --%>
    <spring:url value="/resources/core/js/jquery.min.js" var="jquery"/>
    <script src="${jquery}"></script>

    <spring:url value="/resources/core/js/angular.min.js" var="angular"/>
    <script src="${angular}"></script>

    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <script src="${bootstrapJs}"></script>

    <%-- скрипты приложения --%>
    <jsp:include page="/WEB-INF/app/includes/appJs.jsp"/>


</head>
<body>
<spring:url value="/resources/rest/images/1.png" var="img"/>
<img src="${img}" alt="img">

<jsp:include page="/WEB-INF/app/test/test.jsp"/>

<jsp:include page="/WEB-INF/app/registration/registration.jsp"/>


</body>
</html>
