<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 23-04-2020
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1> Her kan du vælge placering til din skur</h1>

${requestScope.shedMsg}

<h3>carport længde: ${sessionScope.carportRequest.length}</h3>
<h3>carport bredde: ${sessionScope.carportRequest.width}</h3>


<c:set var="version" value="${requestScope.shedVersion}"/>
<c:choose>
    <c:when test="${version == 1}">
        <form name="shedposition" action="FrontController" method="POST">
            <input type="hidden" name="target" value="shedposition">
            <label>Her kan du vælge, hvor din skur skal placeres:</label>
            <select name="position" class="form-control">
                <option selected disabled>Vælg placering</option>
                <option value="SL">Til venstre siden</option>
                <option value="SR">Til højre siden</option>
            </select>
            <input type="submit" value="Videre">
        </form>
    </c:when>
    <c:when test="${version == 2}">
        <form name="shedposition" action="FrontController" method="POST">
            <input type="hidden" name="target" value="shedposition">
            <label>Her kan du vælge, hvor din skur skal placeres:</label>
            <select name="position" class="form-control">
                <option selected disabled>Vælg placering</option>
                <option value="BL">På bagsiden til venstre</option>
                <option value="BR">På bagsiden til højre</option>
            </select>
            <input type="submit" value="Videre">
        </form>
    </c:when>
    <c:when test="${version == 3}">
        <form name="shedposition" action="FrontController" method="POST">
            <input type="hidden" name="target" value="shedposition">
            <label>Her kan du vælge, hvor din skur skal placeres:</label>
            <select name="position" class="form-control">
                <option selected disabled>Vælg placering</option>
                <option value="BL">På bagsiden til venstre</option>
                <option value="BR">På bagsiden til højre</option>
                <option value="SL">På siden til venstre</option>
                <option value="SR">På siden til højre</option>
            </select>
            <input type="submit" value="Videre">
        </form>
    </c:when>
    <c:otherwise>
        <form name="designshed" action="FrontController" method="POST">
            <input type="hidden" name="target" value="designshed">
            <input type="hidden" name="shedWidth" value="0">
            <input type="hidden" name="shedDepth" value="0">
            <input type="submit" value="Fortsæt uden skur">
        </form>
    </c:otherwise>
</c:choose>

<form name="makerequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="submit" value="Tilbage til valg af carport mål">
</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
