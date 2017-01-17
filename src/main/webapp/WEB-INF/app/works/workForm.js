(function () {
    "use strict";
    angular.module('serviceiii.workForm', [])
        .controller('WorkFormController', ['$http', '$scope', function ($http, $scope) {
            $scope.work =
                {
                    title: '',
                    price: 0,
                    details: "",
                    workGroup: {
                        id: 1
                    }
                };
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

            $scope.submitWork = function () {
                console.log("hello " + $scope.work);
                $http({
                    method: 'POST',
                    url: 'rest/works',
                    data: work
                }).then(function successCallback(response) {
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });
            };

        }]);
})();