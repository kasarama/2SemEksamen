<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 21-04-2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <title>Din Carport</title>
</head>
<body>

<!-- Page Content -->
<div class="container mt-4">

    <h4>Din carport</h4>
    <h6>Tag med rejsning, uden skur</h6>
    <br>
    *** Billede ***
    <br>
    <br>
    <table class="table table-striped ">
        <thead>
        <tr>
            <th>Træ & Tagplader</th>
            <th>Længde (cm)</th>
            <th>Antal</th>
            <th>Enhed</th>
            <th>Note</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach var="material" items="${sessionScope.woodmateriallist}">
            <tr>
                <td>${material.name}</td>
                <td>${material.size}</td>
                <td>${material.antal}</td>
                <td>${material.unit}</td>
                <td>${material.comment}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <br>

    <table class="table table-striped ">
        <thead>
        <tr>
            <th>Beslag & Skruer</th>
            <th>Antal</th>
            <th>Enhed</th>
            <th>Note</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach var="material" items="${sessionScope.othermateriallist}">
            <tr>
                <td>${material.name}</td>
                <td>${material.antal}</td>
                <td>${material.unit}</td>
                <td>${material.comment}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<!-- Container -->


</body>
</html>
