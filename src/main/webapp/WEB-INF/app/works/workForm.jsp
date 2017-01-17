<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/25/16
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container" ng-controller="WorkFormController">

    <h1>Добавление работы</h1>
    <form name="registrationForm" ng-submit="submitWork()">

        <div class="form-group">
            <label for="workGroupId">WorkGroup</label>
            <select class="form-control" id="workGroupId" ng-model="work.workGroup">
                <option ng-repeat="workGroup in workGroups" value="{{workGroup.id}}">{{workGroup.title}}</option>
            </select>
        </div>

        <div class="form-group">
            <label for="titleId">Title</label>
            <input class="form-control" type="text" id="titleId" ng-model="work.title"/>
        </div>

        <div class="form-group">
            <label for="priceId">Price</label>
            <input class="form-control" type="number" id="priceId" ng-model="work.price"/>

        </div>
        <div class="form-group">
            <textarea class="form-control" id="detailsId" ng-model="work.details"></textarea>
        </div>
        <div class="form-group">
            <button class="btn btn-success" type="submit">Сохранить</button>
        </div>
    </form>
</div>