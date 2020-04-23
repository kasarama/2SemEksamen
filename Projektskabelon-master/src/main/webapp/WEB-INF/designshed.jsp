<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 21-04-2020
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1> Her kan du vælge bredde og dybte af din skur</h1>

${requestScope.possitionMsg}

<h3>carport længde: ${sessionScope.carportRequest.length}</h3>
<h3>carport bredde: ${sessionScope.carportRequest.width}</h3>

<form name="designshed" action="FrontController" method="POST">
    <input type="hidden" name="target" value="designshed">
    <label>Vælg bredde:</label>
    <select name="shedWidth" class="form-control">
        <option selected disabled>Vælg bredde</option>
        <c:forEach var="shedWidth" items="${requestScope.possibleSizes.get(0)}">
            <option value="${shedWidth}">${shedWidth}</option>
        </c:forEach>
    </select>
    <label>Vælg dybde:</label>
    <select name="shedDepth" class="form-control">
        <option selected disabled>Vælg dybde</option>
        <option value="1">hele længde</option>
        <c:forEach var="shedWidth" items="${requestScope.possibleSizes.get(1)}">
            <option value="${shedWidth}">${shedWidth}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Videre">
</form>


<form name="newrequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="submit" value="Start forfra">
</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
