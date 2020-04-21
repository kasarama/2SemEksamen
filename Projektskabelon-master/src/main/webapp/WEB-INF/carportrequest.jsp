<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 20-04-2020
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
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
    <input class="btn btn-primary" type="submit" value="Test" >
</form>






<form name="makerequest" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="makerequest">
    <label>Vælg længde:</label>
    <select name="length" class="form-control">
        <option selected disabled>Vælg længde</option>
        <option value="240">240</option>
        <option value="270">270</option>
        <option value="300">300</option>
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
    <br>
    <label>Vælg bredde:</label>
    <select name="width" class="form-control">
        <option selected disabled>Vælg bredde</option>
        <option value="240">240</option>
        <option value="270">270</option>
        <option value="300">300</option>
        <option value="330">330</option>
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
    <br>
    <label>Vælg tag type:</label>
    <select name="roofType" class="form-control">
        <option selected disabled>Vælg tag type</option>
        <option value="0">Flat tag</option>
        <option value="1">Tag med rejsning </option>
    </select>
    <br>
    <label>Vil du have skur?</label>
    <select name="isShed" class="form-control">
        <option selected disabled> Vil du have skur? </option>
        <option value="1">Med skur</option>
        <option value="0">Uden skur</option>
    </select>
    <br>

    <input class="btn btn-primary" type="submit" value="Videre til Tag" >
</form>

</div>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
