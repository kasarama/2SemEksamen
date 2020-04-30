<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<h1>Her kan du designe din egen carport </h1>

<form name="findmaterial" action="FrontController" method="POST">
    <input type="hidden" name="target" value="findmaterial">
    <label>Vælg carportens længde:</label>
    <select name="carportLength" class="form-control" >
        <option selected disabled>Vælg længde</option>
        <option value="240">240</option>
        <option value="270">270</option>
        <option value="300">300</option>
        <option value="330">330</option>
        <option value="360">360</option>
        <option value="390">390</option>
        <option value="420">420</option>
        <option value="450">450</option>
        <option value="480">480</option>
        <option value="510">510</option>
        <option value="540">540</option>
        <option value="570">570</option>
        <option value="600">600</option>
        <option value="630">630</option>
        <option value="660">660</option>
        <option value="690">690</option>
        <option value="720">720</option>
        <option value="750">750</option>
        <option value="780">780</option>
    </select>
    <label>Vælg carportens bredde:</label>
    <select name="carportWidth" class="form-control" >
        <option selected disabled>Vælg bredde</option>
        <option value="240">240</option>
        <option value="270">270</option>
        <option value="300">300</option>
        <option value="330">330</option>
        <option value="360">360</option>
        <option value="390">390</option>
        <option value="420">420</option>
        <option value="450">450</option>
        <option value="480">480</option>
        <option value="510">510</option>
        <option value="540">540</option>
        <option value="570">570</option>
        <option value="600">600</option>
        <option value="630">630</option>
        <option value="660">660</option>
        <option value="690">690</option>
        <option value="720">720</option>
        <option value="750">750</option>
    </select>
    <br>
    <label>Vælg tag type:</label>
    <select name="roofType" class="form-control" >
        <option selected disabled>Vælg tag</option>
        <option value="0">Fladt tag</option>
        <option value="1">Tag med rejsning</option>
    </select>
    <br>

    <label>Vil du have skur?</label>
    <select name="isShed" class="form-control">
        <option selected disabled> Vil du have skur? </option>
        <option value="0">Uden skur</option>
        <option value="1">Med skur</option>
    </select>
    <br>

    Skur:
    <br>
    NB! Der skal beregnes 15 cm tagudhæng på hver side af skuret
    <br>

        Fortæl os om skuret:
        <br>
        <label>Vælg skurets bredde:</label>
        <select name="shedWidth" class="form-control">
            <option selected disabled>Vælg bredde</option>
            <option value="0">Hele carportens bredde</option>
            <option value="1">Halvdelen af carportens bredde</option>
        </select>
        <label>Vælg skurets dybde:</label>
        <select name="shedDepth" class="form-control">
            <option selected disabled>Vælg dybde</option>
            <c:forEach var="i" begin="12" end="75">
                <option value=${i*10}>${i*10}</option>
            </c:forEach>
        </select>
        <label>Vælg hvilken side skuret skal bygges i:</label>
        <select name="shedSide" class="form-control">
            <option selected disabled>Vælg side</option>
            <option value="left">til venstre</option>
            <option value="right">til højre</option>
        </select>
        <input class="btn btn-primary" type="submit" value="TEST" >

</form>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>