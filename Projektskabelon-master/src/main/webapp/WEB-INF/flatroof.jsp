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

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label>Vælg længde:</label>
        <select name="length" class="form-control">
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

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label>Vælg bredde:</label>
        <select name="width" class="form-control">
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

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label>Vælg tag:</label>
        <select name="roof" class="form-control">
            <option selected disabled>Vælg tag</option>
            <option value="1">Plasttrapezplader</option>
        </select>
    </div>
</div>

<div class="col-md-2 school-options-dropdown text-center">
    <div class="form-group">
        <label>Redskabsskur:</label>
        <select name="shedsize" class="form-control">
            <option selected disabled>Ønsker ikke redskabsskur</option>
            <option value="1">Fuld bredde</option>
            <option value="1">Halv bredde</option>
        </select>

        <label>Redskabsskur dybde:</label>
        <select name="sheddepth" class="form-control">
            <option selected disabled>Ønsker ikke redskabsskur</option>
            <option value="1">150</option>
            <option value="2">180</option>
            <option value="3">210</option>
            <option value="4">240</option>
            <option value="5">270</option>
            <option value="6">300</option>
            <option value="7">330</option>
            <option value="8">360</option>
            <option value="9">390</option>
            <option value="10">420</option>
            <option value="11">450</option>
            <option value="12">480</option>
            <option value="13">510</option>
            <option value="14">540</option>
            <option value="15">570</option>
            <option value="16">600</option>
            <option value="17">630</option>
            <option value="18">760</option>
        </select>
    </div>
</div>


<a href="FrontController?target=redirect&destination=shed">Se skur dimensionerne</a>

</body>
</html>
