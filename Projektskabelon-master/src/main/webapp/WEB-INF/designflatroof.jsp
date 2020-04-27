<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="FunctionLayer.*" %>
<%@include file="../includes/header.inc" %>

<h1>Fladt tag design</h1>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

<br>
<form name="designflatroof" action="FrontController" method="POST">
    <input type="hidden" name="target" value="designflatroof">
    <label>Vælg hældningsgrad:</label>
    <select name="tilt" class="form-control" >
        <c:forEach var="tilt" items="${}">
            <option value=${i}>${i}</option>
        </c:forEach>
    </select>

    <div>
        <h3> Debug: ${roofMaterial.name} </h3>
        <h3> Debug:<c:out value="${roofMaterial.name}" /></h3>
    </div>


</form>
<%@include file="../includes/footer.inc"%>
