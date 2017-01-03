<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<spring:url value="/rest/coordinates" var="coordinatesUrl"/>
<a href="${coordinatesUrl}">Coordinates</a>
<br/>
<spring:url value="/rest/enums" var="enumsUrl"/>
<a href="${enumsUrl}">Enums details</a>
<br/>

<spring:url value="/rest/works" var="worksUrl"/>
<a href="${worksUrl}">Works</a>
<br/>

<spring:url value="/app" var="appUrl"/>
<a href="${appUrl}">Application</a>
<br/>

<p>/rest/works/{id} - GET для получения работы</p>
<p>/rest/works/{id} - DELEte для получения работы</p>
<p>/rest/works POST запрос для сохранения новой работы</p>
<p>/rest/works/{id} PUT запрос для обновления работы</p>
<p>/rest/workGroups/{id} - для получения группы работ</p>
<p>/rest/worksByGroupId/{id} - для получения работ определенной группы</p>
<p>/rest/bonus/{id} - запрос на получение суммы бонусов пользователя (1)</p>
<p>/rest/customer - POST запрос для добавления (регистрации) пользователя</p>
<p>Картинки с именами, соответствующими id группы работ по адресу:</p>
<p>/files/staticImages/{imageName}</p>
<pre>
    Сохранение работы пример Json для POST запроса:
    {"title":"Новая работа", "price":5000, "details":"Подробности", "workGroup":{"id":2}}
    Обновление работы пример Json для POST запроса:
    {"id":14, "title":"Ремонт ТНВД2", "price":5000, "details":"Очень ответственная работа2", "workGroup":{"id":1}}
</pre>

<spring:url value="/rest/workGroups" var="workGroupsUrl"/>
<a href="${workGroupsUrl}">WorkGroups</a>
<br/>
<a href="<spring:url value="/logout"/>"><spring:message code="header.logout" text="Logout"/></a>
<br/>
<spring:url value="/admin" var="adminUrl"/>
<a href="${adminUrl}">AdminPanel</a>
<br/>
<a href="<spring:url value="/client"/>">Клиент</a>
<br/>
<a href="<spring:url value="/app"/>">Тестовая страница приложения</a>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>