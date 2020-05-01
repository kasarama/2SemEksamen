<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1>Fladt tag design</h1>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

<br>
<pre>

    <form name="designflatroof" action="FrontController" method="POST">
        <input type="hidden" name="target" value="designflatroof">
        <label>Vælg hældningsgrad:</label>
        <select name="tiltOptions" class="form-control" >
            <c:forEach var="tilt" begin="${applicationScope.minDegreeTilt}" end="${applicationScope.maxDegreeTilt}" step="5">
                <option value=${tilt}>${tilt}</option>
            </c:forEach>
        </select>
    </form>

    <form name="designflatroof" action="FrontController" method="POST">
    <input type="hidden" name="target" value="designflatroof">
    <label>Eller vælg højde på tag:</label>
    <select name="heightOptions" class="form-control" >

        <c:forEach var="height" begin="${applicationScope.height}" end="${applicationScope.height+5}" step="5">
            <option value=${height}>${height}</option>
        </c:forEach>
    </select>
    </form>

</pre>


<%--
<script>
    function dependencyTiltHeightAndDegree() {

    }
</script>
--%>

<%@include file="../includes/footer.inc"%>