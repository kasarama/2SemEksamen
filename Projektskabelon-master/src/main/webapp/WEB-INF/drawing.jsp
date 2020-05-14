<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 10-05-2020
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drawing</title>
</head>
<body>
    <h1>Drawing page</h1>
    <br>

    <a href="FrontController?target=redirect&destination=prepareOffer">tilbage til Ordre detaljer</a>
    <br>

    ${requestScope.svgFromAbove}
<br>
<br>
<br>
<br>
${requestScope.svgdrawing}
</body>
</html>
