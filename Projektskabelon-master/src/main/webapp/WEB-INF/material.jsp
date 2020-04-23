<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 4/23/20
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Materials</title>
</head>
<body>

<p>${requestScope.material}</p>

<c:forEach var="materialItem" items ="materials"></c:forEach>
id: ${materialItems}</br>

<!-- Creating a hyperlink that goes through back to 'index' page -->
<a href="../index.jsp">Til Forsiden</a>
</body>
</html>
