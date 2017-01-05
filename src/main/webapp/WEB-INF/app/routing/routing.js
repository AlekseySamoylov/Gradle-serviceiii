(function () {
    "use strict";

    angular.module('serviceiii.routing', [])
        .config(function ($routeProvider) {
            $routeProvider
                .when('/admin/users/new', {templateUrl: '/hello.html'})
        })
})();