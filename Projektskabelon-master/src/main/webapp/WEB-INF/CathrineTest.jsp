<%@ page import="FunctionLayer.RoofSizing" %>
<%@ page import="FunctionLayer.Carport" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<%
    if (request.getServletContext().getAttribute("carportRequest")!= null) {
        RoofSizing roofSizing = new RoofSizing((Carport)request.getServletContext().getAttribute("carportRequest"));
        // if i'm the first user on this application, then set the materialList. (else the list already exists)
        if (request.getServletContext().getAttribute("minDegreeTilt") == null) {
            request.getServletContext().setAttribute("minDegreeTilt", roofSizing.getMinpitchDegreeOption());
        }
        if (request.getServletContext().getAttribute("maxDegreeTilt") == null) {
            request.getServletContext().setAttribute("maxDegreeTilt", roofSizing.getMaxpitchDegreeOption());
        }

        if (request.getServletContext().getAttribute("height") == null) {
            request.getServletContext().setAttribute("height", roofSizing.roofHeight(false));
        }
    }
%>

<h1>Tryk videre for tag:</h1>
<br>
<h2>
    <a href="FrontController?target=redirect&destination=designflatroof">Tryk for fladt tag</a>
</h2>


<%@include file="../includes/footer.inc"%>