<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestCath</title>
    <%@include file="../includes/header.inc" %>
</head>
<body>
<h1>Fladt tag design</h1>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

<br>
    <form name="designflatroof" action="FrontController" method="POST">
        <input type="hidden" name="target" value="designflatroof">
        <label>Vælg hældningsgrad:</label>
        <select name="tilt" class="form-control" >
            <c:forEach var="i" begin="2" end="10">
                <option value = "${i}"/>${i}</option>
            </c:forEach>
        </select>
    </form>

</body>
</html>
