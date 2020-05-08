<%
    // if i'm the first user on this application, then set the overlayList. (else the list already exists)
    if (request.getServletContext().getAttribute("overlayList") == null) {
        try {
            request.getServletContext().setAttribute("overlayList", Initializer.getOverlayList());
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
    }
%>
<%
    // if i'm the first user on this application, then set the overlayMaterialsList. (else the list already exists)
    if (request.getServletContext().getAttribute("overlayMaterialsList") == null) {
        try {
            request.getServletContext().setAttribute("overlayMaterialsList", Initializer.getOverlayList());
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
    }
%>












<div class="container2">
    <div class="col-md-12">
        <form name="overlay" action="FrontController" method="POST">
            <input type="hidden" name="target" value="overlay">
            <input type="hidden" name="origin" value="overlay">

            <form name="overlay" action="FrontController" method="POST">
                <input type="hidden" name="target" value="overlay">
                <input type="hidden" name="origin" value="overlay">
                <c:set var="shed" value="${sessionScope.constructionBase.shed.depth}"/>
                <c:choose>
                    <c:when test="${shed != 0}">
                        <br>
                        <br>
                        <h2>Beklædning</h2>

                        <label class="mt-3" for="overlay"> Vælg beklædning:</label>
                        <select name="overlayName" class="form-control" id="overlay">
                            <c:forEach var="material" items="${applicationScope.overlayList}">
                                <option value="${material.name}">${material.name}</option>
                            </c:forEach>
                        </select>

                        <label class="mt-3"> Du kan også vælge at beklæde væggen af konstruktion:</label>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="left" value="left" id="left1">
                            <label class="form-check-label" for="left1">
                                Venstre væg
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="right" value="right" id="right1">
                            <label class="form-check-label" for="right1">
                                Højre væg
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="back" value="back" id="back1">
                            <label class="form-check-label" for="back1">
                                Bagvæg
                            </label>
                        </div>
                    </c:when>

                    <c:otherwise>

                        Du kan vælge at beklæde væggen af carporten:
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="left" value="left" id="left">
                            <label class="form-check-label" for="left">
                                Venstre væg
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="right" value="right" id="right">
                            <label class="form-check-label" for="right">
                                Højre væg
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="back" value="back" id="back">
                            <label class="form-check-label" for="back">
                                Bagvæg
                            </label>
                        </div>
                        <select name="overlayName" class="form-control">
                            <c:forEach var="material" items="${applicationScope.overlayList}">
                                <option value="${material.name}">${material.name}</option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
                <input class="btn btn-danger mt-3" type="submit" name="walls" value="Videre">
                <input class="btn btn-primary mt-3" type="submit" name="shedOverlay" value="SHOW shed overlay">
            </form>
            <!-- End of form -->

            <form name="startOver" action="FrontController" method="POST">
                <input type="hidden" name="target" value="newrequest">
                <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
            </form>
            <h2>
                <c:set var = "msg" value = "${requestScope.notReady}"/>
                <c:if test = "${msg!=null}">
                <p><c:out value = "${msg}"/><p>
                </c:if>
            </h2>
        </form>
    </div>
</div>


<!--
<c:forEach var="material" items="${applicationScope.overlayList}">
    <img id="${material.id}" src="${material.picture}" height="150" width="auto"/>
    <br>
    <input type="button" value="${material.name}" name="${material.id}"
    onMouseOver="document.getElementById('${material.id}').style.display='block'"
    onMouseOut="document.getElementById('${material.id}').style.display='none'">
    <br>
</c:forEach>
<c:forEach var="material" items="${applicationScope.overlayList}">
    ${material.name}<br>
    <input type="image" src="${material.picture}" height="200" width="auto" name="${material.id}"
    alt="${material.name}"><br>
</c:forEach>
-->