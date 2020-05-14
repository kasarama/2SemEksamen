<%@ page import="CarportUtil.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>
<%
    //if i'm the first user on this application, then set the flatMaterialList. (else the list already exists)
    if (request.getServletContext().getAttribute("flatMaterialList") == null) {
        System.out.println("initializing materiallist");
        //}
        request.getServletContext().setAttribute("flatMaterialList", Initializer.getFlatRoofMateriallist());
    }
%>

<div class="container2">
    <div class="col-md-12">
        <form name="designflatroof" action="FrontController" method="post">
            <input type="hidden" name="target" value="designflatroof">
            <br>
            <br>
            <h2>Fladt tag design</h2>
            <label class="mt-3" for="flatroof"> Vælg tagdækning for fladt tag:</label>
            <select class="form-control mt-3" name="flatroof" id="flatroof">
                <option selected disabled>Vælg tagdækning</option>
                <c:forEach var="roofMaterial" items="${applicationScope.flatMaterialList}">
                    <option value="${roofMaterial.id}">${roofMaterial.name} ${roofMaterial.color}</option>
                </c:forEach>
            </select>
            <input class="btn btn-primary mt-3" type="submit" value="Videre til beklædning">


        </form>
        <!-- End of form -->

        <form name="startOver" action="FrontController" method="POST">
            <input type="hidden" name="target" value="newrequest">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
        </form>
    </div>
</div>



<%@include file="../includes/footer.inc"%>