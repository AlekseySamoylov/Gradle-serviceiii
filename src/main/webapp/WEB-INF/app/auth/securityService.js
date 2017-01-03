(function () {
    "use strict";
    angular.module('serviceiii.security', [])
        .factory('SecurityService', ['$http', '$q',
            function ($http, $q) {
                var currentUser;
                var currentUserId;
                console.log("hello auth factory");

                return {
                    login: function (login, pass) {

                        var deferred = $q.defer();
                        $http.post("rest/login", {
                            username: login,
                            pass: pass
                        })
                            .then(function (response) {
                                currentUserId = response.data;
                                deferred.resolve(response.data);
                            })
                            .catch(function (response) {
                                deferred.reject(response);
                            });
                        currentUserId = deferred.promise;
                        return deferred.promise;
                    },
                    logout: function () {

                    },
                    isLoggedIn: function () {

                    },
                    currentUser: function () {

                    },
                    getCurrentUserId: function () {
                        return currentUserId;
                    },
                    makeCustomerFromUserRegForm: function (userForm) {
                        var customer = {
                            user: {
                                username: userForm.login,
                                pass: userForm.password
                            },
                            firstName: userForm.firstName,
                            lastName: userForm.lastName,
                            phone: userForm.phone,
                            email: userForm.email
                        };
                        return customer;
                    }
                }
            }]);
})();