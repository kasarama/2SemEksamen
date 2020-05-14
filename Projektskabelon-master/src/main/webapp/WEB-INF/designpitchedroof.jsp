<%@ page import="CarportUtil.Initializer" %>
<%@ page import="static FunctionLayer.RoofSizing.getMINPITCHDEGREEOPTION" %>
<%@ page import="static FunctionLayer.RoofSizing.getMAXPITCHDEGREEOPTION" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.Material" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<%
// if i'm the first user on this application, then set the pitchedMaterialList. (else the list already exists)
if (request.getServletContext().getAttribute("pitchedMaterialList") == null) {
    System.out.println("initializing materiallist"); //}
    request.getServletContext().setAttribute("pitchedMaterialList", Initializer.getPitchedRoofMateriallist());
}

if (request.getServletContext().getAttribute("MINPITCHDEGREEOPTION") == null) {
    //TODO Må man dette?
            request.getServletContext().setAttribute("MINPITCHDEGREEOPTION", getMINPITCHDEGREEOPTION());
        }

if (request.getServletContext().getAttribute("MAXPITCHDEGREEOPTION") == null) {
        request.getServletContext().setAttribute("MAXPITCHDEGREEOPTION", getMAXPITCHDEGREEOPTION());
    }

%>

<div class="container2">
    <div class="col-md-12">
        <form name="designpitchedroof" action="FrontController" method="post">
            <input type="hidden" name="target" value="designpitchedroof">
            <br>
            <br>
            <h2>Tag med rejsning design</h2>
            <label class="mt-3" for="pitchedroofmaterial"> Vælg tagdækning for tag med hældning:</label>
            <select class="form-control mt-3" name="pitchedroofmaterial" id="pitchedroofmaterial">
                <option selected disabled>Vælg tagdækning</option>
                <c:forEach var="roofMaterial" items="${applicationScope.pitchedMaterialList}">
                    <option value="${roofMaterial.id};${roofMaterial.variationID}">${roofMaterial.name} ${roofMaterial.color}</option>
                </c:forEach>
            </select>
        <!--- </form> --->

            <br>
            <label>Vælg hældningsgrad:</label>
            <br>
            <select name="tiltOptions" class="form-control" name="pitchedroofdegree" id="pitchedroofdegree">
                <c:forEach var="degree" begin="${applicationScope.MINPITCHDEGREEOPTION}" end="${applicationScope.MAXPITCHDEGREEOPTION}" step="5">
                    <option value="${degree}">${degree}</option>
                </c:forEach>
            </select>

            <input class="btn btn-primary mt-3" type="submit" value="Videre til beklædning">
        </form>
        <!-- End of form -->
        <br>


        <form name="startOver" action="FrontController" method="POST">
            <input type="hidden" name="target" value="newrequest">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
        </form>
    </div>
</div>

<%@include file="../includes/footer.inc"%>
