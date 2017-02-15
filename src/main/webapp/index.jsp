<html>
<head>
    <title>Test</title>

</head>
<body ng-app="myApp" ng-controller="StudentCntl">

<div ng-init="init()">
    <table>
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Group</th>
            <th>Year of Admission</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="student in students">
            <td>{{student.id}}</td>
            <td>{{student.idProduct}}</td>
            <td >{{student.price}}</td>
            <td >{{student.count}}</td>
            <td ></td>
            <td > </td>
        </tr>
        </tbody>
    </table>
</div>
</body>

<script src="angular/angular.min.js"></script>
<script src="scripts/app.js"></script>
</html>
