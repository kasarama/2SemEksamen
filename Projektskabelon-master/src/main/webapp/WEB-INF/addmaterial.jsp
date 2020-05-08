<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 25-04-2020
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Tilføj material til databasen</h1>

<h3>Tilføj en material ad gangen:</h3>
<form name="addmaterial" action="FrontController" method="POST">
    <input type="hidden" name="target" value="addmaterial">
    <input type="hidden" name="origin" value="addmaterial">
    name <input type="text" name="name"><br>
    width <input type="text" name="width"><br>
    thickness <input type="text" name="thickness"><br>
    unit <input type="text" name="unit"><br>
    keyword <input type="text" name="keyword"><br>
    category <input type="text" name="category"><br>
    price <input type="text" name="price"><br>
    picture <input type="text" name="picture"><br>
    spending <input type="text" name="spending"><br>

    <input class="btn btn-primary" type="submit" name="addOne" value="tilføj">
<br>
<br>
<br>
<h3>Tilføj materials from text file:</h3>
    <input type="hidden" name="target" value="addmaterial">
    <input type="hidden" name="origin" value="addmaterial">
    stig på din komputer til den fil du vil læe materials fra:<br>
    <input type="text" name="path"><br>
    <input class="btn btn-primary" type="submit" name="readFile" value="Læs og tilføj">
</form>

<h3>${requestScope.status}</h3>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>
