<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to Sem 2</h1>

        <h2>
            <a href="FrontController?target=redirect&destination=carportrequest">Design din egen Carport</a>
        </h2>


        <a href="FrontController?target=redirect&destination=flatroof">Test</a>

        <c:if test = "${requestScope.error!= null}" >
           <h2>Error ! </h2>
            ${requestScope.error}
        </c:if>
    </body>
</html>
