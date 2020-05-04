<%@ page import="CarportUtil.Initializer" %><%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 25-04-2020
  Time: 02:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>


<%
    // if i'm the first user on this application, then set the overlayList. (else the list already exists)
    if (request.getServletContext().getAttribute("overlayList") == null) {
        request.getServletContext().setAttribute("overlayList", Initializer.getOverlayList());
    }
%>
<%
    // if i'm the first user on this application, then set the overlayMaterialsList. (else the list already exists)
    if (request.getServletContext().getAttribute("overlayMaterialsList") == null) {
        request.getServletContext().setAttribute("overlayMaterialsList", Initializer.getOverlayList());
    }
%>


<h1>Beklædning</h1>


<form name="overlay" action="FrontController" method="POST">

    <input type="hidden" name="target" value="overlay">
    <input type="hidden" name="origin" value="overlay">

    <form name="overlay" action="FrontController" method="POST">
        <input type="hidden" name="target" value="overlay">
        <input type="hidden" name="origin" value="overlay">
        <c:set var="shed" value="${sessionScope.constructionBase.shed.depth}"/>
        <c:choose>
            <c:when test="${shed != 0}">
                Vælg beklædning
                <select name="overlayID" class="form-control">
                    <option value="1">aaaall</option>
                    <option value="2">bbbbbbeauty</option>
                    <option value="3">ccccccom on!</option>
                    <!--
                    <c:forEach var="material" items="${applicationScope.overlayList}">
                        <option value="${material.id}">${material.name}</option>
                    </c:forEach>
-->
                </select>
                Du kan også vælge at beklæde vægger af construction:
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="left" value="left" id="left1">
                    <label class="form-check-label" for="left1">
                        Venstre væg
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="right" value="right" id="right1">
                    <label class="form-check-label" for="right1">
                        Højre væg
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="back" value="back" id="back1">
                    <label class="form-check-label" for="back1">
                        Bagvæg
                    </label>
                </div>
            </c:when>
            <c:otherwise>
                Du kan vælge at beklæde vægger af carporten:
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="left" value="left" id="left">
                    <label class="form-check-label" for="left">
                        Venstre væg
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="right" value="right" id="right">
                    <label class="form-check-label" for="right">
                        Højre væg
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="back" value="back" id="back">
                    <label class="form-check-label" for="back">
                        Bagvæg
                    </label>
                </div>
                <select name="overlayID" class="form-control">
                    <c:forEach var="material" items="${applicationScope.overlayList}">
                        <option value="${material.id}">${material.name}</option>
                    </c:forEach>
                </select>
            </c:otherwise>
        </c:choose>
        <input type="submit" name="justShed" value="Videre">
        <input type="submit" name="shedOverlay" value="SHOW shed overlay">
    </form>

    <h2>
        <c:set var = "msg" value = "${requestScope.notReady}"/>
        <c:if test = "${salary!=null}">
        <p><c:out value = "${msg}"/><p>
        </c:if>
    </h2>

    <!--
        <c:forEach var="material" items="${applicationScope.overlayList}">
            <img id="${material.id}" src="${material.picture}" height="150" width="auto"/>
            <br>
            <input type="button" value="${material.name}" name="${material.id}"
                   onMouseOver="document.getElementById('${material.id}').style.display='block'"
                   onMouseOut="document.getElementById('${material.id}').style.display='none'">
            <br>
        </c:forEach>

    <c:forEach var="material" items="${applicationScope.overlayList}">
        ${material.name}<br>
        <input type="image" src="${material.picture}" height="200" width="auto" name="${material.id}"
               alt="${material.name}"><br>
    </c:forEach>
    -->

</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
