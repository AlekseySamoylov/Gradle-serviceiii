<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 12/25/16
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div ng-controller="WorksJournalController">
    <div ng-show="editorMode" class="container">
        <h1>Добавление работы</h1>
        <form name="registrationForm" ng-submit="submitWork()">

            <div class="form-group">
                <label for="workGroupId">Наименование группы работ</label>
                <h1>{{tempWorkGroupTitle}}</h1>
                <select required class="form-control" id="workGroupId" ng-model="work.workGroup.id">
                    <option ng-repeat="workGroup in workGroups" value="{{workGroup.id}}"
                            ng-selected="selectedWorkGroup(workGroup.id)">{{workGroup.title}}
                    </option>
                </select>
            </div>

            <div class="form-group">
                <label for="titleId">Название работы</label>
                <input required class="form-control" type="text" id="titleId" ng-model="work.title"/>
            </div>

            <div class="form-group">
                <label for="priceId">Цена</label>
                <input required class="form-control" type="number" id="priceId" ng-model="work.price"/>

            </div>
            <div class="form-group">
                <label for="detailsId">Описание работы</label>
                <textarea class="form-control" id="detailsId" ng-model="work.details"></textarea>
            </div>
            <div class="form-group">
                <button class="btn btn-success" type="submit">Сохранить</button>
            </div>
        </form>
        <div class="form-group">
            <button class="btn" ng-click="backButton()">Назад</button>
        </div>
    </div>
    <div ng-hide="editorMode" class="container">

        <h1>Список работ</h1>

        <button class="button btn-success" ng-click="addWork()">Добавить работу</button>
        <table class="table" ng-repeat="filledWorkGroup in filledWorkGroups">
            <tr>
                <td colspan="5"><strong>{{filledWorkGroup.title}}</strong></td>
            </tr>
            <hr>
            <td>Название</td>
            <td>Цена</td>
            <td colspan="2">Описание</td>
            <td>Опции</td>
            </hr>
            <tr ng-repeat="work in filledWorkGroup.works">
                <td>{{work.title}}</td>
                <td>{{work.price}}</td>
                <td colspan="2">{{work.details}}</td>
                <td>
                    <button class="button btn-default" ng-click="edit(work, filledWorkGroup.id)">Изменить</button>
                    <button class="button btn-danger" ng-click="delete(work.id)">Удалить</button>
                </td>
            </tr>
        </table>

    </div>
</div>