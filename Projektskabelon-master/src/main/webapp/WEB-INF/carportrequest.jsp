
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Her kan du designe din egen carport </h1>

<form name="findmaterial" action="FrontController" method="POST">
    <input type="hidden" name="target" value="findmaterial">
    <label>Vælg længde:</label>
    <select name="length" class="form-control">
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
    <br>
    <label>Vælg bredde:</label>
    <select name="width" class="form-control">
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
    <select name="roofType" class="form-control">
        <option selected disabled>Vælg tag type</option>
        <option value="0">Flat tag</option>
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

    <input class="btn btn-primary" type="submit" value="TEST" >
</form>

    <br>
    <br>
    <br>
    <br>
    <br>








<form name="makerequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="makerequest">
    <label>Vælg længde:</label>
    <select name="length" class="form-control" required>
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
    <label>Vælg bredde:</label>
    <select name="width" class="form-control" required>
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
    <select name="roofType" class="form-control" required>
        <option selected disabled>Vælg tag type</option>
        <option value="flat">Fladt tag</option>
        <option value="pitched">Tag med rejsning </option>
    </select>
    <br>
    <label>Vil du have skur?</label>
    <select name="isShed" class="form-control" required>
        <option selected disabled> Vil du have skur? </option>
        <option value="0">Uden skur</option>
        <option value="1">Med skur</option>
    </select>
    <br>


    <input type="submit" value="Videre" >
</form>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>
