<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Her kan du designe din egen construction </h1>

    You have chosen:
    length :${sessionScope.constructionBase.length}
    width :${sessionScope.constructionBase.width}
    pitched roof? :${sessionScope.constructionBase.roof.pitched}
    shed depth :${sessionScope.constructionBase.shed.depth}
    shed width :${sessionScope.constructionBase.shed.width}



<form name="findmaterial" action="FrontController" method="POST">
    <input type="hidden" name="target" value="findmaterial">
    <input class="btn btn-primary" type="submit" value="Show material List" >
</form>






<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>