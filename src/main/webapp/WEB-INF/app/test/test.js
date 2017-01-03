(function () {
    "use strict";
    angular.module('serviceiii.test', [])
        .controller('TestController', ['$scope', '$http', 'SecurityService',
            function ($scope, $http, SecurityService) {
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

                SecurityService.login("user", "secret").then(function (data) {
                    $scope.testLogin = data;
                });
            
        }]);
})();