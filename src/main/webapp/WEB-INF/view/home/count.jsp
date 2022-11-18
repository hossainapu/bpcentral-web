<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper_dashboard title="Search" bodyheader="Search">
    <jsp:attribute name="script">
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
                        <div class="col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div class="flex-1 ms-3">
                                            <h5 class="font-size-15 mb-1"><a href="#" class="text-dark">${schoolName}</a></h5>
                                        </div>
                                    </div>
                                    <div class="mt-3 pt-1 align-items-center">
                                        <div class="flex-1 ms-3">
                                            <h1 class="font-size-24">${count}</h1>
                                        </div>
                                    </div>
                                    <div class="btn-group" role="group">
                                        <a href=""><button type="button" class="btn btn-outline-light text-truncate"><i class="uil uil-user me-1"></i>Rate Teacher</button></a>
                                        <button type="button" class="btn btn-outline-light text-truncate"><i class="uil uil-envelope-alt me-1"></i>View Rating</button>
                                    </div>
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