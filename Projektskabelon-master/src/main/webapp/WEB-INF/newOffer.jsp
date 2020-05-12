<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 12-05-2020
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h2>Detaljer af den valideted construction</h2>




<form name="itemlist" action="FrontController" method="POST">
    <input type="hidden" name="target" value="itemlist">
    <input type="hidden" name="origin" value="newOffer">
    <label> Juster salgsprisen - original : (orders salgprice from request)</label>
    <input type="number" name="saleprice" class="form-control" value="her shoud come orders sale price">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="Sæt ny salgspris" value="Item List">
</form>

<form name="itemlist" action="FrontController" method="POST">
    <input type="hidden" name="target" value="itemlist">
    <input type="hidden" name="origin" value="newOffer">
    <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="showitemlist" value="Item List">
</form>



<%@include file="../includes/footer.inc"%>