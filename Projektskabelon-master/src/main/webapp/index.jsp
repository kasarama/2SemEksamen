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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="/your-path-to-fontawesome/css/fontawesome.css" rel="stylesheet">
    <link href="/your-path-to-fontawesome/css/brands.css" rel="stylesheet">
    <link href="/your-path-to-fontawesome/css/solid.css" rel="stylesheet">

    <title>Fog Carport Designe Centre</title>
    <style>
        .container {
            position: relative;
            text-align: center;
            font-family: "Arial Black";
            color: #333333;
        }
        .centered {
            position: absolute;
            top: 280px;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .bootstrapColorBg {background-color:#004d99;}
        .white {color:#ffffff;}

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
                    <a class="nav-link" href="FrontController?target=redirect&destination=login">Login</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <img src="./images/baggrund.png" style="filter: opacity(30%);" alt="Background" width="100%" height=auto>
        <div class="centered">
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


    <!-- Footer -->
    <footer class="py-4 bg-primary black-background white">
        <div class="container">
            <p class="m-0 text-center text-white"><i class="far fa-address-card">Johannes Fog A/S</i></p>
            <p class="m-0 text-center text-white">45 87 10 01</p>
            <p class="m-0 text-center text-white">Send email</p>
        </div>
    </footer>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="includes/footer.inc"%>
