<%-- 
    Document   : menu
    Created on : May 8, 2017, 11:21:59 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="vertical-menu">

    <div data-simplebar class="h-100">

        <!--- Sidemenu -->
        <div id="sidebar-menu">
            <!-- Left Menu Start -->
            <ul class="metismenu list-unstyled" id="side-menu">
                <li class="menu-title" data-key="t-menu"></li>
                <li class="${play_create_menu}">
                    <a href="${pageContext.request.contextPath}/">
                        <span class="badge rounded-pill bg-soft-success text-success float-end"></span>
                        <span data-key="t-dashboard">Search</span>
                    </a>
                </li>

            </ul>

        </div>
        <!-- Sidebar -->
    </div>
</div>