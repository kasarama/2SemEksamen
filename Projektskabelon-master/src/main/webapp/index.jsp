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

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Fog Carport Designe Centre</title>


    <style>
        body, html {
            height: 100%;
            margin: 0;
        }
        .bg {
            /* The image used */
            background-image: url("./images/pencil-blueprint-5959862.jpg");
            /* Full height */
            height: 100%;
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            /* Add the blur effect */
            filter: blur(2px);
        }
        /* Position text in the middle of the page/image */
        .bg-text {
            font-family: "Arial Black";
            color: #333333;
            font-weight: bold;
            position: absolute;
            top: 65%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 2;
            width: 60%;
            padding: 20px;
            text-align: center;
        }
    </style>

</head>
<body>
<img src="./images/verstTilHjemmeside.png" alt="Logo" width="100%" height=auto>

<div class="bg"></div>
    <div class="bg-text">
    <h2>Velkommen til</h2>

        <img class="mt-3" src="./images/logo.png" alt="Logo" width="60%" height=auto>

    <h2>
        <a href="FrontController?target=redirect&destination=carportBase">New Designe Center</a>
    </h2>
    <br>
    <br>
    <br><a href="FrontController?target=redirect&destination=addmaterial">Add Material</a>
    <br>
    <br>
</div>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="includes/footer.inc"%>
