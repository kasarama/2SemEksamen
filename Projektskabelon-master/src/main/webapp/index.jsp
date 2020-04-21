<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.inc"%>
        <h1>Welcome to Sem 2</h1>

        <h2>
            <a href="FrontController?target=redirect&destination=carportrequest">Design din egen Carport</a>
        </h2>

        <c:if test = "${requestScope.error!= null}" >
           <h2>Error ! </h2>
            ${requestScope.error}
        </c:if>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="includes/footer.inc"%>
