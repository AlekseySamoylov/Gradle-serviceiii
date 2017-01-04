<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div class="container" ng-show="SecurityService.isLoggedId()" ng-controller="LoginController">
    <h1>Вход</h1>
    <button class="button" ng-click="userLogout()">Выход</button>
</div>