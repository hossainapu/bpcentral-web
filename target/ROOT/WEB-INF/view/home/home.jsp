<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper_dashboard title="Search" bodyheader="Search">
    <jsp:attribute name="script">
        <script>
            $(function () {
                $("#input_query").autocomplete({
                    source: function (request, callback) {
                        $.ajax({
                            type: "GET",
                            url: "${pageContext.request.contextPath}/school-autoComplete?query=" + $("#input_query").val(),
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            success: function (data) {
                                callback(getArray(data))
                            }

                        })
                    },
                    select: function (event, ui) {
                        var value = ui.item.value;
                        $("#idSchoolName").val(value);
                        $("#searchForm").submit();
                    }

                });
            });

            function getArray(data) {

                var dataArray = [];
                if (data != null && data.length > 0) {
                    for (i = 0; i < data.length; i++) {
                        dataArray.push(data[i].name);

                    }
                }
                return dataArray;
            }
        </script>
    </jsp:attribute>

    <jsp:attribute name="style">
        <style>
            .ui-autocomplete {
                position: absolute;
                top: 100%;
                left: 0;
                z-index: 1000;
                float: left;
                display: none;
                min-width: 160px;   
                padding: 4px 4px;
                margin: 0 0 10px 25px;
                list-style: none;
                background-color: #ffffff;
                border-color: #ccc;
                border-color: rgba(0, 0, 0, 0.2);
                border-style: solid;
                border-width: 1px;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
                -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
                box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
                -webkit-background-clip: padding-box;
                -moz-background-clip: padding;
                background-clip: padding-box;
                *border-right-width: 2px;
                *border-bottom-width: 2px;
            }

            .ui-menu-item > a.ui-corner-all {
                display: block;
                padding: 3px 15px;
                clear: both;
                font-weight: normal;
                line-height: 18px;
                color: #555555;
                white-space: nowrap;
                text-decoration: none;
            }

            .ui-state-hover, .ui-state-active {
                color: #ffffff;
                text-decoration: none;
                background-color: #0088cc;
                border-radius: 0px;
                -webkit-border-radius: 0px;
                -moz-border-radius: 0px;
                background-image: none;
            }

            .custom-wrap {
                overflow: hidden; 
                text-overflow: ellipsis; 
                white-space: nowrap;
            }
        </style>
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
                                <div class="card-body">
                                    <div class="d-flex flex-column h-100">

                                        <form id="searchForm" action="${pageContext.request.contextPath}/search-school" method='GET' class="mt-4 pt-2" >
                                            <div class="auth-content my-auto">
                                                <div class="text-center">
                                                    <h5 class="mb-0">Search school name here</h5>
                                                </div>

                                                <div class="mb-4">
                                                    <input name="schoolName" type="hidden" class="form-control" id="idSchoolName">
                                                    <input name="query" type="text" class="form-control" id="input_query">
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <button class="btn btn-primary w-100 waves-effect waves-light" type="submit">Search</button>
                                            </div>
                                        </form>

                                    </div>
                                    <div class="mt-4 mt-md-5 text-center">
                                        <p class="mb-0">© <script>document.write(new Date().getFullYear())</script></p>
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