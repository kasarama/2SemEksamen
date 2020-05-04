
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en rejsning tag-->

<h3>Tag med rejsning design</h3>

${requestScope.carportToString}

<h3>
    <a href="FrontController?target=redirect&destination=overlay">Videre ti overlay</a>
</h3>

<c:set var="roof" value="${sessionScope.constructionRequest.angle}"/>
<c:choose>
    <c:when test="${val == '0'}">

<form name="showAngleValue" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showAngleValue">
    <label>Vælg vinkelstørrelse på tagets ryg:</label>
    <select name="angle" class="form-control">
        <option selected disabled>Vælg type</option>
        <option value=""></option>
        <option value="2">type 2</option>
        <option value="3">type 3</option>
        <option value="4">type 4</option>
    </select>
    <input class="btn btn-primary" type="submit" value="Videre" >
</form>
    </c:when>
</c:choose>
<%@include file="../includes/footer.inc"%>
