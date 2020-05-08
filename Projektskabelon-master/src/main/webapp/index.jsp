<%@ page import="CarportUtil.Initializer" %>
<%@ page import="FunctionLayer.LoginSampleException" %><%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/22/20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" charset="utf-8" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Fog Carport Designe Centre</title>
    <style>
        body {
            position: relative;
            text-align: center;
            font-family: "Arial Black";
            color: #333333;
        }
        select {
            font-family: "Arial";
        }
        .container2 {
            background-image: url("./images/baggrund3.png");
            background-repeat: no-repeat; /* Do not repeat the image */
            background-size: cover; /* Resize the background image to cover the entire container */
        }

    </style>

</head>
<body>

    <!-- Start Picture -->
    <img src="./images/verstTilHjemmeside2.png" alt="Logo" width="100%" height=20%>

    <!-- Navigation -->
    <nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light" style="border-bottom: 2px solid black;">
        <a class="navbar-brand ml-4 c" href="FrontController?target=redirect&destination=index">
            Fog
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mr-4" id="navbarNavDropdown" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="FrontController?target=redirect&destination=index"><i class="fa fa-fw fa-home"></i>Hjem <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?target=redirect&destination=login">Min profil</a>
                </li>
            </ul>
        </div>
    </nav>

<div class="container2">
    <div class="col-md-12">
            <br>
            <br>
        <h2>Velkommen til</h2>
        <img class="mt-4 mb-3" src="./images/logo.png" alt="Logo" width="430" height=auto>
        <h6  class="mb-3" style="font-size: small;">Her kan du designe din egen carport & <br>
            få vejledning, når inden du køber</h6>
        <br><br>
        <a class=" mt-4 mb-3 btn btn-primary" href="FrontController?target=redirect&destination=carportBase" role="button">DESIGN CARPORT</a>
        <br>
        <a class=" mt-3 btn btn-dark" href="FrontController?target=redirect&destination=?" role="button">Login/Registrer</a>
    </div>
</div>
<br>
<br>
<%@include file="includes/footer.inc"%>

<a href="FrontController?target=redirect&destination=addmaterial">Add Material</a>
