(function () {
    "use strict";

    angular.module('serviceiii.worksJournal', [])
        .controller('WorksJournalController', ['$scope', '$http', function ($scope, $http) {

            $scope.editorMode = false;

            $scope.filledWorkGroups = {};

            $scope.tempWorkGroup = {};

            $scope.work =
                {
                    title: '',
                    price: 0,
                    details: "",
                    workGroup: {
                        id: 1
                    }
                };

            $scope.selectedWorkGroup = function (workGroupId) {

                return $scope.work.workGroup.id === workGroupId;
            };

            $scope.refreshWorksJournal = function () {
                $http({
                    method: 'GET',
                    url: 'rest/works'
                }).then(function successCallback(response) {
                    $scope.filledWorkGroups = response.data;
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });
            };
            $scope.refreshWorksJournal();


            $scope.workGroups = {};


            $http({
                method: 'GET',
                url: 'rest/workGroups'
            }).then(function successCallback(response) {
                $scope.workGroups = response.data;
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });


            $scope.cleanWork = function () {
                $scope.work.id = undefined;
                $scope.work.title = "";
                $scope.work.price = 0;
                $scope.work.details = "";
            };

            $scope.backButton = function () {
                $scope.cleanWork();
                $scope.editorMode = false;
            };

            $scope.submitWork = function () {
                console.log("hello " + $scope.work);
                if ($scope.work.id) {
                    $http({
                        method: 'PUT',
                        url: 'rest/works/' + $scope.work.id,
                        data: $scope.work
                    }).then(function successCallback(response) {
                        $scope.refreshWorksJournal();
                        $scope.cleanWork();
                        $scope.editorMode = false;
                    }, function errorCallback(response) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                    });
                } else {
                    $http({
                        method: 'POST',
                        url: 'rest/works',
                        data: $scope.work
                    }).then(function successCallback(response) {
                        $scope.refreshWorksJournal();
                        $scope.cleanWork();
                        $scope.editorMode = false;
                    }, function errorCallback(response) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                    });
                }

            };

            $scope.delete = function (workId) {
                console.log("hello delete workId " + workId);
                $http({
                    method: 'DELETE',
                    url: 'rest/works/' + workId
                }).then(function successCallback(response) {
                    $scope.refreshWorksJournal();
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });
            };

            $scope.edit = function (editWork, editWorkGroupId) {
                console.log("hello edit " + editWork.id);
                $scope.work.id = editWork.id;
                $scope.work.title = editWork.title;
                $scope.work.price = editWork.price;
                $scope.work.details = editWork.details;
                $scope.work.workGroup.id = editWorkGroupId;
                $scope.editorMode = true;

            };

            $scope.addWork = function () {
                $scope.editorMode = true;
            }


        }]);
})();