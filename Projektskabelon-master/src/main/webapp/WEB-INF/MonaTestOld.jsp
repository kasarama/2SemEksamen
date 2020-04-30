<%@ page import="CarportUtil.Initializer" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 24-04-2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%@include file="../includes/header.inc" %>

    <%
        // if i'm the first user on this application, then set the materialList. (else the list already exists)
        if (request.getServletContext().getAttribute("materialList")== null){
            request.getServletContext().setAttribute("materialList", Initializer.getMaterialList());
        }
    %>

    <h3>Fladt tag design centre </h3>
    <!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

    <!-- Let this contain the material list from DB - the name columns should be displayed in dropdown -->
    <!-- make forms (fields) to type the data need to design a flat roof...height/angle? -->
    <!-- todo: material table in DB needs to be reconstructed, so that roof materials are in a separate table.-->
    <!-- make a button: videre til.. to go to next page -->

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


    <!-- tag længde/bredde -->


</head>
<body>

</body>
</html>
