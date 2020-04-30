<%@ page import="CarportUtil.Initializer" %><%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/30/20
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<%
    // if i'm the first user on this application, then set the materialList. (else the list already exists)
    if (request.getServletContext().getAttribute("materialList")== null){
        request.getServletContext().setAttribute("materialList", Initializer.getMaterialList());



%>
<c:forEach var="roofMaterial" items="${applicationScope.materialList}">
    ${roofMaterial.name}
</c:forEach>


<form name="makerequest" action="FrontController" method="post">
    <input type="hidden" name="target" value="makerequest">

    <div class="form-group">
        <label for="roof"> Vælg tagdækning:</label>
        <select class="form-control" name="roof" id="roof">
            <option selected disabled>Vælg type:</option>

            <c:forEach var="roofMaterial" items="${applicationScope.materialList}">
                <option value=${roofMaterial.materialID}>${roofMaterial.name}</option>
            </c:forEach>
        </select> </div>

    <input class="btn btn-primary" type="submit" value="Videre" >
</form>

<%@include file="../includes/footer.inc" %>
