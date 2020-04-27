<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 25-04-2020
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Tilføj material til databasen</h1>

<form name="addmaterial" action="FrontController" method="POST">
    <input type="hidden" name="target" value="addmaterial">
    <input type="hidden" name="origin" value="addmaterial">
    name<input type="text" name="name"><br>
    size<input type="text" name="size"><br>
    unit<input type="text" name="unit"><br>
    keyword<input type="text" name="keyword"><br>
    category<input type="text" name="category"><br>
    price<input type="text" name="price"><br>
    picture<input type="text" name="picture"><br>

    <input class="btn btn-primary" type="submit" value="tilføj" >
</form>

<c:if test = "${requestScope.error!= null}" >
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>
