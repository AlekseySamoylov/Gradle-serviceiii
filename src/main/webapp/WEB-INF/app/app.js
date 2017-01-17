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
        'serviceiii.bonus',
        'serviceiii.workForm',
        'serviceiii.worksJournal'
    ])
        .config(function ($anchorScrollProvider) {
            $anchorScrollProvider.disableAutoScrolling();
        });

})();