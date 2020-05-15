<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 11-05-2020
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h2>Sendte tilbud</h2>

<form name="showequests" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showrequests">
    <input type="hidden" name="origin" value="sentOffers">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="sentoffers" value="Opdater fra databasen">
</form>

<table class="table table-striped ">
    <thead>
    <tr class="tr1">
        <th>Order ID</th>
        <th>Customer ID</th>
        <th>E-mail</th>
        <th>Dato</th>
        <th> </th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${applicationScope.newRequestsList}">
        <tr class="tr2">
            <td>${order.orderID}</td>
            <td>${order.customerID}</td>
            <td>${order.email}</td>
            <td>${order.date}</td>
            <td>${order.cost}</td>
            <td>${order.salePrice}</td>
            <td>${order.coverageToString()}</td>
            <td>

                <form name="validate" action="FrontController" method="POST">
                    <input type="hidden" name="target" value="contact">
                    <input type="hidden" name="origin" value="sentOffers">
                    <input type="hidden" name="orderID" value="${order.customerID}">
                    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Kontakt Kunde">
                </form>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>


<a href="FrontController?target=redirect&destination=employeePage">Tilbage</a>




<%@include file="../includes/footer.inc" %>