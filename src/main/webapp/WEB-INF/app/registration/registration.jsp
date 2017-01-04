<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div class="container" nng-show="!SecurityService.isLoggedId()" ng-controller="RegistrationController">
    <h1>Быстрая регистрация</h1>

    <p>{{user}} {{noExistInList}} {{allChecked}}</p>
    <form name="registrationForm" ng-submit="saveUser()">
        <div class="form-group">
            <input class="form-control" placeholder="Имя" type="text" name="firstName" ng-model="user.firstName"
                   ng-blur="checkFirstName()" required/>
            <span style="color: red;" ng-show="firstNameIncorrect">Укажите Ваше имя корректно</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Фамилия" type="text" name="lastName" ng-model="user.lastName"
                   ng-blur="checkLastName()" required/>
            <span style="color: red;" ng-show="lastNameIncorrect">Укажите Вашу фамилию корректно</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Номер телефона" type="text" name="userPhone" ng-model="user.phone"
                   ng-blur="checkPhone(); check()" required/>
            <span style="color: red;" ng-show="phoneIncorrect">Укажите Ваш номер телефона в формате 89991112233</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Электронная почта" type="email" name="userEmail"
                   ng-model="user.email" ng-blur="checkEM = registrationForm.userEmail.$invalid; check()" required/>
            <span style="color: red;" ng-show="checkEM">Укажите Вашу электронную почту корректно</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Логин" type="text" name="login" ng-model="user.login"
                   ng-blur="checkLogin(); checkModel()" my-login="doSomething()" required/>
            <span style="color: red;" ng-show="loginIncorrect">Введите логин корректно (только латинские буквы)</span>
            <span style="color: red;" ng-show="!noExistInList">Логин уже занят</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Пароль" type="password" name="password" ng-model="user.password"
                   my-enter="doSomething()" ng-blur="checkPassword()" required/>
            <span style="color: red;" ng-show="passIsShort">Введите пароль (более 5 символов)</span>
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="Пароль повторно" type="password" ng-model="passwordSecond"
                   ng-blur="checkRepeatedPassword()" my-enter="doSomething()" required/>
            <span style="color: red;" ng-show="passNoRepeated">Повторно введите пароль</span>
            <span style="color: red;" ng-show="passNoEquals">Пароли должны совпадать</span>
        </div>

        <div class="form-group">
            <button ng-show="noExistInList && allChecked" class="btn btn-success" type="submit">Зарегистрировать
            </button>
        </div>
    </form>
</div>