<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 5/4/20
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h1> Skal denne del slettes? </h1>
${requestScope.carportToString}

<form name="showdrawing" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showdrawing">
    <label>Vælg tagdækning:</label>
    <select name="length" class="form-control">
        <option selected disabled>Vælg type</option>
        <option value="1">type 1</option>
        <option value="2">type 2</option>
        <option value="3">type 3</option>
        <option value="4">type 4</option>
    </select>
    <input class="btn btn-primary" type="submit" value="Videre" >
</form>

<c:set var="roof" value="${sessionScope.constructionRequest.angle}"/>
<c:choose>
    <c:when test="${val == '0'}">

        <form name="showAngleValue" action="FrontController" method="POST">
            <input type="hidden" name="target" value="showAngleValue">
            <label>Vælg vinkelstørrelse på tagets ryg:</label>
            <select name="angle" class="form-control">
                <option selected disabled>Vælg type</option>
                <option value=""></option>
                <option value="2">type 2</option>
                <option value="3">type 3</option>
                <option value="4">type 4</option>
            </select>
            <input class="btn btn-primary" type="submit" value="Videre" >
        </form>
    </c:when>
</c:choose>


<%@include file="../includes/footer.inc"%>

