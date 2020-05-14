<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 04-05-2020
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<div class="container2">
    <div class="col-md-12">

        <h2>Nye Forespørgsler</h2>


        <form name="showrequests" action="FrontController" method="POST">
            <input type="hidden" name="target" value="showrequests">
            <input type="hidden" name="origin" value="newRequests">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequests" value="Opdater fra databasen">
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
                    <td>

                        <form name="validate" action="FrontController" method="POST">
                            <input type="hidden" name="target" value="validate">
                            <input type="hidden" name="origin" value="newRequests">
                            <input type="hidden" name="orderID" value="${order.orderID}">
                            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Til validering">
                        </form>

                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<a href="FrontController?target=redirect&destination=employeePage">Tilbage</a>


<%@include file="../includes/footer.inc" %>