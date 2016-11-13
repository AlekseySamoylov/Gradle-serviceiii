<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Service III</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<body>
<h1>Hello service</h1>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<spring:url value="/coordinates" var="coordinatesUrl"/>
<a href="${coordinatesUrl}">Coordinates</a>
<br/>
<spring:url value="/enums" var="enumsUrl"/>
<a href="${enumsUrl}">Enums details</a>
<br/>

<spring:url value="/works" var="worksUrl"/>
<a href="${worksUrl}">Works</a>
<br/>

<spring:url value="/prices" var="pricesUrl"/>
<a href="${pricesUrl}">Prices</a>
<br/>

<spring:url value="/workGroups" var="workGroupsUrl"/>
<a href="${workGroupsUrl}">WorkGroups</a>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>