<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 10/05/20
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="../includes/header.inc"%>

<div class="row">


    <div class="col-md-4"></div>
    <div class="col-md-4">
            <h4 class="text-center">Du har valgt:</h4>

            <!-- *** applicationScope/requestScope ?? *** -->

    <!-- ** Creating a table that will contain rows/columns to display the chosen construction ** -->
    <!-- "table"  puts the table in a table form (with dividers) -->
    <!-- "table-striped" makes the table grey and white (stripes-pattern) -->
    <table class="table table-striped">
        <tr>
            <td>Carport længde: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${sessionScope.carportBase.carportLength}</td>
        </tr>
        <tr>
            <td>Carport bredde: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${sessionScope.carportBase.carportWidth}</td>
        </tr>
        <tr>
            <td>Tagtype: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Tagdækning: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>beklædning: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>beklædning til væg: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Skur: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Skur: Ja/Nej</td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Skur bredde:</td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Skur dybde:</td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${sessionScope.carportBase.shedDepth}</td>

        </tr>
        <tr>
            <td>Skur placering:</td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
    </table>


        <form name="sendnewrequest" action="FrontController" method="POST">
            <input type="hidden" name="target" value="sendnewrequest">
            <input type="hidden" name="origin" value="customerChoiceResult">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="sendnewrequest" value="Send forespørgelse">
        </form>


        <form name="startOver" action="FrontController" method="POST">
            <input type="hidden" name="target" value="newrequest">
            <input type="hidden" name="origin" value="customerChoiceResult">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
        </form>

        <form name="svg" action="FrontController" method="POST">
            <input type="hidden" name="target" value="svg">
            <input type="hidden" name="origin" value="customerChoiceResult">
            <input class="btn btn-primary mt-3" type="submit" name="svgSketch" value="See Caport tegning?">
        </form>

        <form name="itemlist" action="FrontController" method="POST">
            <input type="hidden" name="target" value="itemlist">
            <input type="hidden" name="origin" value="customerChoiceResult">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="showitemlist" value="Item List">
        </form>

            <!-- NOTE: doesn't work yet
            Hint: Create forEach loop to print a List BD line 53- 60 -->

        <c:forEach var="roofMaterial" items="${requestScope.pitchedroofInfos}">
            id: ${roofMaterial}<br/> <!-- "br" creates a break after every printed value-->
        </c:forEach>

    </div>
    <div class="col-md-4"></div>
</div>  <!-- row closing tag -->

<%@include file="../includes/footer.inc"%>



