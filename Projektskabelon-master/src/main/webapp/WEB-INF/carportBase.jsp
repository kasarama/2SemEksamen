<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 24-04-2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<<<<<<< HEAD
<!-- Start Picture -->
<div style="width: 100%; height: 20%; position: relative;">
    <img id="image1" style="position: relative;" src="./images/verstTilHjemmeside2.png" alt="header" />
    <img id="image2" style="position: absolute; top: 2px; left: 80px;" src="./images/logo.png" alt="logo" />
</div>



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
<h1>Alt starter her!</h1>
<h2>Her er nogle basale informationer du skal angive om din construction</h2>
<form name="carportbase" action="FrontController" method="POST">
    <input type="hidden" name="origin" value="carportBase">
    <input type="hidden" name="target" value="carportbase">
    <input type="hidden" name="constructionHeight" value=2000> <!-- det her er det eneste sted man angivr constructionens height-->
    <label>Vælg længde:</label>
    <select name="carportLength" class="form-control" >
        <c:forEach var="i" begin="24" end="75">
            <option value=${i*100}>${i*10} cm</option>
        </c:forEach>
    </select>
    <label>Vælg bredde:</label>
    <select name="carportWidth" class="form-control" >
        <c:forEach var="i" begin="24" end="75">
            <option value=${i*100}>${i*10} cm</option>
        </c:forEach>
    </select>
    <br>
    <label>Vælg tag type:</label>
    <select name="roofType" class="form-control" >
        <option value="0">Fladt tag</option>
        <option value="1">Tag med rejsning</option>
    </select>
    <br>
    <input type="submit" name="noShed" value="Fortsæt uden redskabsrummet">
    <br>

    <h3>Skur</h3>:
    NB! Der skal beregnes 15 cm tagudhæng på hver side af skuret

    <div>
        Fortæl os om skuret:
        <br>
        <label>Vælg bredde:</label>
        <select name="shedWidthParameter" class="form-control">
            <option value="1">på hele carportens bredde</option>
            <option value="2">på halvdelen af carportens bredde</option>
        </select>
        <label>Vælg dybde:</label>
        <select name="shedDepth" class="form-control">
            <c:forEach var="i" begin="12" end="35">
                <option value=${i*100}>${i*10} cm</option>
            </c:forEach>
        </select>
        <label>Vælg siden:</label>
        <select name="shedSide" class="form-control">
            <option value="left">til venstre</option>
            <option value="right">til højre</option>
        </select>
        <input type="submit" name="withShed" value="Videre med det valgte redskabsrum">
    </div>
</form>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>