(function () {
    "use strict";
    angular.module('serviceiii.login', [])
        .controller('LoginController', ['$scope', '$route', 'SecurityService',
            function ($scope, $route, SecurityService) {

                $scope.loginUser = function () {
                    SecurityService.login($scope.username, $scope.password);
                    $route.reload();
                };

                $scope.userLogout = function () {
                    SecurityService.logout();
                    $route.reload();
                };

            }]);
})();