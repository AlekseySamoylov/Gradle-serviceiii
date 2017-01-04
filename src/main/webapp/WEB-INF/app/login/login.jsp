<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div class="container" ng-show="!SecurityService.isLoggedId()" ng-controller="LoginController">
    <h1>Вход</h1>

    <form name="registrationForm" ng-submit="loginUser()">

        <div class="form-group">
            <input class="form-control" placeholder="Логин" type="text" name="login" ng-model="username" required/>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Пароль" type="password" name="password" ng-model="password"
                   required/>
        </div>

        <div class="form-group">
            <button class="btn btn-success" type="submit">Войти</button>
        </div>
    </form>
</div>