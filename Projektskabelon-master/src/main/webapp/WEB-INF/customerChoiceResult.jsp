<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/20/20
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Designed Carport</title>
</head>
<body>

<h1 class="Du har valgt:"></h1>
<!-- ** Creating a table that will contain rows/columns to display the chosen construction ** -->
<!-- "table"  puts the table in a table form (with dividers) -->
<!-- "table-striped" makes the table grey and white (stripes-pattern) -->
<table class="table table-striped">
    <!-- Creating 4 rows with 2 columns each - "tr": table row, "td": table columns -->
    <tr>
        <td>Længde: </td>
        <!-- getting the "length" attribute from the "Frontcontroller" who got it from "Carport" -->
        <td>${requestScope.length}</td>
    </tr>
    <tr>
        <td>Bredde: </td>
        <!-- getting the "width" attribute from the "Frontcontroller" who got it from "Carport" -->
        <td>${requestScope.width}</td>
    </tr>
    <tr>
        <td>Tag: </td>
        <!-- getting the "roof" attribute from the "Frontcontroller" who got it from "Carport" -->
        <td>${requestScope.roof}</td>
    </tr>
</table>


<form name="sendnewrequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="sendnewrequest">
    <input type="hidden" name="origin" value="customerChoiceResult">
    <input type="submit" name="sendnewrequest" value="Send forespørgelse">
</form>


<form name="startOver" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="hidden" name="origin" value="customerChoiceResult">
    <input type="submit" name="newrequest" value="Start forfra">
</form>

<form name="itemlist" action="FrontController" method="POST">
    <input type="hidden" name="target" value="itemlist">
    <input type="hidden" name="origin" value="customerChoiceResult">
    <input type="submit" name="showitemlist" value="Item List">
</form>

<!-- alligning the hyperlink to the center -->
<div class="text-center">
    <!-- Creating a hyperlink that goes through back to 'index' page -->
    <a href="../index.jsp">Til Forsiden</a>
</div>


</body>
</html>
