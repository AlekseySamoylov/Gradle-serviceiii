<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/15/16
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>Hello test Client</h1>
<a href="<spring:url value="/logout"/>"><spring:message code="header.logout" text="Logout"/></a>
</body>
</html>
