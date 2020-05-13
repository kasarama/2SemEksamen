<%@ page import="CarportUtil.Initializer" %>
<%@ page import="FunctionLayer.LoginSampleException" %><%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/22/20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<div class="container2">
    <div class="col-md-12">
        <br>
        <br>
        <h2>
            <c:set var="msg" value="${requestScope.newRequestMSG}"/>
            <c:choose>
                <c:when test="${msg != null}">
                    ${msg}
                </c:when>
                <c:otherwise>
                    Velkommen til
                </c:otherwise>
            </c:choose></h2>

        <div class="col-md-6 school-options-dropdown text-center">

            <c:if test="${requestScope.orderMSG!= null}">
                <h2>Error ! </h2>
                ${requestScope.orderReadyMSG}
            </c:if>
        </div>
        <img class="mt-4 mb-3" src="./images/logo.png" alt="Logo" width="430" height=auto>
        <h6 class="mb-3" style="font-size: small;">Her kan du designe din egen carport & <br>
            få vejledning, inden du køber</h6>
        <br>
        <a class=" mt-4 mb-3 btn btn-primary" href="FrontController?target=redirect&destination=carportBase"
           role="button">DESIGN CARPORT</a>
    </div>
</div>
<br>
<br>
<%@include file="../includes/footer.inc" %>
