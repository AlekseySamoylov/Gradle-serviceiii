<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/25/16
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div ng-controller="TestController">
    <%--<h1>id пользователя: {{testLogin}}</h1>--%>
    <%--<button class="button" ng-click="showUserId()">Show user id</button>--%>


    <%--<jsp:include page="/WEB-INF/app/registration/registration.jsp"/>--%>


    <%--<jsp:include page="/WEB-INF/app/login/login.jsp"/>--%>

    <%--<jsp:include page="/WEB-INF/app/login/logout.jsp"/>--%>

    <%--<jsp:include page="/WEB-INF/app/bonus/bonus.jsp"/>--%>

    <jsp:include page="/WEB-INF/app/works/worksJournal.jsp"/>


</div>