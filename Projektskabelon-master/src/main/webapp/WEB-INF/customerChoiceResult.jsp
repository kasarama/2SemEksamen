<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 10/05/20
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes/header.inc"%>

<div class="row">

    <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1 class="text-center">Du har valgt:</h1>

            <!-- *** applicationScope/requestScope ?? *** -->

    <!-- ** Creating a table that will contain rows/columns to display the chosen construction ** -->
    <!-- "table"  puts the table in a table form (with dividers) -->
    <!-- "table-striped" makes the table grey and white (stripes-pattern) -->
    <table class="table table-striped">
        <tr>
            <td>Carport længde: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
        <tr>
            <td>Carport bredde: </td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
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
            <td>Skur længde:</td>
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
            <td>${requestScope.attributeName}</td>

        </tr>
        <tr>
            <td>Skur placering:</td>
            <!-- getting the "attributeName" attribute from the "Frontcontroller" who got it from "Class" -->
            <td>${requestScope.attributeName}</td>
        </tr>
    </table>

            <form name="makerequest" action="FrontController" method="POST">
                <input type="hidden" name="target" value="makerequest">
                <input class="btn btn-primary mt-3" type="submit" name="makerequest" value="Send request">
            </form>

            <form name="startOver" action="FrontController" method="POST">
                <input type="hidden" name="target" value="newrequest">
                <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
            </form>

            <!-- Hint: Create forEach loop to print a List BD line 53- 60 -->

        </div>
    <div class="col-md-4"></div>
</div>  <!-- row closing tag -->

<%@include file="../includes/footer.inc"%>
