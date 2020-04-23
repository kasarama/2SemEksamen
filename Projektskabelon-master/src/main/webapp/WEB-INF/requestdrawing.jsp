

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<!--TODO lav en form for at tagne den valgt carport-->


<h1>Her should be the drawing</h1>
<form name="sendrequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="sendrequest">
    <input type="submit" value="Send Forespørgelse">
</form>
<br>
<form name="newrequest" action="FrontController" method="POST">
    <input type="hidden" name="target" value="newrequest">
    <input type="submit" value="Start forfra">
</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc" %>
