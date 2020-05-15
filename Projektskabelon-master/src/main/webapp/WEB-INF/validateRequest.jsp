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


<div class="container2">
    <div class="col-md-12">

        <c:set var="order" value="${applicationScope.orderForValidation}"/>
        <c:choose>
            <c:when test="${order!=null}">
                <form name="editprice" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                    <input type="hidden" name="origin" value="validateRequest">
                    <input type="hidden" name="target" value="editprice">
                    <br>
                    <br>
                    <h2>Ordre nr. ${order.orderID}</h2>

                    <div class="row mt-4">
                        <div class="col-md-6 school-options-dropdown text-center">


                            <div class="form-group">
                                <label>Vælg carportens længde i mm - original : ${order.construction.carportLength}</label>
                                <input type="number" name="carportLength" class="form-control"
                                       value=${order.construction.carportLength} min="2400" max="7500">
                            </div>

                            <div class="form-group">
                                <label>Vælg carportens bredde i mm - original : ${order.construction.carportWidth}</label>
                                <input type="number" name="carportWidth" class="form-control"
                                       value=${order.construction.carportWidth} min="2400" max="7500">
                            </div>

                            <c:set var="shed" value="${order.construction.shed}"/>
                            <c:choose>
                                <c:when test="${shed.depth!=0}">
                                    <div class="form-group">

                                        <div class="form-group">
                                            <label>Vælg redskansrummet bredde i mm - original : ${shed.depth}</label>
                                            <input type="number" name="shedDepth" class="form-control"
                                                   value=${shed.depth} min="1200" max="3500">
                                        </div>

                                        <label>Vælg siden til redksbsrummet - original : ${shed.danishSide()}</label>
                                        <select name="shedSide" class="form-control">
                                            <option value="right">højre</option>
                                            <option value="left">venstre</option>
                                        </select>
                                    </div>
                                </c:when>
                            </c:choose>

                            <c:set var="roof" value="${order.construction.roof}"/>
                            <c:choose>
                                <c:when test="${roof.isPitched}">
                                    <div class="form-group">
                                        <label>Vælg vinkel for tag ${roof.typeToString()}</label>
                                        <input type="hidden" name="tilt" value=0>
                                        <input type="number" name="angle" class="form-control"
                                               value=${roof.degree} min="0" max="45">
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="form-group">
                                        <label>Vælg rejsning for ${roof.typeToString()} tag</label>
                                        <input type="hidden" name="angle" value=0>
                                        <input type="number" name="tilt" class="form-control"
                                               value=${roof.tilt} min="3" max="50">
                                    </div>
                                </c:otherwise>
                            </c:choose>

                            <div class="form-group">
                                <label>Hvad koster transporten?</label>

                                <input type="number" name="transport" class="form-control"
                                       value="100" min="100" max="5000">
                            </div>


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