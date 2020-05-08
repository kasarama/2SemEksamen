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

    <!-- Start Picture -->
    <img src="./images/header.JPG" alt="header" width="100%" height=auto>


    <!-- Navigation -->
    <nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light" style="border-bottom: 2px solid black;">
        <a class="navbar-brand ml-4 c" href="FrontController?target=redirect&destination=index">
            Fog
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mr-4" id="navbarNavDropdown" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="FrontController?target=redirect&destination=index"><i
                            class="fa fa-fw fa-home"></i>Hjem <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?target=redirect&destination=login">Min profil</a>
                </li>
            </ul>
        </div>
    </nav>

<!-- Page content -->
    <div class="container1 text-center">
            <form name="carportbase" action="FrontController" method="POST">
                <input type="hidden" name="origin" value="carportBase">
                <input type="hidden" name="target" value="carportbase">
                <input type="hidden" name="constructionHeight" value=2000> <!-- det her er det eneste sted man angivr constructionens height-->
                <h2>Design din Carport</h2>
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg længde:</label>
                            <select name="carportLength" class="form-control">
                                <c:forEach var="i" begin="24" end="75">
                                    <option value=${i*100}>${i*10} cm</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg bredde:</label>
                            <select name="carportWidth" class="form-control">
                                <c:forEach var="i" begin="24" end="75">
                                    <option value=${i*100}>${i*10} cm</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- 1. row end -->
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg tag type:</label>
                            <select name="roofType" class="form-control">
                                <option value="0">Fladt tag</option>
                                <option value="1">Tag med rejsning</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 text-center mt-md-4">
                        <input class="btn btn-primary" type="submit" name="noShed" value="Fortsæt uden skuret" role="button">
                    </div>
                </div>
                <!-- 2. row end -->

                <h2>Design dit Skur</h2>
                <h6 class="mb-3" style="font-size: small;">NB! Der skal beregnes 15 cm tagudhæng på hver side af skuret</h6>
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg bredde:</label>
                            <select name="shedWidthParameter" class="form-control">
                                <option value="1">Hele carportens bredde</option>
                                <option value="2">Halvdelen af carportens bredde</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg dybde:</label>
                            <select name="shedDepth" class="form-control">
                                <c:forEach var="i" begin="12" end="35">
                                    <option value=${i*100}>${i*10} cm</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- 1. row end -->
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg placerings side:</label>
                            <select name="shedSide" class="form-control">
                                <option value="left">Venstre</option>
                                <option value="right">Højre</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 text-center mt-md-4">
                        <input class="btn btn-primary" type="submit" name="withShed" value="Videre med det valgte skur" role="button">
                    </div>
                </div>
                <!-- 2. row end -->
            </form>
            <!-- End of form -->
    </div>
    <!-- End of page content -->


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>