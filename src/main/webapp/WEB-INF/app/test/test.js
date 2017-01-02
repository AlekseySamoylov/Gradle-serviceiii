(function () {
    "use strict";
    angular.module('serviceiii.test', [])
        .controller('TestController', ['$scope', '$http', 'AuthService',
            function ($scope, $http, AuthService) {
            $scope.test = "Hello world";

            var testResponse = $http.get("rest/enums", {
                id: 1
            });

                testResponse.then(function (response) {
                    $scope.testId = response.data;
                });
            
            testResponse.success(function (data, status, headers, config) {
                $scope.test = data;
            });

                AuthService.login("user", "secret").then(function (data) {
                    $scope.testLogin = data;
                });
            
        }]);
})();