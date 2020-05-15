<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="./includes/indexLoginHeader.inc" %>

<div class="container2">
    <div class="col-md-12">
            <br>
            <br>
        <h2>Velkommen til</h2>
        <img class="mt-4 mb-3" src="./images/logo.png" alt="Logo" width="430" height=auto>
        <h6  class="mb-3" style="font-size: small;">Her kan du designe din egen carport & <br>
            få vejledning, inden du køber</h6>
        <br><br>
        <a class=" mt-4 mb-3 btn btn-primary" href="FrontController?target=redirect&destination=login" role="button">DESIGN CARPORT</a>
        <br>
        <a class=" mt-3 btn btn-dark" href="FrontController?target=redirect&destination=login" role="button">Login/Registrer</a>
    </div>
</div>
<br>
<br>
<%@include file="includes/footer.inc"%>
