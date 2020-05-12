<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 11-05-2020
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h2>Nye Administration</h2>

<form name="showequests" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showrequests">
    <input type="hidden" name="origin" value="employeePage">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequests" value="Vis ny forespørgelser">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="sentoffers" value="Vis sendte tilbud">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="orders" value="Vis bestillinger">
</form>





<%@include file="../includes/footer.inc" %>