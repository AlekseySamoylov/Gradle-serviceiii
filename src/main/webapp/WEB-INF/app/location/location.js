(function () {
    "use strict";

    angular.module('serviceiii.location', [])
        .config(function ($locationProvider) {
            $locationProvider.html5Mode(true);
        });
})();