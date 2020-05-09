<!-- Footer -->
<c:if test = "${requestScope.error!= null}" >
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>

<footer class="py-4 bg-dark">
    <div class="container text-white">
        <div class="row">
            <div class="col" style="text-align: right; right: 50px">
                <i class="fa fa-address-card-o mb-3" style="font-size:24px"></i>
                <br>
                <i class="fa fa-phone-square mb-3" style="font-size:24px"></i>
                <br>
                <i class="fa fa-envelope-o" style="font-size:24px"></i>
            </div>
            <div class="col" style="text-align: left; left: -50px">
                <p class="mb-3">Johannes Fog A/S</p>
                <p class="mb-3">45 87 10 01</p>
                <p>Send email</p>
            </div>
        </div>
    </div>
</footer>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>