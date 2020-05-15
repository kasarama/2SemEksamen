<%@ page import="CarportUtil.Initializer" %>
<%@ page import="FunctionLayer.LoginSampleException" %><%--
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
        try {
            request.getServletContext().setAttribute("overlayList", Initializer.getOverlayList());
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
    }
%>


<c:if test="${requestScope.overlayMSG!= null}">
    <div>
        <h3>${requestScope.overlayMSG}</h3>
    </div>
</c:if>

<div class="container2">
    <div class="col-md-12">
        <form name="overlay" action="FrontController" method="POST">
            <input type="hidden" name="target" value="overlay">
            <input type="hidden" name="origin" value="overlay">


            <c:set var="shed" value="${sessionScope.carportBase.shed.depth}"/>
            <c:choose>


                <c:when test="${shed !='0'}">
                    <br>
                    <br>
                    <h2>Beklædning</h2>

                    <label class="mt-3" for="overlay"> Vælg beklædning:</label>
                    <select name="overlayName" class="form-control" id="overlay">
                        <option selected disabled>Vælg beklædning</option>
                        <c:forEach var="material" items="${applicationScope.overlayList}">
                            <option value="${material.name};${material.color}">${material.color} ${material.name}</option>
                        </c:forEach>
                    </select>

                    <label class="mt-3"> Du kan også vælge at beklæde vægge af konstruktion:</label>
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
                    <input class="btn btn-primary mt-3" type="submit" name="noWalls" value="Videre kun med skur">

                </c:when>


                <c:otherwise>
                    <br>
                    <br>
                    <h2>Beklædning</h2>


                    Du kan vælge at beklæde nogle vægge af carporten:
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
                    <label class="mt-3" for="overlay"> Vælg beklædning:</label>
                    <select name="overlayName" class="form-control" id="overlay">
                        <option selected disabled>Vælg beklædning</option>
                        <c:forEach var="material" items="${applicationScope.overlayList}">
                            <option value="${material.name};${material.color}">${material.color} ${material.name}</option>
                        </c:forEach>
                    </select>
                    <input class="btn btn-primary mt-3" type="submit" name="noWalls" value="Kun carport, ingen vægge">
                </c:otherwise>
            </c:choose>
            <input class="btn btn-primary mt-3" type="submit" name="coverWalls" value="Videre med de valgte vægge">
        </form>
        <!-- End of form -->


        <form name="startOver" action="FrontController" method="POST">
            <input type="hidden" name="target" value="newrequest">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
        </form>
        <h2>
            <c:set var="msg" value="${requestScope.notReady}"/>
            <c:if test="${msg!=null}">
            <p><c:out value="${msg}"/><p>
            </c:if>
        </h2>
        </form>
    </div>
</div>


<%@include file="../includes/footer.inc" %>