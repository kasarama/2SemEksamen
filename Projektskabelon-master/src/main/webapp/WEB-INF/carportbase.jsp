<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 24-04-2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1>Alt starter her!</h1>
<h2>Her er nogle basele informationer du skal angive om din carport</h2>
<form name="carportbase" action="FrontController" method="POST">
    <input type="hidden" name="origin" value="carportbase">
    <input type="hidden" name="target" value="carportbase">
    <label>Vælg længde:</label>
    <select name="carportLength" class="form-control" >
        <c:forEach var="i" begin="24" end="75">
            <option value=${i*10}>${i*10}</option>
        </c:forEach>
    </select>
    <label>Vælg bredde:</label>
    <select name="carportWidth" class="form-control" >
        <c:forEach var="i" begin="24" end="75">
            <option value=${i*10}>${i*10}</option>
        </c:forEach>
    </select>
    <br>
    <label>Vælg tag type:</label>
    <select name="roofType" class="form-control" >
        <option value="0">Fladt tag</option>
        <option value="1">Tag med rejsning</option>
    </select>
    <br>
    Redskabsrum:
    NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet

    <div>
        Fortel os om redskabsrummet:
        <br>
        <label>Vælg bredde:</label>
        <select name="shedWidthParameter" class="form-control">
            <option value="1">på hele carportens bredde</option>
            <option value="2">på halvdelen af carportens bredde</option>
        </select>
        <label>Vælg dybde:</label>
        <select name="shedDepth" class="form-control">
            <c:forEach var="i" begin="12" end="75">
                <option value=${i*10}>${i*10}</option>
            </c:forEach>
        </select>
        <label>Vælg siden:</label>
        <select name="shedSide" class="form-control">
            <option value="left">til venstre</option>
            <option value="right">til højre</option>
        </select>
        <input type="submit" name="withShed" value="Videre med det valgte redskabsrum">
    </div>
    <div>
        <p1>eller</p1>
        <input type="submit" name="noShed" value="Fortsæt uden redskabsrummet">
    </div>
        <p1>eller</p1>
        <input type="submit" name="tooverlaynoshed" value="No shed / Vælg beklædning">
        <input type="submit" name="tooverlay" value="With shed / Vælg beklædning">
    </div>

</form>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
