(function () {
    "use strict";

    angular.module('serviceiii.registration', [])
        .controller('RegistrationController', ['$scope', '$http', 'SecurityService',
            function ($scope, $http, SecurityService) {
                $scope.user = {
                    firstName: "",
                    lastName: "",
                    phone: "",
                    email: "",
                    login: "",
                    password: ""
                };
                $scope.loginList = [];
                $scope.noExistInList = true;
                $scope.allChecked = false;
                $scope.passwordSecond = "";
                $scope.passIsShort = false;
                $scope.passNoRepeated = false;
                $scope.passNoEquals = false;
                $scope.firstNameIncorrect = false;
                $scope.lastNameIncorrect = false;
                $scope.phoneIncorrect = false;

                $http.get("rest/login-list")
                    .then(function (response) {
                        $scope.loginList = response.data;
                        $scope.checkModel = function () {
                            $scope.noExistInList = !contains($scope.loginList, $scope.user.login);
                        }
                    });

                $scope.checkFirstName = function () {
                    $scope.firstNameIncorrect = !($scope.user.firstName && $scope.user.firstName.length >= 2 && $scope.user.firstName.length < 20);
                };
                $scope.$watch('user.firstName', function () {
                    if ($scope.user.firstName !== "") {
                        $scope.checkFirstName();
                    }
                });

                $scope.checkLastName = function () {
                    $scope.lastNameIncorrect = !($scope.user.lastName && $scope.user.lastName.length >= 2 && $scope.user.lastName.length < 20);
                };
                $scope.$watch('user.lastName', function () {
                    if ($scope.user.lastName !== "") {
                        $scope.checkLastName();
                    }
                });

                $scope.checkPhone = function () {
                    $scope.phoneIncorrect = !($scope.user.phone && $scope.user.phone.match(/\d/g) && $scope.user.phone.match(/\d/g).length === 11);
                };
                $scope.$watch('user.phone', function () {
                    if ($scope.user.phone !== "") {
                        $scope.checkPhone();
                    }
                });

                $scope.checkLogin = function () {
                    $scope.loginIncorrect = !($scope.user.login && $scope.user.login.length > 3 && $scope.user.login.length < 20 && $scope.user.login.match(/^[a-zA-Z\s]+$/));
                };
                $scope.$watch('user.login', function () {
                    if ($scope.user.login !== "") {
                        $scope.checkLogin();
                        $scope.noExistInList = !contains($scope.loginList, $scope.user.login);
                    }
                });
                $scope.checkPassword = function () {
                    $scope.passIsShort = !($scope.user.password && $scope.user.password.length > 5 && $scope.user.password.length < 20);
                    $scope.passNoEquals = !($scope.user.password === $scope.passwordSecond);
                };
                $scope.$watch('user.password', function () {
                    if ($scope.user.password !== "") {
                        $scope.checkPassword();
                    }
                });

                $scope.checkRepeatedPassword = function () {
                    $scope.passNoRepeated = !($scope.passwordSecond && $scope.passwordSecond.length > 5 && $scope.passwordSecond.length < 20);
                    $scope.passNoEquals = !($scope.user.password === $scope.passwordSecond);
                };
                $scope.$watch('passwordSecond', function () {
                    if ($scope.passwordSecond !== "") {
                        $scope.checkRepeatedPassword();
                        check();
                    }
                });

                var check = function () {
                    var formIsValid = $scope.registrationForm.$valid;
                    $scope.allChecked = (
                    !$scope.loginIncorrect
                    && !$scope.passIsShort
                    && !$scope.passNoRepeated
                    && !$scope.passNoEquals
                    && !$scope.firstNameIncorrect
                    && !$scope.lastNameIncorrect
                    && !$scope.phoneIncorrect
                    && ($scope.user.login && $scope.user.login.length > 1)
                    && formIsValid);
                };

                $scope.$watch('user', function () {
                    check();
                }, true);

                $scope.saveUser = function () {
                    var customer = SecurityService.makeCustomerFromUserRegForm($scope.user);

                    window.alert("send" + customer);
                };

                var contains = function (array, entry) {
                    var i = array.length;
                    while (i--) {
                        if (array[i].toLowerCase() === entry.toLowerCase()) {
                            return true;
                        }
                    }
                    return false;
                };
            }]);
})();