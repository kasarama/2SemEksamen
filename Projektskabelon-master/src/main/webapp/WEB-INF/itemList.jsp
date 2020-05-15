<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 03-05-2020
  Time: 03:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<!-- Page Content -->
<div class="container2">
    <div class="col-md-12">
        <br>
        <br>
        <h2>Stykliste for ordre nr. ${requestScope.orderForValidation.orderID}</h2>
        <br>

        <!-- todo adjust tables  so they contain needed data
        todo should sho material.availablesize-->

        <br>
        <br>
        <div class="col-md-6">
            <div class="col-md-6 text-center mt-md-4">
                <a class="btn btn-dark mt-3" href="FrontController?target=redirect&destination=prepareOffer">
                    Tilbage til Ordre detaljer</a>
            </div>
        </div>

        <br>

        <table class="table table-striped ">
            <thead>
            <tr class="tr1">
                <th>Construction</th>
                <th>Længde (cm)</th>
                <th>Antal</th>
                <th>Enhed</th>
                <th>Note</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach var="material" items="${applicationScope.orderForValidation.construction.fundamentMaterials}">
                <tr class="tr2">
                    <td>${material.name}</td>
                    <td>${material.amount}</td>
                    <td>${material.unit}</td>
                    <td>${material.comment}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <br>

        <table class="table table-striped ">
            <thead>
            <tr class="tr1">
                <th>Tag</th>
                <th>Længde (cm)</th>
                <th>Antal</th>
                <th>Enhed</th>
                <th>Note</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach var="material" items="${applicationScope.orderForValidation.construction.roof.roofMaterialList}">
                <tr class="tr2">
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


        <c:set var="list" value="${applicationScope.orderForValidation.construction.shed.materials}"/>
        <c:choose>
            <c:when test="${list.size() != 0}">
                <table class="table table-striped ">
                    <thead>
                    <tr class="tr1">
                        <th>Beklædnings materiale</th>
                        <th>Størrelse</th>
                        <th>Antal</th>
                        <th>Enhed</th>
                        <th>Kommentar</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach var="material" items="${list}">
                        <tr class="tr2">
                            <th>${material.name}</th>
                            <th>${material.availablesize}</th>
                            <th>${material.amount}</th>
                            <th>${material.unit}</th>
                            <th>${material.comment}</th>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:when>
        </c:choose>

        <a href="FrontController?target=redirect&destination=prepareOffer">tilbage til Ordre detaljer</a>
        <br>

    </div>
</div>
<!-- Container -->

<%@include file="../includes/footer.inc" %>
