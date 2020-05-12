<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 12-05-2020
  Time: 02:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>


<h2> Here comes a form to edit chosen construction</h2>
orderForValidation


<div class="container2">
    <div class="col-md-12">

        <c:set var="con" value="${requestScope.constructionForValidation}"/>
        <c:choose>
            <c:when test="${con!=null}">
                <form name="showedit" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                    <input type="hidden" name="origin" value="validateRequest">
                    <input type="hidden" name="target" value="showedit">
                    <br>
                    <br>
                    <h2>Ordre nr. ${requestScope.orderForValidation.orderID}</h2>

                    <div class="row mt-4">
                        <div class="col-md-6 school-options-dropdown text-center">


                            <div class="form-group">
                                <label>Vælg carportens længde i mm - original : ${con.carportLength}</label>
                                <input type="number" name="carportLength" class="form-control"
                                       value=${con.carportLength} min="240" max="7500">
                            </div>

                            <div class="form-group">
                                <label>Vælg carportens bredde i mm - original : ${con.carportWidth}</label>
                                <input type="number" name="carportWidth" class="form-control"
                                       value=${con.carportWidth} min="240" max="7500">
                            </div>

                            <c:set var="shed" value="${con.shed}"/>
                            <c:choose>
                                <c:when test="${shed.depth!=0}">
                                    <div class="form-group">
                                        <label>Vælg siden til redksbsrummet - original : ${shed.danishSide()}</label>
                                        <select name="shedSide" class="form-control">
                                            <option value="right">højre</option>
                                            <option value="left">venstre</option>
                                        </select>
                                    </div>
                                </c:when>
                            </c:choose>

                            <c:set var="roof" value="${con.roof}"/>
                            <c:choose>
                                <c:when test="${roof.isPitched}">
                                    <div class="form-group">
                                        <label>Vælg vinkel for tag med ${roof.typeToString()}</label>
                                        <input type="number" name="angle" class="form-control"
                                               value=${roof.degree} min="0" max="45">
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="form-group">
                                        <label>Vælg rejsning for ${roof.typeToString()} tag</label>
                                        <input type="number" name="tilt" class="form-control"
                                               value=${roof.tilt} min="3" max="50">
                                    </div>
                                </c:otherwise>
                            </c:choose>


                            <div class="col-md-6 text-center mt-md-4">
                                <input class="btn btn-primary" type="submit" value="Videre til detaljer"
                                       role="button">

                            </div>
                        </div>
                    </div>
                </form>
            </c:when>
        </c:choose>

    </div>
</div>


<%@include file="../includes/footer.inc" %>