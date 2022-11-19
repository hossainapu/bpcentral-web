<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper_dashboard title="Search" bodyheader="Search">
    <jsp:attribute name="script">
        <script>
            $( document ).ready(function() {
                <c:forEach var="result" items="${schools}" varStatus="loop">
                    var r = "${result.rate}";
                    var rate = parseInt(r);
                    try{
                        var myRater = raterJs({
                            starSize: 20,
                            step: .5,
                            element: document.querySelector("#rater-step-${result.id}"),
                            rating: rate
                        });
                    }catch(ex){console.log(ex)}
                </c:forEach>
            });
        </script>
    </jsp:attribute>

    <jsp:attribute name="style">
    </jsp:attribute>

    <jsp:body>
        <div class="main-content">

            <div class="page-content">
                <div class="container-fluid">

                    <div class="row">
                        <c:forEach var="result" items="${schools}" varStatus="loop">
                            <div class="col-xl-3 col-sm-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex align-items-center">
                                            <div>
                                                <img src="${result.image_url}" alt="" class="avatar-lg rounded-circle img-thumbnail">
                                            </div>
                                            <div class="flex-1 ms-3">
                                                <h5 class="font-size-15 mb-1"><a href="#" class="text-dark">${result.full_name}</a></h5>
                                                <p class="text-muted mb-0">${result.title}</p>
                                                <p class="text-muted mb-0">${result.department}</p>
                                            </div>
                                        </div>
                                        <div class="mt-3 pt-1">
                                            <!--                                            <p class="text-muted mb-0"><i class="mdi mdi-phone font-size-15 align-middle pe-2 text-primary"></i>
                                                                                            070 2860 5375</p>-->
                                            <p class="text-muted mb-0 mt-2"><i class="mdi mdi-email font-size-15 align-middle pe-2 text-primary"></i>
                                                ${result.email}</p>
                                            <p class="text-muted mb-0 mt-2"><i class="mdi mdi-google-maps font-size-15 align-middle pe-2 text-primary"></i>
                                                ${result.school_name}</p>
                                            <p><div class="rating" id="rater-step-${result.id}"></div></p>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->
                            </div>
                        </c:forEach>
                    </div>

                    <div class="row g-0 align-items-center mb-4">
                        ${paging}
                    </div>

                </div>
            </div>

        </div>
    </jsp:body>
</t:wrapper_dashboard>