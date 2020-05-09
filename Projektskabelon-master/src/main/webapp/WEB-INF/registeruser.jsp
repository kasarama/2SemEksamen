
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<div class="container2">
    <div class="col-md-12">
    <div class="row">
        <div class="col text-center">
            <h1 class="mb-4">Login</h1>
            <form name="login" action="FrontController" method="post">

                <input type="hidden" name="target" value="login"/>

                <div class="form-group">
                    <label for="email">Indtast din email:</label>
                    <input type="text" name="email" class="form-control" id="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="password">Indtast dit password:</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-dark mt-3">Login</button>
                </div>
            </form>
        </div> <!-- /.colonne 1 -->

        <div class="col text-center">
            <h1 class="mb-4">Registrer</h1>

            <form name="registrer" action="FrontController" method="post">
                <input type="hidden" name="target" value="registrer"/>

                <div class="form-group">
                    <label for="navn">Indtast dit navn:</label>
                    <input type="text" name="navn" class="form-control" id="navn" aria-describedby="navnHelp">
                </div>
                <div class="form-group">
                    <label for="email">Indtast din email:</label>
                    <input type="text" name="email" class="form-control" id="email" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="password1">Indtast dit password:</label>
                    <input type="password" name="password1" class="form-control" id="password1">
                </div>
                <div class="form-group">
                    <label for="password2">Indtast dit password igen:</label>
                    <input type="password" name="password2" class="form-control" id="password2">
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-dark mt-3">Registrer</button>
                </div>
            </form>
        </div> <!-- /.colonne 2 -->
    </div> <!-- /.row -->

    <div class="text-center mt-3">
        <a class="btn btn-outline-dark" href="FrontController?target=redirect&destination=index" role="button">Tilbage til start</a>
    </div>
    </div>
</div> <!-- /.container -->

<form name="showRequests" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showRequests">
    <input type="submit" value="Vis Forespørgelser">
</form>


<c:if test = "${requestScope.error!= null}" >
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>
