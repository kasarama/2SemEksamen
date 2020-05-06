<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 03-05-2020
  Time: 03:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>




<table style="width:50%">
    <tr>
        <th>Navn</th>
        <th>størelse</th>
        <th>antal</th>
        <th>enhed</th>
        <th>kommentar</th>
    </tr>

    <c:forEach var="material" items="${requestScope.ovarlayMaterialList}">
        <tr>
        <th>${material.name}</th>
        <th>${material.size}</th>
        <th>${material.amount}</th>
        <th>${material.unit}</th>
        <th>${material.comment}</th>
        </tr>
    </c:forEach>
</table>

<%@include file="../includes/footer.inc" %>
