<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper_dashboard title="Search" bodyheader="Search">
    <jsp:attribute name="script">
        <script>

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

                                    <form id="searchForm" action="${pageContext.request.contextPath}/search-teacher" method='POST' class="mt-4 pt-2" >
                                        <input name="schoolName" type="hidden" class="form-control" id="idSchoolName" value="${schoolName}">

                                        <div class="d-flex align-items-center">
                                            <div class="flex-1 ms-3">
                                                <h5 class="font-size-15 mb-1"><a href="#" class="text-dark">${schoolName}</a></h5>
                                            </div>
                                        </div>
                                        <div class="mt-3 pt-1 align-items-center">
                                            <div class="flex-1 ms-3">
                                                <div class="mb-3">
                                                    <label class="form-label">Teacher Name</label>
                                                    <input name="teacherName" value="" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="flex-1 ms-3">
                                                <div class="mb-3">
                                                    <label class="form-label">Subject</label>
                                                    <input name="subjectTeaches" value="" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="flex-1 ms-3">
                                                <div class="mb-3">
                                                    <label class="form-label">Grade</label>
                                                    <input name="gradeTeaches" value="" type="text" class="form-control" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="btn-group" role="group">
                                            <button type="submit" class="btn btn-outline-light text-truncate"><i class="uil uil-envelope-alt me-1"></i>Search</button>
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