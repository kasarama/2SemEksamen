

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1> Her kan du designe din skur</h1>

${requestScope.shedMsg}

<h3>carport længde: ${sessionScope.carportRequest.length}</h3>
<h3>carport bredde: ${sessionScope.carportRequest.width}</h3>

    <form name="shedWidth" action="FrontController" method="POST">
    <input type="hidden" name="target" value="makerequest">
    <label>Vælg bredde:</label>
    <select name="shedWidth" class="form-control">
    <option selected disabled>Vælg bredde</option>
    <option value="1">hele længde</option>
    <c:forEach var="shedWidth" items="${requestScope.possibleSizes.get(0)}">
        <option value="${shedWidth}">${shedWidth}</option>
    </c:forEach>




<form name="makerequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="makerequest">
    <input type="submit" value="Tilbage">
</form>



<c:set var="roof" value="${sessionScope.carportRequest.angle}"/>
<c:choose>
    <c:when test="${val == '0'}">
        <form name="designflatroof" action="FrontController" method="POST">
            <input type="hidden" name="target" value="designflatroof">
            <input type="submit" value="Videre">
        </form>
    </c:when>
    <c:otherwise>
        <form name="designpitchedroof" action="FrontController" method="POST">
            <input type="hidden" name="target" value="designpitchedroof">
            <input type="submit" value="Videre">
        </form>
    </c:otherwise>
</c:choose>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
