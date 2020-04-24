<%@ page import="javax.naming.InitialContext" %>
<%@ page import="CarportUtil.Initializer" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Includes/header.inc" %>

<%
    //getting and saving materialList on session level.
    if (request.getServletContext().getAttribute("materialList")== null) {
    request.getServletContext().setAttribute("materialList", Initializer.getMaterialList());
    }
%>


<title>Vælg Materiale: </title>

<!-- Let this contain the material list from DB - the name columns should be displayed in dropdown -->
<!-- make forms (fields) to type the data need to design a flat roof...height/angle? -->
<!-- todo: material table in DB needs to be reconstructed, so that roof materials are in a separate table.-->
<!-- make a button: videre til.. to go to next page -->

<h1 class="Vælg Materiale:"></h1>

<!-- Go through "Frontcontroller" to reach "carport" page when 'videre' button is pressed -->
<form action="FrontController" method="post">
<input type="hidden" name="target" value="carport"/>

<!-- ** Creating a  dropdown to choose carport material ** -->

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label for="material">Vælg materiale:</label>
        <select class="form-control" name="material" id="material">

            <option selected disabled>Vælg materiale</option>

            <!-- using forEach loop to get and display the 'materialList' data on sessionScope level -->
            <c:forEach var="materialItem" items="${applicationScope.materialList}"> <!-- items = loop though 'materialList' -->
                <!-- get 'materialID', 'name' and 'size' from 'materialItem' to generate the options -->
                <option value="${materialItem.materialID}">${materialItem.name}${materialItem.size}</option>
            </c:forEach>
        </select>
    </div>
</div>

<!-- ** Creating forms to TYPE carport roof length and width ** -->

<!-- ** Creating a button with 'sumbit' type to sumbit the chosen carport data ** -->
<div class="text-center"> <!--alligning the button to the center -->
    <button type="submit" class="btn btn-primary">Videre</button>
</div>
</form>

<%@include file=" /Includes/footer.inc"%>