<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/9/16
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin panel</h1>
<a href="<spring:url value="/logout"/>"><spring:message code="header.logout" text="Logout"/></a>
</body>
</html>
