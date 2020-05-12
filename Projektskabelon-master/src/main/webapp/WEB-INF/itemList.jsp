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

<!-- todo juster tables  so they contain needed data -->
        <br>
        <br>
        <a href="FrontController?target=redirect&destination=newOffer">tilbage til Ordre detaljer</a>

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


            <c:forEach var="material" items="${requestScope.constructionMaterials}">
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


            <c:forEach var="material" items="${requestScope.roofMaterials}">
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


        <c:set var="list" value="${requestScope.overlayMaterials}"/>
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


                    <c:forEach var="material" items="${requestScope.overlayMaterials}">
                        <tr class="tr2">
                            <th>${material.name}</th>
                            <th>${material.size}</th>
                            <th>${material.amount}</th>
                            <th>${material.unit}</th>
                            <th>${material.comment}</th>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:when>
        </c:choose>

        <a href="FrontController?target=redirect&destination=newOffer">tilbage til Ordre detaljer</a>
        <br>

    </div>
</div>
<!-- Container -->

<%@include file="../includes/footer.inc" %>
