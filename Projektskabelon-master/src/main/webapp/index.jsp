<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/20/20
  Time: 12:22
<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/20/20
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 20-04-2020
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Design Carport</title>
</head>
<body>

<h1 class="Design din Carport:"></h1>

<!-- Go through "Frontcontroller" to reach "carport" page when 'sumbit' button is pressed -->
<form action="FrontController" method="post">
<input type="hidden" name="target" value="carport"/>

<!-- ** Creating a button a dropdown to choose carport length ** -->

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label for="length">Vælg længde:</label>
        <select class="form-control" name="length" id="length">

            <option selected disabled>Vælg længde</option>
            <option value="1">240</option>
            <option value="2">270</option>
            <option value="3">300</option>
            <option value="4">330</option>
            <option value="5">360</option>
            <option value="6">390</option>
            <option value="7">420</option>
            <option value="8">450</option>
            <option value="9">480</option>
            <option value="10">510</option>
            <option value="11">540</option>
            <option value="12">570</option>
            <option value="13">600</option>
            <option value="14">630</option>
            <option value="15">660</option>
            <option value="16">690</option>
            <option value="17">720</option>
            <option value="18">750</option>
            <option value="19">780</option>
        </select>
    </div>
</div>

<!-- ** Creating a button a dropdown to choose carport width ** -->

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label for="width">Vælg bredde:</label>
        <select class="form-control" name="width" id="width">

            <option selected disabled>Vælg bredde</option>
            <option value="1">240</option>
            <option value="2">270</option>
            <option value="3">300</option>
            <option value="4">330</option>
            <option value="5">360</option>
            <option value="6">390</option>
            <option value="7">420</option>
            <option value="8">450</option>
            <option value="9">480</option>
            <option value="10">510</option>
            <option value="11">540</option>
            <option value="12">570</option>
            <option value="13">600</option>
            <option value="14">630</option>
            <option value="15">660</option>
            <option value="16">690</option>
            <option value="17">720</option>
            <option value="18">750</option>
        </select>
    </div>
</div>

<!-- ** Creating a dropdown to choose carport roof ** -->

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label for="roof">Vælg tag:</label>
        <select class="form-control" name="roof" id="roof">

            <option selected disabled>Vælg tag</option>
            <option value="1">Plasttrapezplader</option>
        </select>
    </div>
</div>

<!-- ** Creating a button with 'sumbit' type to sumbit the chosen carport data ** -->
<div class="text-center"> <!--alligning the button to the center -->
    <button type="submit" class="btn btn-primary">Sumbit</button>
</div>
</form>

</body>
</html>