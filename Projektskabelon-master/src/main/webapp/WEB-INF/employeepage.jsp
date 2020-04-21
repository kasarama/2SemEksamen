<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 20-04-2020
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 20-04-2020
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Hello ${sessionScope.email} </h1>


<form name="showRequests" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showRequests">
    <input type="submit" value="Vis Forespørgelser">
</form>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>