<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper_dashboard title="Search" bodyheader="Search">
    <jsp:attribute name="script">
        <script>
            $(function () {
                var myRater = raterJs({
                    starSize:20,
                    step:.5,
                    element: document.querySelector("#rater-step"),
                    rateCallback:function(e,t){
                        this.setRating(e);
                        $("#idRating").val(e);
                        t();
                    }
                });
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
                        <div class="col-lg-3">
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-title">
                                    <c:if test="${msg ne '' and msg ne null}">
                                        <p>${msg}</p>
                                    </c:if>
                                    
                                </div>
                                <div class="card-body">
                                    
                                    <form id="searchForm" action="${pageContext.request.contextPath}/rate-teacher" method='POST' class="mt-4 pt-2" >
                                        <input name="schoolName" type="hidden" class="form-control" id="idSchoolName" value="${schoolName}">
                                        <input name="teacherName" type="hidden" class="form-control" id="idTeacherName" value="${teacherName}">
                                        <input name="id" type="hidden" class="form-control" id="idTeacher" value="${teacherId}">
                                        <input name="rate" type="hidden" class="form-control" id="idRating">
                                        <div class="d-flex align-items-center">
                                            <div class="flex-1 ms-3">
                                                <h5 class="font-size-15 mb-1"><a href="#" class="text-dark">${schoolName}</a></h5>
                                                <p class="text-muted mb-0">${teacherName}</p> <div class="rating" id="rater-step"></div>
                                            </div>
                                        </div>
                                        <div class="mt-3 pt-1 align-items-center">
                                            <div class="flex-1 ms-3">
                                                <div class="mb-3">
                                                    <label class="form-label">Comments</label>
                                                    <input name="comment" value="${rate.comment}" type="text" class="form-control" placeholder="Make a comment here .. " required="">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="btn-group" role="group">
                                            <button type="submit" class="btn btn-outline-light text-truncate"><i class="uil uil-envelope-alt me-1"></i>Submit Rating</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                        </div>                  
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:wrapper_dashboard>