(function () {
    "use strict";

    angular.module('serviceiii', [
        'ngRoute',
        'ngCookies',
            //'serviceiii.location',
        'serviceiii.test',
        'serviceiii.security',
        'serviceiii.registration',
        'serviceiii.login',
        'serviceiii.bonus'
    ])
        .config(function ($anchorScrollProvider) {
            $anchorScrollProvider.disableAutoScrolling();
        });

})();