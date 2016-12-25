(function () {
    "use strict";
    console.log("hello");
    angular.module('serviceiii.test', [])
        .controller('TestController', ['$scope', '$http', function ($scope, $http) {
            $scope.test = "Hello world";

            var testResponse = $http.get("rest/enums", {
                id: 1
            });
            testResponse.success(function (data, status, headers, config) {
                $scope.test = data;
            });
        }]);
})();