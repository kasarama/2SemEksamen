<%@ page import="CarportUtil.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<%
// if i'm the first user on this application, then set the pitchedMaterialList. (else the list already exists)
if (request.getServletContext().getAttribute("pitchedMaterialList") == null) {
System.out.println("initializing materiallist");
}
request.getServletContext().setAttribute("pitchedMaterialList", Initializer.getPitchedRoofMateriallist());
%>
<h1>Tag med rejsning design</h1>

<form name="makerequest" action="FrontController" method="post">
    <input type="hidden" name="target" value="makerequest">
    <label for="pitchedroof"> Vælg tagdækning for tag med hældning:</label>
    <select class="form-control" name="pitchedroof" id="pitchedroof">
        <option selected disabled>Vælg tag type (pitched):</option>

        <c:forEach var="roofMaterial" items="${applicationScope.pitchedMaterialList}">
            <option value="${roofMaterial.id}">${roofMaterial.name}</option>
        </c:forEach>


    </select>

    <input class="btn btn-primary" type="submit" value="Videre">


<button type="button" >
    <a href="FrontController?target=redirect&destination=overlay">Videre til overlay</a>
</button>

</form>
<form name="startOver" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="submit" name="newrequest" value="Start forfra">
</form>



<%@include file="../includes/footer.inc"%>
