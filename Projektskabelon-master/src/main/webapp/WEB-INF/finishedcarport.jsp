<%--
  Created by IntelliJ IDEA.
  User: miade
  Date: 21-04-2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <title>Din Carport</title>
</head>
<body>

<!-- Page Content -->
<div class="container mt-4">

    <h4>Din carport</h4>
    <br>
    *** Billede ***
    <br>
    <br>
        <table class="table table-striped ">
            <thead>
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th>
                <th>Antal</th>
                <th>Enhed</th>
                <th>Note</th>
            </tr>
            </thead>
            <tbody>

                <tr>
                    <td>${sessionScope.stolpeInfo.name}</td>
                    <td>${sessionScope.stolpeInfo.size}</td>
                    <td>${sessionScope.stolpeAntal}</td>
                    <td>${sessionScope.stolpeInfo.unit}</td>
                    <td>${sessionScope.stolpeInfo.comment}</td>
                </tr>

            </tbody>
        </table>
    </form>

</div>
<!-- Container -->


Stykliste:
Antal posts: ${sessionScope.posts}
<br>
Der skal bruges:
<br>
- ${sessionScope.stolpe} cm

</body>
</html>
