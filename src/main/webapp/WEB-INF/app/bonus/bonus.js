(function () {
    "use strict";
    angular.module('serviceiii.bonus', [])
        .factory('BonusService', ['$http', 'SecurityService',
            function ($http, SecurityService) {

                return {
                    getBonuses: function () {
                        $http.get("rest/bonus/1"/*{,
                         params: {id: 1/!*SecurityService.getCurrentUserId()*!/}
                         }*/).then(function successCallback(response) {
                            console.log("hello " + response.data);
                            // this callback will be called asynchronously
                            // when the response is available
                        }, function errorCallback(response) {
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                        });
                    }
                };
            }])
        .controller('BonusController', ['$scope', 'SecurityService', 'BonusService',
            function ($scope, SecurityService, BonusService) {

                $scope.userBonuses = 1000;

                BonusService.getBonuses();

            }]);
})();