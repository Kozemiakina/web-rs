'use strict';

var myApp = angular.module('myApp', []);

function StudentCntl($scope, $http) {

    $scope.apiURL = document.location.origin + "/rs/student";

    $scope.init = function(){
        console.log("is init");
        $scope.getStudents();
    };

    $scope.getStudents = function () {

        $http.get($scope.apiURL).
            success(function (data, status, headers, config) {
                $scope.students = data;
            }).
            error(function (data, status, headers, config) {
                console.log("error on get students");
            });
    };

    $scope.update = function(item){
        $http.put($scope.apiURL, item).
            success(function (data, status, headers, config) {
                console.log("student updated");
            }).
            error(function (data, status, headers, config) {
                console.log("error on update of student");
            });
    }
}

myApp.controller('StudentCntl',StudentCntl);