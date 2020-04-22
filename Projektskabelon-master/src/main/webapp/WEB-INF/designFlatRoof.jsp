<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/22/20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Includes/header.inc" %>

<h3>Fladt tag design centre </h3>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

<form name="makerequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="makerequest">
    <label>Vælg tagdækning:</label>
    <select name="length" class="form-control">
        <option selected disabled>Vælg type</option>
        <option value="1">type 1</option>
        <option value="2">type 2</option>
        <option value="3">type 3</option>
        <option value="4">type 4</option>
    </select>
    <input class="btn btn-primary" type="submit" value="Videre" >
</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file=" ../Includes/footer.inc"%>
