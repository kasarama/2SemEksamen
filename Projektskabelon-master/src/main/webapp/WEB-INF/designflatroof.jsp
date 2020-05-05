<%@ page import="CarportUtil.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>
<%
    //if i'm the first user on this application, then set the flatMaterialList. (else the list already exists)
    if (request.getServletContext().getAttribute("flatMaterialList") == null) {
        System.out.println("initializing materiallist");
    }
    request.getServletContext().setAttribute("flatMaterialList", Initializer.getFlatRoofMateriallist());
%>

<h1>Fladt tag design</h1>

<form name="makerequest" action="FrontController" method="post">
    <input type="hidden" name="target" value="makerequest">
    <label for="flatroof"> Vælg tagdækning for fladt tag:</label>
    <select class="form-control" name="flatroof" id="flatroof">
        <option selected disabled>Vælg tag type (flat):</option>

        <c:forEach var="roofMaterial" items="${applicationScope.flatMaterialList}">
            <option value="${roofMaterial.id}">${roofMaterial.name}</option>
        </c:forEach>
    </select>

    <input class="btn btn-primary" type="submit" value="Videre">
</form>
   <button type="button" >
       <a href="FrontController?target=redirect&destination=overlay">Videre til overlay</a>
   </button>

</form>
<form name="startOver" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="submit" name="newrequest" value="Start forfra">
</form>

<%@include file="../includes/footer.inc"%>
