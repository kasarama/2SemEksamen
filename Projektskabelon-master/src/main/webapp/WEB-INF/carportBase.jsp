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

    <div class="container2">
        <div class="col-md-12">
            <form name="carportbase" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                <input type="hidden" name="origin" value="carportBase">
                <input type="hidden" name="target" value="carportbase">
                <input type="hidden" name="constructionHeight" value=2000> <!-- det her er det eneste sted man angivr constructionens height-->
                <br>
                <br>
                <h2>Design din Carport</h2>
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg carportens længde:</label>
                            <select name="carportLength" class="form-control">
                                <option selected disabled>Vælg længde</option>
                                <c:forEach var="i" begin="24" end="75">
                                    <option value=${i*100}>${i*10} cm</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg carportens bredde:</label>
                            <select name="carportWidth" class="form-control">
                                <option selected disabled>Vælg bredde</option>
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
                            <label>Vælg tagtype:</label>
                            <select name="roofType" class="form-control">
                                <option selected disabled>Vælg tagtype</option>
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

                <h2 class="mt-4">Design dit Skur</h2>
                <h6 class="mb-3 mt-3" style="font-size: small;">NB! Der skal beregnes 15 cm tagudhæng på hver side af skuret</h6>
                <div class="row mt-4">
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg skurets bredde:</label>
                            <select name="shedWidthParameter" class="form-control">
                                <option selected disabled>Vælg bredde</option>
                                <option value="1">Hele carportens bredde</option>
                                <option value="2">Halvdelen af carportens bredde</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 school-options-dropdown text-center">
                        <div class="form-group">
                            <label>Vælg skurets dybde:</label>
                            <select name="shedDepth" class="form-control">
                                <option selected disabled>Vælg dybde</option>
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
                            <label>Vælg skurets placering:</label>
                            <select name="shedSide" class="form-control">
                                <option selected disabled>Vælg side</option>
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
    </div>
<br>
<br>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>