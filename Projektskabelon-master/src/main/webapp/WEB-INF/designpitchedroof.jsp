<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 21-04-2020
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h3>Tag med rejsning design centre </h3>

<form name="showdrawing" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showdrawing">
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


<%@include file="../includes/footer.inc"%>
