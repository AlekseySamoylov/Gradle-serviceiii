(function () {
    "use strict";
    angular.module('serviceiii.security', [])
        .factory('SecurityService', ['$http', '$q', '$cookies',
            function ($http, $q, $cookies) {
                var currentUserId = $cookies.get('currentUserId');
                return {
                    registration: function (customer) {
                        var deferred = $q.defer();

                        $http.post("rest/customer", customer)
                            .then(function (response) {
                                deferred.resolve(response)
                            })
                            .catch(function (response) {
                                deferred.reject(response)
                            });
                        currentUserId = deferred.promise;
                        $cookies.put("currentUserId", currentUserId);
                        return deferred.promise;
                    },
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
                        $cookies.put("currentUserId", currentUserId);
                        return deferred.promise;
                    },
                    logout: function () {
                        currentUserId = null;
                        $cookies.put("currentUserId", currentUserId);
                    },
                    isLoggedIn: function () {
                        return !!currentUserId;
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