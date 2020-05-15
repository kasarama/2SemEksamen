<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 12-05-2020
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h2>Detaljer af den valideret construction</h2>

<!-- todo Nice table with order details, cost, sale price, coverage, link til all available SVG, link til Item List
todo make a method to calculate the cost and sale price, make form for coverage and for saleprice
todo Return the same page with actial data ??

-->


<div class="container2">
    <div class="col-md-6">

        <div class="col-md-6">

            <form name="itemList" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                <input type="hidden" name="origin" value="prepareOffer">
                <input type="hidden" name="target" value="itemlist">
                <div class="col-md-6 text-center mt-md-4">
                    <input class="btn btn-dark mt-3" type="submit" name="itemlist" value="Vis Stykliste"
                           role="button">
                </div>
            </form>
        </div>

        <div class="col-md-6">
            <!-- TODO Fix the form so it shows the drowings for employee -->
            <form name="drawing" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                <input type="hidden" name="origin" value="prepareOffer">
                <input type="hidden" name="target" value="drawing">
                <div class="col-md-6 text-center mt-md-4">
                    <input class="btn btn-dark mt-3" type="submit" name="drawing" value="Tegning"
                           role="button">
                </div>
            </form>
        </div>



        <c:set var="order" value="${applicationScope.orderForValidation}"/>
        <c:choose>
            <c:when test="${order!=null}">
                <form name="sendoffer" action="FrontController" method="POST" class="ml-lg-5 mr-lg-5">
                    <input type="hidden" name="origin" value="prepareOffer">
                    <input type="hidden" name="target" value="sendoffer">
                    <br>
                    <br>
                    <h2>Ordre nr. ${order.orderID}</h2>

                    <div class="row mt-4">
                        <div class="col-md-6 school-options-dropdown text-center">


                            <div class="form-group">
                                <label>Constructions kostpris</label>
                                <select class="form-control">
                                    <option selected disabled>${order.cost}</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Salgspris - original : ${order.salePrice}</label>
                                <input type="number" step="0.01" name="saleprice" class="form-control"
                                       value=${order.salePrice} min="${order.cost+order.transport}"
                                       max="${(order.cost+order.transport)*5}">
                            </div>


                            <div class="form-group">
                                <label>Dækningsgrad - original : ${order.coverage}</label>
                                <input type="number" step="0.01" name="coverage" class="form-control"
                                       value=${order.coverage} min="0">
                            </div>


                            <div class="col-md-6 text-center mt-md-4">
                                <input class="btn btn-dark mt-3" type="submit" name="byPrice"
                                       value="Gem pris og send Tilbudet"
                                       role="button">
                            </div>

                            <div class="col-md-6 text-center mt-md-4">
                                <input class="btn btn-dark mt-3" type="submit" name="byCoverage"
                                       value="Gem dækningsgrad og send Tilbudet"
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